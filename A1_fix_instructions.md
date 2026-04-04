The repository is already close to full-credit quality. The main repairs are consistency fixes.

Action items:

- Align `Assignment_1/src/main/java/sorting/SortBenchmark.java` and `Assignment_1/Sorting 1,000,000 Integers Using JMH.pdf` so they describe the same benchmark scope.
- If Bubble Sort is intentionally handled on smaller inputs for practicality, implement that split explicitly in the tracked benchmark code instead of describing it only in the PDF report.
- Make the dataset parameter configuration explicit in `Assignment_1/src/main/java/sorting/SortBenchmark.java` so the benchmark inputs are unambiguous from code alone.

Recommended order:

1. Decide the final Bubble Sort scope.
2. Update the tracked benchmark code to match that decision.
3. Rerun JMH and revise the PDF accordingly.
