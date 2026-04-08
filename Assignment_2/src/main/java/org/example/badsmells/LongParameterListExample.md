**Smell:**
Long Parameter List

**Problem:**
The original registerStudent method took 12 parameters, many of which were related (address fields, guardian info). This makes the method hard to read, easy to misuse, and difficult to maintain.

**Refactoring:**
Introduced parameter objects:

* Address: groups city, street, and zip code
* Guardian: groups guardian name and phone
* Student: encapsulates all relevant student info

The registerStudent method now takes a single Student object, reducing parameter clutter and improving readability.

**Result:**
The code is now cleaner, more maintainable, and intention-revealing. Behavior is preserved, and related data is logically grouped.