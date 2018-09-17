package com.tonnoz.wct.main.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    private StringUtils(){}

    public static final String URL_REGEX = "(.*?)((http|https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)(.*?)";
    public static final String DATE_PATTERN = "M/d/yy, HH:mm ";
    public static final String DASH = "-";
    public static final char DASH_CHAR = '-';
    public static final String COLUMN = ":";

    public static String extractUrls(String text){
        final Matcher urlMatcher = Pattern.compile(URL_REGEX, Pattern.CASE_INSENSITIVE).matcher(text);
        final List<String> a = new ArrayList<>();
        while (urlMatcher.find()){
            a.add(text.substring(urlMatcher.start(2), urlMatcher.end(2)));
        }
        return a.get(0);
    }

    public static boolean isRegularLookingLogLine(String txt){
        String re1="((?:[0]?[1-9]|[1][012])[-:\\/.](?:(?:[0-2]?\\d{1})|(?:[3][01]{1}))[-:\\/.](?:(?:\\d{1}\\d{1})))(?![\\d])";	// MMDDYY 1
        String re2="(,)";	// Any Single Character 1
        String re3="(\\s+)";	// White Space 1
        String re4="((?:(?:[0-1][0-9])|(?:[2][0-3])|(?:[0-9])):(?:[0-5][0-9])(?::[0-5][0-9])?(?:\\s?(?:am|AM|pm|PM))?)";	// HourMinuteSec 1
        String re5="(\\s+)";	// White Space 2
        String re6="(.*)";	// anything
        Pattern p = Pattern.compile(re1+re2+re3+re4+re5+re6,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        return p.matcher(txt).matches();
    }

}
