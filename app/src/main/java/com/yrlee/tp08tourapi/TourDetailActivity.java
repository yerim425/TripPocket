package com.yrlee.tp08tourapi;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import static com.yrlee.tp08tourapi.BuildConfig.API_KEY;

import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.yrlee.tp08tourapi.adapter.ImagePagerAdapter;
import com.yrlee.tp08tourapi.data.TourDetailItem;
import com.yrlee.tp08tourapi.data.TourItem;
import com.yrlee.tp08tourapi.util.Constants;
import com.yrlee.tp08tourapi.util.XmlParserUtil;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TourDetailActivity extends AppCompatActivity {

    private String contentId;
    private String contentTypeId;

    // ui
    private TextView tvFailLoadData;
    private TextView tvTitle;

    // progress bar
    private ProgressBar progressBar;
    private boolean isLoading = false;

    // viewpager
    private ImagePagerAdapter imagePagerAdapter;

    // 상세정보 객체
    private TourDetailItem tourItem;

    String BASE_URL = "https://apis.data.go.kr/B551011/KorService2/";
    String BASE_TYPE = "?&serviceKey=" + API_KEY + "&MobileOS=AND&MobileApp=TripPocket&_type=xml";

    private String detailAddr; // 상세정보 조회
    private String detailRequestKeyword = "detailCommon2";
    private String introAddr; // 소개정보 조회
    private String introRequestKeyword = "detailIntro2";
    private String repeatAddr; // 반복정보 조회 - 여행코스
    private String repeatRequestKeyword = "detailInfo2";


    // 스레드를 여러개 생성하는 것을 방지
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tour_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // ui 초기화
        tvFailLoadData = findViewById(R.id.tv_fail_load_data);
        progressBar = findViewById(R.id.progressbar);
        tvTitle = findViewById(R.id.tvTitle);

        // viewpager
        imagePagerAdapter = new ImagePagerAdapter(null);

        contentId = getIntent().getStringExtra("contentId");
//        contentTypeId = getIntent().getStringExtra("contentTypeId");
        if (contentId == null || contentId.isEmpty()) {
            tvFailLoadData.setVisibility(VISIBLE);
        } else {
            tourItem = new TourDetailItem(contentId);
            Log.d("here", "contentId: " + contentId);

            loadContentData();
        }


    }

    // 1번 api 호출 - 기본 상세 정보 조회
    public void loadContentData() {
        setLoading(true);

        executor.execute(() -> {
            // 기본 상세 정보 조회 url
            detailAddr = BASE_URL + detailRequestKeyword + BASE_TYPE + "&contentId=" + tourItem.contentId;
            Log.d("here", detailAddr);
            try {
                XmlPullParser xpp = XmlParserUtil.getParser(detailAddr);
                detailParse(xpp);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            runOnUiThread(() -> {
                if (isFinishing() || isDestroyed()) return;
                // ui 반영
                // 제목
                tvTitle.setText(tourItem.title);

                // 메인 이미지
                ArrayList<String> imageList = new ArrayList<>();
                imageList.add(tourItem.firstImage);
                if(!tourItem.firstImage2.isEmpty()) imageList.add(tourItem.firstImage2);
                ViewPager2 viewPager = findViewById(R.id.viewPager);
                imagePagerAdapter.setImageList(imageList);
                viewPager.setAdapter(imagePagerAdapter);
            });
        });

        // 2번 api 호출 - 상세 소개 정보 조회
        executor.execute(()->{
            Log.d("here", "contentTypeId: " + tourItem.contentTypeId);
            introAddr = BASE_URL + introRequestKeyword + BASE_TYPE
                    + "&contentId=" + tourItem.contentId
                    + "&contentTypeId=" + tourItem.contentTypeId;

            try {
                XmlPullParser xpp = XmlParserUtil.getParser(detailAddr);
                introParse(xpp);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            // ui
            runOnUiThread(()->{
                if(Objects.equals(tourItem.contentTypeId, "15")){ // 축제

                }else if (Objects.equals(tourItem.contentTypeId, "25")){ // 여행코스

                }else{ // 관광지, 문화시설, 레포츠

                }
            });

        });

        // 3번째 api 호출 - 반복 정보 조회 -> 여행코스 리스트 조회
        if(Objects.equals(tourItem.contentTypeId, "25")){

        }

        setLoading(false);
    }

    // 기본 상세 정보 xml 문서 파싱
    private void detailParse(XmlPullParser xpp) throws XmlPullParserException, IOException {
        int eventType = xpp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            switch (eventType) {
                case XmlPullParser.START_DOCUMENT:
                    break;
                case XmlPullParser.START_TAG:
                    String tagName = xpp.getName();
                    if (tagName.equals("contenttypeid")) {
                        xpp.next();
                        tourItem.contentTypeId = xpp.getText();
                    } else if (tagName.equals("title")) {
                        xpp.next();
                        tourItem.title = xpp.getText();
                        Log.d("url", "title: " + xpp.getText());
                    } else if (tagName.equals("homepage")) {
                        xpp.next();
                        tourItem.homePage = xpp.getText();
                    } else if (tagName.equals("firstimage")) {
                        xpp.next();
                        tourItem.firstImage = xpp.getText();
                    } else if (tagName.equals("firstimage2")) {
                        xpp.next();
                        tourItem.firstImage2 = xpp.getText();
                    } else if (tagName.equals("addr1")) {
                        xpp.next();
                        tourItem.addr1 = xpp.getText();
                    } else if (tagName.equals("addr2")) {
                        xpp.next();
                        tourItem.addr2 = xpp.getText();
                    } else if (tagName.equals("mapx")) {
                        xpp.next();
                        tourItem.mapx = xpp.getText();
                    } else if (tagName.equals("mapy")) {
                        xpp.next();
                        tourItem.mapy = xpp.getText();
                    } else if (tagName.equals("overview")) {
                        xpp.next();
                        tourItem.overview = xpp.getText();
                    }
                    break;
                case XmlPullParser.END_TAG:
            }
            eventType = xpp.next();
        }
    }

    // 소개 상세 정보 xml 파싱
    private void introParse(XmlPullParser xpp) throws XmlPullParserException, IOException {

        int eventType = xpp.getEventType();
        if(Objects.equals(tourItem.contentTypeId, "15")){ // 축제 정보
            //주최자정보, 주최자연락처, 행사시작일, 행사종료일, 공연시간, 행사장소, 이용요금
            TourDetailItem.FestivalData fesData = new TourDetailItem.FestivalData();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        break;
                    case XmlPullParser.START_TAG:
                        String tagName = xpp.getName();
                        if (tagName.equals("sponsor1")) {
                            xpp.next();
                            fesData.sponsor1 = xpp.getText();
                        } else if (tagName.equals("sponsor1tel")) {
                            xpp.next();
                            fesData.sponsor1tel = xpp.getText();
                        } else if (tagName.equals("eventstartdate")) {
                            xpp.next();
                            fesData.eventStartDate = xpp.getText();
                        } else if (tagName.equals("eventenddate")) {
                            xpp.next();
                            fesData.eventEndDate = xpp.getText();
                        } else if (tagName.equals("eventplace")) {
                            xpp.next();
                            fesData.eventPlace = xpp.getText();
                        } else if (tagName.equals("playtime")) {
                            xpp.next();
                            fesData.playTime = xpp.getText();
                        }else if (tagName.equals("usetimefestival")) {
                            xpp.next();
                            fesData.useTimeFestival = xpp.getText();
                        }
                        break;
                    case XmlPullParser.END_TAG:
                }
                eventType = xpp.next();
            }
            tourItem.fesData = fesData;
        }
        else if(Objects.equals(tourItem.contentTypeId, "25")) {// 여행코스 정보
            TourDetailItem.RecommendData recommendData = new TourDetailItem.RecommendData();
            // 코스 총 소요시간 데이터 가져오기
            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        break;
                    case XmlPullParser.START_TAG:
                        String tagName = xpp.getName();
                        if (tagName.equals("taketime")) {
                            xpp.next();
                            recommendData.takeTime = xpp.getText();
                        }
                        break;
                    case XmlPullParser.END_TAG:
                }
                eventType = xpp.next();
            }
            tourItem.recommendData = recommendData;

        }else{ // 관광지, 문화시설, 레포츠
            //이용요금, 이용시간, 주차시설, 주차요금, 문의 및 안내, 쉬는날
            TourDetailItem.IntroData introData = new TourDetailItem.IntroData();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        break;
                    case XmlPullParser.START_TAG:
                        String tagName = xpp.getName();
                        if (tagName.contains("usefee")) {
                            xpp.next();
                            introData.useFee = xpp.getText();
                        } else if (tagName.contains("usetime")) {
                            xpp.next();
                            introData.useTime = xpp.getText();
                        } else if (tagName.contains("parking")) {
                            xpp.next();
                            introData.parking = xpp.getText();
                        } else if (tagName.contains("parkingfee")) {
                            xpp.next();
                            introData.parkingFee = xpp.getText();
                        } else if (tagName.contains("infocenter")) {
                            xpp.next();
                            introData.infoCenter = xpp.getText();
                        } else if (tagName.contains("restdate")) {
                            xpp.next();
                            introData.restDate = xpp.getText();
                        }
                        break;
                    case XmlPullParser.END_TAG:
                }
                eventType = xpp.next();
            }
            tourItem.introData = introData;
        }
    }

    private void setLoading(Boolean loading) {
        isLoading = loading;
        progressBar.setVisibility(isLoading ? VISIBLE : INVISIBLE);

    }
}