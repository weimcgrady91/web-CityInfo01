package com.wei.cityinfo.service;

import com.wei.cityinfo.dao.CityInfoDao;

public class PageService {
    public static int PAGE_SIZE = 3;

    public static int obtainRecordCount(int sign, String state,String charge) {
        CityInfoDao cityInfoDao = new CityInfoDao();
        return cityInfoDao.findCount(sign,state, charge);
    }

    public static int obtainRecordCount(String searchKey, String condition, String state,boolean accurate) {
        CityInfoDao dao = new CityInfoDao();
        return dao.findSearchCount(searchKey,condition,state,accurate);
    }
}
