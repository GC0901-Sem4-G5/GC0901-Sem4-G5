/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.CreditCard;
import com.paypal.api.payments.FundingInstrument;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;
import connection.GetConnect;
import entity.cart;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public String payment(String type, String number, int month, int year, String fname, String lname, String total) {
        Map<String, String> sdkConfig = new HashMap<String, String>();
        sdkConfig.put("mode", "sandbox");
        String accessToken;
        try {
            accessToken = new OAuthTokenCredential("AR3KhFqcrflYdAvk8MHd0TU-vg-WiFwwTXsTSQ2aUGAbXuhFMOTt7AKPtxQN0eizSer7b8ULdEwo3P1z", "EGDWragMViWhBvstc7ycTeAT1Gp-2FZcwsJdDPFI4LHB9eo1UHoeVoxAHMv3v0e2gFtiyeUr-HBZ1gi0", sdkConfig).getAccessToken();
            APIContext apiContext = new APIContext(accessToken);
            apiContext.setConfigurationMap(sdkConfig);
            CreditCard creditCard = new CreditCard();
            creditCard.setType(type);
            creditCard.setNumber(number);
            creditCard.setExpireMonth(month);
            creditCard.setExpireYear(year);
            creditCard.setFirstName(fname);
            creditCard.setLastName(lname);
            FundingInstrument fundingInstrument = new FundingInstrument();
            fundingInstrument.setCreditCard(creditCard);
            List<FundingInstrument> fundingInstrumentList = new ArrayList<FundingInstrument>();
            fundingInstrumentList.add(fundingInstrument);
            Payer payer = new Payer();
            payer.setFundingInstruments(fundingInstrumentList);
            payer.setPaymentMethod("credit_card");
            Amount amount = new Amount();
            amount.setCurrency("USD");
            amount.setTotal(total);
            Transaction transaction = new Transaction();
            transaction.setDescription("creating a direct payment with credit card");
            transaction.setAmount(amount);
            List<Transaction> transactions = new ArrayList<Transaction>();
            transactions.add(transaction);
            Payment payment = new Payment();
            payment.setIntent("sale");
            payment.setPayer(payer);
            payment.setTransactions(transactions);
            Payment createdPayment;
            createdPayment = payment.create(apiContext);
            String status = createdPayment.getState();
            System.out.println(createdPayment.getId());
            System.out.println(createdPayment.getUpdateTime());
            return status;
        } catch (PayPalRESTException ex) {
            ex.printStackTrace();
            return "ERROR";
        }
    }

    public int createOrder(int userOrder, String statuspay) {
        int keyid = -1;
        GetConnect conn = new GetConnect();
        Connection con = conn.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(" insert into [order](userOrder,statuspay) values(?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, userOrder);
            ps.setString(2, statuspay);
            ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            keys.next();
            keyid = keys.getInt(1);
            keys.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            keyid = -1;
        }
        return keyid;
    }

    public int createOrderDetail(int orderId, int PriceId, int quantity, double total) {
        int keyid = -1;
        GetConnect conn = new GetConnect();
        Connection con = conn.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(" insert into [orderDetail](orderId,PriceId,quantity,total) values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, orderId);
            ps.setInt(2, PriceId);
            ps.setInt(3, quantity);
            ps.setDouble(4, total);
            ps.executeUpdate();
            ResultSet keys = ps.getGeneratedKeys();
            keys.next();
            keyid = keys.getInt(1);
            keys.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            keyid = -1;
        }
        return keyid;
    }

    public int getquantity(int PriceId) {
        int quantity = -1;
        try {

            GetConnect conn = new GetConnect();
            Connection con = conn.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT quantity from [Price] where id = ?");
            ps.setInt(1, PriceId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                quantity = rs.getInt("quantity");
            }

        } catch (SQLException ex) {
            Logger.getLogger(CartModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return quantity;
    }

    public boolean changequantity(int PriceId, int quantity) {
        boolean status = false;
        try {

            GetConnect conn = new GetConnect();
            Connection con = conn.getConnection();
            int quantitytotal = getquantity(PriceId);
            PreparedStatement ps = con.prepareStatement("UPDATE [Price] SET quantity = ? WHERE id = ?");
            ps.setInt(1, quantitytotal - quantity);
            ps.setInt(2, PriceId);
            ps.executeUpdate();
            status = true;
        } catch (SQLException ex) {
            Logger.getLogger(CartModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

}
