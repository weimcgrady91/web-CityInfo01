package com.wei.cityinfo.service;

import com.wei.cityinfo.dao.CityInfoDao;
import com.wei.cityinfo.dao.TypeDao;
import com.wei.cityinfo.model.Condition;
import com.wei.cityinfo.model.Info;
import com.wei.cityinfo.model.Type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CityInfoService {
    private TypeDao typeDao = new TypeDao();
    private CityInfoDao cityInfoDao = new CityInfoDao();

    public CityInfoService() {

    }


    public List<Info> obtainNormalInfoList(int sign, int pageNum) {
        return cityInfoDao.findInfoByType(sign, "1","0", (pageNum - 1) * PageService.PAGE_SIZE, PageService.PAGE_SIZE);
    }

    public List<Info> obtionCheckInfoList(int sign,String state,String charge,int pageNum) {
        return cityInfoDao.findInfoByType(sign, state,charge, (pageNum - 1) * PageService.PAGE_SIZE, PageService.PAGE_SIZE);
    }

    /**
     * 获取最新收费信息，每个类型获取1条
     *
     * @return
     */
    public List<Map<Type, List<Info>>> obtainHotCharge() {
        List<Map<Type, List<Info>>> list = new ArrayList<>();
        List<Type> types = typeDao.findAll();
        for (Type type : types) {
            int typeSign = type.getTypeSign();
            List<Info> item = cityInfoDao.findInfoByType(typeSign, "1","1", 0, 1);
            Map<Type, List<Info>> map = new HashMap<>();
            map.put(type, item);
            list.add(map);
        }
        return list;
    }

    public List<Map<Type, List<Info>>> obtainHotNormal() {
        List<Map<Type, List<Info>>> list = new ArrayList<>();
        List<Type> types = typeDao.findAll();
        for (Type type : types) {
            int typeSign = type.getTypeSign();
            List<Info> item = cityInfoDao.findInfoByType(typeSign,"1", "0", 0, 5);
            Map<Type, List<Info>> map = new HashMap<>();
            map.put(type, item);
            list.add(map);
        }
        return list;
    }

    public List<Type> obtainTypes() {
        return typeDao.findAll();
    }

    public List<Condition> obtainSearchConditions() {
        List<Condition> conditions = new ArrayList<>();
        conditions.add(new Condition("info_title", "标题"));
        conditions.add(new Condition("info_content", "内容"));
        conditions.add(new Condition("info_linkman", "联系人"));
        conditions.add(new Condition("info_phone", "电话"));
        conditions.add(new Condition("info_email", "Email"));
        return conditions;
    }

    public Info obtainInfo(int id) {
        return cityInfoDao.find(id);
    }


    public boolean addInfo(Info info) {
        return cityInfoDao.add(info);
    }

    public List<Info> search(String searchKey, String condition, boolean accurate) {
        return cityInfoDao.findInfo(condition,searchKey,"0",accurate);
    }

    public boolean updateInfo(Info info) {
        return cityInfoDao.update(info);
    }

    public boolean deleteInfo(int id) {
        Info info = cityInfoDao.find(id);
        if(info!=null) {
            return cityInfoDao.delete(info);
        }
        return false;
    }
}
