package com.tracker;

import com.tracker.Model.Dao.FoodDao;
import com.tracker.Model.Dao.LifeStyleDao;
import com.tracker.Model.Dao.UserDao;
import com.tracker.Model.Dao.UserRoleDao;
import com.tracker.Model.DaoFactory;
import com.tracker.Model.Entities.Food;
import com.tracker.Model.Entities.LifeStyle;
import com.tracker.Model.Entities.User;
import com.tracker.Model.Entities.UserRole;
import com.tracker.Service.UserService;

public class Entry {
    public static void main(String[] args) {
        UserDao userDao = DaoFactory.createUserDao();
//        userDao.add(new User(null, "123","12342",24,24,424,1));
        LifeStyleDao lifeStyleDao = DaoFactory.createLifeStyleDao();
//        lifeStyleDao.add(new LifeStyle(null, "active"));
//        lifeStyleDao.add(new LifeStyle(null, "passive"));
        UserService userService = new UserService();
//        userService.createUser(new User(null, "1234","1234",null,null,null,null));
        FoodDao foodDao = DaoFactory.createFoodDao();
        foodDao.add(new Food(null, "123",2,2,3,4));
    }
}
