package com.qinshixun.project.action;

import com.qinshixun.project.model.UserModel;
import com.qinshixun.project.service.QueryService;
import com.qinshixun.project.service.RemoveService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class QueryAction {

    @Autowired
    private QueryService queryService;

    @Autowired
    private RemoveService removeService;
    private int totalPage;

    private int startPage = 1;

    private int maxPage = 5;

    private long id;

    private boolean check = false;

    private List<UserModel> userlist;

    //判断查询用户是否存在
    public String queryUser() {
        String username = ServletActionContext.getRequest().getParameter("username");
        totalPage = queryService.queryNumber(username, maxPage);
        if (totalPage != 0) {
            ServletActionContext.getRequest().getSession().setAttribute("username",username);
            ServletActionContext.getRequest().getSession().setAttribute("querytotalPage",totalPage);
            check = true;
        }
        return "error";
    }

    //前往查询结果界面
    public String toQueryPage() {
        String username = ServletActionContext.getRequest().getParameter("username");
        userlist = queryService.queryUser((startPage - 1) * maxPage, maxPage, username);
        return "success";
    }

    //查询结果下页操作
    public String nextQueryPage(){
        String username = ServletActionContext.getRequest().getParameter("username");
        startPage = Integer.valueOf(ServletActionContext.getRequest().getParameter("startPage"));
        userlist = queryService.queryUser((startPage - 1) * maxPage, maxPage, username);
        return "success";
    }

    //删除查询结果指定的一条
    public String removeQuery() {

        id = Long.valueOf(ServletActionContext.getRequest().getParameter("id"));
        String username = ServletActionContext.getRequest().getParameter("username");
        startPage=Integer.valueOf(ServletActionContext.getRequest().getParameter("startPage"));
        removeService.removeUser(id);
        totalPage = queryService.queryNumber(username, maxPage);

        if (startPage > totalPage) {
            userlist = queryService.queryUser((startPage - 2) * maxPage, maxPage, username);
            startPage = startPage - 1;
        } else {
            userlist = queryService.queryUser((startPage - 1) * maxPage, maxPage, username);
        }
        return "success";
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
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

    public int getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
