package com.wei.cityinfo.test;

import com.wei.cityinfo.util.PageIndicatorCreate;

public class PageUtilsDriver {
    public static void main(String[] args) {
        String url = "http://localhost:8080/CityInfo/IndexServlet?pageNum=";
        String a1 = PageIndicatorCreate.createIndicator(url,3,15);
        System.out.println(a1);
    }
}
