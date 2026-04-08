package org.example.badsmells;

/*
 * Smell: Speculative Generality
 *
 * The interface carries extra options for future scenarios, but the
 * implementation ignores them. The abstraction is prepared for variation that
 * does not currently exist.
 *
 * Proposed Refactorings:
 * - Remove unused parameters and options.
 * - Inline or simplify abstractions that only support imaginary requirements.
 */
public class SpeculativeGeneralityExample {

	interface NotificationChannel {

		void send(String message);
	}

	static class EmailChannel implements NotificationChannel {

		@Override
		public void send(String message) {
			System.out.println(message);
		}
	}

	public void clientCode() {
		NotificationChannel channel = new EmailChannel();
		channel.send("Exam starts at 10:00");
	}
}
