package com.tracker.Controller.Commands;

import com.tracker.Controller.ConfigPath;
import com.tracker.Controller.Dto.SumDto;
import com.tracker.Model.Entities.User;
import com.tracker.Service.FoodService;
import com.tracker.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandRegister implements ICommand{
    UserService userService = new UserService();
    FoodService foodService = new FoodService();
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String age = request.getParameter("age");
        String height = request.getParameter("height");
        String weight = request.getParameter("weight");
        String lifestyle = request.getParameter("lifestyle");
        HttpSession session = request.getSession();
        User user = new User(
                null,
                username,
                password,
                Integer.parseInt(age),
                Integer.parseInt(height),
                Integer.parseInt(weight),
                Integer.parseInt(lifestyle));
        if(userService.isUserUnique(username)){
            userService.createUser(user);
        }
        else {
            request.setAttribute("unique", false);
            return ConfigPath.register.getJspPath();
        }
        request.setAttribute("unique", true);
        session.setAttribute("registered", true);
        session.setAttribute("user", user);
        session.setAttribute("admin", false);
        session.setAttribute("current_sum", new SumDto(0,0,0,0));
        session.setAttribute("max_sum", foodService.getMaxSum(user));
        return ConfigPath.home.getJspPath();
    }
}
