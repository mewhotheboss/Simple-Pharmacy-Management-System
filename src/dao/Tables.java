package dao;

import javax.swing.JOptionPane;
import java.sql.*;

public class Tables {

    public static void main(String[] args) {
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();

//            String appuser = "CREATE TABLE user (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(200), dob VARCHAR(50), mobileNumber VARCHAR(11), email VARCHAR(200), userName VARCHAR(50), password VARCHAR(50), address VARCHAR(200), securityQuestion VARCHAR(200), answer VARCHAR(200), UNIQUE(email))";
//            String admindetails = "insert into user(name,dob,mobileNumber,email,userName,password,address,securityQuestion,answer) values('Abdul Kuddus','12-01-1980','01678954685','kuddus@gmail.com','Admin','kuddus','Dhaka','What is your hobby?','Eating')";
//            String medicinedetails = "CREATE TABLE medicine(id INT AUTO_INCREMENT PRIMARY KEY, uniqueId varchar(200), name varchar(200), companyName varchar(200), quantity bigint, price bigint ) ";
            String bill = "create table bill( bill_pk int AUTO_INCREMENT PRIMARY KEY, billId varchar(200), billDate varchar(50), totalPaid bigint, generatedBy varchar(50))";

//            DbOperations.setDataOrDelete(appuser, "User Table Created Succesfully");
//            DbOperations.setDataOrDelete(admindetails, "Admin table added Succesfully");
//            DbOperations.setDataOrDelete(medicinedetails, "Medicine table added Succesfully");
            DbOperations.setDataOrDelete(bill, "Medicine table added Succesfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
