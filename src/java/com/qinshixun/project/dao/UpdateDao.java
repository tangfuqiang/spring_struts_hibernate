package com.qinshixun.project.dao;

import com.qinshixun.project.common.BaseDao;
import com.qinshixun.project.model.UserModel;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public class UpdateDao {
    @Autowired
    private BaseDao baseDao;

    @Transactional
    public void updateUser(long id,String username,String hobby,char sex,String email,String occupation,Date birthday){
        Session session = baseDao.getSessionFactory().getCurrentSession();
        UserModel userModel = (UserModel) session.get(UserModel.class,id);
        userModel.setUsername(username);
        userModel.setSex(sex);
        userModel.setOccupation(occupation);
        userModel.setHobby(hobby);
        userModel.setEmail(email);
        userModel.setBirthday(birthday);
        session.update(userModel);
    }
}
