/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.paypal.base.rest.PayPalRESTException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dattr_000
 */
public class test {

    public static void main(String[] args) {
        CartModel c = new CartModel();
        String payment;
        payment = c.payment("visa","4446283280247004",11,2018,"fsa","fsaf","1000");
        System.out.println(payment);
    }

}
