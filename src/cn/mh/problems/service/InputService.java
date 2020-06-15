package cn.mh.problems.service;

import cn.mh.problems.common.Common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 文字输入逻辑
 *
 * @author komorebi
 */
public class InputService {

    private static final Pattern INPUT_STRING_PATTERN = Pattern.compile(" {2,}");

    public void inputString() {
        System.out.println("输入您的字符串");
        Common.INPUT.nextLine();

        String str = Common.INPUT.nextLine();
        this.verifyInputString(str);

        Common.CONTENT = str;
    }

    /**
     * 验证输入的字符串
     */
    private void verifyInputString(String value) {
        Matcher m = INPUT_STRING_PATTERN.matcher(value);

        if (m.find()) {
            throw new IllegalArgumentException("不可以出现连续空格...");
        }
    }
}
