package com.wei.cityinfo.servlet.foreground;

import com.wei.cityinfo.model.Condition;
import com.wei.cityinfo.model.Info;
import com.wei.cityinfo.model.Type;
import com.wei.cityinfo.service.CityInfoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class IndexServlet extends HttpServlet {
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

        List<Condition> conditionList = service.obtainSearchConditions();
        session.setAttribute("searchConditions",conditionList);

        List<Map<Type, List<Info>>> hotCharge = service.obtainHotCharge();
        session.setAttribute("hotCharge",hotCharge);

        List<Map<Type, List<Info>>>hotNormal= service.obtainHotNormal();
        session.setAttribute("hotNormal",hotNormal);

        req.getRequestDispatcher("/WEB-INF/foreground/index.jsp").forward(req,resp);
    }
}
