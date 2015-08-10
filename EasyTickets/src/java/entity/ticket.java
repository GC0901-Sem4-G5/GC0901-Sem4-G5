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
public class ticket {

    private int id;
    private String ticketCode;
    private String Arena;
    private String DateStart;
    private String eventName;
    private String address;
    private String city;
    private int priceid;
    private int orderDetailid;
    private String created;
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public String getArena() {
        return Arena;
    }

    public void setArena(String Arena) {
        this.Arena = Arena;
    }

    public String getDateStart() {
        return DateStart;
    }

    public void setDateStart(String DateStart) {
        this.DateStart = DateStart;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPriceid() {
        return priceid;
    }

    public void setPriceid(int priceid) {
        this.priceid = priceid;
    }

    public int getOrderDetailid() {
        return orderDetailid;
    }

    public void setOrderDetailid(int orderDetailid) {
        this.orderDetailid = orderDetailid;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ticket(int id, String ticketCode, String Arena, String DateStart, String eventName, String address, String city) {
        this.id = id;
        this.ticketCode = ticketCode;
        this.Arena = Arena;
        this.DateStart = DateStart;
        this.eventName = eventName;
        this.address = address;
        this.city = city;
    }

    public ticket() {
    }

}
