package com.wei.cityinfo.servlet.admin;

import com.wei.cityinfo.model.Type;
import com.wei.cityinfo.model.User;
import com.wei.cityinfo.service.CityInfoService;
import com.wei.cityinfo.service.UserService;
import com.wei.cityinfo.servlet.BasicsServlet;
import com.wei.cityinfo.util.TextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class LoginServlet extends BasicsServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            forwardError(req,resp);
        }
        UserService service = new UserService();
        User user = new User(username,password);
        CityInfoService cityInfoService = new CityInfoService();
        List<Type> typeList = cityInfoService.obtainTypes();
        boolean result = service.login(user);
        if(result) {
            HttpSession session = req.getSession(true);
            session.setAttribute("admin",user);
            session.setAttribute("typeList",typeList);
            forwardSuccess(req,resp);
        } else {
            forwardError(req,resp);
        }
    }

    @Override
    public void forwardError(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/admin/login.jsp").forward(req,resp);
    }

    @Override
    public void forwardSuccess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("index");
    }
}
