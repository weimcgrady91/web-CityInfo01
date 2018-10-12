package com.wei.cityinfo.test;

import java.util.Calendar;

public class CustomCalendar {
    public static void main(String[] args) {
        showCalendar();
    }

    public static void showCalendar() {
        //定义6*7个单元格
        String[] cells = new String[6 * 7];
        for (int i = 0; i < cells.length; i++) {
            cells[i] = "";
        }

        //设置目标月的第一天，设置firstDayOfWeek 每周重第几天开始
        Calendar thisMonth = Calendar.getInstance();
        thisMonth.setFirstDayOfWeek(Calendar.SUNDAY);
        thisMonth.set(Calendar.DAY_OF_MONTH, 1);

        //获取1号是一周的第几天 减一是需要和单元格索引对齐(DAY_OF_WEEK 取值从1开始，单元格索引从0开始)
        //偏移量
        int firstIndex = thisMonth.get(Calendar.DAY_OF_WEEK) - 1;
        //获取当月最大天数
        int maxIndex = thisMonth.getActualMaximum(Calendar.DAY_OF_MONTH);

        //填充单元格
        for (int i = 0; i < maxIndex; i++) {
            //单元格加上偏移量
            cells[firstIndex + i] = String.valueOf(i + 1);
        }
        String[] titles = {"日", "一", "二", "三", "四", "五", "六"};
        for (int i = 0; i < titles.length; i++) {
            System.out.print("" + titles[i] + " ");
        }
        System.out.println();
        //输出单元格
        for (int i = 0; i < 6; i++) {
            for (int j = i * 7; j < (i + 1) * 7; j++) {
                //标记特定天 (单元格减去偏移量+1 = 目标日期) 对齐索引方便计算
                if((j-firstIndex+1)==22){
                    System.out.print("<red>"+cells[j]+"<red>");
                } else {
                    System.out.print(cells[j]+" ");
                }
            }
            System.out.println();
        }

    }
}
