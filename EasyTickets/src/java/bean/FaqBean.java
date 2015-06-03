/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.event;
import entity.faq;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.FAQModel;
import model.getListEvent;

/**
 *
 * @author dattr_000
 */
@ManagedBean
@RequestScoped
public class FaqBean {

    private List<faq> listfaq = new ArrayList<>();

    /**
     * Creates a new instance of FaqBean
     */
    public List<faq> getList() {
        FAQModel faq = new FAQModel();
        listfaq = faq.getFAQ();
        return listfaq;
    }

}
