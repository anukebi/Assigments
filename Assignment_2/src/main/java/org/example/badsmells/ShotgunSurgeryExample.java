package org.example.badsmells;

/*
 * Smell: Shotgun Surgery
 *
 * A single concept, course title wording, is spread across several classes. One
 * naming change would trigger several small edits in different places.
 *
 * Proposed Refactorings:
 * - Move shared formatting behavior into one class.
 * - Introduce a single source of truth for course presentation rules.
 */
public class ShotgunSurgeryExample {

		static class Course {

			private final String title;

			Course(String title) {
				this.title = title;
			}

			public String getTitle() {
				return title;
			}

			public String label() {
				return "Course: " + title;
			}

			public String invoiceDescription() {
				return "Invoice for " + title;
			}

			public String certificateText() {
				return "Completed " + title;
			}
		}

		public void clientCode() {
			Course course = new Course("Refactoring");

			System.out.println(course.label());
			System.out.println(course.invoiceDescription());
			System.out.println(course.certificateText());
		}
}
