package com.tracker.Controller.Commands;

import com.tracker.Controller.ConfigPath;
import com.tracker.Service.FoodService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandDeleteFood implements ICommand{
    FoodService foodService = new FoodService();
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("registered") == null)
            return ConfigPath.home.getJspPath();
        Boolean registered = (Boolean) session.getAttribute("registered");
        if(registered) {
            foodService.deleteFood(Integer.parseInt(request.getParameter("id")));
            return ECommand.foodList.getCommand().execute(request);
        }
        return ConfigPath.home.getJspPath();
    }
}
