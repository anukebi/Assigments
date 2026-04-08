package org.example.badsmells;

/*
 * Smell: Data Class
 *
 * StudentRecord is only a bag of fields. When behavior is kept elsewhere and a
 * class mostly exposes raw data, the model stays weak and passive.
 *
 * Proposed Refactorings:
 * - Move behavior that uses the data into StudentRecord.
 * - Encapsulate fields and remove pointless setters where possible.
 */
public class DataClassExample {

	public static class StudentRecord {

		private final String name;
		private int credits;
		private double gpa;

		public StudentRecord(String name, int credits, double gpa) {
			this.name = name;
			this.credits = credits;
			this.gpa = gpa;
		}

		public String getName() {
			return name;
		}

		public int getCredits() {
			return credits;
		}

		public void setCredits(int credits) {
			this.credits = credits;
		}

		public double getGpa() {
			return gpa;
		}

		public void setGpa(double gpa) {
			this.gpa = gpa;
		}

		public boolean isEligibleForHonors() {
			return credits >= 30 && gpa >= 3.7;
		}

		public double discountPercent() {
			if (gpa >= 3.8) {
				return 0.15;
			}
			if (gpa >= 3.5) {
				return 0.10;
			}
			return 0.0;
		}

		public String describe() {
			if (gpa < 2.0) {
				return name + " is on academic probation";
			}
			if (credits < 15) {
				return name + " is a new student";
			}
			return name + " is in good standing";
		}

	}

	public void clientCode() {
		StudentRecord student = new StudentRecord("Nino", 32, 3.8);

		System.out.println(student.isEligibleForHonors());
		System.out.println(student.discountPercent());
		System.out.println(student.describe());
	}

}
