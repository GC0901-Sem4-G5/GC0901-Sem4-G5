/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import entity.event;
import entity.location;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.getEventDetail;
import model.getListEvent;

/**
 *
 * @author dattr_000
 */
@ManagedBean
@RequestScoped
public class EventListBean {

    private List<event> listevent = new ArrayList<>();
    private String searchString;
    private event ev;
    @ManagedProperty("#{param.id}")
    private String id;
    private String stadiumimg;
    private List<location> listlocation = new ArrayList<>();
    private String cityget;

    @PostConstruct
    public void init() {
        getFullList();
        getLocation();
    }

    public String getSearchString() {
        return searchString;
    }

    public List<location> getListlocation() {
        return listlocation;
    }

    public void setListlocation(List<location> listlocation) {
        this.listlocation = listlocation;
    }

    public String getCityget() {
        return cityget;
    }

    public void setCityget(String cityget) {
        this.cityget = cityget;
    }
    
    

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public event getEv() {
        return ev;
    }

    public void setEv(event ev) {
        this.ev = ev;
    }

    public String getStadiumimg() {
        return stadiumimg;
    }

    public void setStadiumimg(String stadiumimg) {
        this.stadiumimg = stadiumimg;
    }

    public List<event> getListevent() {
        return listevent;
    }

    public void setListevent(List<event> listevent) {
        this.listevent = listevent;
    }

    public void getFullList() {
        getListEvent list = new getListEvent();
        listevent = list.getEventList();
    }

    public double getPrice(int event) {
        getListEvent list = new getListEvent();
        return list.getTop1Price(event);
    }

    public String getMovieEvent() {
        System.out.println("hello !!!");
        getListEvent list = new getListEvent();
        listevent = list.getType(1);
        return "";
    }

    public void getMusicEvent() {
        getListEvent list = new getListEvent();
        listevent = list.getType(2);
    }

    public void getDramaEvent() {
        getListEvent list = new getListEvent();
        listevent = list.getType(3);
    }

    public void getSportEvent() {
        getListEvent list = new getListEvent();
        listevent = list.getType(4);
    }

    public void searchEvent() {
        if (searchString != "") {
            getListEvent list = new getListEvent();
            listevent = list.SearchEvent(searchString);
        } else {
            getFullList();
        }
    }

    public String detail() {
        getEventDetail gete = new getEventDetail();
        ev = gete.getEvent(Integer.parseInt(id));
        return "eventdetail";
    }
    
    public void getLocation(){
         getListEvent list = new getListEvent();
         listlocation = list.getLocation();
    }

    /**
     * Creates a new instance of EventListBean
     */
}
