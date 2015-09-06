/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connection.GetConnect;
import entity.event;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author dattr_000
 */
public class CheckTicket {

    private ResultSet rs;

    public event check(String codeticket) {
        event e = new event();
        try {
            GetConnect conn = new GetConnect();
            Connection con = conn.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT [Event].eventname,[Event].enventImg,[Event].DateStart,location.city, location.address from [Event] INNER JOIN location ON location.id = [Event].location INNER JOIN Price ON Price.eventid = [Event].id INNER JOIN Ticket ON Ticket.priceid = Price.id WHERE Ticket.codeticket LIKE ?");
            ps.setString(1, codeticket);
            rs = ps.executeQuery();
            while (rs.next()) {
                e.setStartdate(rs.getTimestamp("DateStart").toString());
                e.setEventname(rs.getString("eventname"));
                e.setEnventImg(rs.getString("enventImg"));
                e.setLocationName(rs.getString("city"));
                e.setLocationAddress(rs.getString("address"));
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return e;
    }

}
