**Smell:**
Feature Envy

**Problem:**
The ScholarshipCalculator class relied heavily on the internal data of StudentAccount without contributing significant behavior of its own. This indicates that the logic was in the wrong place, creating unnecessary coupling and reducing cohesion.

**Refactoring:**
Applied Move Method by transferring the scholarship qualification logic into StudentAccount as qualifiesForScholarship(). The ScholarshipCalculator class was removed because it no longer added value.

**Result:**
The logic now lives with the data it depends on, improving cohesion and reducing coupling. Client code becomes simpler and more expressive, calling account.qualifiesForScholarship() directly. The behavior is preserved while the design is cleaner and more object-oriented.