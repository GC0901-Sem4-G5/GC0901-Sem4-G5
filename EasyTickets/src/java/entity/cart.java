/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author dattr_000
 */
public class cart {

    private String eventName;
    private int eventid;
    private String arena;
    private int arenaId;
    private double price;
    private int quantity = 0;

    public String getEventName() {
        return eventName;
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
    
    

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getArena() {
        return arena;
    }

    public void setArena(String arena) {
        this.arena = arena;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
