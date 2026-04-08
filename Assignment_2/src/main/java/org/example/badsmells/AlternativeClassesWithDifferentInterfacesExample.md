**Smell:**
Alternative Classes with Different Interfaces

**Problem:**
ZoomClassroom and TeamsClassroom provide similar functionality but expose different method names. This forces client code to treat them differently and prevents polymorphic use.

**Refactoring:**
Introduced a common interface (Classroom) and aligned both classes to use a shared method name (startSession).

**Result:**
Both classes can now be used interchangeably through a common abstraction. Client code is simpler, more consistent, and follows polymorphism, improving maintainability and extensibility.