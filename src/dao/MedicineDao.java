/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Medicine;
import java.sql.*;

/**
 *
 * @author win10
 */
public class MedicineDao {

    public static void save(Medicine medicine) {
        String query = "INSERT INTO medicine(uniqueId, name, companyName, quantity, price) VALUES ('" + medicine.getUniqueId() + "','" + medicine.getName() + "','" + medicine.getCompanyName() + "','" + medicine.getQuantity() + "','" + medicine.getPrice() + "')";
        DbOperations.setDataOrDelete(query, "Registered Successfully");
    }

    public static ArrayList<Medicine> getAllRecords() {
        ArrayList<Medicine> arrayList = new ArrayList<>();
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM medicine");
            while (rs.next()) {
                Medicine medicine = new Medicine();
                medicine.setId(rs.getInt("id")); // Setting the id field
                medicine.setUniqueId(rs.getString("uniqueId"));
                medicine.setName(rs.getString("name"));
                medicine.setCompanyName(rs.getString("companyName"));
                medicine.setQuantity(rs.getInt("quantity"));
                medicine.setPrice(rs.getDouble("price"));
                arrayList.add(medicine);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return arrayList;
    }

    public static void delete(String uniqueId) {
        String query = "DELETE FROM medicine WHERE uniqueId = '" + uniqueId + "'";
        DbOperations.setDataOrDelete(query, "Deleted Successfully");
    }

    public static Medicine getMedicineByName(String name) {
        Medicine medicine = null;
        try {
            ResultSet rs = DbOperations.getData("SELECT * FROM medicine WHERE name = '" + name + "'");
            if (rs.next()) {
                medicine = new Medicine();
                medicine.setUniqueId(rs.getString("uniqueId"));
                medicine.setName(rs.getString("name"));
                medicine.setCompanyName(rs.getString("companyName"));
                medicine.setQuantity(rs.getInt("quantity"));
                medicine.setPrice(rs.getDouble("price"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return medicine;
    }

    public static void update(String name, int quantity, double price) {
        String query = "UPDATE medicine SET quantity = " + quantity + ", price = " + price + " WHERE name = '" + name + "'";
        DbOperations.setDataOrDelete(query, "Quantity and price updated successfully");
    }
    
    public static ArrayList<Medicine> getAllRecordsByName(String name) {
    ArrayList<Medicine> medicines = new ArrayList<>();
    try {
        ResultSet rs = DbOperations.getData("SELECT * FROM medicine WHERE name LIKE '%" + name + "%'");
        while (rs.next()) {
            Medicine medicine = new Medicine();
            medicine.setId(rs.getInt("id"));
            medicine.setUniqueId(rs.getString("uniqueId"));
            medicine.setName(rs.getString("name"));
            medicine.setCompanyName(rs.getString("companyName"));
            medicine.setQuantity(rs.getInt("quantity"));
            medicine.setPrice(rs.getDouble("price"));
            medicines.add(medicine);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    return medicines;
}



}
