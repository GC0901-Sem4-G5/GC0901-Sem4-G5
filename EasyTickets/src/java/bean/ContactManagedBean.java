/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.paypal.api.payments.Cost;
import entity.contactus;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.ContactUsModel;
import model.FAQModel;

/**
 *
 * @author Windows 8.1X64 M1
 */
@ManagedBean(name = "contactus")
@SessionScoped
public class ContactManagedBean implements Serializable{
    
    private ContactUsModel contactusModel;
    private List<contactus> listContacts;
    private List<contactus> filteredContact;
    private contactus curContact;
    /**
     * Creates a new instance of ContactManagedBean
     */
    public ContactManagedBean() {
        contactusModel = new ContactUsModel();
        filteredContact = new ArrayList<contactus>();
    }
    
    
    public String showAdd(){
        curContact = new contactus();
        return "contactus?faces-redirect=true";
    }
    
    public String displayCreate(){
        curContact = new contactus();
        return "add-contactus?faces-redirect=true";
    }
    
    public String create(){
       
        contactusModel.createContact(curContact.getName(), curContact.getEmail(), curContact.getPhone(), curContact.getContent());
        return "contactus";
    }
    
    private void addMessage(String sumary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, sumary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
   

    public String delete(){
        contactusModel.delete(curContact);
        return "contactus";
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
     * @return the filteredContact
     */
    public List<contactus> getFilteredContact() {
        return filteredContact;
    }

    /**
     * @param filteredContact the filteredContact to set
     */
    public void setFilteredContact(List<contactus> filteredContact) {
        this.filteredContact = filteredContact;
    }

    /**
     * @return the curContact
     */
    public contactus getCurContact() {
        return curContact;
    }

    /**
     * @param curContact the curContact to set
     */
    public void setCurContact(contactus curContact) {
        this.curContact = curContact;
    }

    public List<contactus> getListContacts() {
        listContacts = contactusModel.getContactUs();
        return listContacts;
    }

    public void setListContacts(List<contactus> listContacts) {
        this.listContacts = listContacts;
    }
    
}
