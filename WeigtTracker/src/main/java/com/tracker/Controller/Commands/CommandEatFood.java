package com.tracker.Controller.Commands;

import com.tracker.Controller.Dto.SumDto;
import com.tracker.Model.Entities.Food;
import com.tracker.Service.FoodService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandEatFood implements ICommand{
    FoodService foodService = new FoodService();
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Food food = foodService.getFoodById(Integer.parseInt(request.getParameter("id")));
        SumDto current = (SumDto) session.getAttribute("current_sum");
        SumDto max = (SumDto) session.getAttribute("max_sum");
        Integer calories = current.calories()+food.calories();
        Integer proteins = current.proteins()+food.proteins();
        Integer fats = current.fats()+food.fats();
        Integer carbohydrates = current.carbohydrates()+food.carbohydrates();
        session.setAttribute("current_sum", new SumDto( calories, proteins, fats, carbohydrates));
        if(calories>=max.calories()||proteins>=max.proteins()||fats>= max.fats()||carbohydrates>= max.carbohydrates())
            request.setAttribute("limit", true);
        else request.setAttribute("limit", false);
        return ECommand.track.getCommand().execute(request);
    }
}
