package org.example.badsmells;

/*
 * Smell: Middle Man
 *
 * StudentPortal mostly forwards calls to TranscriptService. The extra layer
 * adds little behavior of its own.
 *
 * Proposed Refactorings:
 * - Remove the middle man and let clients talk to the real service.
 * - Keep only delegation that adds real policy or encapsulation value.
 */
public class MiddleManExample {

	static class TranscriptService {

		public String findGrade(String studentId) {
			return "A";
		}
	}

	public void clientCode() {
		TranscriptService transcriptService = new TranscriptService();
		System.out.println(transcriptService.findGrade("s-1001"));
	}
}
