package org.example.badsmells;

/*
 * Smell: Long Parameter List
 *
 * The method takes many related values directly instead of receiving a few
 * meaningful objects such as address or guardian contact information.
 *
 * Proposed Refactorings:
 * - Introduce parameter objects for address and guardian contact.
 * - Preserve whole object when the caller already has a richer object.
 */
public class LongParameterListExample {
	public static class Address {
		private final String city;
		private final String street;
		private final String zipCode;

		public Address(String city, String street, String zipCode) {
			this.city = city;
			this.street = street;
			this.zipCode = zipCode;
		}

		@Override
		public String toString() {
			return city + ", " + street + ", " + zipCode;
		}
	}
	public static class Guardian {
		private final String name;
		private final String phone;

		public Guardian(String name, String phone) {
			this.name = name;
			this.phone = phone;
		}

		@Override
		public String toString() {
			return name + " (" + phone + ")";
		}
	}

	public static class Student {
		private final String firstName;
		private final String lastName;
		private final String email;
		private final String phone;
		private final Address address;
		private final Guardian guardian;
		private final String program;
		private final int startYear;
		private final boolean scholarship;

		public Student(String firstName, String lastName, String email, String phone,
					   Address address, Guardian guardian, String program, int startYear, boolean scholarship) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.phone = phone;
			this.address = address;
			this.guardian = guardian;
			this.program = program;
			this.startYear = startYear;
			this.scholarship = scholarship;
		}

		@Override
		public String toString() {
			return firstName + " " + lastName + " -> " + program + " (" + startYear + "), "
					+ "guardian=" + guardian + ", scholarship=" + scholarship
					+ ", address=" + address + ", contact=" + email + "/" + phone;
		}
	}

	public String registerStudent(Student student) {
		return student.toString();
	}

	public void clientCode() {
		Address address = new Address("Tbilisi", "Rustaveli Ave 10", "0108");
		Guardian guardian = new Guardian("Maka Beridze", "+995-555-000-999");
		Student student = new Student("Nino", "Beridze", "nino@example.com", "+995-555-000-001",
				address, guardian, "Computer Science", 2026, true);

		System.out.println(registerStudent(student));
	}
}
