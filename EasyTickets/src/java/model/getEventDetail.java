/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connection.GetConnect;
import entity.event;
import entity.price;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;

/**
 *
 * @author dattr_000
 */
public class getEventDetail {

    private ResultSet rs;
    private String arena;
    private event e;
    private List<price> listprice;

    public List<price> getListprice() {
        return listprice;
    }

    public void setListprice(List<price> listprice) {
        this.listprice = listprice;
    }

    public String getArena() {
        return arena;
    }

    public void setArena(String arena) {
        this.arena = arena;
    }

    public event getE() {
        return e;
    }

    public void setE(event e) {
        this.e = e;
    }

    public event getEvent(int id) {
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
                e.setTypeName(rs.getString("typeName"));
                e.setLocationName(rs.getString("city"));
                e.setLocationAddress(rs.getString("address"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return e;
    }

    public List<price> getPricesbyEventID(int eventid) {
                listprice = new ArrayList<price>();
        try {
            GetConnect conn = new GetConnect();
            Connection con = conn.getConnection();
            PreparedStatement ps = con.prepareStatement("select [Price].id, [Price].price,[Price].quantity,Arena.area from [Price] inner join Arena on Arena.id = [Price].arenaId where quantity>0 and [Price].eventid = ?");
            ps.setInt(1, eventid);
            rs = ps.executeQuery();
            while (rs.next()) {
                price p = new price();
                p.setId(rs.getInt("id"));
                p.setPrice(rs.getFloat("price"));
                p.setQuantity(rs.getInt("quantity"));
                p.setArenaName(rs.getString("area"));
                listprice.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listprice;
    }

}
