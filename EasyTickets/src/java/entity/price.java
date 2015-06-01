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
    private int arenaid;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArenaid() {
        return arenaid;
    }

    public void setArenaid(int arenaid) {
        this.arenaid = arenaid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public price(int id, int arenaid, double price) {
        this.id = id;
        this.arenaid = arenaid;
        this.price = price;
    }
    
}
