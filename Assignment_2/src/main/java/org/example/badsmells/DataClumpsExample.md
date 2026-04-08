**Smell:**
Data Clumps

**Problem:**
The same group of related data (name, email, and phone) was repeatedly passed together across multiple methods. This indicates a missing abstraction, leading to duplication, noisy method signatures, and reduced readability.

**Refactoring:**
Introduced a ContactInfo class to encapsulate the related data. Moved the behavior that operates on this data (label creation, email greeting, SMS message, and reachability check) into the new class. Updated method calls to use this object instead of passing multiple parameters.

**Result:**
The repeated data clump is replaced with a meaningful abstraction, improving encapsulation and reducing duplication. The code is now cleaner, easier to read, and more maintainable. Method signatures are simpler, and behavior is logically grouped with the