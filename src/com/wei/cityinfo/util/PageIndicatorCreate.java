package com.wei.cityinfo.util;

import com.wei.cityinfo.service.PageService;

public class PageIndicatorCreate {
    private static int STEP = 2;

    public static String createIndicator(String url,int pageNum, int maxNum) {
        StringBuilder sb = new StringBuilder();
        if (pageNum == 1) {
                if(pageNum>maxNum){
                    return "";
                }
//            System.out.print("<1>");
            sb.append("<a href='"+url+"1'><font color='red'>1</font></a>");
            int last = pageNum + STEP;
            if (last < maxNum) {
                for (int i = 1; i <= STEP; i++) {
                    sb.append("<a href='"+url+(pageNum + i)+"'>"+(pageNum + i)+"</a>");
//                    System.out.print("<" + (pageNum + i) + ">");
                }
                sb.append("<a href='"+url+(pageNum + 1)+"'>下一页</a>");
                sb.append("<a href='"+url+maxNum+"'>尾页</a>");
//                System.out.print("<下一页><尾页>");
            } else
                for (int i = 1; i <= maxNum - pageNum; i++) {
//                    System.out.print("<" + (pageNum + i) + ">");
                    sb.append("<a href='"+url+(pageNum + i)+"'>"+(pageNum + i)+"</a>");
                }
        } else {
            sb.append("<a href='"+url+"1'>首页</a>");
            sb.append("<a href='"+url+(pageNum - 1)+"'>上一页</a>");
            sb.append("<a href='"+url+pageNum +"'><font color='red'>"+pageNum+"</font></a>");
//            System.out.print("<首页><上一页>");
//            System.out.print("<" + pageNum + ">");
            int last = pageNum + STEP;
            if (last < maxNum) {
                for (int i = 1; i <= STEP; i++) {
//                    System.out.print("<" + (pageNum + i) + ">");
                    sb.append("<a href='"+url+(pageNum + i)+"'>"+(pageNum + i)+"</a>");
                }
//                System.out.print("<下一页><尾页>");
                sb.append("<a href='"+url+(pageNum + 1)+"'>下一页</a>");
                sb.append("<a href='"+url+maxNum+"'>尾页</a>");
            } else {
                for (int i = 1; i <= maxNum - pageNum; i++) {
                    System.out.print("<" + (pageNum + i) + ">");
                    sb.append("<a href='"+url+(pageNum + i)+"'>"+(pageNum + i)+"</a>");
                }
            }
        }
        return sb.toString();
    }

    public static int obtainMaxNum(int count) {
        if(count%PageService.PAGE_SIZE==0) {
            return count/PageService.PAGE_SIZE;
        } else {
            return count/PageService.PAGE_SIZE + 1;
        }
    }

}
