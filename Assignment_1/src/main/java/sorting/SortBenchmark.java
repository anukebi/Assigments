package sorting;

import org.openjdk.jmh.Main;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Warmup;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
@Warmup(iterations = 3)
@Measurement(iterations = 5)
@Fork(1)
public class SortBenchmark {

    private static final int ARRAY_SIZE = 1000000;

    @Param
    private DataGenerator.SortType type;
    private int[] originalData;
    private int[] testData;

    // Prepare data once per trial to prevent redundant generation calls
    @Setup(Level.Trial)
    public void setup() {
        originalData = DataGenerator.generate(ARRAY_SIZE, type);
    }

    // Copy the original, unmodified data to the test variable for each benchmark invocation
    @Setup(Level.Invocation)
    public void setupInvocation() {
        testData = Arrays.copyOf(originalData, originalData.length);
    }

    // Assert the sorting result after each benchmark invocation
    @TearDown(Level.Invocation)
    public void teardownInvocation() {
        SortVerifier.assertCorrect(originalData, testData);
    }

    @Benchmark // Disable for big array sizes
    public void bubbleSort() {
        BubbleSort.sort(testData);
    }

    @Benchmark
    public void quickSort() {
        QuickSort.sort(testData);
    }

    @Benchmark
    public void radixSort() {
        LSDRadixSort.sort(testData);
    }

    @Benchmark
    public void javaSort() {
        Arrays.sort(testData);
    }

    public static void main(String[] args) throws Exception {
        Main.main(args);
    }

}