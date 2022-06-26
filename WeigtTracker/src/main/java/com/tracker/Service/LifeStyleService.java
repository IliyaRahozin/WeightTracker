package com.tracker.Service;

import com.tracker.Model.Dao.LifeStyleDao;
import com.tracker.Model.Dao.UserDao;
import com.tracker.Model.DaoFactory;
import com.tracker.Model.Entities.LifeStyle;
import com.tracker.Model.Entities.User;

import java.util.ArrayList;

public class LifeStyleService {
    final private LifeStyleDao lifeStyleDao = DaoFactory.createLifeStyleDao();
    final private UserDao userDao = DaoFactory.createUserDao();
    public ArrayList<LifeStyle> getLifeStyles(){
        return lifeStyleDao.findAll();
    }
    public String getTypeById(Integer id){
        return lifeStyleDao.findById(id).type();
    }

    public ArrayList<String> getUsersLifeStyles(){
        ArrayList<String> result = new ArrayList<>();
        for(User user: userDao.findAll()){
            result.add(lifeStyleDao.findById(user.id()).type());
        }
        return result;
    }
}
