/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connection.GetConnect;
import entity.event;
import entity.faq;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dattr_000
 */
public class FAQModel {

    private ResultSet rs;
    

    public List<faq> getFAQ() {
        List<faq> listfaq = new ArrayList<>();
        try {
            GetConnect conn = new GetConnect();
            Connection con = conn.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from FAQ");
            rs = ps.executeQuery();
            while (rs.next()) {
                listfaq.add(new faq(rs.getInt("id"),rs.getString("question"),rs.getString("answer")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listfaq;
    }
    public boolean edit(faq faq) {
        boolean result = false;
        try {
            GetConnect conn = new GetConnect();
            Connection con = conn.getConnection();
            PreparedStatement ps = con.prepareStatement("update FAQ set question = ?, answer = ? where id = ?");
            ps.setString(1, faq.getQuestion());
            ps.setString(2, faq.getAnswer());
            ps.setInt(3, faq.getId());
            ps.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return result;
    }
    public boolean add(faq faq) {
        boolean result = false;
        try {
            GetConnect conn = new GetConnect();
            Connection con = conn.getConnection();
            PreparedStatement ps = con.prepareStatement("Insert into FAQ (question,answer) Values(?,?)");
            ps.setString(1, faq.getQuestion());
            ps.setString(2, faq.getAnswer());
            
            ps.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return result;
    }
    public boolean delete(faq faq) {
        boolean result = false;
        try {
            GetConnect conn = new GetConnect();
            Connection con = conn.getConnection();
            PreparedStatement ps = con.prepareStatement("Delete from FAQ where id = ?"); 
            ps.setInt(1, faq.getId());
            ps.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return result;
    }
}
