package org.example.badsmells;

/*
 * Smell: Duplicated Code
 *
 * Both invoice methods repeat the same pricing logic. If the pricing rules
 * change, multiple copies must be found and kept in sync.
 *
 * Proposed Refactorings:
 * - Extract the shared pricing logic into one method.
 * - Move the shared behavior into a dedicated pricing class if needed.
 */
public class DuplicatedCodeExample {

	public double summerInvoice(double subtotal) {
		return calculateTotal(subtotal, 0.10, 0);
	}

	public double winterInvoice(double subtotal) {
		return calculateTotal(subtotal, 0.20, 50);
	}

	private double calculateTotal(double subtotal, double discountRate, double flatDiscount) {
		double tax = subtotal * 0.18;
		double shipping = subtotal > 100 ? 0 : 15;

		double discount;
		if (subtotal > 200) {
			discount = subtotal * discountRate;
		} else {
			discount = flatDiscount;
		}

		return subtotal + tax + shipping - discount;
	}

	public void clientCode() {
		System.out.println(summerInvoice(240));
		System.out.println(winterInvoice(240));
	}
}
