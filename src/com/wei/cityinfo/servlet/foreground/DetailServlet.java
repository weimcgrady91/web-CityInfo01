package com.wei.cityinfo.servlet.foreground;

import com.wei.cityinfo.model.Info;
import com.wei.cityinfo.service.CityInfoService;
import com.wei.cityinfo.servlet.BasicsServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DetailServlet extends BasicsServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = 0;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("获取信息id错误!!");
            forwardError(req, resp);
            return;
        }

        CityInfoService service = new CityInfoService();
        Info info = service.obtainInfo(id);

        req.setAttribute("infoDetail", info);
        req.setAttribute("mainPage", "detail.jsp");
        req.getRequestDispatcher("/WEB-INF/foreground/index.jsp").forward(req, resp);
    }

    @Override
    public void forwardError(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("mainPage", "default.jsp");
        req.getRequestDispatcher("/WEB-INF/foreground/index.jsp").forward(req, resp);
    }

    @Override
    public void forwardSuccess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
