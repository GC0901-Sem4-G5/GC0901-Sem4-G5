/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Monki
 */
@ManagedBean
@SessionScoped
public class AccountManager {
    private Connection conn;
    private String username;
    private String password;
    private String email;
    private String firstname;
    private String lastname;
    private String type;
    private String telephone; 
    private String address;       
    private String bankAccount;       
    private String created;       
    private String birthdate;
    private String newPassword;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
    
    DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    
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
    
    private ResultSet rs;
    /**
     * Creates a new instance of accountManager
     */
    public AccountManager() {
    }
    
    public String login(String username, String password, String url) {
        try {
            PreparedStatement ps = conn.prepareStatement("select * from [user] where username=? and [password] = ?");
            ps.execute(username, 2);
            ps.execute(password, 12);
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
    
    public String signUp(){
        return "SignUp";
    }
    
    public void editPassSQL(String password, String newPassword){
        try {
            PreparedStatement ps = conn.prepareStatement("update [user] set password=? where password=?");
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
                editPassSQL(password,newPassword);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Login";
    }

    public String signUpAccount(String username, String firstname, String lastname, String type, String email, String address,
            String telephone, String bankAccount, String created, String birthdate, String password){
        try {
            PreparedStatement ps = conn.prepareStatement("insert into [user] values(?,?,?,?,?,?,?,?,?,?,?)");
            Date date = new Date();
            ps.setString(2, username);
            ps.setString(3, firstname);
            ps.setString(4, lastname);
            ps.setString(5, "Custom");
            ps.setString(6, telephone);
            ps.setString(7, email);
            ps.setString(8, address);
            ps.setString(9, bankAccount);
            ps.setString(10, df.format(date));
            ps.setString(11, birthdate);
            ps.setString(12, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "login";
    }
    
    public String cancel(){
        return "Login";
    }
}
