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
public class billDao {
    public static ArrayList<Medicine> searchMedicineByName(String name) {
    ArrayList<Medicine> arrayList = new ArrayList<>();
    try {
        ResultSet rs = DbOperations.getData("SELECT * FROM medicine WHERE name LIKE '%" + name + "%'");
        while (rs.next()) {
            Medicine medicine = new Medicine();
            medicine.setName(rs.getString("name"));
            arrayList.add(medicine);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }
    return arrayList;
}
 
    public static Medicine getMedicineByName(String name) {
    Medicine medicine = null; // Initialize to null

    try {
        ResultSet rs = DbOperations.getData("SELECT * FROM medicine WHERE name = '" + name + "'");
        if (rs.next()) {
            // If a medicine is found, populate the medicine object
            medicine = new Medicine();
            medicine.setUniqueId(rs.getString("uniqueId"));
            medicine.setName(rs.getString("name"));
            medicine.setCompanyName(rs.getString("companyName"));
            medicine.setPrice(rs.getDouble("price"));
            medicine.setQuantity(rs.getInt("quantity"));
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }
    return medicine; // Return null if no medicine is found
}


    
}
