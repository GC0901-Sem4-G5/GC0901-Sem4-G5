/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connection.GetConnect;
import entity.user;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.xml.registry.infomodel.User;

/**
 *
 * @author dattr_000
 */
public class AccountModel {

    private ResultSet rs;

    public boolean checklogin(String username, String password) {
        user u;
        boolean status = false;
        try {

            GetConnect conn = new GetConnect();
            Connection con = conn.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * from [user] where username = ? and [password]=?");
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            status = rs.next();

        } catch (SQLException ex) {
            Logger.getLogger(AccountModel.class.getName()).log(Level.SEVERE, null, ex);
            status = false;
        }
        return status;
    }

    public boolean checkEmail(String email) {
        boolean status = false;
        try {
            GetConnect conn = new GetConnect();
            Connection con = conn.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * from [user] where email = ?");
            ps.setString(1, email);
            rs = ps.executeQuery();
           if(rs.next()){
               status = true;
           }else{
               status = false;
           }

        } catch (SQLException ex) {
            Logger.getLogger(AccountModel.class.getName()).log(Level.SEVERE, null, ex);
            status = false;
        }
        return status;
    }

    public String getPasswordbyEmail(String email) {
        String password = "";
        try {
            GetConnect conn = new GetConnect();
            Connection con = conn.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT password from [user] where email = ?");
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                password = rs.getString("password");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return password;
    }

    public void generateAndSendEmai(String email, String password) throws AddressException, MessagingException {
        Properties mailServerProperties;
        Session getMailSession;
        MimeMessage generateMailMessage;
        // Step1
        System.out.println("\n 1st ===> setup Mail Server Properties..");
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");
        System.out.println("Mail Server Properties have been setup successfully..");

        // Step2
        System.out.println("\n\n 2nd ===> get Mail Session..");
        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        generateMailMessage = new MimeMessage(getMailSession);
        generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

        generateMailMessage.setSubject("Retrieve password from easyticket");
        String emailBody = "Your password is" + password;
        generateMailMessage.setContent(emailBody, "text/html");
        System.out.println("Mail Session has been created successfully..");

        // Step3
        System.out.println("\n\n 3rd ===> Get Session and Send mail");
        Transport transport = getMailSession.getTransport("smtp");

        // Enter your correct gmail UserID and Password
        // if you have 2FA enabled then provide App Specific Password
        transport.connect("smtp.gmail.com", "viptranpro@gmail.com", "22072010");
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();
    }

    public boolean createAccount(user u) {
        boolean status;
        int i = 0;
        try {
            GetConnect conn = new GetConnect();
            Connection con = conn.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into [user](username,firstname,lastname,[type],telephone,email,[address],birthdate,[password]) values(?,?,?,?,?,?,?,?,?)");
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getFirstname());
            ps.setString(3, u.getLastname());
            ps.setString(4, u.getType());
            ps.setString(5, u.getTelephone());
            ps.setString(6, u.getEmail());
            ps.setString(7, u.getEmail());
            ps.setString(8, u.getBirthdate());
            ps.setString(9, u.getPassword());
            i = ps.executeUpdate();
            if (i > 0) {
                status = true;
            } else {
                status = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountModel.class.getName()).log(Level.SEVERE, null, ex);
            status = false;
        }
        return status;
    }

    
       public boolean checkUsernameExist(String username) {
        boolean status;
        try {

            GetConnect conn = new GetConnect();
            Connection con = conn.getConnection();
            PreparedStatement ps = con.prepareStatement("select username from [user] where username = ?");
            ps.setString(1, username);
            rs = ps.executeQuery();
            status = rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(AccountModel.class.getName()).log(Level.SEVERE, null, ex);
            status = false;
        }
        return status;
    }
}