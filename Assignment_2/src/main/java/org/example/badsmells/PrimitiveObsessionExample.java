package org.example.badsmells;

/*
 * Smell: Primitive Obsession
 *
 * Status, country, debt, and age are handled as raw primitives instead of
 * domain concepts with their own rules and meaning.
 *
 * Proposed Refactorings:
 * - Replace primitives with domain objects or enums.
 * - Move validation and business rules into those domain types.
 */
public class PrimitiveObsessionExample {

	public enum StudentStatus {
		ACTIVE, BLOCKED
	}

	public enum CountryCode {
		GE, US, OTHER
	}

	public boolean canRentDormRoom(int age, StudentStatus status, double unpaidBalance, CountryCode country) {
		return age >= 18
				&& status == StudentStatus.ACTIVE
				&& unpaidBalance < 100
				&& country == CountryCode.GE;
	}

	public void clientCode() {
		System.out.println(canRentDormRoom(19, StudentStatus.ACTIVE, 0.0, CountryCode.GE));
		System.out.println(canRentDormRoom(17, StudentStatus.BLOCKED, 120.0, CountryCode.US));
	}
}
