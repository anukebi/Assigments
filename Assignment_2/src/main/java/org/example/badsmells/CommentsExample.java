package org.example.badsmells;

/*
 * Smell: Comments
 *
 * The issue is not that comments exist. The issue is that the comments are
 * compensating for code that should explain itself better through structure and
 * naming.
 *
 * Proposed Refactorings:
 * - Extract intention-revealing methods.
 * - Rename variables and methods so the code explains itself.
 */
public class CommentsExample {

	private static final double VIP_DISCOUNT_SCALE = 0.90;
	private static final double BULK_DISCOUNT_SCALE = 0.95;
	private static final int BULK_DISCOUNT_THRESHOLD = 20;
	private static final double TAX_SCALE = 1.18;

	public double finalPrice(double basePrice, boolean vip, int quantity) {
		double price = basePrice;
		price = applyVipDiscountIfNeeded(price, vip);
		price = applyBulkDiscountIfNeeded(price, quantity);
		price = applyTax(price);
		return price;
	}

	private double applyVipDiscountIfNeeded(double price, boolean vip) {
        return vip
				? price * VIP_DISCOUNT_SCALE
				: price;
    }

	private double applyBulkDiscountIfNeeded(double price, int quantity) {
        return quantity > BULK_DISCOUNT_THRESHOLD
				? price * BULK_DISCOUNT_SCALE
				: price;
    }

	private double applyTax(double price) {
		return price * TAX_SCALE;
	}

	public void clientCode() {
		double vipOrder = finalPrice(120, true, 25);
		double regularOrder = finalPrice(120, false, 5);
		System.out.println(vipOrder);
		System.out.println(regularOrder);
	}

}
