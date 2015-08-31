/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connection.GetConnect;
import entity.contactus;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dattr_000
 */
public class ContactUsModel {

    public boolean createContact(String name, String email, String phone, String content) {
        boolean status = false;
        int result = 0;
        GetConnect conn = new GetConnect();
        Connection con = conn.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO [ContactUs] (name, email,phone,content,created ) VALUES (?,?,?,?,?)");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, content);
            java.util.Date today = new java.util.Date();
            ps.setDate(5, new java.sql.Date(today.getTime()));
            result = ps.executeUpdate();
            if (result > 0) {
                status = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            status = false;
        }
        return status;
    }
    
    private ResultSet rs;
    

    public List<contactus> getContactUs() {
        List<contactus> listContactus = new ArrayList<>();
        try {
            GetConnect conn = new GetConnect();
            Connection con = conn.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from ContactUs");
            rs = ps.executeQuery();
            while (rs.next()) {
                contactus contactus = new contactus();
                contactus.setId(rs.getInt("id"));
                contactus.setName(rs.getString("name"));
                contactus.setContent(rs.getString("content"));
                contactus.setPhone(rs.getString("phone"));
                contactus.setEmail(rs.getString("email"));
                String date = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("created"));
                contactus.setCreated(date);
                listContactus.add(contactus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listContactus;
    }
    
    public boolean delete(contactus contactus) {
        boolean result = false;
        try {
            GetConnect conn = new GetConnect();
            Connection con = conn.getConnection();
            PreparedStatement ps = con.prepareStatement("Delete from ContactUs where id = ?"); 
            ps.setInt(1, contactus.getId());
            ps.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return result;
    }
}
