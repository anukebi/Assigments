**Smell:** Speculative Generality

**Problem:**
The NotificationChannel interface defines extra parameters (futureTemplate, encrypted, urgent) that are not used in the current implementation. The abstraction is prepared for future scenarios that do not exist, adding unnecessary complexity and confusion.

**Refactoring:**

* Removed unused parameters from the interface and implementation.
* Simplified the NotificationChannel interface to match current needs.
* Kept the design focused on actual behavior rather than imaginary requirements.

**Result:**
The code is now simpler, easier to understand, and maintain. The interface expresses only what is actually needed, eliminating speculative complexity while preserving the ability to send notifications.