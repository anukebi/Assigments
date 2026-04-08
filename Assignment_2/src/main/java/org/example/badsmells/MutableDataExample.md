**Smell:**
Mutable Data

**Problem:**
The internal list was exposed directly, allowing clients to mutate it without control. This breaks encapsulation and makes the object state fragile.

**Refactoring:**

Return an unmodifiable view of the list using Collections.unmodifiableList.
Keep all updates inside intention-revealing methods like enroll().

**Result:**

* Prevents accidental external modification.
* Maintains encapsulation and controlled state changes.
* Original behavior (adding students) is preserved.