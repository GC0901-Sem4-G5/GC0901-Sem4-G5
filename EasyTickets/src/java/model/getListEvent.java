/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import connection.GetConnect;
import entity.event;
import entity.location;
import entity.type;
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
    private List<location> listlocation = new ArrayList<>();
    private List<type> listtype = new ArrayList<type>();

    public List<event> getEventList() {
        try {
            GetConnect conn = new GetConnect();
            Connection con = conn.getConnection();
            PreparedStatement ps = con.prepareStatement("select [Event].id,[Event].eventname,[Event].DateStart,[Event].enventImg from [Event]");
            rs = ps.executeQuery();
            while (rs.next()) {
                event e = new event();
                e.setId(rs.getInt("id"));
                e.setEventname(rs.getString("eventname"));
                e.setStartdate(rs.getTimestamp("DateStart").toString());
                e.setEnventImg(rs.getString("enventImg"));
                listevent.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listevent;
    }

    public double getTop1Price(int eventid) {
        double priceget = 0;
        try {
            GetConnect conn = new GetConnect();
            Connection con = conn.getConnection();
            PreparedStatement ps = con.prepareStatement("select top 1 [price] from [Price] where eventid = ? order by price asc");
            ps.setInt(1, eventid);
            rs = ps.executeQuery();
            while (rs.next()) {
                priceget = rs.getFloat("price");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return priceget;
    }

    public List<event> getType(int typeid) {
        try {
            GetConnect conn = new GetConnect();
            Connection con = conn.getConnection();
            PreparedStatement ps = con.prepareStatement("select [Event].id,[Event].eventname,[Event].DateStart,[Event].enventImg from [Event] where [Event].typeid= ?");
            ps.setInt(1, typeid);
            rs = ps.executeQuery();
            while (rs.next()) {
                event e = new event();
                e.setId(rs.getInt("id"));
                e.setEventname(rs.getString("eventname"));
                e.setStartdate(rs.getTimestamp("DateStart").toString());
                e.setEnventImg(rs.getString("enventImg"));
                listevent.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listevent;
    }

    public List<event> SearchEvent(String eventName) {
        String query = "%" + eventName + "%";
        try {
            GetConnect conn = new GetConnect();
            Connection con = conn.getConnection();
            PreparedStatement ps = con.prepareStatement("select [Event].id,[Event].eventname,[Event].DateStart,[Event].enventImg from [Event] where [Event].eventname like ?");
            ps.setString(1, query);
            rs = ps.executeQuery();
            while (rs.next()) {
                event e = new event();
                e.setId(rs.getInt("id"));
                e.setEventname(rs.getString("eventname"));
                e.setStartdate(rs.getTimestamp("DateStart").toString());
                e.setEnventImg(rs.getString("enventImg"));
                listevent.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listevent;
    }

    public List<location> getLocation() {
        try {
            GetConnect conn = new GetConnect();
            Connection con = conn.getConnection();
            PreparedStatement ps = con.prepareStatement("select city from location group by city");
            rs = ps.executeQuery();
            while (rs.next()) {
                location lo = new location();
                lo.setCity(rs.getString("city"));
                listlocation.add(lo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listlocation;
    }

    public List<type> getType() {
        try {
            GetConnect conn = new GetConnect();
            Connection con = conn.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from type");
            rs = ps.executeQuery();
            while (rs.next()) {
                type ty = new type(rs.getInt("id"), rs.getString("typename"));
                listtype.add(ty);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listtype;
    }

    public List<event> getEventListByCondition(String Condition) {
        try {
            GetConnect conn = new GetConnect();
            Connection con = conn.getConnection();
            PreparedStatement ps = con.prepareStatement("select [Event].id,[Event].eventname,[Event].DateStart,[Event].enventImg from [Event] INNER JOIN location on location.id = [Event].location where " + Condition);
            rs = ps.executeQuery();
            while (rs.next()) {
                event e = new event();
                e.setId(rs.getInt("id"));
                e.setEventname(rs.getString("eventname"));
                e.setStartdate(rs.getTimestamp("DateStart").toString());
                e.setEnventImg(rs.getString("enventImg"));
                listevent.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listevent;
    }
}
