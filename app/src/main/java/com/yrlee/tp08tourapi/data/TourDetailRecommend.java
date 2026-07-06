package com.yrlee.tp08tourapi.data;

import java.util.List;

public class TourDetailRecommend{
    // 이거 안 쓸 수도 있음;


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
