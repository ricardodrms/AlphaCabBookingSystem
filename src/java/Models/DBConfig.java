/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author k9-sheppard
 */
public class DBConfig {
    private static Connection connection = null;  
  
  
  
    public static Connection getConnection() {  
  
        if (connection != null)  
  
            return connection;  
  
        else {  
  
            try {  
  
//                Properties prop = new Properties();  
//  
//                InputStream inputStream = DBConfig.class.getClassLoader().getResourceAsStream("/db.properties");  
//  
//                prop.load(inputStream);  
//  
//                String driver = prop.getProperty("driver");  
//  
//                String url = prop.getProperty("url");  
//  
//                String user = prop.getProperty("user");  
//  
//                String password = prop.getProperty("password");  
//  
//                Class.forName(driver);  
  
 //               connection = DriverManager.getConnection(url, user, password); 
                          Class.forName("com.mysql.jdbc.Driver");

                    connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/Alphacab", "root", ""); 
  
           } 
              catch (ClassNotFoundException e) {  
  
                e.printStackTrace();  
  
            } 
            catch (SQLException e) {  
  
                e.printStackTrace();  
  
            } 
            //catch (FileNotFoundException e) {  
//  
//                e.printStackTrace();  
//  
//            } catch (IOException e) {  
//  
//                e.printStackTrace();  
//  
 //         }  
  
            return connection;  
  
        }  
  
  
  
    }  
}