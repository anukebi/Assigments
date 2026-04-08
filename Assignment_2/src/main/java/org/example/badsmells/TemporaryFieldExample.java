package org.example.badsmells;

/*
 * Smell: Temporary Field
 *
 * The object has fields that matter only in certain modes. Depending on which
 * method was called, part of the object's state is irrelevant.
 *
 * Proposed Refactorings:
 * - Extract classes for the different modes.
 * - Move mode-specific fields and logic into the appropriate class.
 */
public class TemporaryFieldExample {

	static class OnsiteExam {
		private final String examRoom;

		OnsiteExam(String examRoom) {
			this.examRoom = examRoom;
		}

		public String prepare() {
			return "Use room " + examRoom;
		}
	}
	static class OnlineExam {
		private final String meetingLink;

		OnlineExam(String meetingLink) {
			this.meetingLink = meetingLink;
		}

		public String prepare() {
			return "Join " + meetingLink;
		}
	}

	public void clientCode() {
		OnsiteExam onsiteExam = new OnsiteExam("B-204");
		OnlineExam onlineExam = new OnlineExam("https://meet.example/exam");

		System.out.println(onsiteExam.prepare());
		System.out.println(onlineExam.prepare());
	}
}
