**Smell:** Refused Bequest

**Problem:** Penguin inherits from Bird but cannot fulfill the fly() contract. This breaks the Liskov Substitution Principle and makes the inheritance misleading.

**Refactoring:** Introduced a clearer hierarchy or composition where only birds that actually fly implement flying behavior. Penguin no longer inherits an incompatible method, avoiding the need to throw exceptions for unimplemented behavior.

**Result:** The class hierarchy now accurately reflects the abilities of each bird type. The code is safer, easier to understand, and respects correct object-oriented design principles.