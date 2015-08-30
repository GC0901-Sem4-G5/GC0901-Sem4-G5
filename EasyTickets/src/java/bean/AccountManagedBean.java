/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;


import entity.Account;
import entity.Permission;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.AccountDB;
import model.PermissionModel;
import org.apache.commons.lang3.StringUtils;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Windows 8.1X64 M1
 */
@ManagedBean(name = "account")
@SessionScoped
public class AccountManagedBean implements Serializable {
    
    private PermissionModel permissionModel;
    private AccountDB accountDB;
    private Account curAccount;
    private List<Account> filteredAccounts;
    private List<String> selectedPermissions;
    private List<String> selectedPermissionsCreate;
    private String message;
    private String oldPassword;
    private String newPassword;
    private String msg;
    private Account editAccount;
    private String changepass;
    private Account curSubAccount;

    public AccountManagedBean() {
        message = "";
        changepass = "";
        msg = "";
        curSubAccount = new Account();
        selectedPermissionsCreate = new ArrayList<>();
        permissionModel = new PermissionModel();
        accountDB = new AccountDB();
    }

    public List<Permission> getPermissions() {
        return permissionModel.getAll();
    }

     public List<Account> getAccounts() {
        return accountDB.findAll();
    }

    public String showAdd() {
        curSubAccount = new Account();
        return "add-account?faces-redirect=true";
    }

    public String showEdit() {
        return "edit-account?faces-redirect=true";
    }

    public String showBack() {
        return "account?faces-redirect=true";
    }

    public String showChangePassword() {
        return "change-password?faces-redirect=true";
    }

    public String showConfirm() {
        return "account";
    }

    public String create() {
        try {
            String action = "";
            boolean flag = true;
            if (flag == true) {
                List<Account> list = accountDB.findAll();
                
                for (Account list1 : list) {
                    if (list1.getUsername().equals(curSubAccount.getUsername())) {
                        msg = "Current Accout existed, please input orther!";
                        action = "add-account";
                        flag = true;
                        break;
                    } else {
                        flag = false;

                    }
                }

            }
            if (flag == false) {
                List<String> role = new ArrayList<String>();
                for (String p : selectedPermissionsCreate) {
                    role.add(p);
                }
                curSubAccount.setRole(StringUtils.join(role, ","));
                accountDB.add(curSubAccount);
                msg = "";
                action = "account";

            }
            return action;

        } catch (Exception e) {
            e.printStackTrace();
            return "add-account?faces-redirect=true";
        }
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String edit() {

        String action = "";
        boolean flag = true;
        if (flag == true) {
            List<Account> list = accountDB.findAll();
            int index = -1;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId() == editAccount.getId()) {
                    index = i;
                    break;
                }
            }
            if (index > -1) {
                list.remove(index);
            }
            for (Account list1 : list) {
                if (list1.getUsername().equals(editAccount.getUsername())) {
                    message = "Current Accout existed, please input orther!";
                    action = "edit-account";
                    flag = true;
                    break;
                } else {
                    flag = false;

                }
            }

        }
        if (flag == false) {
            List<String> role = new ArrayList<String>();
            for (String p : selectedPermissions) {
                role.add(p);
            }
            editAccount.setRole(StringUtils.join(role, ","));
            accountDB.edit(editAccount);
            message = "";
            action = "account?faces-redirect=true";
        }
        return action;

    }

    public String changePassword() {

        editAccount.setPassword(newPassword);

        accountDB.edit(editAccount);

        return "account?faces-redirect=true";
    }

    public void delelete() {
        accountDB.delete(editAccount);
        RequestContext.getCurrentInstance().addCallbackParam("loggedIn", true);
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
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

    public List<String> getSelectedPermissions() {
        selectedPermissions = new ArrayList<>();
        String role = editAccount.getRole();
        if (!StringUtils.isBlank(role)) {
            List<Permission> permissions = getPermissions();
            String[] listPermission = role.split(",");
            for (String per : listPermission) {
                for (Permission permission : permissions) {
                    if (per.equals(permission.getRoleName())) {
                        selectedPermissions.add(permission.getRoleName());
                        break;
                    }
                }
            }
        }

        return selectedPermissions;
    }

    public void setSelectedPermissions(List<String> selectedPermissions) {
        this.selectedPermissions = selectedPermissions;
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
     * @return the oldPassword
     */
    public String getOldPassword() {
        return oldPassword;
    }

    /**
     * @param oldPassword the oldPassword to set
     */
    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    /**
     * @return the newPassword
     */
    public String getNewPassword() {
        return newPassword;
    }

    /**
     * @param newPassword the newPassword to set
     */
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
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

    /**
     * @return the changepass
     */
    public String getChangepass() {
        return changepass;
    }

    /**
     * @param changepass the changepass to set
     */
    public void setChangepass(String changepass) {
        this.changepass = changepass;
    }

    /**
     * @return the curSubAccount
     */
    public Account getCurSubAccount() {
        return curSubAccount;
    }

    /**
     * @param curSubAccount the curSubAccount to set
     */
    public void setCurSubAccount(Account curSubAccount) {
        this.curSubAccount = curSubAccount;
    }

    /**
     * @return the selectedPermissionsCreate
     */
    public List<String> getSelectedPermissionsCreate() {
        return selectedPermissionsCreate;
    }

    /**
     * @param selectedPermissionsCreate the selectedPermissionsCreate to set
     */
    public void setSelectedPermissionsCreate(List<String> selectedPermissionsCreate) {
        this.selectedPermissionsCreate = selectedPermissionsCreate;
    }

}
