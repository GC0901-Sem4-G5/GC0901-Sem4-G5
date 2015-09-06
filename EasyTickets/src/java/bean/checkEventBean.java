/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import connection.GetConnect;
import entity.event;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.CheckTicket;

/**
 *
 * @author dattr_000
 */
@ManagedBean
@RequestScoped
public class checkEventBean {

    private String search;
    private String eventName;
    private String statusEvent;
    private String City;
    private String address;
    private String Time;
    private String Date;
    private String img;
    private String display = "none";
    private String message = "TICKET UNVAILABLE";

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getStatusEvent() {
        return statusEvent;
    }

    public void setStatusEvent(String statusEvent) {
        this.statusEvent = statusEvent;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    private ResultSet rs;

    public boolean Checkticket() {
        event e = new event();
        CheckTicket c = new CheckTicket();
        e = c.check(search);
        City = e.getLocationName();
        Date = e.getStartdate().substring(0, 11);
        Time = e.getStartdate().substring(11, e.getStartdate().length());
        address = e.getLocationAddress();
        eventName = e.getEventname();
        img = e.getEnventImg();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString = e.getStartdate().substring(0, 11);
        Date date2 = new Date();
        String format = formatter.format(date2);
        try {
            Date date = formatter.parse(dateInString);
            System.out.println(date);
            boolean before = date.before(date2);
            if(before==true){
                statusEvent = "Done";
            }else{
                statusEvent = "Upcoming";
            }
            display = "block";
        } catch (ParseException ex) {
            Logger.getLogger(checkEventBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

}
