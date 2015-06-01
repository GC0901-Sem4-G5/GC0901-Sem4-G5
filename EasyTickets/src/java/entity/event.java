/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author win pc
 */
public class event {
    
    private int id;
    private int typeid;
    private String startdate;
    private String enddate;
    private String eventname;
    private String content;
    private int location;
    private String created;   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTypeid() {
        return typeid;
    }

    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public event(int id, int typeid, String startdate, String enddate, String eventname, String content, int location, String created) {
        this.id = id;
        this.typeid = typeid;
        this.startdate = startdate;
        this.enddate = enddate;
        this.eventname = eventname;
        this.content = content;
        this.location = location;
        this.created = created;
    }
    
    
}
