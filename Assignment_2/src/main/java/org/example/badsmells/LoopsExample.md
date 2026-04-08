**Smell:**
Loops

**Problem:**
The original honorStudents method used an explicit for loop to filter and collect honor students. The loop obscures the higher-level operation (selecting students with GPA > 3.5).

**Refactoring:**
Replaced the loop with a stream pipeline, combining filter and map in a single, intention-revealing expression.

**Result:**

* The code is shorter, clearer, and easier to read.
* Intent (selecting honor students) is explicit.
* Behavior is unchanged: only students with GPA > 3.5 are returned.