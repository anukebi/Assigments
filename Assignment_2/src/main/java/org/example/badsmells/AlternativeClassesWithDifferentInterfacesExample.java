package org.example.badsmells;

/*
 * Smell: Alternative Classes with Different Interfaces
 *
 * ZoomClassroom and TeamsClassroom serve a similar purpose, but their APIs do
 * not match. Because clients cannot use them through one shared protocol, code
 * must branch or adapt between them.
 *
 * Proposed Refactorings:
 * - Align the interfaces with common method names and semantics.
 * - Introduce a shared abstraction or adapter.
 */

public class AlternativeClassesWithDifferentInterfacesExample {

	static class ZoomClassroom implements Classroom {
		@Override
		public void startSession() {
			System.out.println("Zoom session started");
		}
	}

	static class TeamsClassroom implements Classroom {
		@Override
		public void startSession() {
			System.out.println("Teams meeting started");

		}
	}

	interface Classroom {
		void startSession();
	}

	public void clientCode() {
		Classroom zoom = new ZoomClassroom();
		Classroom teams = new TeamsClassroom();

		zoom.startSession();
		teams.startSession();
	}
}
