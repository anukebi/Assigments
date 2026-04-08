package org.example.badsmells;

/*
 * Smell: Refused Bequest
 *
 * Penguin inherits from Bird but rejects part of the inherited contract by
 * throwing from fly(). That means the inheritance relationship is misleading.
 *
 * Proposed Refactorings:
 * - Replace inheritance with a better hierarchy or composition.
 * - Push flying behavior down only to birds that actually fly.
 */
public class RefusedBequestExample {

	interface Flyable {
			void fly();
		}

	static class Bird {

		public void chirp() {
			System.out.println("Chirping");
		}
	}

		static class Sparrow extends Bird implements Flyable {
			@Override
			public void fly() {
				System.out.println("Sparrow is flying");
			}
		}

		static class Eagle extends Bird implements Flyable {
			@Override
			public void fly() {
				System.out.println("Eagle is soaring");
			}
		}

	static class Penguin extends Bird {

	}

	public void clientCode() {
		Bird sparrow = new Sparrow();
		Bird eagle = new Eagle();
		Bird penguin = new Penguin();

		sparrow.chirp();
		eagle.chirp();
		penguin.chirp();

		if (sparrow instanceof Flyable) ((Flyable) sparrow).fly();
		if (eagle instanceof Flyable) ((Flyable) eagle).fly();
	}
}
