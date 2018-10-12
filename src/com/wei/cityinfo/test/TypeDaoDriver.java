package com.wei.cityinfo.test;

import com.wei.cityinfo.dao.TypeDao;
import com.wei.cityinfo.model.Type;

import java.util.List;

public class TypeDaoDriver {
    public static void main(String[] args) {
        add();
//        queryAll();
    }

    public static void queryAll() {
        TypeDao typeDao = new TypeDao();
        List<Type> typeList = typeDao.findAll();
        for (Type type : typeList) {
            System.out.println(type);
        }
    }

    public static void add() {
        String[] names = new String[]{
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
        String[] types = new String[]{
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
        for (int i = 0; i < names.length; i++) {
            Type type = new Type();
            type.setTypeName(names[i]);
            type.setTypeIntro(types[i]);
            TypeDao typeDao = new TypeDao();
            boolean result = typeDao.add(type);
            System.out.println(type.toString() + " result=" + result);

        }
    }
}
