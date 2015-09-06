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
import entity.ticket;
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
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author dattr_000
 */
public class CartModel {

    private static ArrayList<cart> items;
    private String messageError;

    public static ArrayList<cart> getItems() {
        return items;
    }

    public static void setItems(ArrayList<cart> items) {
        CartModel.items = items;
    }

    public String getMessageError() {
        return messageError;
    }

    public void setMessageError(String messageError) {
        this.messageError = messageError;
    }

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
            String status = createdPayment.getState() + "/" + createdPayment.getId();
            System.out.println(createdPayment.getId());
            System.out.println(createdPayment.getUpdateTime());
            return status;
        } catch (PayPalRESTException ex) {
            ex.printStackTrace();
            return "ERROR";
        }
    }

    public int createOrder(int userOrder, String statuspay, String idpay) {
        int keyid = -1;
        GetConnect conn = new GetConnect();
        Connection con = conn.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(" insert into [order](userOrder,statuspay,payid) values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, userOrder);
            ps.setString(2, statuspay);
            ps.setString(3, idpay);
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

    public String randomTicketCode() {
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(18);
        for (int i = 0; i < 18; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }

    public boolean createTicket(int priceid, int orderDetailid, String statusticket) {
        boolean status = false;
        GetConnect conn = new GetConnect();
        Connection con = conn.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("insert into Ticket(priceid, orderDetailid, codeticket,[status]) values(?,?,?,?)");
            ps.setInt(1, priceid);
            ps.setInt(2, orderDetailid);
            ps.setString(3, randomTicketCode());
            ps.setString(4, statusticket);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public List<ticket> getTicket(int orderId) {
        List<ticket> list = new ArrayList<ticket>();
        try {

            GetConnect conn = new GetConnect();
            Connection con = conn.getConnection();
            ResultSet rs;
            PreparedStatement ps = con.prepareStatement("select Ticket.id,Ticket.codeticket,Arena.area,[Event].DateStart,[Event].eventname,location.[address],location.city  from Ticket inner join Price on Price.id = Ticket.priceid inner join Arena on Price.arenaId = Arena.id inner join [Event] on [Event].id = Price.eventid inner join location on [Event].location = location.id inner join orderDetail on orderDetail.id = Ticket.orderDetailid inner join [order] on [order].id = orderDetail.orderId where [order].id = ? order by codeticket");
            ps.setInt(1, orderId);
            rs = ps.executeQuery();
            while (rs.next()) {
                ticket t = new ticket();
                t.setId(rs.getInt("id"));
                t.setTicketCode(rs.getString("codeticket"));
                t.setArena(rs.getString("area"));
                t.setDateStart(rs.getDate("DateStart").toString());
                t.setEventName(rs.getString("eventname"));
                t.setAddress(rs.getString("address"));
                t.setCity(rs.getString("city"));
                list.add(t);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CartModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<ticket> generateAndSendEmai(int orderId, String email) throws AddressException, MessagingException {
        Properties mailServerProperties;
        Session getMailSession;
        MimeMessage generateMailMessage;
        List<ticket> list = new ArrayList<ticket>();
        list = getTicket(orderId);
        // Step1
        System.out.println("\n 1st ===> setup Mail Server Properties..");
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");
        System.out.println("Mail Server Properties have been setup successfully..");

        // Step2
        System.out.println("\n\n 2nd ===> get Mail Session..");
        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        generateMailMessage = new MimeMessage(getMailSession);
        generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

        generateMailMessage.setSubject("Ticket List Order");
        String emailBody = "<center><h2>EASY TICKET CENTER</h2>"
                + "<h4><i><b>8, Ton That Thuyet, Ha Noi</b></i></h4>"
                + "<h1>YOUR TICKET</h1></center>"
                + "<table style=\" border-collapse: collapse;\">\n"
                + "<tr style=\" font-size: 16px;font-weight: bold;\">\n"
                + "<td style=\" border: 1px solid black;width:5%;\">No</td>\n"
                + "<td style=\" border: 1px solid black;width:20%;\">Name</td>\n"
                + "<td style=\" border: 1px solid black;width:10%;\">Date</td>\n"
                + "<td style=\" border: 1px solid black;width:10%;\">Time</td>\n"
                + "<td style=\" border: 1px solid black;width:20%;\">Address</td>\n"
                + "<td style=\" border: 1px solid black;width:10%;\">Arena</td>\n"
                + "<td style=\" border: 1px solid black;width:25%;\">Code</td>\n"
                + "<tr/>\n";
        for (int i = 0; i < list.size(); i++) {
            emailBody = emailBody + "<tr><td>" + i + "</td>";
            emailBody = emailBody + "<td>" + list.get(i).getEventName() + "</td>";
            emailBody = emailBody + "<td>" + list.get(i).getDateStart() + "</td>";
            emailBody = emailBody + "<td>" + list.get(i).getDateStart() + "</td>";
            emailBody = emailBody + "<td>" + list.get(i).getAddress() + ", " + list.get(i).getCity() + "</td>";
            emailBody = emailBody + "<td>" + list.get(i).getArena() + "</td>";
            emailBody = emailBody + "<td>" + list.get(i).getTicketCode() + "</td></tr>";
        }
        emailBody = emailBody + "</table>";
        generateMailMessage.setContent(emailBody, "text/html");
        System.out.println("Mail Session has been created successfully..");

        // Step3
        System.out.println("\n\n 3rd ===> Get Session and Send mail");
        Transport transport = getMailSession.getTransport("smtp");

        // Enter your correct gmail UserID and Password
        // if you have 2FA enabled then provide App Specific Password
        transport.connect("smtp.gmail.com", "viptranpro@gmail.com", "22072010");
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();
        return list;
    }

}
