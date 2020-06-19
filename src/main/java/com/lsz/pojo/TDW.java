package com.lsz.pojo;

import com.lsz.annotation.MyAnnotation;
import com.sun.org.glassfish.gmbal.ManagedAttribute;

public class TDW {

    @MyAnnotation(value = "notBlank")
    private String merchantId;

    private String merchantName;

    @MyAnnotation(value = "notBlankAndSixDigit")
    private String merchantCityCode;

    @MyAnnotation(value = "notBlankAndSixDigit")
    private String merchantProviceCode;

    @MyAnnotation(value = "isLatitude")
    private String merchantLat;
    @MyAnnotation(value = "isLongitude")
    private String merchantLng;
    @MyAnnotation(value = "zeroOrOne")
    private String merchantStatus;

}
