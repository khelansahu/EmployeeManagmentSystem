# 🧑‍💼 Employee Management System

This is a simple **Employee Management System** web application built using **Java EE (J2EE)**, **Servlets**, **JDBC**, and **MySQL**. The system allows an administrator to add employee details to a database via a styled HTML form and persist the data using JDBC.

---

## 🚀 Features

- Add new employees with:
  - ID
  - Name
  - Email
  - Password
  - Age
  - Address
- Backend logic using Java Servlets
- Data stored in a MySQL database
- Simple, clean UI with modern styling (HTML + CSS)
- MVC-based separation of concerns

---

## 🛠️ Technologies Used

- **Frontend**: HTML, CSS
- **Backend**: Java Servlets (J2EE), JDBC
- **Database**: MySQL
- **Server**: Apache Tomcat

---

## 📁 Project Structure

employee-management-system/
├── AddEmployeeAdminServlet.java # Servlet that handles form submission and inserts into DB
├── addEmployee.html # HTML form for adding employee data
├── ... (Other JSPs, HTML, Servlets if applicable)

## 🧪 Database Setup

1. Open MySQL and create the database:


1. CREATE DATABASE practice;

Create the emp table: 

2. CREATE TABLE emp (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(100),
    age INT,
    address VARCHAR(200)
);  
Ensure your JDBC configuration in the servlet is correct:

Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/practice?user=root&&password=root"
);

🚀 How to Run
1. Clone the repository:
   git clone https://github.com/your-username/employee-management-system.git
2. Import into Eclipse or IntelliJ as a Dynamic Web Project.
3. Set up Apache Tomcat in your IDE.
4. Deploy the project and visit:
   http://localhost:8080/employee-management-system/addEmployee.html
5. Fill in employee details and submit to store in the database.

📸 UI Preview
![Screenshot (17)](https://github.com/user-attachments/assets/17223531-9cb8-4214-9d03-d02cd5009ddf)
![Screenshot (18)](https://github.com/user-attachments/assets/9a83bc68-1e62-4bd0-970b-c21900b0cc46)
![Screenshot (19)](https://github.com/user-attachments/assets/0f58d692-61f6-4c8d-91c6-5476c7b3aa9b)
![Screenshot (20)](https://github.com/user-attachments/assets/5bbc3f99-0d1f-4c16-98e4-a2dc6cbb021e)
![Screenshot (14)](https://github.com/user-attachments/assets/de9dffbd-e723-4ecf-8a2b-eefdbf8c3ea9)
![Screenshot (15)](https://github.com/user-attachments/assets/2c1aaa64-974c-4b96-8895-4f5b123502cc)
![Screenshot (16)](https://github.com/user-attachments/assets/d2702ff6-8183-4609-b98b-151eea809bdd)

👨‍💻 Author
Your Name – khelan sahu

📜 License
This project is open-source and available under the MIT License.
