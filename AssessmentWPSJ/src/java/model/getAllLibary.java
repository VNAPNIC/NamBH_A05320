/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Libary;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author NamIT
 */
public class getAllLibary extends DataAccessHelper{
    Connection con;
    private final String GET_ALL = "select * from libary";
    
    public ArrayList<Libary> getAll(){
        ArrayList<Libary> objs = new ArrayList<>();
        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Libary item = new Libary();
                item.setCode(rs.getInt("code"));
                item.setName(rs.getString("name"));
                item.setAuther(rs.getString("author"));
                item.setBon(rs.getBoolean("bon"));
                objs.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
}
