/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.cart;
import entity.event;
import entity.user;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.AccountModel;
import model.CartModel;
import model.getEventDetail;
import org.omg.CORBA.Current;

/**
 *
 * @author dattr_000
 */
@ManagedBean
@SessionScoped
public class CartBean {

    private static final long serialVersionUID = 1L;
    private CartModel shop = new CartModel();
    private List<cart> list = new ArrayList<cart>();
    private int Quantity = 1;
    private int idEvent;
    private int idUser;
    private int idArena;
    private event e = new event();
    private int quantityup;
    private String checkedpayment = "1";
    private String visanumber;
    private String fistnamepaypal;
    private String lastnamepaypal;
    private int monthvisa;
    private int yearvisa;
    private String typecard;
    private String messageError;

    public String getMessageError() {
        return messageError;
    }

    public void setMessageError(String messageError) {
        this.messageError = messageError;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getTypecard() {
        return typecard;
    }

    public void setTypecard(String typecard) {
        this.typecard = typecard;
    }

    public String getVisanumber() {
        return visanumber;
    }

    public void setVisanumber(String visanumber) {
        this.visanumber = visanumber;
    }

    public String getFistnamepaypal() {
        return fistnamepaypal;
    }

    public void setFistnamepaypal(String fistnamepaypal) {
        this.fistnamepaypal = fistnamepaypal;
    }

    public String getLastnamepaypal() {
        return lastnamepaypal;
    }

    public void setLastnamepaypal(String lastnamepaypal) {
        this.lastnamepaypal = lastnamepaypal;
    }

    public int getMonthvisa() {
        return monthvisa;
    }

    public void setMonthvisa(int monthvisa) {
        this.monthvisa = monthvisa;
    }

    public int getYearvisa() {
        return yearvisa;
    }

    public void setYearvisa(int yearvisa) {
        this.yearvisa = yearvisa;
    }

    public int getQuantityup() {
        return quantityup;
    }

    public String getCheckedpayment() {
        return checkedpayment;
    }

    public void setCheckedpayment(String checkedpayment) {
        this.checkedpayment = checkedpayment;
    }

    public void setQuantityup(int quantityup) {
        this.quantityup = quantityup;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public List<cart> getList() {
        return list;
    }

    public void setList(List<cart> list) {
        this.list = list;
    }

    public int getIdArena() {
        return idArena;
    }

    public void setIdArena(int idArena) {
        this.idArena = idArena;
    }

    public event getE() {
        return e;
    }

    public void setE(event e) {
        this.e = e;
    }

    public CartModel getShop() {
        return shop;
    }

    public void setShop(CartModel shop) {
        this.shop = shop;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public int getIndex(String proName) {
        for (int i = 0; i < list.size(); i++) {
            String auction = list.get(i).getEventName();
            if (proName.equals(auction)) {
                return i;
            }
        }
        return -1;
    }

    public int getexist(String proName, double price) {
        for (int i = 0; i < list.size(); i++) {
            String auction = list.get(i).getEventName();
            double price2 = list.get(i).getPrice();
            if (proName.equals(auction) && price == price2) {
                return i;
            }
        }
        return -1;
    }

    public void updateQuantity(String eventName) {
        int i = getIndex(eventName);
        list.get(i).setQuantity(quantityup);
        quantityup = 1;
    }

    public void remote(String eventName) {
        int i = getIndex(eventName);
        list.remove(i);
    }

    public void AddToCart() {

        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        HttpSession appsession = request.getSession(true);
        if (null == appsession.getAttribute("username")) {
            ExternalContext extContext = context.getExternalContext();
            String url = extContext.encodeActionURL(context.getApplication().
                    getViewHandler().getActionURL(context, "/login.xhtml"));
            try {
                extContext.redirect(url);
            } catch (IOException ex) {
                Logger.getLogger(AccountBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            String attribute = (String) appsession.getAttribute("eventid");
            getEventDetail ed = new getEventDetail();
            idEvent = Integer.parseInt(attribute);
            System.out.println(idEvent);
            System.out.println(Quantity);
            System.out.println(idArena);
            cart c = new cart();
            c.setQuantity(Quantity);
            c.setArenaId(idArena);
            c.setEventid(idEvent);
            c.setEventName(ed.getNamebyID(idEvent));
            c.setArena(ed.getArenabyID(idArena));
            c.setPrice(ed.getPricebyID(idArena));
            if (getexist(c.getEventName(), c.getPrice()) < 0) {
                list.add(c);
            }
            Quantity = 1;
            quantityup = 1;
            ExternalContext extContext = context.getExternalContext();
            String url = extContext.encodeActionURL(context.getApplication().
                    getViewHandler().getActionURL(context, "/cart.xhtml"));
            try {
                extContext.redirect(url);
            } catch (IOException ex) {
                Logger.getLogger(AccountBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < list.size(); i++) {
            total = total + list.get(i).getPrice() * list.get(i).getQuantity();
        }
        return total;
    }

    public int getTotalofTicket() {
        int total = 0;
        for (int i = 0; i < list.size(); i++) {
            total = total + list.get(i).getQuantity();
        }
        return total;
    }

    public user getuser() {
        AccountModel acc = new AccountModel();
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        HttpSession appsession = request.getSession(true);
        String usernameget = (String) appsession.getAttribute("username");
        user u = new user();
        u = acc.getInfobyusername(usernameget);
        idUser = u.getId();
        return u;
    }
// visa number 5361084902279153

    public String checkoutcompleted() throws MessagingException {
        if (checkedpayment.contains("1")) {
            int createOrder = 0;
            System.out.println(visanumber);
            System.out.println(fistnamepaypal);
            System.out.println(lastnamepaypal);
            System.out.println(monthvisa);
            System.out.println(yearvisa);
            CartModel cart = new CartModel();
            Double total = getTotal();
            DecimalFormat formatter = (DecimalFormat) NumberFormat.getCurrencyInstance(Locale.US);
            DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
            symbols.setCurrencySymbol(""); // Don't use null.
            formatter.setDecimalFormatSymbols(symbols);
            formatter.setMinimumFractionDigits(2);
            String totalString = formatter.format(total);
            String statuspay = cart.payment(typecard, visanumber, monthvisa, yearvisa, fistnamepaypal, lastnamepaypal, totalString);
            String payment = statuspay.substring(0, statuspay.indexOf("/"));
            String idpay = statuspay.substring(statuspay.indexOf("/") + 1, statuspay.length());
            if (payment.contains("approved") || payment.equals("in_progress") || payment.equals("pending") || payment.equals("created")) {
                user u = getuser();
                int id = u.getId();
                createOrder = cart.createOrder(id, payment, idpay);
                if (createOrder > 0) {
                    for (int i = 0; i < list.size(); i++) {
                        int quantitylist = list.get(i).getQuantity();
                        int pricetidget = list.get(i).getArenaId();
                        double totalget = list.get(i).getQuantity() * list.get(i).getPrice();
                        int createOrderDetail = cart.createOrderDetail(createOrder, pricetidget, quantitylist, totalget);
                        int originalQuantity = cart.getquantity(pricetidget);
                        int lastQuantity = originalQuantity - quantitylist;
                        cart.changequantity(pricetidget, lastQuantity);
                        for (int j = 0; j <= quantitylist; j++) {
                            cart.createTicket(pricetidget, createOrderDetail, "success");
                        }
                    }
                    cart.generateAndSendEmai(createOrder, u.getEmail());
                } else {
                    messageError = "Error !!!";
                    return "checkout";
                }
                return "paysuccess";
            } else {
                messageError = payment;
                return "checkout";
            }
        } else {
            int createOrder = 0;
            System.out.println(visanumber);
            System.out.println(fistnamepaypal);
            System.out.println(lastnamepaypal);
            System.out.println(monthvisa);
            System.out.println(yearvisa);
            CartModel cart = new CartModel();
            Double total = getTotal();
            DecimalFormat formatter = (DecimalFormat) NumberFormat.getCurrencyInstance(Locale.US);
            DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
            symbols.setCurrencySymbol(""); // Don't use null.
            formatter.setDecimalFormatSymbols(symbols);
            formatter.setMinimumFractionDigits(2);
            String totalString = formatter.format(total);
            user u = getuser();
            int id = u.getId();
            createOrder = cart.createOrder(id, "unpaid", "");
            if (createOrder > 0) {
                for (int i = 0; i < list.size(); i++) {
                    int quantitylist = list.get(i).getQuantity();
                    int pricetidget = list.get(i).getArenaId();
                    double totalget = list.get(i).getQuantity() * list.get(i).getPrice();
                    int createOrderDetail = cart.createOrderDetail(createOrder, pricetidget, quantitylist, totalget);
                    int originalQuantity = cart.getquantity(pricetidget);
                    int lastQuantity = originalQuantity - quantitylist;
                    cart.changequantity(pricetidget, lastQuantity);
                    for (int j = 0; j <= quantitylist; j++) {
                        cart.createTicket(pricetidget, createOrderDetail, "success");
                    }
                }
            }
            return "paysuccessnotpay";
        }
    }
}
