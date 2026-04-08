package org.example.badsmells;

import java.util.ArrayList;
import java.util.List;

/*
 * Smell: Large Class
 *
 * This class mixes enrollment, staffing, finance, cafeteria, transport, help
 * desk, payroll, and website concerns. Too many responsibilities are being kept
 * in one abstraction.
 *
 * Proposed Refactorings:
 * - Extract cohesive subsets into separate classes.
 * - Split responsibilities by domain area and move related fields with behavior.
 */
public class LargeClassExample {
	static class Enrollment {
		private final List<String> students = new ArrayList<>();
		private final List<String> teachers = new ArrayList<>();
		private final List<String> courses = new ArrayList<>();

		public void enrollStudent(String student) {
			students.add(student);
		}

		public void hireTeacher(String teacher) {
			teachers.add(teacher);
		}

		public void addCourse(String course) {
			courses.add(course);
		}

		public List<String> getStudents() {
			return students;
		}
	}

	static class Finance {
		private double budget;
		private String payrollDay;

		public void chargeTuition(double amount) {
			budget += amount;
		}

		public void paySalary(double amount) {
			budget -= amount;
		}

		public void setPayrollDay(String day) {
			payrollDay = day;
		}

		public double getBudget() {
			return budget;
		}
	}

	static class HelpDesk {
		private int openTickets;

		public void openTicket() {
			openTickets++;
		}

		public int getOpenTickets() {
			return openTickets;
		}
	}

	static class Website {
		private String theme;

		public void updateTheme(String theme) {
			this.theme = theme;
		}

		public String getTheme() {
			return theme;
		}
	}

	static class Transport {
		private String busSchedule;

		public void publishBusSchedule(String schedule) {
			busSchedule = schedule;
		}

		public String getBusSchedule() {
			return busSchedule;
		}
	}

	static class Cafeteria {
		private String menu;

		public void publishMenu(String menu) {
			this.menu = menu;
		}

		public String getMenu() {
			return menu;
		}
	}

	public void clientCode() {
		Enrollment enrollment = new Enrollment();
		Finance finance = new Finance();
		HelpDesk helpDesk = new HelpDesk();
		Website website = new Website();
		Transport transport = new Transport();
		Cafeteria cafeteria = new Cafeteria();

		enrollment.enrollStudent("Nino");
		enrollment.hireTeacher("Ms. Kapanadze");
		enrollment.addCourse("Refactoring");

		finance.chargeTuition(2400);
		finance.paySalary(1200);
		finance.setPayrollDay("Friday");

		helpDesk.openTicket();
		website.updateTheme("blue");
		transport.publishBusSchedule("Route A at 08:00");
		cafeteria.publishMenu("Soup and salad");
	}

}
