**Smell:**
Divergent Change

**Problem:**
The class handled multiple unrelated responsibilities, including report formatting, SQL generation, and CSV export. Each of these concerns represents a different reason to change, causing the class to violate the Single Responsibility Principle and making it harder to maintain.

**Refactoring:**
Applied Extract Class to separate the different responsibilities into StudentReportFormatter, StudentSqlBuilder, and StudentCsvExporter. Moved the relevant fields and methods into their respective classes so that each class handles a single concern.

**Result:**
Each class now has a clear and focused responsibility, improving cohesion and reducing the risk of unrelated changes affecting the same module. The design is easier to understand, maintain, and extend, while preserving the original behavior.