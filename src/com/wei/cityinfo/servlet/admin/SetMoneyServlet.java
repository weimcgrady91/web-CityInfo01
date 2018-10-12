package com.wei.cityinfo.servlet.admin;

import com.wei.cityinfo.model.Info;
import com.wei.cityinfo.service.CityInfoService;
import com.wei.cityinfo.servlet.BasicsServlet;
import com.wei.cityinfo.util.TextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SetMoneyServlet extends BasicsServlet {
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
            forwardError(req, resp);
            return;
        }
        String action = req.getParameter("action");
        CityInfoService service = new CityInfoService();
        if(TextUtils.isEmpty(action)) {
            Info info = service.obtainInfo(id);
            req.setAttribute("info",info);
            req.setAttribute("mainPage","money_show.jsp");
            req.getRequestDispatcher("/WEB-INF/admin/index.jsp").forward(req,resp);
            return;
        }
        if(action.equals("setMoney")){
            Info info =service.obtainInfo(id);
            info.setPayfor("1");
            boolean result = service.updateInfo(info);
            if(result) {
                req.setAttribute("result","设置成功!");
            } else {
                req.setAttribute("result","设置失败!");
            }
            req.setAttribute("mainPage","money_show.jsp");
            req.getRequestDispatcher("/WEB-INF/admin/index.jsp").forward(req,resp);
        }




    }

    @Override
    public void forwardError(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("index");
    }

    @Override
    public void forwardSuccess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
