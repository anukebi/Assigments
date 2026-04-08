package org.example.badsmells;

/*
 * Smell: Long Function
 *
 * One function handles discount calculation, shipping, tax, approval logic, and
 * output formatting. Several distinct tasks are mixed into one block.
 *
 * Proposed Refactorings:
 * - Extract methods for discount, shipping, tax, and approval logic.
 * - Introduce parameter object or helper class if data starts traveling together.
 */
public class LongFunctionExample {

	public String processOrder(String customerType, int quantity, double price, boolean expressDelivery) {

		double subtotal = calculateSubtotal(quantity, price);
		double discount = calculateDiscount(customerType, subtotal);
		double shipping = calculateShipping(quantity, expressDelivery);
		double tax = calculateTax(subtotal, discount);
		double total = subtotal - discount + shipping + tax;
		String status = determineApprovalStatus(total);

		return formatSummary(customerType, quantity, price, subtotal, discount, shipping, tax, total, status);
	}

	private double calculateSubtotal(int quantity, double price) {
		return quantity * price;
	}

	private double calculateDiscount(String customerType, double subtotal) {
		switch (customerType) {
			case "STUDENT": return subtotal * 0.05;
			case "VIP": return subtotal * 0.12;
			case "EMPLOYEE": return subtotal * 0.20;
			default: return 0;
		}
	}

	private double calculateShipping(int quantity, boolean expressDelivery) {
		double shipping = expressDelivery ? 25 : 10;
		if (quantity > 10) {
			shipping += expressDelivery ? 10 : 5;
		}
		return shipping;
	}

	private double calculateTax(double subtotal, double discount) {
		return (subtotal - discount) * 0.18;
	}

	private String determineApprovalStatus(double total) {
		if (total > 500) return "MANAGER_APPROVAL";
		if (total > 200) return "FINANCE_REVIEW";
		return "AUTO_APPROVED";
	}
	private String formatSummary(String customerType, int quantity, double price, double subtotal, double discount,
								 double shipping, double tax, double total, String status) {
		return new StringBuilder()
				.append("customerType=").append(customerType).append('\n')
				.append("quantity=").append(quantity).append('\n')
				.append("price=").append(price).append('\n')
				.append("subtotal=").append(subtotal).append('\n')
				.append("discount=").append(discount).append('\n')
				.append("shipping=").append(shipping).append('\n')
				.append("tax=").append(tax).append('\n')
				.append("total=").append(total).append('\n')
				.append("status=").append(status)
				.toString();
	}

	public void clientCode() {
		System.out.println(processOrder("VIP", 12, 30, true));
		System.out.println(processOrder("STUDENT", 2, 50, false));
	}
}
