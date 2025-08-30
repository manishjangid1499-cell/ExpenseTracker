import java.sql.Date;

public class Expense {
    private int id;
    private String title;
    private double amount;
    private String category;
    private Date date;
    private String notes;

    // Constructor without ID (for new expenses)
    public Expense(String title, double amount, String category, Date date, String notes) {
        this.title = title;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.notes = notes;
    }

    // Constructor with ID (for existing expenses)
    public Expense(int id, String title, double amount, String category, Date date, String notes) {
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.notes = notes;
    }

    // Getters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public double getAmount() { return amount; }
    public String getCategory() { return category; }
    public Date getDate() { return date; }
    public String getNotes() { return notes; }
}
