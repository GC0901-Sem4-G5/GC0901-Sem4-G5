/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.user;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    private String oldPass;
    private String newpass;
    private String emailcreate;
    private String passwordcreate;
    private user u;
    private Date birthdayinfo;

    public Date getBirthdayinfo() {
        return birthdayinfo;
    }

    public void setBirthdayinfo(Date birthdayinfo) {
        this.birthdayinfo = birthdayinfo;
    }

    public user getU() {
        return u;
    }

    public String getOldPass() {
        return oldPass;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }

    public String getNewpass() {
        return newpass;
    }

    public void setNewpass(String newpass) {
        this.newpass = newpass;
    }

    public void setU(user u) {
        this.u = u;
    }

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
            FirstName = "Guest";
            linkmanager = "login";
            button = "LOGIN";
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            HttpSession appsession = request.getSession(true);
            appsession.removeAttribute("username");
            System.out.println("Success Logout");
            return "home";
        }
    }

    public String findpassword() throws InterruptedException {
        AccountModel acc = new AccountModel();
        String passwordget;
        if (acc.checkEmail(email)) {
            passwordget = acc.getPasswordbyEmail(email);
            try {
                acc.generateAndSendEmai(email, passwordget);
                messageforgotpass = "Your password will be sent to your email. Please check your email";
                passwordget = "";
                email = "";
            } catch (MessagingException ex) {
                Logger.getLogger(AccountBean.class.getName()).log(Level.SEVERE, null, ex);
                messageforgotpass = "ERROR !!!";
            }

        } else {
            messageforgotpass = "Email not available";
        }
        return "";
    }

    public void BlackField() {
        usernamecreate = null;
        passwordcreate = null;
        firstnamecreate = null;
        lastnamecreate = null;
        emailcreate = null;
        telephonecreate = null;
        addresscreate = null;
        birthdaycreate = null;

    }

    public void redirect() {
        String url = "login.xhtml";
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        try {
            ec.redirect(url);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String createAccount() {
        SimpleDateFormat year = new SimpleDateFormat("dd-MM-yyyy");
        String birthday = year.format(birthdaycreate);
        AccountModel acc = new AccountModel();
        boolean createAccount = acc.createAccount(usernamecreate, firstnamecreate, lastnamecreate, "Custommer", telephonecreate, emailcreate, birthday, addresscreate, passwordcreate);
        if (createAccount) {
            messageforgotpass = "Create Success !";
            return "";
        } else {
            messageforgotpass = "Create Error !";
            return "";
        }
//        if (acc.checkEmail(getEmailcreate())) {
//            if (acc.checkUsernameExist(usernamecreate)) {
//                
//                if (acc.createAccount(u)) {
//                    messageforgotpass = "Create Success !!!";
//                    return "login";
//                } else {
//                    messageforgotpass = "Create Error !!!";
//                    return "";
//                }
//            } else {
//                messageforgotpass = "Username Already Registered.";
//                return "";
//            }
//        } else {
//            messageforgotpass = "Email Already Registered.";
//            return "";
//        }
    }

    public void loginaction() {
        AccountModel acc = new AccountModel();
        if (acc.checklogin(username, password)) {
            FirstName = acc.getFirstnamebyUsername(username);
            linkmanager = "managecustomer";
            button = "LOGOUT";
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            HttpSession appsession = request.getSession(true);
            appsession.setAttribute("username", username);
            appsession.setMaxInactiveInterval(86400);
            System.out.println("Success Login");
            ExternalContext extContext = context.getExternalContext();
            String url = extContext.encodeActionURL(context.getApplication().
                    getViewHandler().getActionURL(context, "/home.xhtml"));

            try {
                extContext.redirect(url);
            } catch (IOException ex) {
                Logger.getLogger(AccountBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("false");
        }
    }

    public void getInformation() {
        u = new user();
        AccountModel acc = new AccountModel();
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        HttpSession appsession = request.getSession(true);
        String usernamess = (String) appsession.getAttribute("username");
        u = acc.getInfobyusername(usernamess);
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date;
        try {
            birthdayinfo = formatter.parse(u.getBirthdate());
        } catch (ParseException ex) {
            Logger.getLogger(AccountBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String updateCusInfo() {
        AccountModel acc = new AccountModel();
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        HttpSession appsession = request.getSession(true);
        String usernamess = (String) appsession.getAttribute("username");
        SimpleDateFormat year = new SimpleDateFormat("dd-MM-yyyy");
        String birthdayi = year.format(birthdayinfo);
        if (acc.UpdateInfomationCustommer(usernamess, u.getFirstname(), u.getLastname(), u.getTelephone(), u.getEmail(), birthdayi, u.getAddress())) {
            messageforgotpass = "Update Completed !";
            return "";
        } else {
            messageforgotpass = "Update False !";
            getInformation();
            return "";
        }
    }

    public String CancelChangePass() {
        oldPass = "";
        newpass = "";
        return "cuschangepass";
    }

    public String changepass() {
        AccountModel acc = new AccountModel();
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        HttpSession appsession = request.getSession(true);
        String usernamess = (String) appsession.getAttribute("username");
        String passByUsername = acc.getPassByUsername(usernamess);
        if (passByUsername.equals(oldPass)) {
            boolean changePassbyUsername = acc.changePassbyUsername(newpass, usernamess);
            if (changePassbyUsername == true) {
                messageforgotpass = "Change Password Success !";
            } else {
                messageforgotpass = "Change Password Error !";
            }
        } else {
            messageforgotpass = "Old Passwod Wrong !";
        }
        return "cuschangepass";
    }
}
