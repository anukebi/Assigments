# Sorting Benchmark (Java)

This project compares different sorting algorithms on large datasets (1,000,000 integers) using JMH for benchmarking.

### Algorithms

1. Bubble Sort (with early exit)

2. Quick Sort (in-place)

3. LSD Radix Sort (base 256, supports negatives)

4. Arrays.sort() (Java built-in)

### Test Data

Each algorithm is tested on:

1. Random data
2. Already sorted arrays
3. Reverse sorted arrays
4. Nearly sorted arrays (~1% swaps)

### Benchmark

JMH is used instead of manual timing to get more reliable results.

Warm-up: 3 iterations

Measurement: 5 iterations

### Correctness

Each algorithm result is checked against Arrays.sort() to make sure it is correct.

### Run

```shell
mvn clean install
java -jar target/benchmarks.jar
```

## Notes

* Bubble sort is very slow on large inputs (as expected)
* Quick sort performance depends on pivot choice
* Radix sort performs consistently well
* Java’s Arrays.sort() is highly optimized

