/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;


import entity.Account;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Windows 8.1X64 M1
 */
@WebFilter("/faces/admin/*")
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String url = req.getRequestURI();
        String page = url.substring(url.lastIndexOf("/") + 1);
        Account account = (Account) req.getSession().getAttribute("account_admin");
        if (page.equals(PermissionConstant.LOGIN_PAGE)) {
            chain.doFilter(request, response);
        } else {
            if (account != null) {
                if (account.getRole().equals("admin")) {
                    chain.doFilter(request, response);
                } else {
                    if (page.equals(PermissionConstant.HOME_PAGE)) {
                        chain.doFilter(request, response);
                    } else {
                        if (page.equals(PermissionConstant.ADMIN_ACCOUNT_PAGE) || page.equals(PermissionConstant.ADMIN_ACCOUNT_EDIT_PAGE) || page.equals(PermissionConstant.ADMIN_ACCOUNT_ADD_PAGE)|| page.equals(PermissionConstant.ADMIN_ACCOUNT_CHANGE_PASS_PAGE)) {
                            if (account.getRole().contains(PermissionConstant.ROLE_MANAGE_ADMIN_ACCOUNT)) {
                                chain.doFilter(request, response);
                            } else {
                                goToLogin(req, response);
                            }
                        } else if (page.equals(PermissionConstant.CUSTOMER_ACCOUNT_PAGE) || page.equals(PermissionConstant.CUSTOMER_ACCOUNT_EDIT_PAGE) || page.equals(PermissionConstant.CUSTOMER_ACCOUNT_ADD_PAGE)) {
                            if (account.getRole().contains(PermissionConstant.ROLE_MANAGE_CUSTOMER_ACCOUNT)) {
                                chain.doFilter(request, response);
                            } else {
                                goToLogin(req, response);
                            }
                        } else if (page.equals(PermissionConstant.ORDER_ACCOUNT_PAGE) || page.equals(PermissionConstant.ORDER_ACCOUNT_EDIT_PAGE) || page.equals(PermissionConstant.ORDER_DETAILS_ADD_PAGE) || page.equals(PermissionConstant.ORDERDETAILS_ADD_PAGE)) {
                            if (account.getRole().contains(PermissionConstant.ROLE_MANAGE_ORDER)) {
                                chain.doFilter(request, response);
                            } else {
                                goToLogin(req, response);
                            }
                        } else if (page.equals(PermissionConstant.FAQ_PAGE) || page.equals(PermissionConstant.FAQ_EDIT_PAGE) || page.equals(PermissionConstant.FAQ_ADD_PAGE)) {
                            if (account.getRole().contains(PermissionConstant.ROLE_MANAGE_FAQ)) {
                                chain.doFilter(request, response);
                            } else {
                                goToLogin(req, response);
                            }
                        } else if (page.equals(PermissionConstant.FEEDBACK_PAGE) || page.equals(PermissionConstant.FEEDBACK_EDIT_PAGE) || page.equals(PermissionConstant.FEEDBACK_ADD_PAGE)) {
                            if (account.getRole().contains(PermissionConstant.ROLE_MANAGE_FEEDBACK)) {
                                chain.doFilter(request, response);
                            } else {
                                goToLogin(req, response);
                            }
                        } else {
                            goToLogin(req, response);
                        }
                    }
                }

            } else {
                goToLogin(req, response);
            }
        }
        //chain.doFilter(request, response);
    }

    private void goToLogin(HttpServletRequest req, ServletResponse response) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) response;
        res.sendRedirect(req.getContextPath() + "/faces/admin/login.xhtml");
    }

    @Override
    public void destroy() {

    }

}
