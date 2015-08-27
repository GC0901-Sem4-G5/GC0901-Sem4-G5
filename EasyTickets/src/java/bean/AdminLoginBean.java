/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;


import entity.Account;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.AccountDB;

/**
 *
 * @author Windows 8.1X64 M1
 */
@ManagedBean
@SessionScoped
public class AdminLoginBean implements Serializable{
    
    
    
    /**
     * Creates a new instance of LoginBean
     */
    public AdminLoginBean() {
    }
    private List<Account> filteredAccounts;
    private String username;  
      
    private String password;  
    private String message;
    private Account curAccount;
    private Account editAccount;
    
    private Map<String,Boolean> mapRole = new HashMap<String, Boolean>();
     
    public List<Account> getAccounts() {
        AccountDB accountDB = new AccountDB();
        return accountDB.findAll();
    }
    
    public String showAdd(){
        curAccount = new Account();
        return "edit-account";
    }
    
    public String create() {
        AccountDB accountDB = new AccountDB();
        accountDB.add(curAccount);
        return "account";
    }
    
    public String edit() {
        AccountDB accountDB = new AccountDB();
        accountDB.edit(curAccount);
        return "account";
    }
    public String delete() {
        AccountDB accountDB = new AccountDB();
        accountDB.delete(curAccount);
        return "account";
    }
    
    
    public String login() {  
        AccountDB accountDB = new AccountDB();
        Account account = accountDB.checkLogin(username, password);
        if(account != null) {  
            HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpSession session = request.getSession();
            session.setAttribute("account_admin", account);
            this.mapRole = buildMapRole(account.getRole());
            message = "";
            return "home?faces-redirect=true";
        } else {  
             
            message = "Login Fail. Please try again!";
            return "login?faces-redirect=true";
        }  
          
        //FacesContext.getCurrentInstance().addMessage(null, msg);  
        //context.addCallbackParam("loggedIn", loggedIn);  
    } 
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public static HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
    }
    
    public String logout() {
        HttpSession session = getSession();
        if (session != null) {
            session.invalidate();
        }
        username = "";
        password = "";
        
        return "login?faces-redirect=true";
    }
    
    private Map<String, Boolean> buildMapRole(String role) {
        Map<String, Boolean> mapRole = new HashMap<>();
        if (role.equalsIgnoreCase("admin")) {
            mapRole = putDataRole(mapRole, true);
        } else {
            mapRole = putDataRole(mapRole, false);
            if (role.contains(PermissionConstant.ROLE_MANAGE_ADMIN_ACCOUNT)) {
                mapRole.put("ADMIN_ACCOUNT_PAGE", true);
            }
            if (role.contains(PermissionConstant.ROLE_MANAGE_CUSTOMER_ACCOUNT)) {
                mapRole.put("CUSTOMER_PAGE", true);
            }
            
            if (role.contains(PermissionConstant.ROLE_MANAGE_ORDER)) {
                mapRole.put("ORDER_PAGE", true);
            }
            
            if (role.contains(PermissionConstant.ROLE_MANAGE_EVENT)) {
                mapRole.put("EVENT_PAGE", true);
            }
            if (role.contains(PermissionConstant.ROLE_MANAGE_FAQ)) {
                mapRole.put("FAQ_PAGE", true);
            }
            
            if (role.contains(PermissionConstant.ROLE_MANAGE_FEEDBACK)) {
                mapRole.put("FEEDBACK_PAGE", true);
            }
        }

        return mapRole;
    }
    
    private Map<String, Boolean> putDataRole(Map<String, Boolean> mapRole, boolean isAdmin) {
        mapRole.put("ADMIN_ACCOUNT_PAGE", isAdmin);
        mapRole.put("CUSTOMER_PAGE", isAdmin);
        mapRole.put("ORDER_PAGE", isAdmin);
        mapRole.put("EVENT_PAGE", isAdmin);
        mapRole.put("FAQ_PAGE", isAdmin);
        mapRole.put("FEEDBACK_PAGE", isAdmin);
        return mapRole;
    }

    public Map<String, Boolean> getMapRole() {
        return mapRole;
    }

    public void setMapRole(Map<String, Boolean> mapRole) {
        this.mapRole = mapRole;
    }
    
    public String getUsername() {  
        return username;  
    }  
  
    public void setUsername(String username) {  
        this.username = username;  
    }  
  
    public String getPassword() {  
        return password;  
    }  
  
    public void setPassword(String password) {  
        this.password = password;  
    }  
  
   

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the curAccount
     */
    public Account getCurAccount() {
        return curAccount;
    }

    /**
     * @param curAccount the curAccount to set
     */
    public void setCurAccount(Account curAccount) {
        this.curAccount = curAccount;
    }

    /**
     * @return the filteredAccounts
     */
    public List<Account> getFilteredAccounts() {
        return filteredAccounts;
    }

    /**
     * @param filteredAccounts the filteredAccounts to set
     */
    public void setFilteredAccounts(List<Account> filteredAccounts) {
        this.filteredAccounts = filteredAccounts;
    }

    /**
     * @return the editAccount
     */
    public Account getEditAccount() {
        return editAccount;
    }

    /**
     * @param editAccount the editAccount to set
     */
    public void setEditAccount(Account editAccount) {
        this.editAccount = editAccount;
    }
}
