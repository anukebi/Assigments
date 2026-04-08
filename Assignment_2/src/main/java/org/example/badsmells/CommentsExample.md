**Smell:**
Comments

**Problem:**
The method relied on comments to explain business rules because the code itself was not expressive. The logic was implemented in a single method with unclear structure.

**Refactoring:**
Extracted intention-revealing methods for VIP discount, bulk discount, and tax calculation. Introduced named constants and improved variable naming.

**Result:**
The code is now self-explanatory and no longer requires comments. Each business rule is clearly represented, improving readability and maintainability while preserving the original behavior.