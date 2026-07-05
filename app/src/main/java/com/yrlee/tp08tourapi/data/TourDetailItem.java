package com.yrlee.tp08tourapi.data;

import java.util.List;

public class TourDetailItem {

    public String contentId;
    public String contentTypeId = "";

    // 공통정보조회
    public String title;
    public String homePage="";
    public String firstImage="";
    public String firstImage2="";
    public String addr1="";
    public String addr2="";
    public String mapx="";
    public String mapy="";
    public String overview="";

    public IntroData introData;
    public FestivalData fesData;
    public RecommendData recommendData;

    public TourDetailItem(String id){
        this.contentId = id;
    }

    // 소개정보 조회
    public static class IntroData{
        public String useFee; // 이용요금
        public String useTime; // 이용시간
        public String parking;  // 주차시설
        public String parkingFee; // 주차요금
        public String infoCenter; // 문의 및 안내
        public String restDate; // 쉬는날

    }

    // 소개정보 조회 - 축제
    public static class FestivalData{
        public String sponsor1; // 주최자 정보
        public String sponsor1tel; // 주최자 연락처
        public String eventStartDate; // 행사 시작일
        public String eventEndDate; // 행사 종료일
        public String eventPlace; // 행사 장소
        public String playTime; // 행사 시간
        public String useTimeFestival; // 이용 요금
    }

    public static class RecommendData{
        public String takeTime; // 코스 총 소요시간
        public List<SubData> recommendList;

        // 여행코스 내의 서브 장소 데이터
        public class SubData{
            public String subContentId;
            public String subName;
            public String subDetailOverview;
            public String subDetailImage;

        }
    }



}
