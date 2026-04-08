**Smell:**
Shotgun Surgery

**Problem:**
A single concept—course title formatting—is duplicated across multiple classes (Course, Invoice, Certificate). Changing the course title presentation would require coordinated edits in several places, increasing the risk of inconsistencies and errors.

**Refactoring:**

* Introduced a single source of truth for course presentation by centralizing the formatting behavior in one place (e.g., Course class).
* Other classes could reference the course object or its label instead of duplicating formatting logic.

**Result:**
The course title presentation is now maintained in one place. Changes are easy to apply consistently, reducing the likelihood of bugs and improving maintainability. Each class only focuses on its primary responsibility, and duplication is removed.