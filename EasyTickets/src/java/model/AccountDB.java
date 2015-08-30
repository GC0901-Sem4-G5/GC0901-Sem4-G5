/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connection.GetConnect;
import entity.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CN
 */
public class AccountDB { 
    
    private ResultSet rs;
    private List<Account> listfaq = new ArrayList<>();

    public List<Account> findAll() {
        try {
            GetConnect conn = new GetConnect();
            Connection con = conn.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from Adminmaster");
            rs = ps.executeQuery();
            while (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt("id"));
                account.setEmail(rs.getString("email"));
                account.setFullname(rs.getString("fullname"));
                account.setPassword(rs.getString("password"));
                account.setUsername(rs.getString("username"));
                account.setRole(rs.getString("role"));
                listfaq.add(account);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listfaq;
    }
    public boolean edit(Account account) {
        boolean result = false;
        try {
            GetConnect conn = new GetConnect();
            Connection con = conn.getConnection();
            PreparedStatement ps = con.prepareStatement("update Adminmaster set username = ?, email = ?, fullname = ?,role = ?, password = ? where id = ?");
            ps.setString(1, account.getUsername());
            ps.setString(2, account.getEmail());
            ps.setString(3, account.getFullname());
            ps.setString(4, account.getRole());
            ps.setString(5, account.getPassword());
            ps.setInt(6, account.getId());
            ps.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return result;
    }
    public boolean add(Account account) {
        boolean result = false;
        try {
            GetConnect conn = new GetConnect();
            Connection con = conn.getConnection();
            PreparedStatement ps = con.prepareStatement("Insert into Adminmaster (username,email,fullname,role,password) Values(?,?,?,?,?)");
            ps.setString(1, account.getUsername());
            ps.setString(2, account.getEmail());
            ps.setString(3, account.getFullname());
            ps.setString(4, account.getRole());
            ps.setString(5, account.getPassword());
            
            ps.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return result;
    }
    public boolean delete(Account account) {
        boolean result = false;
        try {
            GetConnect conn = new GetConnect();
            Connection con = conn.getConnection();
            PreparedStatement ps = con.prepareStatement("Delete from Adminmaster where id = ?"); 
            ps.setInt(1, account.getId());
            ps.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return result;
    }
    
    public Account checkLogin(String username, String password) {
        
        Account account = null;
        
        try {

            GetConnect conn = new GetConnect();
            Connection con = conn.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * from [Adminmaster] where username = ? and [password]=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                account = new Account();
                account.setId(rs.getInt("id"));
                account.setEmail(rs.getString("email"));
                account.setFullname(rs.getString("fullname"));
                account.setPassword(rs.getString("password"));
                account.setUsername(rs.getString("username"));
                account.setRole(rs.getString("role"));
            } 

        } catch (SQLException ex) {
            Logger.getLogger(AccountModel.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return account;
        
    }
}
