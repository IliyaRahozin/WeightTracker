package com.tracker.Model;

import com.tracker.Model.Dao.FoodDao;
import com.tracker.Model.Dao.LifeStyleDao;
import com.tracker.Model.Dao.UserDao;
import com.tracker.Model.Dao.UserRoleDao;

public class DaoFactory {
    public static UserDao createUserDao(){
        return new UserDao();
    }
    public static LifeStyleDao createLifeStyleDao(){
        return new LifeStyleDao();
    }
    public static UserRoleDao createUserRoleDao(){
        return new UserRoleDao();
    }
    public static FoodDao createFoodDao(){
        return new FoodDao();
    }
}
