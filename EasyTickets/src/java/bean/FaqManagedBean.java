/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.faq;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.FAQModel;

/**
 *
 * @author Windows 8.1X64 M1
 */
@ManagedBean(name = "faq")
@SessionScoped
public class FaqManagedBean implements Serializable{
    
    private FAQModel faqModel;
    private List<faq> listFaqs;
    private List<faq> filteredFaq;
    private faq curFaq;
    /**
     * Creates a new instance of FaqManagedBean
     */
    public FaqManagedBean() {
        faqModel = new FAQModel();
        filteredFaq = new ArrayList<faq>();
    }
    
    
    public String showAdd(){
        curFaq = new faq();
        return "faq?faces-redirect=true";
    }
    
    public String displayCreate(){
        curFaq = new faq();
        return "add-faq?faces-redirect=true";
    }
    
    public String create(){
       
        faqModel.add(curFaq);
        return "faq";
    }
    
    private void addMessage(String sumary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, sumary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public String edit(){
       faqModel.edit(curFaq);
       return "faq";
    }
   

    public String delete(){
        faqModel.delete(curFaq);
        return "faq";
    }
    
    public void destroyWorld() {
        delete();
        addMessage("Message", "Delete Succesffull!!.");
    }
     
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    /**
     * @return the filteredFaq
     */
    public List<faq> getFilteredFaq() {
        return filteredFaq;
    }

    /**
     * @param filteredFaq the filteredFaq to set
     */
    public void setFilteredFaq(List<faq> filteredFaq) {
        this.filteredFaq = filteredFaq;
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

    public List<faq> getListFaqs() {
        listFaqs = faqModel.getFAQ();
        return listFaqs;
    }

    public void setListFaqs(List<faq> listFaqs) {
        this.listFaqs = listFaqs;
    }
    
}
