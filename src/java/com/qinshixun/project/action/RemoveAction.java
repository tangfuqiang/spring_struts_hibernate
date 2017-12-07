package com.qinshixun.project.action;

import com.qinshixun.project.model.UserModel;
import com.qinshixun.project.service.LoginService;
import com.qinshixun.project.service.RemoveService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RemoveAction {

    private long id;
    private List<UserModel> newuserlist;
    private int maxPage = 5;
    private int startPage;
    private int totalPage;

    @Autowired
    private RemoveService removeService;

    @Autowired
    private LoginService loginService;

    public String removeUser(){
        id=Long.valueOf( ServletActionContext.getRequest().getParameter("id"));
        startPage=Integer.valueOf(ServletActionContext.getRequest().getParameter("startPage"));
        removeService.removeUser(id);
        totalPage=loginService.getTotalPage(maxPage);
        ServletActionContext.getRequest().getSession().setAttribute("totalPage",totalPage);
        if(startPage>totalPage) {

            startPage=startPage-1;
            newuserlist=loginService.getUser((startPage-2)*maxPage,maxPage);

        }else {
            newuserlist=loginService.getUser((startPage-1)*maxPage,maxPage);
        }
        return "success";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<UserModel> getNewuserlist() {
        return newuserlist;
    }

    public void setNewuserlist(List<UserModel> newuserlist) {
        this.newuserlist = newuserlist;
    }
}
