**Smell:**
Global Data

**Problem:**
The public static fields currentSemester and tuitionRate were accessible from anywhere, making it unclear who owns or controls the state. This weakens encapsulation and increases the risk of unintended side effects.

**Refactoring:**
Encapsulated the state in a UniversityContext object. All access to the semester and tuition rate now goes through controlled methods. Both BillingService and SemesterAdministration receive a reference to the context instead of relying on global variables.

**Result:**
The state is now controlled and properly encapsulated. Changes to semester or tuition rate are only possible through well-defined methods, reducing coupling and improving maintainability. Client code interacts cleanly with the context object, preserving behavior while removing global data access.