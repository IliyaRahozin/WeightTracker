package com.tracker.Controller.Commands;

import com.tracker.Controller.ConfigPath;
import com.tracker.Service.LifeStyleService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class Register implements ICommand{
    LifeStyleService lifeStyleService = new LifeStyleService();
    @Override
    public String execute(HttpServletRequest request) throws ServletException, IOException {
        request.setAttribute("lifestyles", lifeStyleService.getLifeStyles());
        return ConfigPath.register.getJspPath();
    }
}
