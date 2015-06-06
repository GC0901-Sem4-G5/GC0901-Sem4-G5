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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dattr_000
 */
public class getEventDetail {
    
     private ResultSet rs;
    private event e;
    
    public event getEventList(int id) {
        try {
            GetConnect conn = new GetConnect();
            Connection con = conn.getConnection();
            PreparedStatement ps = con.prepareStatement("select Event.id, Event.DateStart, Event.eventname, Event.content,Event.enventImg, [Type].typeName, location.city, location.address from Event inner join [Type] on Event.typeid = [Type].id inner join location on location.id = Event.location where Event.id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                e = new event();
                e.setId(rs.getInt("id"));
                e.setStartdate(rs.getTimestamp("DateStart").toString());
                e.setEventname(rs.getString("eventname"));
                e.setContent(rs.getString("content"));
                e.setEnventImg(rs.getString("enventImg"));
                e.setTypeName("typeName");
                e.setLocationName("city");
                e.setLocationAddress("address");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return e;
    }
    
}
