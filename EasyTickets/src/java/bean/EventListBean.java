/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import entity.event;
import entity.location;
import entity.type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
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
    private List<type> listtype = new ArrayList<>();
    private String[] cityget;
    private String[] typeget;
    private int dateget;
    private int timeidget;

    @PostConstruct
    public void init() {
        getFullList();
    }

    public String[] getTypeget() {
        return typeget;
    }

    public int getDateget() {
        return dateget;
    }

    public void setDateget(int dateget) {
        this.dateget = dateget;
    }

    public int getTimeget() {
        return timeidget;
    }

    public void setTimeget(int timeget) {
        this.timeidget = timeget;
    }

    public void setTypeget(String[] typeget) {
        this.typeget = typeget;
    }

    public List<type> getListtype() {
        return listtype;
    }

    public void setListtype(List<type> listtype) {
        this.listtype = listtype;
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

    public String[] getCityget() {
        return cityget;
    }

    public void setCityget(String[] cityget) {
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
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        HttpSession appsession = request.getSession(true);
        appsession.setAttribute("eventid", id);
        return "eventdetail";
    }

    public List<location> getLocation() {
        getListEvent list = new getListEvent();
        listlocation = list.getLocation();
        return listlocation;
    }

    public List<type> getType() {
        getListEvent list = new getListEvent();
        listtype = list.getType();
        return listtype;
    }

    public void filter() {
        String condition = null;
        if (dateget != 0) {
            if (dateget == 1) {
                condition = " DateStart < DATEADD(DAY,7,GETDATE()) and DateStart > GETDATE() ";
            } else {
                if (dateget == 2) {
                    condition = " CONVERT(VARCHAR(10),DateStart,110) >= CONVERT(VARCHAR(10),GETDATE(),110) and DateStart <=  DATEADD(DAY , 7-DATEPART(WEEKDAY,GETDATE()),GETDATE()) ";
                } else {
                    condition = " DATEPART(month,DateStart)  =  DATEPART(month,GETDATE()) + 1 ";
                }
            }
        }
        if (timeidget != 0) {
            if (timeidget == 1) {
                condition = condition + " AND DATEPART(hour,DateStart) < 12";
            } else {
                if (timeidget == 2) {
                    condition = condition + " AND DATEPART(hour,DateStart) >= 12 AND DATEPART(hour,DateStart) < 18 ";
                } else {
                    condition = condition + " AND DATEPART(hour,DateStart) >= 18";
                }
            }
        }
        if (typeget != null) {
            if (typeget.length == 1) {
                condition = condition + " AND [Event].typeid = " + typeget[0].toString();
            } else {
                if (typeget.length == 2) {
                    condition = condition + " AND ( [Event].typeid = " + typeget[0].toString();
                    condition = condition + " OR [Event].typeid =" + typeget[1].toString() + " ) ";
                } else {
                    if (typeget.length > 2) {
                        condition = condition + " AND ( [Event].typeid = " + typeget[0].toString();
                        for (int i = 1; i < typeget.length; i++) {
                            condition = condition + " OR [Event].typeid = " + typeget[i].toString();
                        }
                        condition = condition + " ) ";
                    }

                }
            }
        }
        if (cityget != null) {
            if (cityget.length == 1) {
                condition = condition + " AND location.city like " + "'" + cityget[0].toString() + "'";
            } else {
                if (cityget.length == 2) {
                    condition = condition + " AND ( location.city = " + "'" + cityget[0].toString() + "'";
                    condition = condition + " OR location.city = " + "'" + cityget[1].toString() + "' ) ";
                } else {
                    if (cityget.length > 2) {
                        condition = condition + " AND ( location.city like " + "'" + cityget[0].toString() + "'";
                        for (int i = 1; i < cityget.length; i++) {
                            condition = condition + " OR location.city like " + "'" + cityget[i].toString() + "'";
                        }
                        condition = condition + " ) ";
                    }
                }
            }
        }
        getListEvent list = new getListEvent();
        listevent = list.getEventListByCondition(condition);
    }

    /**
     * Creates a new instance of EventListBean
     */
}
