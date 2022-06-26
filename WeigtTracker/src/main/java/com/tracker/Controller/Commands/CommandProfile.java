package com.tracker.Controller.Commands;

import com.tracker.Controller.ConfigPath;
import com.tracker.Model.Entities.User;
import com.tracker.Service.LifeStyleService;
import com.tracker.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandProfile implements ICommand{
    UserService userService = new UserService();
    LifeStyleService lifeStyleService = new LifeStyleService();
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("registered") == null)
            return ConfigPath.home.getJspPath();
        Boolean registered = (Boolean) session.getAttribute("registered");
        if(registered){
            System.out.println(((User)session.getAttribute("user")));
            request.setAttribute("lifestyle", lifeStyleService.getTypeById(((User)session.getAttribute("user")).lifestyle()));
            request.setAttribute("lifestyles", lifeStyleService.getLifeStyles());
            return ConfigPath.profile.getJspPath();
        }
        return ConfigPath.home.getJspPath();
    }
}
