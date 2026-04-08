package org.example.badsmells;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Smell: Mutable Data
 *
 * The internal list is returned directly, so callers can mutate object state
 * without the class controlling those changes.
 *
 * Proposed Refactorings:
 * - Return an unmodifiable view or defensive copy.
 * - Encapsulate updates behind intention-revealing methods.
 */
public class MutableDataExample {

	private final List<String> enrolledStudents = new ArrayList<>();

	public List<String> getEnrolledStudents() {
		return Collections.unmodifiableList(enrolledStudents);
	}

	public void enroll(String studentId) {
		enrolledStudents.add(studentId);
	}

	public void clientCode() {
		enroll("s-1001");
		System.out.println(getEnrolledStudents().size());
	}
}
