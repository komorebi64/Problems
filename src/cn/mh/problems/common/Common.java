package cn.mh.problems.common;

import java.util.Scanner;

/**
 * 共享值
 *
 * @author komorebi
 */
public class Common {

    public static final Scanner INPUT = new Scanner(System.in);

    /**
     * 文本内容
     */
    public static String CONTENT;

    /**
     * 文本内容的 hashcode 用于检查文本内容被替换
     */
    public static int CONTENT_HASHCODE;

    /**
     * 退出指示数字
     */
   public static final int EXIT_SIGN = 7;

}
