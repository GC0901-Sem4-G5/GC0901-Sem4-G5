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
public class getListEvent {
   private ResultSet rs;
   private List<event> listevent = new ArrayList<>();
   
   public List<event> getEventList() {
        try {
            GetConnect conn = new GetConnect();
            Connection con = conn.getConnection();
            PreparedStatement ps = con.prepareStatement("select [Type].typeName , [Event].id,[Event].eventname,location.city,[Event].startdate from [Event] INNER JOIN [Type] on [Type].id = [Event].typeid INNER JOIN location on location.id = [Event].location");
            rs = ps.executeQuery();
            while (rs.next()) {
              
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listevent;
    }
}
