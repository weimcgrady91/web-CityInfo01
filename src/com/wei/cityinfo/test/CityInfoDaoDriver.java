package com.wei.cityinfo.test;

import com.wei.cityinfo.dao.CityInfoDao;
import com.wei.cityinfo.model.Info;

import java.util.Date;
import java.util.List;

public class CityInfoDaoDriver {
    static String[] names = new String[]{
            "recruit",
            "training",
            "house",
            "buy",
            "invite",
            "apartment",
            "apply",
            "tutor",
            "car",
            "sale",
            "search"
    };
    static String[] types = new String[]{
            "招聘信息",
            "培训信息",
            "房屋信息",
            "求购信息",
            "招商引资",
            "公寓信息",
            "求职信息",
            "家教信息",
            "车辆信息",
            "出售信息",
            "寻找启示",
    };


    public static void add() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 2; j++) {
                Info info = new Info();
                info.setType(i + 1);
                info.setTitle("付费"+types[i] + j);
                info.setContent("付费"+types[i] + j);
                info.setLinkman("魏XXX");
                info.setPhone("18710087516");
                info.setEmail("weiqunhz0516@gmail.com");
                info.setDate(new Date());
                info.setState("1");
                info.setPayfor("1");
                CityInfoDao cityInfoDao = new CityInfoDao();
                boolean result = cityInfoDao.add(info);
                System.out.println("添加:" + info.toString() + " [result= " + result + "]");
            }

        }
    }

    public static void testHotChargeTop() {
        CityInfoDao dao = new CityInfoDao();
        List<Info> infos = dao.findInfoByType(3, "1","1", 0, 1);
        for (Info info : infos) {
            System.out.println(info.toString());
        }
    }

    public static void testHotNormalTop() {
        CityInfoDao dao = new CityInfoDao();
        List<Info> infos = dao.findInfoByType(3,"1", "0", 0, 5);
        for (Info info : infos) {
            System.out.println(info.toString());
        }
    }

    public static void obtainById() {
        CityInfoDao dao = new CityInfoDao();
        Info info = dao.find(1133);
        System.out.println(info.toString());
    }

    public static void search() {
        CityInfoDao dao = new CityInfoDao();
        List<Info> infos = dao.findInfo("info_title","付费","1",false);
        for(Info info:infos) {
            System.out.println(info);
        }
    }
    public static void search2() {
        CityInfoDao dao = new CityInfoDao();
        List<Info> infos = dao.findInfo("info_title","付费出售信息0","1",true);
        for(Info info:infos) {
            System.out.println(info);
        }
    }

    public static void shenhe() {
        CityInfoDao dao = new CityInfoDao();
        List<Info> infos = dao.findInfo("0","1",3);
        for(Info info:infos) {
            System.out.println(info);
        }
    }
    public static void main(String[] args) {
        add();
//        testHotChargeTop();
//        testHotNormalTop();
//        obtainById();
//        search();
//        search2();
//        shenhe();
    }
}
