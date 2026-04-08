package org.example.badsmells;

/*
 * Smell: Message Chains
 *
 * The caller navigates through several objects to get one value. That couples
 * the caller to the full object graph instead of to a simpler abstraction.
 *
 * Proposed Refactorings:
 * - Hide delegates behind a simpler method.
 * - Move the behavior closer to the object that owns the needed data.
 */
public class MessageChainsExample {

	static class University {
		private final Department department = new Department();

		Department getDepartment() {
			return new Department();
		}

		String getCoordinatorPhoneNumber() {
			return department.getCoordinator().getOffice().getPhoneNumber();
		}
	}

	static class Department {

		private final Coordinator coordinator = new Coordinator();

		Coordinator getCoordinator() {
			return new Coordinator();
		}
	}

	static class Coordinator {

		private final Office office = new Office();

		Office getOffice() {
			return new Office();
		}
	}

	static class Office {

		String getPhoneNumber() {
			return "555-0101";
		}
	}

	public void clientCode() {

		University university = new University();
		System.out.println(university.getCoordinatorPhoneNumber());
	}

}
