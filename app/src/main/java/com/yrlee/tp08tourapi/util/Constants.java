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
        map.put("서울", "11");
        map.put("전남광주통합특별시", "12");
        map.put("부산", "26");
        map.put("대구", "27");
        map.put("인천", "28");
        map.put("대전", "30");
        map.put("울산", "31");
        map.put("세종특별자치시", "36110");
        map.put("경기도", "41");
        map.put("충청북도", "43");
        map.put("충청남도", "44");
        map.put("경상북도", "47");
        map.put("경상남도", "48");
        map.put("제주특별자치도", "50");
        map.put("강원특별자치도", "51");
        map.put("전북특별자치도", "52");

        SIDO_MAP = Collections.unmodifiableMap(map);

        SIGUNGU_MAP = Map.ofEntries(
                entry("11", Map.ofEntries(
                        entry("강남구", "680"),
                        entry("강동구", "740"),
                        entry("강북구", "305"),
                        entry("강서구", "500"),
                        entry("관악구", "620"),
                        entry("광진구", "215"),
                        entry("구로구", "530"),
                        entry("금천구", "545"),
                        entry("노원구", "350"),
                        entry("도봉구", "320"),
                        entry("동대문구", "230"),
                        entry("동작구", "590"),
                        entry("마포구", "440"),
                        entry("서대문구", "410"),
                        entry("서초구", "650"),
                        entry("성동구", "200"),
                        entry("성북구", "290"),
                        entry("송파구", "710"),
                        entry("양천구", "470"),
                        entry("영등포구", "560"),
                        entry("용산구", "170"),
                        entry("은평구", "380"),
                        entry("종로구", "110"),
                        entry("중구", "140"),
                        entry("중랑구", "260")
                )),
                entry("12", Map.ofEntries(
                        entry("목포시", "110"),
                        entry("여수시", "130"),
                        entry("순천시", "150"),
                        entry("나주시", "170"),
                        entry("광양시", "190"),
                        entry("동구", "210"),
                        entry("서구", "240"),
                        entry("남구", "270"),
                        entry("북구", "300"),
                        entry("광산구", "330"),
                        entry("담양군", "710"),
                        entry("곡성군", "720"),
                        entry("구례군", "730"),
                        entry("고흥군", "740"),
                        entry("보성군", "750"),
                        entry("화순군", "760"),
                        entry("장흥군", "770"),
                        entry("강진군", "780"),
                        entry("해남군", "790"),
                        entry("영암군", "800"),
                        entry("무안군", "810"),
                        entry("함평군", "820"),
                        entry("영광군", "830"),
                        entry("장성군", "840"),
                        entry("완도군", "850"),
                        entry("진도군", "860"),
                        entry("신안군", "870")
                )),
                entry("26", Map.ofEntries(
                        entry("중구", "110"),
                        entry("서구", "140"),
                        entry("동구", "170"),
                        entry("영도구", "200"),
                        entry("부산진구", "230"),
                        entry("동래구", "260"),
                        entry("남구", "290"),
                        entry("북구", "320"),
                        entry("해운대구", "350"),
                        entry("사하구", "380"),
                        entry("금정구", "410"),
                        entry("강서구", "440"),
                        entry("연제구", "470"),
                        entry("수영구", "500"),
                        entry("사상구", "530"),
                        entry("기장군", "710")
                )),
                entry("27", Map.ofEntries(
                        entry("중구", "110"),
                        entry("동구", "140"),
                        entry("서구", "170"),
                        entry("남구", "200"),
                        entry("북구", "230"),
                        entry("수성구", "260"),
                        entry("달서구", "290"),
                        entry("달성군", "710"),
                        entry("군위군", "720")
                )),
                entry("28", Map.ofEntries(
                        entry("제물포구", "125"),
                        entry("영종구", "155"),
                        entry("미추홀구", "177"),
                        entry("연수구", "185"),
                        entry("남동구", "200"),
                        entry("부평구", "237"),
                        entry("계양구", "245"),
                        entry("서해구", "275"),
                        entry("검단구", "290"),
                        entry("강화군", "710"),
                        entry("웅진군", "720")
                )),
                entry("30", Map.ofEntries(
                        entry("동구", "110"),
                        entry("중구", "140"),
                        entry("서구", "170"),
                        entry("유성구", "200"),
                        entry("대덕구", "230")
                )),
                entry("31", Map.ofEntries(
                        entry("중구", "110"),
                        entry("남구", "140"),
                        entry("동구", "170"),
                        entry("북구", "200"),
                        entry("울주군", "710")
                )),
                entry("36110", Map.ofEntries(
                        entry("세종특별자치시", "36110")
                )),
                entry("41", Map.ofEntries(
                        entry("수원시", "110"),
                        entry("수원시 장안구", "111"),
                        entry("수원시 권선구", "113"),
                        entry("수원시 팔달구", "115"),
                        entry("수원시 영통구", "117"),
                        entry("성남시", "130"),
                        entry("성남시 수정구", "131"),
                        entry("성남시 중원구", "133"),
                        entry("성남시 분당구", "135"),
                        entry("의정부시", "150"),
                        entry("안양시", "170"),
                        entry("안양시 만안구", "171"),
                        entry("안양시 동안구", "173"),
                        entry("부천시", "190"),
                        entry("부천시 원미구", "192"),
                        entry("부천시 소사구", "194"),
                        entry("부천시 오정구", "196"),
                        entry("광명시", "210"),
                        entry("평택시", "220"),
                        entry("동두천시", "250"),
                        entry("안산시", "270"),
                        entry("안산시 상록구", "271"),
                        entry("안산시 단원구", "273"),
                        entry("고양시", "280"),
                        entry("고양시 덕양구", "281"),
                        entry("고양시 일산동구", "285"),
                        entry("고양시 일산서구", "287"),
                        entry("과천시", "290"),
                        entry("구리시", "310"),
                        entry("남양주시", "360"),
                        entry("오산시", "370"),
                        entry("시흥시", "390"),
                        entry("군포시", "410"),
                        entry("의왕시", "430"),
                        entry("하남시", "450"),
                        entry("용인시", "460"),
                        entry("용인시 처인구", "461"),
                        entry("용인시 기흥구", "463"),
                        entry("용인시 수지구", "465"),
                        entry("파주시", "480"),
                        entry("이천시", "500"),
                        entry("안성시", "550"),
                        entry("김포시", "570"),
                        entry("화성시", "590"),
                        entry("화성시 만세구", "591"),
                        entry("화성시 효행구", "593"),
                        entry("화성시 병점구", "595"),
                        entry("화성시 동탄구", "597"),
                        entry("광주시", "610"),
                        entry("양주시", "630"),
                        entry("포천시", "650"),
                        entry("여주시", "670"),
                        entry("연천군", "800"),
                        entry("가평군", "820"),
                        entry("양평군", "830")
                )),
                entry("43", Map.ofEntries(
                        entry("청주시", "110"),
                        entry("청주시 상당구", "111"),
                        entry("청주시 서원구", "112"),
                        entry("청주시 흥덕구", "113"),
                        entry("청주시 청원구", "114"),
                        entry("충주시", "130"),
                        entry("제천시", "150"),
                        entry("보은군", "720"),
                        entry("옥천군", "730"),
                        entry("영동군", "740"),
                        entry("증평군", "745"),
                        entry("진천군", "750"),
                        entry("괴산군", "760"),
                        entry("음성군", "770"),
                        entry("단양군", "800")
                )),
                entry("44", Map.ofEntries(
                        entry("천안시", "130"),
                        entry("천안시 동남구", "131"),
                        entry("천안시 서북구", "133"),
                        entry("공주시", "150"),
                        entry("보령시", "180"),
                        entry("아산시", "200"),
                        entry("서산시", "210"),
                        entry("논산시", "230"),
                        entry("계룡시", "250"),
                        entry("당진시", "270"),
                        entry("금산군", "710"),
                        entry("부여군", "760"),
                        entry("서천군", "770"),
                        entry("청양군", "790"),
                        entry("홍성군", "800"),
                        entry("예산군", "810"),
                        entry("태안군", "825")
                )),
                entry("47", Map.ofEntries(
                        entry("포항시", "110"),
                        entry("포항시 남구", "111"),
                        entry("포항시 북구", "113"),
                        entry("경주시", "130"),
                        entry("김천시", "150"),
                        entry("안동시", "170"),
                        entry("구미시", "190"),
                        entry("영주시", "210"),
                        entry("영천시", "230"),
                        entry("상주시", "250"),
                        entry("문경시", "280"),
                        entry("경산시", "290"),
                        entry("의성군", "730"),
                        entry("청송군", "750"),
                        entry("영양군", "760"),
                        entry("영덕군", "770"),
                        entry("청도군", "820"),
                        entry("고령군", "830"),
                        entry("성주군", "840"),
                        entry("칠곡군", "850"),
                        entry("예천군", "900"),
                        entry("봉화군", "920"),
                        entry("울진군", "930"),
                        entry("울릉군", "940")
                )),
                entry("48", Map.ofEntries(
                        entry("창원시", "120"),
                        entry("창원시 의창구", "121"),
                        entry("창원시 성산구", "123"),
                        entry("창원시 마산합포구", "125"),
                        entry("창원시 마산회원구", "127"),
                        entry("창원시 진해구", "129"),
                        entry("진주시", "170"),
                        entry("통영시", "220"),
                        entry("사천시", "240"),
                        entry("김해시", "250"),
                        entry("밀양시", "270"),
                        entry("거제시", "310"),
                        entry("양산시", "330"),
                        entry("의령군", "720"),
                        entry("함안군", "730"),
                        entry("창녕군", "740"),
                        entry("고성군", "820"),
                        entry("남해군", "840"),
                        entry("하동군", "850"),
                        entry("산청군", "860"),
                        entry("함양군", "870"),
                        entry("거창군", "880"),
                        entry("합천군", "890")
                )),
                entry("50", Map.ofEntries(
                        entry("제주시", "110"),
                        entry("서귀포시", "130")
                )),
                entry("51", Map.ofEntries(
                        entry("춘천시", "110"),
                        entry("원주시", "130"),
                        entry("강릉시", "150"),
                        entry("동해시", "170"),
                        entry("태백시", "190"),
                        entry("속초시", "210"),
                        entry("삼척시", "230"),
                        entry("홍천군", "720"),
                        entry("횡성군", "730"),
                        entry("영월군", "750"),
                        entry("평창군", "760"),
                        entry("정선군", "770"),
                        entry("철원군", "780"),
                        entry("화천군", "790"),
                        entry("양구군", "800"),
                        entry("인제군", "810"),
                        entry("고성군", "820"),
                        entry("양양군", "830")
                )),
                entry("52", Map.ofEntries(
                        entry("전주시", "110"),
                        entry("전주시 완산구", "111"),
                        entry("전주시 덕진구", "113"),
                        entry("군산시", "130"),
                        entry("익산시", "140"),
                        entry("정읍시", "180"),
                        entry("남원시", "190"),
                        entry("김제시", "210"),
                        entry("완주군", "710"),
                        entry("진안군", "720"),
                        entry("무주군", "730"),
                        entry("장수군", "740"),
                        entry("임실군", "750"),
                        entry("순창군", "770"),
                        entry("고창군", "790"),
                        entry("부안군", "800")
                ))

        );
    }

}
