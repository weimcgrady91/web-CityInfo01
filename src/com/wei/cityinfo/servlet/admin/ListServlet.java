package com.wei.cityinfo.servlet.admin;

import com.wei.cityinfo.model.Info;
import com.wei.cityinfo.service.CityInfoService;
import com.wei.cityinfo.service.PageService;
import com.wei.cityinfo.servlet.BasicsServlet;
import com.wei.cityinfo.util.PageIndicatorCreate;
import com.wei.cityinfo.util.TextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListServlet extends BasicsServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String charge = req.getParameter("charge");
        String state = req.getParameter("state");
        if (TextUtils.isEmpty(charge)) {
            req.setAttribute("checkMsg","请选择付费状态!");
            forwardError(req,resp);
            return;
        }
        if(TextUtils.isEmpty(state)){
            req.setAttribute("checkMsg","请选择审核状态!");
            forwardError(req,resp);
            return;
        }

        int typeSign = 0;
        try {
            typeSign = Integer.parseInt(req.getParameter("typeSign"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            req.setAttribute("checkMsg","查找信息错误!");
            forwardError(req, resp);
            return;
        }

        int pageNum = 0;
        String pageNumStr = req.getParameter("pageNum");
        if (TextUtils.isEmpty(pageNumStr)) {
            pageNum = 1;
        } else {
            try {
                pageNum = Integer.parseInt(pageNumStr);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                req.setAttribute("checkMsg","查找信息错误!");
                forwardError(req, resp);
                return;
            }
        }

        CityInfoService service = new CityInfoService();
        int count = PageService.obtainRecordCount(typeSign, state, charge);
        if (pageNum <= 1) {
            pageNum = 1;
        } else if (pageNum >= count) {
            pageNum = count;
        }

        List<Info> infoList = service.obtionCheckInfoList(typeSign,state,charge,pageNum);
        String path = req.getContextPath();
        String url = req.getScheme() + "://" + req.getServerName() + ":"
                + req.getServerPort() + path + "/admin/list?typeSign=" + typeSign + "&state="+state+"&charge="+charge+"&pageNum=";
        int maxNum = PageIndicatorCreate.obtainMaxNum(count);
        String pageIndicator = PageIndicatorCreate.createIndicator(url, pageNum, maxNum) + "共" + count + "条记录";
        req.setAttribute("infoList", infoList);
        req.setAttribute("pageIndicator", pageIndicator);
        req.setAttribute("mainPage","list.jsp");
        req.getRequestDispatcher("/WEB-INF/admin/index.jsp").forward(req,resp);
    }

    @Override
    public void forwardError(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("mainPage","list.jsp");
        req.getRequestDispatcher("/WEB-INF/admin/index.jsp").forward(req,resp);
    }

    @Override
    public void forwardSuccess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
