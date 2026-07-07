package com.yrlee.tp08tourapi.util;

public class DateUtil {

    // 날짜 변환 함수
    public static String formatDate(String date) {
        if (date == null || date.length() != 8) {
            return date;
        }
        return date.substring(0, 4) + "."
                + date.substring(4, 6) + "."
                + date.substring(6, 8);
    }

    // 행사기간 문자열 포멧 함수
    public static String getEventDate(String startDate, String endDate){
        if(endDate == null || endDate.isEmpty() || startDate.equals(endDate)){
            return formatDate(startDate);
        }else {
            return formatDate(startDate) + " ~ " + formatDate(endDate);
        }
    }
}
