**Smell:** 
Primitive Obsession

**Problem:** The method relied on raw types (int, String, double) for age, status, balance, and country code. This spreads validation and rules across the code and makes it easy to misuse or pass incorrect values.

**Refactoring:** Introduced StudentStatus and CountryCode enums to replace the string primitives. The method now accepts these enums instead of raw strings, and comparison logic uses type-safe constants.

**Result:** The code is now self-explanatory, type-safe, and easier to maintain. Invalid statuses or country codes cannot be accidentally passed, and the business rules are localized within the enums and the method.