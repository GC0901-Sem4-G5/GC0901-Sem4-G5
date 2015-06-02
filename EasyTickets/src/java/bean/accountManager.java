/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Monki
 */
@ManagedBean
@SessionScoped
public class accountManager {
    private Connection conn;
    private String username;
    private String password;
    private String email;
    private String newPassword;
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
    
    private ResultSet rs;
    /**
     * Creates a new instance of accountManager
     */
    public accountManager() {
    }
    
    public String login(String username, String password, String url) {
        try {
            PreparedStatement ps = conn.prepareStatement("select * from [user] where username=? and [password] = ?");
            ps.execute(username, 1);
            ps.execute(password, 2);
            rs = ps.executeQuery();
            if(username.equals(rs.getString("username")) && password.equals(rs.getString("[password]"))){
                return url;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return url;
        }
        return url;
    }
    
    public String forgotPass(){
        return "NewPass";
    }
    
    public String signIn(){
        return "SignIn";
    }
    
    public void editPassSQL(String password, String newPassword){
        try {
            PreparedStatement ps = conn.prepareStatement("update [user] set password=? where password=?");
            ps.execute(newPassword,1);
            ps.execute(password, 2);
            rs = ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String editPassWeb(String email){
        try {
            PreparedStatement ps = conn.prepareStatement("select * from [user] where email = ?");
            ps.execute(email, 1);
            rs = ps.executeQuery();
            if(email.equals(rs.getString("email"))){
                editPassSQL(password, newPassword);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Login";
    }
}
