package org.example.badsmells;

/*
 * Smell: Global Data
 *
 * These public static fields are reachable from anywhere. That makes ownership
 * weak and makes changes harder to track.
 *
 * Proposed Refactorings:
 * - Encapsulate the global variables behind methods.
 * - Move the state into a dedicated object with controlled access.
 */
public class GlobalDataExample {
	public static class UniversityContext {
		private String currentSemester = "SPRING";
		private double tuitionRate = 1250.0;

		public String getCurrentSemester() {
			return currentSemester;
		}

		public double getTuitionRate() {
			return tuitionRate;
		}

		public void applyEmergencyIncrease(double delta) {
			tuitionRate += delta;
		}

		public void openFallSemester() {
			currentSemester = "FALL";
		}

		public void approveRateIncrease(double delta) {
			tuitionRate += delta;
		}
	}

	static class BillingService {
		private final UniversityContext context;

		public BillingService(UniversityContext context) {
			this.context = context;
		}

		public double calculateInvoice(int credits) {
			return credits * context.getTuitionRate();
		}
	}

	static class SemesterAdministration {
		private final UniversityContext context;

		public SemesterAdministration(UniversityContext context) {
			this.context = context;
		}

		public void openFallSemester() {
			context.openFallSemester();
		}

		public void approveRateIncrease() {
			context.approveRateIncrease(100);
		}
	}


	public void clientCode() {
		UniversityContext context = new UniversityContext();
		BillingService billingService = new BillingService(context);
		SemesterAdministration administration = new SemesterAdministration(context);

		System.out.println(context.getCurrentSemester());
		System.out.println(billingService.calculateInvoice(3));
		administration.openFallSemester();
		administration.approveRateIncrease();
		System.out.println(context.getCurrentSemester());
		System.out.println(billingService.calculateInvoice(3));
	}

}
