package com.qinshixun.project.action;

import com.qinshixun.project.common.BaseDao;
import com.qinshixun.project.model.UserModel;
import com.qinshixun.project.service.QueryService;
import com.qinshixun.project.service.UpdateService;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateAction {
    @Autowired
    private BaseDao baseDao;

    @Autowired
    private UpdateService updateService;

    @Autowired
    private QueryService queryService;

    private boolean check;

    public String updateUser() throws ParseException {
        HttpServletRequest request = ServletActionContext.getRequest();
        Long id = Long.valueOf(request.getParameter("id"));
        char sex = request.getParameter("sex").charAt(0);
        String hobby = request.getParameter("hobby");
        String occupation = request.getParameter("occupation");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        Boolean usernamecheck = Boolean.valueOf(request.getParameter("usernamecheck"));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = simpleDateFormat.parse(request.getParameter("birthday"));

        if (usernamecheck) {
            if (queryService.queryUsername(username) != null) {
                check = false;
            } else {

                check = true;
                updateService.updateUser(id, username, hobby, sex, email, occupation, birthday);
            }
        }else {
            check=true;
            updateService.updateUser(id, username, hobby, sex, email, occupation, birthday);

        }

        return "success";
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
