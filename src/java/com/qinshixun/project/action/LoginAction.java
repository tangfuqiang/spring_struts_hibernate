package com.qinshixun.project.action;

import com.qinshixun.project.model.AdminModel;
import com.qinshixun.project.model.UserModel;
import com.qinshixun.project.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.struts2.ServletActionContext;

import java.util.List;

public class LoginAction {
    @Autowired
    private LoginService loginService;

    private AdminModel adminModel;

    private Boolean check;

    private int startPage = 1;

    private int maxPage = 5;

    private int totalPage;

    private List<UserModel> userlist;

    public String Check() {
        String username = ServletActionContext.getRequest().getParameter("username");
        String password = ServletActionContext.getRequest().getParameter("password");
        adminModel = loginService.Check(username, password);
        if (adminModel == null) {
            check = false;
        } else {
            totalPage = loginService.getTotalPage(maxPage);
            ServletActionContext.getRequest().getSession().setAttribute("loginCheck", username);
            ServletActionContext.getRequest().getSession().setAttribute("totalPage", totalPage);
            check = true;
        }
        return "error";
    }

    public String getUser() {
        userlist = loginService.getUser((startPage - 1) * maxPage, maxPage);
        return "success";
    }

    public String nextPage() {

        startPage = Integer.valueOf(ServletActionContext.getRequest().getParameter("startPage"));
        userlist = loginService.getUser((startPage - 1) * maxPage, maxPage);
        return "success";
    }

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }

    public List<UserModel> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<UserModel> userlist) {
        this.userlist = userlist;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }

}
