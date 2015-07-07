/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.event;
import entity.price;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.getEventDetail;

/**
 *
 * @author dattr_000
 */
@ManagedBean
@SessionScoped
public class eventDetailBean {

    private String id;
    private int idsave;
    private String TypeName;
    private String startdate;
    private String eventname;
    private String content;
    private String locationName;
    private String locationAddress;
    private String eventImg;
    private event ev;
    private String stadiumimg;
    private int quantity = 5;
    private List<price> listprice;
    private List<price> selectedOptions;

    public String getStadiumimg() {
        return stadiumimg;
    }

    public List<price> getListprice() {
        return listprice;
    }

    public void setListprice(List<price> listprice) {
        this.listprice = listprice;
    }

    public int getIdsave() {
        return idsave;
    }

    public void setIdsave(int idsave) {
        this.idsave = idsave;
    }

    public List<price> getSelectedOptions() {
        return selectedOptions;
    }

    public void setSelectedOptions(List<price> selectedOptions) {
        this.selectedOptions = selectedOptions;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setStadiumimg(String stadiumimg) {
        this.stadiumimg = stadiumimg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEventImg() {
        return eventImg;
    }

    public void setEventImg(String eventImg) {
        this.eventImg = eventImg;
    }

    public String getTypeName() {
        return TypeName;
    }

    public void setTypeName(String TypeName) {
        this.TypeName = TypeName;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public String getEnventImg() {
        return eventImg;
    }

    public void setEnventImg(String enventImg) {
        this.eventImg = enventImg;
    }

    public event getEv() {
        return ev;
    }

    public void setEv(event ev) {
        this.ev = ev;
    }

    public void getDetail() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        HttpSession appsession = request.getSession(true);
        String attribute = (String) appsession.getAttribute("eventid");
        idsave = Integer.parseInt(attribute);
        getEventDetail gete = new getEventDetail();
        ev = gete.getEvent(idsave);
        eventname = ev.getEventname();
        TypeName = ev.getTypeName();
        if (TypeName.contains("Movie")) {
            stadiumimg = "movie.jpg";
        } else {
            if (TypeName.contains("Sports")) {
                stadiumimg = "sports.jpg";
            } else {
                if (TypeName.contains("Music")) {
                    stadiumimg = "music.jpg";
                } else {
                    if (TypeName.contains("Drama")) {
                        stadiumimg = "drama.jpg";
                    }
                }
            }
        }
        startdate = ev.getStartdate();
        content = ev.getContent();
        eventImg = ev.getEnventImg();
        locationAddress = ev.getLocationAddress();
        locationName = ev.getLocationName();
    }

    public List<price> getPrice() {
        listprice = new ArrayList<price>();
        getEventDetail gete = new getEventDetail();
        listprice = gete.getPricesbyEventID(idsave);
        return listprice;
    }

}
