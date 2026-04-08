**Smell:**
Duplicated Code

**Problem:**
The summerInvoice and winterInvoice methods contained duplicated pricing logic, including tax calculation and shipping rules. This duplication increases maintenance cost, since any change to the pricing rules would need to be applied in multiple places, risking inconsistencies.

**Refactoring:**
Applied Extract Method to move the shared pricing logic into a single method calculateTotal. Parameterized the differences in discount calculation using a discount rate and flat discount value, allowing both invoice methods to reuse the same logic.

**Result:**
The duplication is removed, and the pricing logic is centralized in one place. This improves maintainability and reduces the risk of inconsistencies. The code is cleaner, easier to understand, and follows the DRY principle while preserving the original behavior.