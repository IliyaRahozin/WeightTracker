package com.tracker.Service;

import com.tracker.Controller.Dto.SumDto;
import com.tracker.Model.Dao.FoodDao;
import com.tracker.Model.DaoFactory;
import com.tracker.Model.Entities.Food;
import com.tracker.Model.Entities.User;

import java.util.ArrayList;

public class FoodService {
    FoodDao foodDao = DaoFactory.createFoodDao();
    public ArrayList<Food> getAllFood(){
        return foodDao.findAll();
    }

    public void addFood(Food food){
        foodDao.add(food);
    }

    public void deleteFood(Integer id){
        foodDao.delete(id);
    }

    public SumDto getMaxSum(User user){
        return new SumDto( (int)(66.5/user.lifestyle() + 13.75*user.weight() + 5* user.height() - 6.7* user.age()),
                (int)(6.5/user.lifestyle() + 1.75*user.weight() + user.height() - 0.7* user.age()),
                (int)(0.5/user.lifestyle() + 3.75*user.weight() + 2* user.height() - 1.1* user.age()),
                (int)(16.5/user.lifestyle() + 2.75*user.weight() + 0.5* user.height() - 2* user.age()));
    }

    public Food getFoodById(Integer id){
        return foodDao.findById(id);
    }
}
