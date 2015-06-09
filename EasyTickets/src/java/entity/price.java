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
public class price {

    private int id;
    private int quantity;
    private int eventid;
    private String eventName;
    private int arenaId;
    private String arenaName;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getEventid() {
        return eventid;
    }

    public void setEventid(int eventid) {
        this.eventid = eventid;
    }

    public int getArenaId() {
        return arenaId;
    }

    public void setArenaId(int arenaId) {
        this.arenaId = arenaId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getArenaName() {
        return arenaName;
    }

    public void setArenaName(String arenaName) {
        this.arenaName = arenaName;
    }

    public price() {
    }

    public price(int id, int quantity, int eventid, int arenaId, double price) {
        this.id = id;
        this.quantity = quantity;
        this.eventid = eventid;
        this.arenaId = arenaId;
        this.price = price;
    }

    public price(int id, int quantity, String eventName, String arenaName, double price) {
        this.id = id;
        this.quantity = quantity;
        this.eventName = eventName;
        this.arenaName = arenaName;
        this.price = price;
    }

}
