package com.wei.cityinfo.test;

import com.wei.cityinfo.model.Info;
import com.wei.cityinfo.model.Type;
import com.wei.cityinfo.service.CityInfoService;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CityInfoServiceDriver {
    public static void main(String[] args) {
        testChargeHotInfo();
//        testHotNormal();
    }

    public static void testChargeHotInfo(){
        CityInfoService cityInfoService = new CityInfoService();
//        Map<Type, List<Info>> map =  cityInfoService.obtainHotCharge();
//        Iterator<Map.Entry<Type, List<Info>>> entries = map.entrySet().iterator();
//        while (entries.hasNext()) {
//            Map.Entry<Type, List<Info>> entry = entries.next();
//            System.out.println("Key = " + entry.getKey().getTypeSign() + ", Value = " + entry.getValue().get(0).toString());
//        }
    }
    public static void testHotNormal(){
        CityInfoService cityInfoService = new CityInfoService();
//        Map<Type, List<Info>> map =  cityInfoService.obtainHotNormal();
//        Iterator<Map.Entry<Type, List<Info>>> entries = map.entrySet().iterator();
//        while (entries.hasNext()) {
//            Map.Entry<Type, List<Info>> entry = entries.next();
//            System.out.println("Key = " + entry.getKey().getTypeSign() + ", Value = " + entry.getValue());
//        }
    }
}
