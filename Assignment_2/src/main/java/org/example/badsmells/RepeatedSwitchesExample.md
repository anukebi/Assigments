**Smell:**
Repeated Switches

**Problem:**
The same classification logic (tuition discount, dorm priority) appears in multiple switch statements. Adding a new student type requires coordinated edits in each switch, which is error-prone and hard to maintain.

**Refactoring:**

* Replaced switches with an enum StudentType that encapsulates all type-specific behavior.
* Moved tuition discount and dorm priority logic into the enum.
* Client code now queries behavior via enum methods, removing duplication and making the logic self-contained.

**Result:**
The code is now easier to maintain and extend. Adding a new student type only requires updating the enum, eliminating repeated switch statements. Each student type clearly owns its own behavior, improving readability and reducing the risk of errors.