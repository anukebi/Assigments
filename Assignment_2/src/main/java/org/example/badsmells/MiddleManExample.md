**Smell:**
Middle Man

**Problem:**
StudentPortal only forwarded calls to TranscriptService without adding behavior. This extra layer adds noise, increases maintenance, and provides no real encapsulation.

**Refactoring:**
Removed StudentPortal. Clients now call TranscriptService directly. Only delegation that adds real policy or encapsulation value should remain.

**Result:**

* Client code is cleaner and more direct.
* Reduced unnecessary indirection.
* Original behavior is preserved.