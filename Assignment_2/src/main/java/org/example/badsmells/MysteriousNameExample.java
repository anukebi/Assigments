package org.example.badsmells;

/*
 * Smell: Mysterious Name
 *
 * The names f, a, b, c, x, and y tell the reader almost nothing. Understanding
 * the code requires reverse-engineering instead of reading intention.
 *
 * Proposed Refactorings:
 * - Rename method and variables to reveal intent.
 * - Extract named helper methods if the calculation has distinct steps.
 */
public class MysteriousNameExample {

	public int computeWeightedDifference(int multiplier, int multiplicand, int subtrahend) {
		int product = multiplier * multiplicand;
		int difference = product - subtrahend;
		return difference / 2;
	}

	public void clientCode() {
		int result = computeWeightedDifference(8, 4, 6);
		System.out.println(result);
	}
}
