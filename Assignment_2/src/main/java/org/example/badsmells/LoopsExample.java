package org.example.badsmells;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Smell: Loops
 *
 * The loop hides a simple collection transformation: filter students by GPA and
 * collect their names. Fowler treats this as a smell when a clearer pipeline
 * form is available.
 *
 * Proposed Refactorings:
 * - Replace the loop with a stream pipeline.
 * - Extract the selection predicate into a named method if it is reused.
 */
public class LoopsExample {

	public List<String> honorStudents(List<Student> students) {
		return students.stream()
				.filter(s -> s.gpa > 3.5)
				.map(s -> s.name)
				.collect(Collectors.toList());
	}

	static class Student {

		String name;
		double gpa;

		Student(String name, double gpa) {
			this.name = name;
			this.gpa = gpa;
		}
	}

	public void clientCode() {
		List<Student> students = List.of(
				new Student("Nino", 3.9),
				new Student("Giorgi", 3.1),
				new Student("Maka", 3.7)
		);

		System.out.println(honorStudents(students));
	}
}
