# Expense Tracker (Java + MySQL)

## 📌 Project Overview
This is a **console-based Expense Tracker application** built with **Java** and **MySQL**.  
It allows users to record, update, delete, and view daily expenses.  
Additionally, it provides **category-wise** and **monthly summaries**.

## 🚀 Features
- Add, view, update, and delete expenses  
- Category-wise expense summary  
- Monthly expense summary  
- MySQL database integration using JDBC  

## 🛠 Tech Stack
- Java (Core + JDBC)
- MySQL
- MySQL Connector/J

## 📂 Project Structure
```
ExpenseTracker/
 ├── src/                   # Java source code
 ├── lib/                   # External libraries (e.g., MySQL connector)
 ├── sql/                   # Database schema
 └── README.md              # Project documentation
```

## ⚙️ Setup Instructions
1. Import the project into your IDE (Eclipse/IntelliJ/NetBeans).  
2. Add the MySQL Connector JAR file to your classpath (`lib/` folder).  
3. Run the SQL script inside `sql/expense_tracker.sql` in MySQL Workbench.  
4. Update `DBConnection.java` with your MySQL username & password.  
5. Run `ExpenseTrackerApp.java`.  

## 🎯 Usage
Run the application and use the console menu:  
1. Add Expense  
2. View Expenses  
3. Update Expense  
4. Delete Expense  
5. Category Summary  
6. Monthly Summary  
7. Exit  

## 👤 Author
Developed by [Manish Jangid]

