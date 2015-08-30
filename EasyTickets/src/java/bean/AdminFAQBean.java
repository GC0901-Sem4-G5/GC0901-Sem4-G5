/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.faq;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import model.FAQModel;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Windows 8.1X64 M1
 */
@ManagedBean
@SessionScoped
public class AdminFAQBean {
    
    private List<faq> listfaq = new ArrayList<>();

    private faq curFaq;
    /**
     * Creates a new instance of AdminFAQBean
     */
    public AdminFAQBean() {
        curFaq = new faq();
    }

    public List<faq> getListfaq() {
        FAQModel faq = new FAQModel();
        listfaq = faq.getFAQ();
        return listfaq;
    }
    public String edit() {
        FAQModel faq = new FAQModel();
        faq.edit(curFaq);
        return "addmin_faq";
    }
    public String delete() {
        FAQModel faq = new FAQModel();
        faq.delete(curFaq);
        return "addmin_faq";
    }
    public String add() {
        FAQModel faq = new FAQModel();
        faq.add(curFaq);
        return "addmin_faq";
    }
    
    public String redirect() {
        return "addmin_faq";
        
    }
    public String redirectAdd() {
        return "admin_add_faq";
    }

    public void setListfaq(List<faq> listfaq) {
        this.listfaq = listfaq;
    }
    
    
  

    /**
     * @return the curFaq
     */
    public faq getCurFaq() {
        return curFaq;
    }

    /**
     * @param curFaq the curFaq to set
     */
    public void setCurFaq(faq curFaq) {
        this.curFaq = curFaq;
    }
    
}
