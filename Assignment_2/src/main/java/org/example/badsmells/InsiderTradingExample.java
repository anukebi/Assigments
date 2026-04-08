package org.example.badsmells;

/*
 * Smell: Insider Trading
 *
 * AuditService manipulates BankAccount internals directly. The classes know too
 * much about each other's data and become tightly coupled.
 *
 * Proposed Refactorings:
 * - Move account-specific decisions into BankAccount.
 * - Hide fields and expose intention-revealing methods instead.
 */
public class InsiderTradingExample {

	static class BankAccount {
		private double balance;
		private String status;

		public BankAccount(double balance) {
			this.balance = balance;
			this.status = "ACTIVE";
		}

		public double getBalance() {
			return balance;
		}

		public String getStatus() {
			return status;
		}

		public void freezeIfOverdrawn() {
			if (balance < 0) {
				status = "FROZEN";
			}
		}
	}
	static class AuditService {
		public void freezeIfNeeded(BankAccount account) {
			account.freezeIfOverdrawn();
		}
	}

	public void clientCode() {
		BankAccount account = new BankAccount(-50);

		AuditService auditService = new AuditService();
		auditService.freezeIfNeeded(account);

		System.out.println(account.getStatus());
	}
}
