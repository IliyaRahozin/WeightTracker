package com.tracker.Controller.Commands;

import com.tracker.Controller.ConfigPath;
import com.tracker.Service.FoodService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandFoodList implements ICommand{
    FoodService foodService = new FoodService();
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Boolean registered = (Boolean) session.getAttribute("registered");
        if(registered == null){
            return ConfigPath.home.getJspPath();
        }
        if(registered){
            request.setAttribute("food", foodService.getAllFood());
            return ConfigPath.food.getJspPath();
        }
        return ConfigPath.home.getJspPath();
    }
}
