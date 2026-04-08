**Smell:**
Message Chains

**Problem:**
The client had to navigate through University -> Department -> Coordinator -> Office to get the phone number. This creates tight coupling to the internal object graph and makes maintenance fragile.

**Refactoring:**
Introduced a convenience method in University (getCoordinatorPhoneNumber) that hides the chain and moves the behavior closer to the data owner.

**Result:**

* Client code is simpler and easier to read.
* Coupling to the internal structure is reduced.
* Behavior is preserved: the correct phone number is returned.