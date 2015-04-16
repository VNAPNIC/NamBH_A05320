/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author NamIT
 */
public class StatusModel extends DataAccessHelper{
    Connection con;
    private final String UPDATE = "UPDATE libary SET bon=? where code=?";
    
    public boolean updateStatus(int code,boolean bon){
       boolean check = false;
        try {
            con = getConnection();
                PreparedStatement ps = con.prepareStatement(UPDATE);
                ps.setBoolean(1, bon==true?false:true);
                ps.setInt(2, code);
                int rs = ps.executeUpdate();
                if(rs > 0){
                    check = true;
                }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
       return check;
    }
}
