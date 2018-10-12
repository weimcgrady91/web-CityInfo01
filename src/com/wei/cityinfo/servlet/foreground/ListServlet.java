package com.wei.cityinfo.servlet.foreground;

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
        int typeSign = 0;
        try {
            typeSign = Integer.parseInt(req.getParameter("typeSign"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
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
                forwardError(req, resp);
                return;
            }
        }

        normalList(typeSign, pageNum, req, resp);
        req.setAttribute("mainPage", "list.jsp");
        req.getRequestDispatcher("/WEB-INF/foreground/index.jsp").forward(req, resp);

    }

    public void normalList(int type, int pageNum, HttpServletRequest req, HttpServletResponse resp) {
        int count = PageService.obtainRecordCount(type, "1", "0");
        if (pageNum <= 1) {
            pageNum = 1;
        } else if (pageNum >= count) {
            pageNum = count;
        }
        CityInfoService service = new CityInfoService();
        List<Info> infoList = service.obtainNormalInfoList(type, pageNum);
        String path = req.getContextPath();
        String url = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + path + "/infoList?typeSign=" + type + "&pageNum=";
        int maxNum = PageIndicatorCreate.obtainMaxNum(count);
        String pageIndicator = PageIndicatorCreate.createIndicator(url, pageNum, maxNum) + "共" + count + "条记录";
        req.setAttribute("infoList", infoList);
        req.setAttribute("infoType", service.obtainTypes().get(type - 1));
        req.setAttribute("pageIndicator", pageIndicator);
    }

    @Override
    public void forwardError(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("index");
    }

    @Override
    public void forwardSuccess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
