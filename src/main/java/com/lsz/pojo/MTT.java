package com.lsz.pojo;

import com.lsz.Enum.MyEnum;
import com.lsz.annotation.MyAnnotation;
import lombok.Data;

@Data
public class MTT {

    @MyAnnotation(value = "notBlank")
    private String labelId;
    private String labelParent;
    private String labelName;
    @MyAnnotation(value = "isDigit")
    private String labelNumber;
}
