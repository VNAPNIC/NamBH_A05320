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
public class LibaryModel extends DataAccessHelper{
    Connection con;
    private final String SREACH = "if exists (select * from libary where code like ? or name like ?) select * from libary where code like ? or name like ? else select * from libary";
    
    public ArrayList<Libary> getSreach(String like){
        ArrayList<Libary> objs = new ArrayList<>();
        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(SREACH);
            ps.setString(1, like+"%");
            ps.setString(2, like+"%");
             ps.setString(3, like+"%");
              ps.setString(4, like+"%");
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
