/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connection.GetConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
            PreparedStatement ps = con.prepareStatement("INSERT INTO [ContactUs] (name, email,phone,content ) VALUES (?,?,?,?)");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, content);
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
}
