package com.lsz.Enum;

public enum MyEnum {
    SPLIT("\\|"),
    PERIOD("."),
    PARSE("_parse"),
    LONGITUDE_PATTERN("^[EW]?((\\d|[1-9]\\d|1[0-7]\\d)[\\s\\-,;°度](\\d|[0-5]\\d)[\\s\\-,;′分](\\d|[0-5]\\d)(\\.\\d{1,2})?[\\s\\-,;\"秒]?$)|(180[\\s\\-,;°度]0[\\s\\-,;′分]0[\\s\\-,;\"秒]?$)"),
    LATITUDE_PATTERN("^[NS]?((\\d|[1-8]\\d)[\\s\\-,;°度](\\d|[0-5]\\d)[\\s\\-,;′分](\\d|[0-5]\\d)(\\.\\d{1,2})?[\\s\\-,;\"秒]?$)|(90[\\s\\-,;°度]0[\\s\\-,;′分]0[\\s\\-,;\"秒]?$)"),
    UTF8("UTF8"),
    NOT_BLANK("notBlank"),
    IS_DIGIT("isDigit"),
    NOT_BLANK_AND_SIX_DIGIT("notBlankAndSixDigit"),
    IS_LATITUDE("isLatitude"),
    IS_LONGITUDE("isLongitude"),
    ZERO_OR_ONE("zeroOrOne")
    ;

    private String value;

    MyEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static void main(String[] args) {
        System.out.println(MyEnum.SPLIT.getValue());

    }
}
