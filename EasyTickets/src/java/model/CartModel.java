/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.cart;
import java.util.ArrayList;

/**
 *
 * @author dattr_000
 */
public class CartModel {

    private static ArrayList<cart> items;

    public CartModel() {
        items = new ArrayList<cart>();
    }

    public void ins(cart p) {
        items.add(p);
    }

    public void remove(int index) {
        items.remove(index);
    }

    public void removeall() {
        items.removeAll(items);
    }

    public int getSize() {
        return items.size();
    }

    public ArrayList<cart> getIt() {
        return items;
    }

    public int getIndex(String proName) {
        for (int i = 0; i < items.size(); i++) {
            String auction = items.get(i).getEventName();
            if (proName.equals(auction)) {
                return i;
            }
        }
        return -1;
    }
}
