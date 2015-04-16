/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NamIT
 */
public class DataAccessHelper {
    private Connection con;
    private final String PORT = "1433";
    private final String HOSTNAME = "localhost";
    private final String DB_NAME = "WPSJAsm";
    private final String DB_USER = "sa";
    private final String DB_PASS = "123456";
    private final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final String URL = "jdbc:sqlserver://" + HOSTNAME + ":" + PORT + ";databaseName=" + DB_NAME;

    protected void driverTest() throws Exception {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (java.lang.ClassNotFoundException e) {
            throw new Exception("JDBC Driver not found!");
        }
    }

    protected Connection getConnection() throws Exception {
        if (this.con == null) {
            driverTest();

            try {
                this.con = DriverManager.getConnection(URL, DB_USER, DB_PASS);
            } catch (java.sql.SQLException e) {
                throw new Exception("Can not connect to DataBase Server: " + URL + e.getMessage());
            }
        }
        return this.con;
    }

    public void getClose() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
