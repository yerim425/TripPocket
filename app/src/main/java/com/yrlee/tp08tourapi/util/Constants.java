package com.yrlee.tp08tourapi.util;

import static java.util.Map.entry;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Constants {

    public static final Map<String, String> CONTENT_TYPE_MAP;
    public static final Map<String, String> CATEGORY1_MAP;
    public static final Map<String, Map<String, String>> CATEGORY2_MAP;
    public static final Map<String, Map<String, String>> CATEGORY3_MAP;
    public static final Map<String, String> SIDO_MAP;
    public static final Map<String, Map<String, String>> SIGUNGU_MAP;


    static {

//        CONTENT_TYPE_MAP = Map.of(
//                "관광지", "12",
//                "문화시설", "14",
//                "축제공연행사", "15",
//                "여행코스", "25",
//                "레포츠", "28");
//
        Map<String, String> typeMap = new LinkedHashMap<>();
        typeMap.put("관광지", "12");
        typeMap.put("문화시설", "14");
        typeMap.put("축제공연행사", "15");
        typeMap.put("레포츠", "28");
        typeMap.put("여행코스", "25");
        CONTENT_TYPE_MAP = Collections.unmodifiableMap(typeMap);


        // 카테고리
        CATEGORY1_MAP = Map.of(
                "AC", "숙박",
                "FD", "음식",
                "SH", "쇼핑",
                "C01", "추천코스",
                "EV", "축제/공연/행사",
                "EX", "체험관광",
                "HS", "역사관광",
                "LS", "레저스포츠",
                "NA", "자연",
                "VE", "문화관광"
        );
        CATEGORY2_MAP = Map.ofEntries(
                entry("C01", Map.ofEntries(
                        entry("C0112", "가족코스"),
                        entry("C0113", "나홀로코스"),
                        entry("C0114", "힐링코스"),
                        entry("C0115", "도보코스"),
                        entry("C0116", "캠핑코스"),
                        entry("C0117", "맛코스")
                )),
                entry("EV", Map.ofEntries(
                        entry("EV01", "축제"),
                        entry("EV02", "공연"),
                        entry("EV03", "행사")
                )), entry("EX", Map.ofEntries(
                        entry("EX01", "전통체험"),
                        entry("EX02", "공예체험"),
                        entry("EX03", "농.산.어촌 체험"),
                        entry("EX04", "산사체험"),
                        entry("EX05", "웰니스관광"),
                        entry("EX06", "산업관광"),
                        entry("EX07", "기타체험")
                )), entry("HS", Map.ofEntries(
                        entry("HS01", "역사유적지"),
                        entry("HS02", "역사유물"),
                        entry("HS03", "종교성지"),
                        entry("HS04", "안보관광지")
                ))
                , entry("LS", Map.ofEntries(
                        entry("LS01", "육상레저스포츠"),
                        entry("LS02", "수상레저스포츠"),
                        entry("LS03", "항공레저스포츠"),
                        entry("LS04", "복합레저스포츠")

                )), entry("NA", Map.ofEntries(
                        entry("NA01", "자연경관(산)"),
                        entry("NA02", "자연경관(하천‧해양)"),
                        entry("NA03", "자연생태"),
                        entry("NA04", "자연공원"),
                        entry("NA05", "기타자연관광")

                )), entry("VE", Map.ofEntries(
                        entry("VE01", "랜드마크관광"),
                        entry("VE02", "테마공원"),
                        entry("VE03", "도시공원"),
                        entry("VE04", "도시.지역문화관광"),
                        entry("VE05", "공연시설"),
                        entry("VE06", "전시시설"),
                        entry("VE07", "행사시설"),
                        entry("VE08", "교육시설"),
                        entry("VE09", "레저스포츠시설")
                ))

        );

        CATEGORY3_MAP = Map.ofEntries(
                // 축제/공연/행사
                entry("EV01", Map.ofEntries(
                        entry("EV010100", "문화관광축제"),
                        entry("EV010200", "문화예술축제"),
                        entry("EV010300", "지역특산물축제"),
                        entry("EV010400", "전통역사축제"),
                        entry("EV010500", "생태자연축제"),
                        entry("EV010600", "기타축제")
                )),
                entry("EV02", Map.ofEntries(
                        entry("EV020100", "전통공연"),
                        entry("EV020200", "연극"),
                        entry("EV020300", "뮤지컬"),
                        entry("EV020400", "오페라"),
                        entry("EV020500", "무용"),
                        entry("EV020600", "클래식음악회"),
                        entry("EV020700", "대중콘서트"),
                        entry("EV020800", "영화"),
                        entry("EV020900", "기타공연"),
                        entry("EV021000", "넌버벌")
                )),
                entry("EV03", Map.ofEntries(
                        entry("EV030100", "전시회"),
                        entry("EV030200", "박람회"),
                        entry("EV030300", "스포츠경기"),
                        entry("EV030400", "기타행사")
                )),
                // 체험관광
                entry("EX01", Map.ofEntries(
                        entry("EX010100", "전통문화체험")
                )),
                entry("EX02", Map.ofEntries(
                        entry("EX020100", "금속공예체험"),
                        entry("EX020200", "유리공예체험"),
                        entry("EX020300", "가죽공예체험"),
                        entry("EX020400", "기타공예체험")
                )),
                entry("EX03", Map.ofEntries(
                        entry("EX030100", "체험마을"),
                        entry("EX030200", "체험목장"),
                        entry("EX030300", "체험농장"),
                        entry("EX030400", "체험어장")
                )),
                entry("EX04", Map.ofEntries(
                        entry("EX040100", "템플스테이"),
                        entry("EX040200", "사찰문화체험")
                )),
                entry("EX05", Map.ofEntries(
                        entry("EX050100", "온천 / 사우나 / 스파"),
                        entry("EX050200", "찜찔방"),
                        entry("EX050300", "한방체험"),
                        entry("EX050400", "힐링명상"),
                        entry("EX050500", "뷰티스파"),
                        entry("EX050600", "기타웰니스"),
                        entry("EX050700", "자연치유")
                )),
                entry("EX06", Map.ofEntries(
                        entry("EX060100", "근대산업유산"),
                        entry("EX060200", "게임 등 첨단IT산업"),
                        entry("EX060300", "전통/향토산업"),
                        entry("EX060400", "문화콘텐츠산업"),
                        entry("EX060500", "장수기업/산업테마거리"),
                        entry("EX060600", "자동차/조선/철강 등"),
                        entry("EX060700", "로봇/항공우주산업"),
                        entry("EX060800", "화장품/주류/먹거리"),
                        entry("EX060900", "친환경/신재생에너지"),
                        entry("EX061000", "기타산업관광지")
                )),
                entry("EX07", Map.ofEntries(
                        entry("EX070100", "유람선/잠수함관광"),
                        entry("EX070200", "기타체험관광")
                )),
                //역사관광
                entry("HS01", Map.ofEntries(
                        entry("HS010100", "고궁"),
                        entry("HS010200", "성ㆍ산성ㆍ성곽"),
                        entry("HS010300", "문"),
                        entry("HS010400", "고택"),
                        entry("HS010500", "생가"),
                        entry("HS010600", "민속마을"),
                        entry("HS010700", "사적지"),
                        entry("HS010800", "고분, 능"),
                        entry("HS010900", "사당"),
                        entry("HS011000", "선사유적지"),
                        entry("HS011100", "근대건축물"),
                        entry("HS011200", "기타역사유적지")
                )),
                entry("HS02", Map.ofEntries(
                        entry("HS020100", "탑ㆍ비석ㆍ기념탑"),
                        entry("HS020200", "선사유물"),
                        entry("HS020300", "불상"),
                        entry("HS020400", "기타역사유물")
                )),
                entry("HS03", Map.ofEntries(
                        entry("HS030100", "불교"),
                        entry("HS030200", "기독교"),
                        entry("HS030300", "이슬람"),
                        entry("HS030400", "기타 종교성지")
                )),
                entry("HS04", Map.ofEntries(
                        entry("HS040100", "안보유적지"),
                        entry("HS040200", "안보관광시설"),
                        entry("HS040300", "북한관광지"),
                        entry("HS040400", "기타안보관광지")
                )),

                // 레저스포츠
                entry("LS01", Map.ofEntries(
                        entry("LS010100", "인라인(실내 인라인 포함)"),
                        entry("LS010200", "자전거하이킹"),
                        entry("LS010300", "카트"),
                        entry("LS010400", "골프"),
                        entry("LS010500", "경마"),
                        entry("LS010600", "경륜"),
                        entry("LS010700", "승마"),
                        entry("LS010800", "스키/스노보드"),
                        entry("LS010900", "스케이트"),
                        entry("LS011000", "썰매장"),
                        entry("LS011100", "수렵장"),
                        entry("LS011200", "사격장"),
                        entry("LS011300", "암벽등반"),
                        entry("LS011400", "서바이벌게임"),
                        entry("LS011500", "ATV"),
                        entry("LS011600", "MTB"),
                        entry("LS011700", "오프로드"),
                        entry("LS011800", "번지점프"),
                        entry("LS011900", "기타육상레저스포츠")
                )),
                entry("LS02", Map.ofEntries(
                        entry("LS020100", "드서핑/제트스키"),
                        entry("LS020200", "카약/카누"),
                        entry("LS020300", "요트"),
                        entry("LS020400", "스노쿨링/스킨스쿠버다이빙"),
                        entry("LS020500", "민물낚시"),
                        entry("LS020600", "바다낚시"),
                        entry("LS020700", "수영"),
                        entry("LS020800", "레프팅"),
                        entry("LS020900", "수상오토바이"),
                        entry("LS021000", "수상자전거"),
                        entry("LS021100", "조정"),
                        entry("LS021200", "워터슬레드"),
                        entry("LS021300", "패러세일"),
                        entry("LS021400", "기타수상레저스포츠")
                )),
                entry("LS03", Map.ofEntries(
                        entry("LS030100", "스카이다이빙"),
                        entry("LS030200", "초경량비행"),
                        entry("LS030300", "헹글라이딩/패러글라이딩"),
                        entry("LS030400", "열기구"),
                        entry("LS030500", "무인비행장치(드론)"),
                        entry("LS030600", "기타항공레저스포츠")
                )),
                entry("LS04", Map.ofEntries(
                        entry("LS040100", "복합레저스포츠")
                )),

                // 자연
                entry("NA01", Map.ofEntries(
                        entry("NA010100", "산, 고개, 오름, 봉우리"),
                        entry("NA010200", "숲"),
                        entry("NA010300", "폭포"),
                        entry("NA010400", "계곡"),
                        entry("NA010500", "약수터")
                )),
                entry("NA02", Map.ofEntries(
                        entry("NA020100", "강"),
                        entry("NA020200", "호수"),
                        entry("NA020300", "저수지"),
                        entry("NA020400", "연못·늪"),
                        entry("NA020500", "섬"),
                        entry("NA020600", "염전"),
                        entry("NA020700", "항구/포구"),
                        entry("NA020800", "해안절경"),
                        entry("NA020900", "해변, 해수욕장")
                )),
                entry("NA03", Map.ofEntries(
                        entry("NA030100", "동굴"),
                        entry("NA030200", "희귀동.식물"),
                        entry("NA030300", "기암괴석"),
                        entry("NA030400", "생태습지"),
                        entry("NA030500", "기타자연생태")
                )),
                entry("NA04", Map.ofEntries(
                        entry("NA040100", "국립공원"),
                        entry("NA040200", "도립공원"),
                        entry("NA040300", "군립공원"),
                        entry("NA040400", "지질공원"),
                        entry("NA040500", "생태관광지"),
                        entry("NA040600", "자연휴양림"),
                        entry("NA040700", "수목원ㆍ정원")
                )),
                entry("NA05", Map.ofEntries(
                        entry("NA050100", "기타자연관광")
                )),

                // 문화시설
                entry("VE01", Map.ofEntries(
                        entry("VE010100", "건물"),
                        entry("VE010200", "타워 / 전망대"),
                        entry("VE010300", "다리 / 대교"),
                        entry("VE010400", "분수"),
                        entry("VE010500", "동상"),
                        entry("VE010600", "터널"),
                        entry("VE010700", "댐"),
                        entry("VE010800", "등대"),
                        entry("VE010900", "기타 건축/조형물")
                )),
                entry("VE02", Map.ofEntries(
                        entry("VE020100", "테마파크"),
                        entry("VE020200", "워터파크"),
                        entry("VE020300", "동물원"),
                        entry("VE020400", "수족관 / 아쿠라리움"),
                        entry("VE020500", "천문대")
                )),
                entry("VE03", Map.ofEntries(
                        entry("VE030100", "시민공원"),
                        entry("VE030200", "소공원"),
                        entry("VE030300", "어린이공원"),
                        entry("VE030400", "근린공원"),
                        entry("VE030500", "주제공원")
                        )),
                entry("VE04", Map.ofEntries(
                        entry("VE040100", "골목길, 문화거리"),
                        entry("VE040200", "마을관광지"),
                        entry("VE040300", "둘레길")
                )),
                entry("VE05", Map.ofEntries(
                        entry("VE050100", "관광단지"),
                        entry("VE050200", "리조트")
                )),
                entry("VE06", Map.ofEntries(
                        entry("VE060100", "공연장"),
                        entry("VE060200", "영화관")
                )),

                entry("VE07", Map.ofEntries(
                        entry("VE070100", "박물관"),
                        entry("VE070200", "기념관"),
                        entry("VE070300", "전시관"),
                        entry("VE070400", "컨벤션센터"),
                        entry("VE070500", "과학관"),
                        entry("VE070600", "미술관/화랑")
                )),
                entry("VE08", Map.ofEntries(
                        entry("VE080100", "연회장")
                )),
                entry("VE09", Map.ofEntries(
                        entry("VE090100", "한국문화원"),
                        entry("VE090200", "외국문화원"),
                        entry("VE090300", "도서관"),
                        entry("VE090400", "문화전수시설"),
                        entry("VE090500", "어학당"),
                        entry("VE090600", "학교")
                ))

        );

        Map<String, String> map = new LinkedHashMap<>();
        map.put("서울", "1");
        map.put("인천", "2");
        map.put("대전", "3");
        map.put("대구", "4");
        map.put("광주", "5");
        map.put("부산", "6");
        map.put("울산", "7");
        map.put("세종특별자치시", "8");
        map.put("경기도", "31");
        map.put("강원특별자치도", "32");
        map.put("충청북도", "33");
        map.put("충청남도", "34");
        map.put("경상북도", "35");
        map.put("경상남도", "36");
        map.put("전북특별자치도", "37");
        map.put("전라남도", "38");
        map.put("제주특별자치도", "39");
        SIDO_MAP = Collections.unmodifiableMap(map);

        SIGUNGU_MAP = Map.ofEntries(
                entry("1", Map.ofEntries(
                        entry("강남구", "1"),
                        entry("강동구", "2"),
                        entry("강북구", "3"),
                        entry("강서구", "4"),
                        entry("관악구", "5"),
                        entry("광진구", "6"),
                        entry("구로구", "7"),
                        entry("금천구", "8"),
                        entry("노원구", "9"),
                        entry("도봉구", "10"),
                        entry("동대문구", "11"),
                        entry("동작구", "12"),
                        entry("마포구", "13"),
                        entry("서대문구", "14"),
                        entry("서초구", "15"),
                        entry("성동구", "16"),
                        entry("성북구", "17"),
                        entry("송파구", "18"),
                        entry("양천구", "19"),
                        entry("영등포구", "20"),
                        entry("용산구", "21"),
                        entry("은평구", "22"),
                        entry("종로구", "23"),
                        entry("중구", "24"),
                        entry("중랑구", "25")
                )),
                entry("2", Map.ofEntries(
                        entry("강화군", "1"),
                        entry("계양구", "2"),
                        entry("미추홀구", "3"),
                        entry("남동구", "4"),
                        entry("동구", "5"),
                        entry("부평구", "6"),
                        entry("서구", "7"),
                        entry("연수구", "8"),
                        entry("옹진군", "9"),
                        entry("중구", "10")
                )),
                entry("3", Map.ofEntries(
                        entry("대덕구", "1"),
                        entry("동구", "2"),
                        entry("서구", "3"),
                        entry("유성구", "4"),
                        entry("중구", "5")
                )),
                entry("4", Map.ofEntries(
                        entry("남구", "1"),
                        entry("달서구", "2"),
                        entry("달성군", "3"),
                        entry("동구", "4"),
                        entry("북구", "5"),
                        entry("서구", "6"),
                        entry("수성구", "7"),
                        entry("중구", "8"),
                        entry("군위군", "9")
                )),
                entry("5", Map.ofEntries(
                        entry("광산구", "1"),
                        entry("남구", "2"),
                        entry("동구", "3"),
                        entry("북구", "4"),
                        entry("서구", "5")
                )),
                entry("6", Map.ofEntries(
                        entry("강서구", "1"),
                        entry("금정구", "2"),
                        entry("기장군", "3"),
                        entry("남구", "4"),
                        entry("동구", "5"),
                        entry("동래구", "6"),
                        entry("부산진구", "7"),
                        entry("북구", "8"),
                        entry("사상구", "9"),
                        entry("사하구", "10"),
                        entry("서구", "11"),
                        entry("수영구", "12"),
                        entry("연제구", "13"),
                        entry("영도구", "14"),
                        entry("중구", "15"),
                        entry("해운대구", "16")
                )),
                entry("7", Map.ofEntries(
                        entry("중구", "1"),
                        entry("남구", "2"),
                        entry("동구", "3"),
                        entry("북구", "4"),
                        entry("울주군", "5")
                )),
                entry("8", Map.ofEntries(
                        entry("세종특별자치시", "1")
                )),
                entry("31", Map.ofEntries(
                        entry("가평군", "1"),
                        entry("고양시", "2"),
                        entry("과천시", "3"),
                        entry("광명시", "4"),
                        entry("광주시", "5"),
                        entry("구리시", "6"),
                        entry("군포시", "7"),
                        entry("김포시", "8"),
                        entry("남양주시", "9"),
                        entry("동두천시", "10"),
                        entry("부천시", "11"),
                        entry("성남시", "12"),
                        entry("수원시", "13"),
                        entry("시흥시", "14"),
                        entry("안산시", "15"),
                        entry("안성시", "16"),
                        entry("안양시", "17"),
                        entry("양주시", "18"),
                        entry("양평군", "19"),
                        entry("여주시", "20"),
                        entry("연천군", "21"),
                        entry("오산시", "22"),
                        entry("용인시", "23"),
                        entry("의왕시", "24"),
                        entry("의정부시", "25"),
                        entry("이천시", "26"),
                        entry("파주시", "27"),
                        entry("평택시", "28"),
                        entry("포천시", "29"),
                        entry("하남시", "30"),
                        entry("화성시", "31")
                )),
                entry("32", Map.ofEntries(
                        entry("강릉시", "1"),
                        entry("고성군", "2"),
                        entry("동해시", "3"),
                        entry("삼척시", "4"),
                        entry("속초시", "5"),
                        entry("양구군", "6"),
                        entry("양양군", "7"),
                        entry("영월군", "8"),
                        entry("원주시", "9"),
                        entry("인제군", "10"),
                        entry("정선군", "11"),
                        entry("철원군", "12"),
                        entry("춘천시", "13"),
                        entry("태백시", "14"),
                        entry("평창군", "15"),
                        entry("홍천군", "16"),
                        entry("화천군", "17"),
                        entry("횡성군", "18")
                )),
                entry("33", Map.ofEntries(
                        entry("괴산군", "1"),
                        entry("단양군", "2"),
                        entry("보은군", "3"),
                        entry("영동군", "4"),
                        entry("옥천군", "5"),
                        entry("음성군", "6"),
                        entry("제천시", "7"),
                        entry("진천군", "8"),
                        entry("청원군", "9"),
                        entry("청주시", "10"),
                        entry("충주시", "11"),
                        entry("증평군", "12")
                )),
                entry("34", Map.ofEntries(
                        entry("공주시", "1"),
                        entry("금산군", "2"),
                        entry("논산시", "3"),
                        entry("당진시", "4"),
                        entry("보령시", "5"),
                        entry("부여군", "6"),
                        entry("서산시", "7"),
                        entry("서천군", "8"),
                        entry("아산시", "9"),
                        entry("예산군", "11"),
                        entry("천안시", "12"),
                        entry("청양군", "13"),
                        entry("태안군", "14"),
                        entry("홍성군", "15"),
                        entry("계룡시", "16")
                )),
                entry("35", Map.ofEntries(
                        entry("경산시", "1"),
                        entry("경주시", "2"),
                        entry("고령군", "3"),
                        entry("구미시", "4"),
                        entry("김천시", "6"),
                        entry("문경시", "7"),
                        entry("봉화군", "8"),
                        entry("상주시", "9"),
                        entry("성주군", "10"),
                        entry("안동시", "11"),
                        entry("영덕군", "12"),
                        entry("영양군", "13"),
                        entry("영주시", "14"),
                        entry("영천시", "15"),
                        entry("예천군", "16"),
                        entry("울릉군", "17"),
                        entry("울진군", "18"),
                        entry("의성군", "19"),
                        entry("청도군", "20"),
                        entry("청송군", "21"),
                        entry("칠곡군", "22"),
                        entry("포항시", "23")
                )),
                entry("36", Map.ofEntries(
                        entry("거제시", "1"),
                        entry("거창군", "2"),
                        entry("고성군", "3"),
                        entry("김해시", "4"),
                        entry("남해군", "5"),
                        entry("밀양시", "7"),
                        entry("사천시", "8"),
                        entry("산청군", "9"),
                        entry("양산시", "10"),
                        entry("의령군", "12"),
                        entry("진주시", "13"),
                        entry("창녕군", "15"),
                        entry("창원시", "16"),
                        entry("통영시", "17"),
                        entry("하동군", "18"),
                        entry("함안군", "19"),
                        entry("함양군", "20"),
                        entry("합천군", "21")
                )),
                entry("37", Map.ofEntries(
                        entry("고창군", "1"),
                        entry("군산시", "2"),
                        entry("김제시", "3"),
                        entry("남원시", "4"),
                        entry("무주군", "5"),
                        entry("부안군", "6"),
                        entry("순창군", "7"),
                        entry("완주군", "8"),
                        entry("익산시", "9"),
                        entry("임실군", "10"),
                        entry("장수군", "11"),
                        entry("전주시", "12"),
                        entry("정읍시", "13"),
                        entry("진안군", "14")
                )),
                entry("38", Map.ofEntries(
                        entry("강진군", "1"),
                        entry("고흥군", "2"),
                        entry("곡성군", "3"),
                        entry("광양시", "4"),
                        entry("구례군", "5"),
                        entry("나주시", "6"),
                        entry("담양군", "7"),
                        entry("목포시", "8"),
                        entry("무안군", "9"),
                        entry("보성군", "10"),
                        entry("순천시", "11"),
                        entry("신안군", "12"),
                        entry("여수시", "13"),
                        entry("영광군", "16"),
                        entry("영암군", "17"),
                        entry("완도군", "18"),
                        entry("장성군", "19"),
                        entry("장흥군", "20"),
                        entry("진도군", "21"),
                        entry("함평군", "22"),
                        entry("해남군", "23"),
                        entry("화순군", "24")
                )), entry("39", Map.ofEntries(
                        entry("남제주군", "1"),
                        entry("북제주군", "2"),
                        entry("서귀포시", "3"),
                        entry("제주시", "4")
                ))
        );
    }

}
