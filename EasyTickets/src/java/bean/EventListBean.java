/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.event;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.getListEvent;

/**
 *
 * @author dattr_000
 */
@ManagedBean
@RequestScoped
public class EventListBean {
private List<event> listevent = new ArrayList<>();

public List<event> getList(){
    getListEvent list = new getListEvent();
    listevent = list.getEventList();
    return listevent;
    
}
    /**
     * Creates a new instance of EventListBean
     */
   
    
}
