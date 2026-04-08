**Smell:**
Long Function

**Problem:**
The processOrder method mixed multiple responsibilities — discount calculation, shipping, tax computation, approval logic, and summary formatting — into a single large block. This makes the method hard to read, test, or maintain.

**Refactoring:**
Applied Extract Method to split the original method into smaller, intention-revealing methods: calculateSubtotal, calculateDiscount, calculateShipping, calculateTax, determineApprovalStatus, and formatSummary.

**Result:**
Each smaller method focuses on a single task, improving readability and maintainability. Client code behavior is preserved, and the logic for each step is clearly isolated for easier modification or testing.