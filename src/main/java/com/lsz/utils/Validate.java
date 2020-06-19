package com.lsz.utils;

import com.lsz.Enum.MyEnum;
import org.apache.commons.lang.StringUtils;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {


    public static boolean notBlank(String str) {
        return StringUtils.isNotBlank(str);
    }

    public static boolean zeroOrOne(String str) {
        return "0".equals(str) || "1".equals(str);
    }

    public static boolean notBlankAndSixDigit(String str) {
        return StringUtils.isNotBlank(str) && str.length() == 6 && isDigit(str);
    }

    public static boolean isDigit(String str) {
        for (char c : str.toCharArray()) {
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }
        return true;
    }

    //判断经度是否有效
    public static boolean isLongitude(String longitude) {
        final Pattern pattern = Pattern.compile(MyEnum.LONGITUDE_PATTERN.getValue());
        final Matcher matcher = pattern.matcher(longitude);
        return matcher.find();
    }

    //判断纬度是否有效
    public static boolean isLatitude(String latitude) {
        final Pattern pattern = Pattern.compile(MyEnum.LATITUDE_PATTERN.getValue());
        final Matcher matcher = pattern.matcher(latitude);
        return matcher.find();
    }

    public static void main(String[] args) {
        System.out.println(isLongitude("39度52分48秒"));
        System.out.println(isLatitude("116度24分20秒"));
    }
}
