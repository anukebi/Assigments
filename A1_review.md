## Summary

This is a strong submission with real JMH usage, all required algorithms, full dataset coverage, correctness checking through benchmark teardown, and a relevant PDF report. The main issue is consistency: the report describes a broader benchmark matrix, including smaller sizes and a reduced Bubble Sort scope, while the tracked JMH code fixes a single `1,000,000`-element benchmark path for all benchmark methods.

## Strengths

- `Assignment_1/pom.xml` includes a complete JMH setup.
- `Assignment_1/src/main/java/sorting/SortBenchmark.java` benchmarks all four required algorithms with real JMH annotations.
- `Assignment_1/src/main/java/sorting/SortBenchmark.java` uses `@Setup(Level.Invocation)` to clone benchmark input and `@TearDown(Level.Invocation)` to assert correctness after each run.
- `Assignment_1/src/main/java/sorting/LSDRadixSort.java` implements a base-`256`, four-pass LSD radix sort and explicitly reorders negative values after the byte passes.
- `Assignment_1/src/main/java/sorting/DataGenerator.java` includes uniform, ascending, descending, and nearly-sorted distributions, with nearly-sorted generated via about `1%` random swaps.
- `Assignment_1/Sorting 1,000,000 Integers Using JMH.pdf` is relevant and analytical.

## Findings

- Moderate: `Assignment_1/Sorting 1,000,000 Integers Using JMH.pdf` describes benchmark results for `N = 1000`, `N = 10,000`, `N = 500,000`, and `N = 1,000,000`, and says Bubble Sort was only tested on small inputs. The tracked JMH code in `Assignment_1/src/main/java/sorting/SortBenchmark.java` instead fixes `ARRAY_SIZE = 1000000` and includes a `bubbleSort()` benchmark method in the same benchmark class. The report and repository code are inconsistent about the actual benchmark scope.
- Minor: `Assignment_1/src/main/java/sorting/SortBenchmark.java` relies on `@Param private DataGenerator.SortType type;` without explicit values in the annotation. This may still work for enums, but the benchmark configuration is less explicit than it should be.

## Requirement Checklist

- Java source code: Present
- JMH benchmark classes: Present
- PDF analytical report: Present
- Bubble Sort with early exit: Present
- In-place Quick Sort with identifiable pivot strategy: Present
- LSD Radix Sort, base `256`, `4` passes, negative support: Present
- `Arrays.sort(int[])` benchmark/reference: Present
- Uniform random dataset: Present
- Already sorted dataset: Present
- Reverse sorted dataset: Present
- Nearly sorted dataset with about `1%` swaps: Present
- Correctness check against `Arrays.sort()`: Present
- Explicit sortedness check: Present
- Required benchmark size of `1,000,000`: Present in tracked JMH code

## Verdict

The submission is close to full compliance and technically strong. The downgrade is mainly for the mismatch between the tracked benchmark code and the report narrative.
