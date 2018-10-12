package com.wei.cityinfo.servlet.admin;

import com.wei.cityinfo.model.Type;
import com.wei.cityinfo.service.CityInfoService;
import com.wei.cityinfo.servlet.BasicsServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class IndexServlet extends BasicsServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CityInfoService service = new CityInfoService();
        List<Type> typeList = service.obtainTypes();
        HttpSession session = req.getSession(true);
        session.setAttribute("typeList",typeList);
        forwardSuccess(req,resp);
    }

    @Override
    public void forwardError(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void forwardSuccess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/admin/index.jsp").forward(req,resp);
    }
}
