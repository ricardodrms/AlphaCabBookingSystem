/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author k9-sheppard
 */
public class CustomerDB {
    
    private Connection conn;
    private Statement state;
    private ResultSet rs;
    
    public CustomerDB() {
        this.conn = DBConfig.getConnection();
    }
    
    public boolean addCustomer(Customer cust){
        try {
            state = conn.createStatement();
            state.executeUpdate(String.format(
                    "INSERT INTO customer (`Name`, `Address`) VALUES ('%s', '%s')", cust.getName(), cust.getAddress()));
            state.close();

        } catch (SQLException e) {
            return false;
        }
        return true;
    }
    
    public boolean editCustomer(Customer cust){
        try {
            state = conn.createStatement();
            state.executeUpdate(String.format(
                    "UPDATE customer SET Name = '%s', Address = '%s' WHERE id = %d", cust.getName(), cust.getAddress(), cust.getId()));
            state.close();

        } catch (SQLException e) {
            return false;
        }
        return true;
    }
    
    
}
