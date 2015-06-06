/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import entity.event;
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
    @ManagedProperty("#{param.id}")
    private String id;

    @PostConstruct
    public void init() {
        getFullList();
    }

    public String getSearchString() {
        return searchString;
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
        return "";
    }

    /**
     * Creates a new instance of EventListBean
     */
}
