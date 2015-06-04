/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.ContactUsModel;

/**
 *
 * @author dattr_000
 */
@ManagedBean
@RequestScoped
public class ContactUsBean {

    /**
     * Creates a new instance of ContactUsBean
     */
    private int id;
    private String name;
    private String email;
    private String phone;
    private String content;
    private String created;
    private String messages;
    private ContactUsModel contact;

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
    
    public void black(){
        name = "";
        phone = "";
        email = "";
        content ="";
    }

    public void sendFeedBack() {
        contact = new ContactUsModel();

        if (contact.createContact(name, email, phone, content)) {
            messages = "Send Feedback Success !";
            black();   
        } else {
            messages = "Send Feedback Error !";
        }
    }

}
