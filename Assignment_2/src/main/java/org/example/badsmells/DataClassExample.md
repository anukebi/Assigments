**Smell:**
Data Class

**Problem:**
StudentRecord originally acted as a passive data holder, with behavior implemented in external classes. This resulted in low cohesion and weak encapsulation.

**Refactoring:**
Applied Move Method by transferring behavior from HonorsEvaluator, TuitionDiscountCalculator, and AcademicStandingReporter into StudentRecord. Encapsulated state by making fields private and removed direct field access. Introduced a constructor for controlled initialization and made name final to enforce immutability where appropriate.

**Result:**
de. The system is easier to understThe refactored design follows object-oriented principles by colocating data and behavior, resulting in higher cohesion and better encapsulation. The class is now responsible for its own logic, reducing coupling and simplifying client code. The system is easier to understand, maintain, and extend, while preserving the original behavior.d, maintain, and extend, while preserving the original behavior