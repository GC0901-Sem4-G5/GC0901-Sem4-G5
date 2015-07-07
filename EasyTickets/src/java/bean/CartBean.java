/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.cart;
import entity.event;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.CartModel;
import model.getEventDetail;

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
    private int idArena;
    private event e = new event();

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

    public void AddToCart() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        HttpSession appsession = request.getSession(true);
        String attribute = (String) appsession.getAttribute("eventid");
        getEventDetail ed = new getEventDetail();
        idEvent = Integer.parseInt(attribute);
        System.out.println(idEvent);
        System.out.println(Quantity);
        System.out.println(idArena);
        cart c = new cart();
        c.setQuantity(Quantity);
        c.setEventName(ed.getNamebyID(idEvent));
        c.setArena(ed.getArenabyID(idArena));
        c.setPrice(ed.getPricebyID(idArena));
        list.add(c);
        shop.ins(c);
        appsession.setAttribute("cartlist", shop.getIt());
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
