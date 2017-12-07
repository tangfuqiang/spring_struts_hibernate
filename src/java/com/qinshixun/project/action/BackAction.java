package com.qinshixun.project.action;

import com.qinshixun.project.model.UserModel;
import com.qinshixun.project.service.LoginService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BackAction {
    @Autowired
    private LoginService loginService;

    private int totalPage;

    private int maxpage=5;

    private int startPage=1;

    private List<UserModel> userlist;

    //返回或用户查询
    public String backOrToUserlist(){
        totalPage=loginService.getTotalPage(maxpage);
        userlist=loginService.getUser((startPage-1)*maxpage,maxpage);
        ServletActionContext.getRequest().getSession().setAttribute("totalPage",totalPage);
        return "success";
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getMaxpage() {
        return maxpage;
    }

    public void setMaxpage(int maxpage) {
        this.maxpage = maxpage;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public List<UserModel> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<UserModel> userlist) {
        this.userlist = userlist;
    }
}
