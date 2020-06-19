package com.lsz.pojo;

import com.lsz.annotation.MyAnnotation;
import lombok.Data;

@Data
public class TRA {

    //tradeId|tradeName|tradeIsShow|tradeDesc|tradeCityCode|tradeProviceCode

    @MyAnnotation(value = "notBlank")
    private String tradeId;
    private String tradeName;
    @MyAnnotation(value = "zeroOrOne")
    private String tradeIsShow;
    private String tradeDesc;
    @MyAnnotation(value = "notBlankAndSixDigit")
    private String tradeCityCode;
    @MyAnnotation(value = "notBlankAndSixDigit")
    private String tradeProviceCode;
}
