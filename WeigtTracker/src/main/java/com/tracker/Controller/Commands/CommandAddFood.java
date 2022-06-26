package com.tracker.Controller.Commands;

import com.tracker.Model.Entities.Food;
import com.tracker.Service.FoodService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandAddFood implements ICommand{
    FoodService foodService = new FoodService();
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("registered") == null)
            return ECommand.home.getCommand().execute(request);
        Boolean registered = (Boolean) session.getAttribute("registered");
        if(registered) {
            foodService.addFood(new Food(
                    null,
                    request.getParameter("name"),
                    Integer.parseInt(request.getParameter("calories")),
                    Integer.parseInt(request.getParameter("proteins")),
                    Integer.parseInt(request.getParameter("fats")),
                    Integer.parseInt(request.getParameter("carbohydrates"))));
            return ECommand.foodList.getCommand().execute(request);
        }
        return ECommand.home.getCommand().execute(request);
    }
}
