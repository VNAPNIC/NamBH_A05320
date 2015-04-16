/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Story;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author NamIT
 */
public class StoryMoel extends DataAccessHelper{
    Connection con;
    private final String INSERT = 
            "INSERT INTO detail " + 
            "VALUES (?,?,?);";
    private final String GET_ALL = "select * from detail where [user]=?";
    
    public boolean AddStory(String date,String name,int code){
       boolean check = false;
        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(INSERT);
            ps.setString(1,date);
            ps.setString(2, name);
            ps.setInt(3, code);
            int rs = ps.executeUpdate();
            if(rs >0){
                check = true;
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
    
    public ArrayList<Story> getALL(String name){
        ArrayList<Story> objs = new ArrayList<>();
        try {
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Story item = new Story();
                item.setId(rs.getInt("id"));
                item.setDate(rs.getString("date"));
                item.setUser(rs.getString("user"));
                item.setCode(rs.getInt("code"));
                objs.add(item);
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
}
