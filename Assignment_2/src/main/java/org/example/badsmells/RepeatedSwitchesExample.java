package org.example.badsmells;

/*
 * Smell: Repeated Switches
 *
 * The same classification logic appears in multiple switch statements. Adding a
 * new student type requires coordinated edits in each one.
 *
 * Proposed Refactorings:
 * - Replace the switches with polymorphism.
 * - Or centralize the classification in one enum or helper so new cases are
 *   added in one place instead of in many repeated switches.
 */
public class RepeatedSwitchesExample {

	public enum StudentType {
		STUDENT(0.05, "NORMAL"),
		ATHLETE(0.15, "HIGH"),
		EMPLOYEE_CHILD(0.25, "LOW"),
		OTHER(0.0, "UNKNOWN");

		private final double tuitionDiscount;
		private final String dormPriority;

		StudentType(double tuitionDiscount, String dormPriority) {
			this.tuitionDiscount = tuitionDiscount;
			this.dormPriority = dormPriority;
		}

		public double getTuitionDiscount() {
			return tuitionDiscount;
		}

		public String getDormPriority() {
			return dormPriority;
		}
	}

	public double tuitionDiscount(StudentType studentType) {
		return studentType.getTuitionDiscount();
	}

	public String dormPriority(StudentType studentType) {
		return studentType.getDormPriority();
	}


	public void clientCode() {
		StudentType type = StudentType.ATHLETE;
		System.out.println(tuitionDiscount(type));
		System.out.println(dormPriority(type));
	}
}
