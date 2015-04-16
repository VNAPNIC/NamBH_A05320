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
public class LoginModel  extends DataAccessHelper{
    Connection con;
    private final String CHECK_LOGIN ="select * from [Login] where [user]=? and pass=?";
    public boolean checklogin(String name,String pass){
        boolean check = false;
        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(CHECK_LOGIN);
            ps.setString(1, name);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();            
            check = rs.next();
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
}
