package com.qinshixun.project.action;

import com.qinshixun.project.model.HobbyModel;
import com.qinshixun.project.model.OccupationModel;
import com.qinshixun.project.model.UserModel;
import com.qinshixun.project.service.AddUserService;
import com.qinshixun.project.service.QueryService;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;


public class AddUserAction {


    @Autowired
    private AddUserService addUserService;

    @Autowired
    private QueryService queryService;

    private List<OccupationModel> occupatiolist;

    private List<HobbyModel> hobbyList;

    private boolean check = true;

    public String toAddPage() {
        occupatiolist = addUserService.getOccupation();
        hobbyList = addUserService.getHobby();
        return "success";
    }

    public String addUser() {

        String username = ServletActionContext.getRequest().getParameter("username");
        String password = ServletActionContext.getRequest().getParameter("password");
        String email = ServletActionContext.getRequest().getParameter("email");
        String hobby = ServletActionContext.getRequest().getParameter("hobby");
        String occupation = ServletActionContext.getRequest().getParameter("occupation");
        char sex = ServletActionContext.getRequest().getParameter("sex").charAt(0);
        String date = ServletActionContext.getRequest().getParameter("birthday");
        System.out.println(username);
        Date birthday = null;

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        try {
            birthday = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        UserModel userModelCheck = queryService.queryUsername(username);
        if (userModelCheck != null) {
            check = false;
        } else {
            UserModel userModel = new UserModel(username, password, email, birthday, sex, occupation, hobby);
            addUserService.addUser(userModel);
        }
        return "success";
    }

    public String queryUsername() {
        String username = ServletActionContext.getRequest().getParameter("username");
        UserModel userModel = queryService.queryUsername(username);
        if (userModel != null) {
            check = false;
        }
        return "success";
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public List<OccupationModel> getOccupatiolist() {
        return occupatiolist;
    }

    public void setOccupatiolist(List<OccupationModel> occupatiolist) {
        this.occupatiolist = occupatiolist;
    }

    public List<HobbyModel> getHobbyList() {
        return hobbyList;
    }

    public void setHobbyList(List<HobbyModel> hobbyList) {
        this.hobbyList = hobbyList;
    }
}
