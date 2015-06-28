/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.user;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.mail.MessagingException;
import model.AccountModel;

/**
 *
 * @author dattr_000
 */
@ManagedBean
@SessionScoped
public class AccountBean implements Serializable {



    private String username;
    private String password;
    private int id;
    private String FirstName = "Guest";
    private String button = "LOGIN";
    private String linkmanager = "login";
    private String messageforgotpass;
    private String email;
    private String firstnamecreate;
    private String lastnamecreate;
    private String usernamecreate;
    private String telephonecreate;
    private String addresscreate;
    private Date birthdaycreate;
    private String emailcreate;
    private String passwordcreate;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPasswordcreate() {
        return passwordcreate;
    }

    public void setPasswordcreate(String passwordcreate) {
        this.passwordcreate = passwordcreate;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getMessageforgotpass() {
        return messageforgotpass;
    }

    public void setMessageforgotpass(String messageforgotpass) {
        this.messageforgotpass = messageforgotpass;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getButton() {
        return button;
    }

    public String getLinkmanager() {
        return linkmanager;
    }

    public void setLinkmanager(String linkmanager) {
        this.linkmanager = linkmanager;
    }

    public void setButton(String button) {
        this.button = button;
    }

    public String getFirstnamecreate() {
        return firstnamecreate;
    }

    public void setFirstnamecreate(String firstnamecreate) {
        this.firstnamecreate = firstnamecreate;
    }

    public String getLastnamecreate() {
        return lastnamecreate;
    }

    public void setLastnamecreate(String lastnamecreate) {
        this.lastnamecreate = lastnamecreate;
    }

    public String getUsernamecreate() {
        return usernamecreate;
    }

    public void setUsernamecreate(String usernamecreate) {
        this.usernamecreate = usernamecreate;
    }

    public String getTelephonecreate() {
        return telephonecreate;
    }

    public void setTelephonecreate(String telephonecreate) {
        this.telephonecreate = telephonecreate;
    }

    public String getAddresscreate() {
        return addresscreate;
    }

    public void setAddresscreate(String addresscreate) {
        this.addresscreate = addresscreate;
    }

    public Date getBirthdaycreate() {
        return birthdaycreate;
    }

    public void setBirthdaycreate(Date birthdaycreate) {
        this.birthdaycreate = birthdaycreate;
    }

    public String getEmailcreate() {
        return emailcreate;
    }

    public void setEmailcreate(String emailcreate) {
        this.emailcreate = emailcreate;
    }
    
    
    
    private static final long serialVersionUID = 1L;

    public String eventAcc() throws IOException {
        if (button.contains("LOGIN")) {
            System.out.println(button);
            return "login";
        } else {
            button = "LOGIN";
            return "home";
        }
    }

    public String findpassword() {
        AccountModel acc = new AccountModel();
        String passwordget;
        if (acc.checkEmail(email)) {
            passwordget = acc.getPasswordbyEmail(email);
            try {
                acc.generateAndSendEmai(email, passwordget);
                messageforgotpass = "Your password will be sent to your email. Please check your email";
            } catch (MessagingException ex) {
                Logger.getLogger(AccountBean.class.getName()).log(Level.SEVERE, null, ex);
                messageforgotpass = "ERROR !!!";
            }

        } else {
            messageforgotpass = "Email not available";
        }
        return "";
    }
    
    public void BlackField(){
        usernamecreate = null;
        passwordcreate = null;
        firstnamecreate = null;
        lastnamecreate = null;
        emailcreate = null;
        telephonecreate = null;
        addresscreate = null;
        birthdaycreate = null;
        
        
    }

    public String createAccount() {
          SimpleDateFormat year = new SimpleDateFormat("dd-MM-yyyy");
        String birthday = year.format(birthdaycreate);
        AccountModel acc = new AccountModel();
        if(acc.checkEmail(getEmailcreate())){
            if(acc.checkUsernameExist(usernamecreate)){
                user u = new user();
                u.setAddress(addresscreate);
                u.setBirthdate(birthday);
                u.setEmail(emailcreate);
                u.setFirstname(firstnamecreate);
                u.setLastname(lastnamecreate);
                u.setPassword(passwordcreate);
                u.setTelephone(telephonecreate);
                u.setType("Customer");
                u.setUsername(usernamecreate);
                if(acc.createAccount(u)){
                    messageforgotpass = "Create Success !!!";
                    return "login";
                }else{
                     messageforgotpass = "Create Error !!!";
                     return "";
                }
            }else{
                messageforgotpass = "Username Already Registered.";
                return "";
            }
        }else{
            messageforgotpass = "Email Already Registered.";
            return "";
        }
    }

}
