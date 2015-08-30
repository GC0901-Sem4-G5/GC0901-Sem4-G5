/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connection.GetConnect;
import entity.Permission;
import entity.user;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
public class PermissionModel {

    private ResultSet rs;

    public List<Permission> getAll() {
        List<Permission> permissions = new ArrayList<>();
        try {

            GetConnect conn = new GetConnect();
            Connection con = conn.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from [Permission]");
            rs = ps.executeQuery();
            while (rs.next()) {
                Permission p = new Permission();
                p.setId(rs.getInt("id"));
                p.setRoleName(rs.getString("role_name"));
                p.setDisplayName(rs.getString("display_name"));
                
                permissions.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return permissions;
    }
    

}
