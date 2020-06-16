package cn.mh.problems.utils;

import java.util.Objects;

/**
 * 字符串工具
 *
 * @author komorebi
 */
public class StringUtils {

    public static boolean isEmpty(String value){
        return Objects.isNull(value) | "".equals(value);
    }
}
