package com.tracker.Controller.Commands;

import com.tracker.Controller.ConfigPath;
import com.tracker.Model.Entities.User;
import com.tracker.Service.FoodService;
import com.tracker.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandUpdateUser implements ICommand{
    UserService userService = new UserService();
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("registered") == null)
            return ConfigPath.home.getJspPath();
        Boolean registered = (Boolean) session.getAttribute("registered");
        if(registered) {
            User user = (User) session.getAttribute("user");
            if(user == null) return ECommand.commandProfile.getCommand().execute(request);
            User updatedUser = new User(
                    user.id(),
                    (String) request.getParameter("username"),
                    user.password(),
                    Integer.parseInt(request.getParameter("age")),
                    Integer.parseInt(request.getParameter("height")),
                    Integer.parseInt(request.getParameter("weight")),
                    Integer.parseInt(request.getParameter("lifestyle")));
            userService.updateUser(updatedUser);
            session.setAttribute("user", updatedUser);
            return ECommand.commandProfile.getCommand().execute(request);
        }
        return ConfigPath.home.getJspPath();
    }
}
