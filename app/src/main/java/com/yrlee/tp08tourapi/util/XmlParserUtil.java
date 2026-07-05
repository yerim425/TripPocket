package com.yrlee.tp08tourapi.util;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class XmlParserUtil {
    private XmlParserUtil() {}

    public static XmlPullParser getParser(String address) throws Exception {

        var url = new URL(address);

        InputStream is = url.openStream();  // 바이트 스트림
        InputStreamReader isr = new InputStreamReader(is); // 문자 스트림

        // Reader가 읽어들인 문자들을 xml 파일로 보고 분석해주는 분석가 객체 준비
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();
        // 분석가에게 xml 데이터를 읽어오는 무지개 로드를 알려주기
        xpp.setInput(isr);

        return xpp;
    }

    public static String readText(XmlPullParser xpp) throws Exception {
        xpp.next();
        return xpp.getText();
    }
}
