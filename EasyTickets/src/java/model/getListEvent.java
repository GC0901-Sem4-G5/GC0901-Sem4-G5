/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connection.manager;
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
public class getListEvent {
   private ResultSet rs;
   private List<event> listevent = new ArrayList<>();
   
   public List<event> getEventList() {
        try {
            manager conn = new manager();
            Connection con = conn.getConnection();
            PreparedStatement ps = con.prepareStatement("select [Type].typeName , [Event].id,[Event].eventname,location.city,[Event].startdate from [Event] INNER JOIN [Type] on [Type].id = [Event].typeid INNER JOIN location on location.id = [Event].location");
            rs = ps.executeQuery();
            while (rs.next()) {
               event e = new event();
               e.setId(rs.getInt("id"));
               e.setTypeName(rs.getString("typeName"));
               e.setEventname(rs.getString("eventname"));
               e.setLocationCity(rs.getString("city"));
               e.setStartdate(rs.getString("startdate"));
               listevent.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listevent;
    }
}
