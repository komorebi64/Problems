package cn.mh.problems.utils;

import java.util.List;
import java.util.Objects;

/**
 * 自己定义的集合工具类
 *
 * @author komorebi
 */
public class Collections {

    /**
     * 集合范围替换
     */
    public static <T> void fill(List<? super T> list, T obj, int begin, int end) {
        if (end > list.size()) {
            throw new IndexOutOfBoundsException("end Position Is Greater Than List Size");
        }
        for (int i = begin; i < end; i++) {
            list.set(i, obj);
        }
    }

    /**
     * 整体替换
     */
    public static <T> void fill(List<? super T> list, T obj) {
        fill(list, obj, 0, list.size());
    }

    /**
     * 判断某一区域内容相同
     *
     * @return 所选区域内值一致则返回 true，反之 false
     */
    public static <T> boolean isSameContent(List<? super T> list, int begin, int end) {
        for (int i = begin; i < end; i++) {
            if (!list.get(i).equals(list.get(i + 1))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 统计一个元素出现的次数
     */
    public static <T> int counter(List<? super T> list, T obj){
        int count = 0;

        for (Object o : list) {
            if (Objects.equals(o, obj)) {
                count++;
            }
        }

        return count;
    }
}
