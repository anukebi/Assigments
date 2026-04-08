**Smell:** Temporary Field

**Problem:**
The original class had fields (examRoom and onlineMeetingLink) that were only relevant depending on which method was called. This made the object state partially meaningless in some contexts, increasing the risk of bugs and confusing the design.

**Refactoring:**

* Extracted separate classes for OnsiteExam and OnlineExam.
* Moved mode-specific fields and logic into their respective classes.
* Removed temporary fields from the main class.

**Result:**
Each class now has a well-defined responsibility. Object state is always meaningful, methods are simpler, and the design avoids confusion caused by irrelevant fields.