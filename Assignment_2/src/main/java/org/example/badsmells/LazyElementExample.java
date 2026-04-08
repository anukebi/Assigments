package org.example.badsmells;

/*
 * Smell: Lazy Element
 *
 * This helper class exists only to trim a string. The extra structure buys very
 * little value and is probably not worth keeping.
 *
 * Proposed Refactorings:
 * - Inline the class into its caller.
 * - Remove the abstraction unless it has real variation or behavior to hold.
 */
public class LazyElementExample {
	public void clientCode() {
		String studentName = "  Nino  ";
		System.out.println(studentName.trim());
	}
}


