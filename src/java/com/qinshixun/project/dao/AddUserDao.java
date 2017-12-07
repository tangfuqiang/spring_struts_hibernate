package com.qinshixun.project.dao;

import com.qinshixun.project.common.BaseDao;
import com.qinshixun.project.model.HobbyModel;
import com.qinshixun.project.model.OccupationModel;
import com.qinshixun.project.model.UserModel;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AddUserDao {
    @Autowired
    private BaseDao baseDao;

    @Transactional
    public List<HobbyModel> getHobby() {
        String sql = "from HobbyModel";
        Query query = baseDao.getSessionFactory().getCurrentSession().createQuery(sql);
        List<HobbyModel> hobbyList = query.list();
        return hobbyList;
    }

    @Transactional
    public List<OccupationModel> getOccupation() {
        String sql = "from OccupationModel";
        Query query = baseDao.getSessionFactory().getCurrentSession().createQuery(sql);
        List<OccupationModel> occupatiolist = query.list();
        return occupatiolist;
    }

    //    @Transactional
//    public int addUser(String username, String password, String email, Date birthday,char sex,String occupation,String hobby){
//        return 0;
//    }
    @Transactional
    public void addUser(UserModel userModel) {

        baseDao.getSessionFactory().getCurrentSession().save(userModel);
    }
}
