import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDAO {
    // Add new expense
    public void addExpense(Expense e) throws Exception {
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO expenses (title, amount, category, date, notes) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, e.getTitle());
        stmt.setDouble(2, e.getAmount());
        stmt.setString(3, e.getCategory());
        stmt.setDate(4, e.getDate());
        stmt.setString(5, e.getNotes());
        stmt.executeUpdate();
        conn.close();
    }

    // View all expenses
    public List<Expense> getAllExpenses() throws Exception {
        List<Expense> list = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT * FROM expenses";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            list.add(new Expense(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getDouble("amount"),
                rs.getString("category"),
                rs.getDate("date"),
                rs.getString("notes")
            ));
        }
        conn.close();
        return list;
    }

    // Delete expense by ID
    public void deleteExpense(int id) throws Exception {
        Connection conn = DBConnection.getConnection();
        String sql = "DELETE FROM expenses WHERE id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        conn.close();
    }

    // Update expense
    public void updateExpense(Expense e) throws Exception {
        Connection conn = DBConnection.getConnection();
        String sql = "UPDATE expenses SET title=?, amount=?, category=?, date=?, notes=? WHERE id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, e.getTitle());
        stmt.setDouble(2, e.getAmount());
        stmt.setString(3, e.getCategory());
        stmt.setDate(4, e.getDate());
        stmt.setString(5, e.getNotes());
        stmt.setInt(6, e.getId());
        stmt.executeUpdate();
        conn.close();
    }

    // Summary: category-wise total
    public void categorySummary() throws Exception {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT category, SUM(amount) as total FROM expenses GROUP BY category";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("Category Summary:");
        while (rs.next()) {
            System.out.println(rs.getString("category") + " => " + rs.getDouble("total"));
        }
        conn.close();
    }

    // Summary: monthly total
    public void monthlySummary() throws Exception {
        Connection conn = DBConnection.getConnection();
        String sql = "SELECT MONTH(date) as month, SUM(amount) as total FROM expenses GROUP BY MONTH(date)";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("Monthly Summary:");
        while (rs.next()) {
            System.out.println("Month " + rs.getInt("month") + " => " + rs.getDouble("total"));
        }
        conn.close();
    }
}
