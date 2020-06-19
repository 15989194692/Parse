package com.lsz;

import com.lsz.pojo.MTT;
import com.lsz.pojo.TDW;
import com.lsz.pojo.TRA;
import com.lsz.utils.ParseUtil;

import java.io.File;

public class TestValidate {
    public static void main(String[] args) {

        final ParseUtil<TRA> traParseUtil = new ParseUtil<>(new TRA());
        final File file1 = new File("TUSS.TRA.T0001.txt");
        traParseUtil.parseTxt(file1);

        final ParseUtil<MTT> mttParseUtil = new ParseUtil<>(new MTT());
        final File file2 = new File("TUSS.MTT.T0023.txt");
        mttParseUtil.parseTxt(file2);

        /*final ParseUtil<TDW> tdwParseUtil = new ParseUtil<>(new TDW());
        final File file3 = new File("TUSS.TDW.T0045.txt");
        tdwParseUtil.parseTxt(file3);*/

    }
}
