**Smell:**
Large Class

**Problem:**
LargeClassExample handled multiple unrelated responsibilities: enrollment, staffing, finance, cafeteria, transport, help desk, payroll, and website. This violates the Single Responsibility Principle and makes the class hard to maintain and extend.

**Refactoring:**
Applied Extract Class to split the original class into multiple cohesive classes: Enrollment, Finance, HelpDesk, Website, Transport, and Cafeteria. Fields and methods relevant to each domain were moved into the corresponding class.

**Result:**
Each class now has a single, focused responsibility, improving cohesion and maintainability. Client code is cleaner and more expressive, and changes in one domain area no longer risk breaking others. The behavior of enrolling students, charging tuition, opening tickets, updating the website, publishing schedules, and setting menus is preserved.