**Smell:**
Insider Trading

**Problem:**
AuditService directly accessed BankAccount internals (balance and secretFlag), creating tight coupling and exposing implementation details. Changes to BankAccount could break the audit logic.

**Refactoring:**
Moved the freeze logic into BankAccount as the freezeIfOverdrawn() method. Fields were made private and given meaningful names (status instead of secretFlag). AuditService now simply calls the account’s method, without knowing internal details.

**Result:**
Encapsulation is restored. BankAccount controls its own state, reducing coupling. AuditService no longer manipulates internals directly. Behavior is preserved, and client code is cleaner and safer.