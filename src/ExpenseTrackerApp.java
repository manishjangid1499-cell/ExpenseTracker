/**
 * Expense Tracker Application
 * Author: Manish Jangid
 * Description: A simple Java console application to manage daily expenses with MySQL.
 */

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class ExpenseTrackerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseDAO dao = new ExpenseDAO();

        while (true) {
            System.out.println("\n=== Expense Tracker ===");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Update Expense");
            System.out.println("4. Delete Expense");
            System.out.println("5. Category Summary");
            System.out.println("6. Monthly Summary");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Title: ");
                        String title = sc.next();
                        System.out.print("Amount: ");
                        double amount = sc.nextDouble();
                        System.out.print("Category: ");
                        String category = sc.next();
                        System.out.print("Date (YYYY-MM-DD): ");
                        String dateStr = sc.next();
                        System.out.print("Notes: ");
                        String notes = sc.next();

                        Expense e = new Expense(title, amount, category, Date.valueOf(dateStr), notes);
                        dao.addExpense(e);
                        System.out.println("Expense added!");
                        break;

                    case 2:
                        List<Expense> list = dao.getAllExpenses();
                        for (Expense ex : list) {
                            System.out.println(ex.getId() + " | " + ex.getTitle() + " | " + ex.getAmount() +
                                               " | " + ex.getCategory() + " | " + ex.getDate() +
                                               " | " + ex.getNotes());
                        }
                        break;

                    case 3:
                        System.out.print("Enter ID to update: ");
                        int id = sc.nextInt();
                        System.out.print("New Title: ");
                        String nt = sc.next();
                        System.out.print("New Amount: ");
                        double na = sc.nextDouble();
                        System.out.print("New Category: ");
                        String nc = sc.next();
                        System.out.print("New Date (YYYY-MM-DD): ");
                        String nd = sc.next();
                        System.out.print("New Notes: ");
                        String nn = sc.next();
                        Expense updated = new Expense(id, nt, na, nc, Date.valueOf(nd), nn);
                        dao.updateExpense(updated);
                        System.out.println("Expense updated!");
                        break;

                    case 4:
                        System.out.print("Enter ID to delete: ");
                        int did = sc.nextInt();
                        dao.deleteExpense(did);
                        System.out.println("Expense deleted!");
                        break;

                    case 5:
                        dao.categorySummary();
                        break;

                    case 6:
                        dao.monthlySummary();
                        break;

                    case 7:
                        System.out.println("Goodbye!");
                        sc.close();
                        System.exit(0);
                        break;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
