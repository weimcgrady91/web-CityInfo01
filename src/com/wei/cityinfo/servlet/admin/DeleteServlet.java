package com.wei.cityinfo.servlet.admin;

import com.wei.cityinfo.dao.CityInfoDao;
import com.wei.cityinfo.service.CityInfoService;
import com.wei.cityinfo.servlet.BasicsServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteServlet extends BasicsServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id=0;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        } catch (Exception e) {
            e.printStackTrace();
            forwardError(req,resp);
            return;
        }
        CityInfoService service = new CityInfoService();
        boolean result = service.deleteInfo(id);
        if(result) {
            req.setAttribute("result","删除成功!");
        } else {
            req.setAttribute("result","删除失败!");
        }
        req.setAttribute("mainPage","money_show.jsp");
        req.getRequestDispatcher("/WEB-INF/admin/index.jsp").forward(req,resp);
    }

    @Override
    public void forwardError(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("index");
    }

    @Override
    public void forwardSuccess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
