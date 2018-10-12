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

public class SearchServlet extends BasicsServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchKey = req.getParameter("searchKey");
        String condition = req.getParameter("condition");
        String accurate = req.getParameter("accurate");
        if(TextUtils.isEmpty(searchKey) || TextUtils.isEmpty(condition) || TextUtils.isEmpty(accurate)){
            forwardError(req,resp);
            return;
        }
        int pageNum = 1;
        String pageNumStr = req.getParameter("pageNum");
        if(!TextUtils.isEmpty(pageNumStr)) {
            try {
                pageNum = Integer.parseInt(pageNumStr);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                forwardError(req,resp);
                return;
            }
        }


        int count = PageService.obtainRecordCount(searchKey, condition,"0",Boolean.valueOf(accurate));
        if (pageNum <= 1) {
            pageNum = 1;
        } else if (pageNum >= count) {
            pageNum = count;
        }
        CityInfoService service = new CityInfoService();
        List<Info> infoList = service.search(searchKey,condition,Boolean.valueOf(accurate));

        String path = req.getContextPath();
        String url = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + path
                + "/search?searchKey=" + searchKey + "&condition="+condition +"&accurate=" +accurate+"&pageNum=";
        int maxNum = PageIndicatorCreate.obtainMaxNum(count);
        String pageIndicator = PageIndicatorCreate.createIndicator(url,pageNum,maxNum) + "共"+count+"条记录";



        req.setAttribute("infoList", infoList);
        req.setAttribute("mainPage", "list.jsp");
        req.setAttribute("pageIndicator", pageIndicator);
        req.getRequestDispatcher("/WEB-INF/foreground/index.jsp").forward(req, resp);
    }

    @Override
    public void forwardError(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("index");
    }

    @Override
    public void forwardSuccess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
