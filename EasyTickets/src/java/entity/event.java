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
    private String TypeName;
    private int TypeID;
    private String startdate;
    private String eventname;
    private String content;
    private String locationName;
    private int locationID;
    private String enventImg;
    private String created;   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String TypeName) {
        this.TypeName = TypeName;
    }

    public int getTypeID() {
        return TypeID;
    }

    public void setTypeID(int TypeID) {
        this.TypeID = TypeID;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
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

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public String getEnventImg() {
        return enventImg;
    }

    public void setEnventImg(String enventImg) {
        this.enventImg = enventImg;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public event(int id, String TypeName, String startdate, String eventname, String content, String locationName, String enventImg, String created) {
        this.id = id;
        this.TypeName = TypeName;
        this.startdate = startdate;
        this.eventname = eventname;
        this.content = content;
        this.locationName = locationName;
        this.enventImg = enventImg;
        this.created = created;
    }

    public event(int id, int TypeID, String startdate, String eventname, String content, int locationID, String enventImg, String created) {
        this.id = id;
        this.TypeID = TypeID;
        this.startdate = startdate;
        this.eventname = eventname;
        this.content = content;
        this.locationID = locationID;
        this.enventImg = enventImg;
        this.created = created;
    }

   

 
    
}
