package com.wei.cityinfo.servlet.foreground;

import com.wei.cityinfo.model.Info;
import com.wei.cityinfo.service.CityInfoService;
import com.wei.cityinfo.servlet.BasicsServlet;
import com.wei.cityinfo.util.TextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class AddServlet extends BasicsServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CityInfoService service = new CityInfoService();

        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String phone = req.getParameter("phone");
        String linkman = req.getParameter("linkman");
        String email = req.getParameter("email");
        if (TextUtils.isEmpty(title)
                || TextUtils.isEmpty(content)
                || TextUtils.isEmpty(phone)
                || TextUtils.isEmpty(linkman)
                || TextUtils.isEmpty(email)) {
            forwardError(req, resp);
            return;
        }

        int typeSign = 0;
        try {
            typeSign = Integer.parseInt(req.getParameter("typeSign"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            forwardError(req, resp);
            return;
        }

        Info info = new Info(typeSign, title, content, linkman, phone, email, new Date(), "0", "0");
        boolean result = service.addInfo(info);
        if (result) {
            req.setAttribute("mainPage", "default.jsp");
//            req.getRequestDispatcher("/index_temp.jsp").forward(req, resp);
            resp.sendRedirect("index");
        } else {
//            req.setAttribute("typeList", types);
            forwardError(req,resp);
        }

    }

    @Override
    public void forwardSuccess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void forwardError(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("mainPage", "add.jsp");
        req.getRequestDispatcher("/WEB-INF/foreground/index.jsp").forward(req, resp);
    }
}
