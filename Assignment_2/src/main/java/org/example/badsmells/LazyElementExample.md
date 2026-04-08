**Smell:**
Lazy Element

**Problem:**
The StudentNameFormatter class existed solely to trim a string. This extra abstraction adds no real value, complicates the code, and is unnecessary.

**Refactoring:**
Applied Inline Class by removing StudentNameFormatter entirely and performing the trim() operation directly in the client code.

**Result:**
The code is simpler and more readable. There is no loss of functionality, and unnecessary abstraction is removed. The client code now clearly expresses its intention without extra indirection.