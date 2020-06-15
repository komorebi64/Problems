package cn.mh.problems.utils;

import cn.mh.problems.common.Common;

/**
 * 输入输出工具
 *
 * @author komorebi
 */
public class InputUtil {
    /**
     * 整数输入
     */
    public static int nextInt() {
        try {
            return Common.INPUT.nextInt();
        }catch (Exception ignore){
            // 避免文本缓冲区的内容不会消失
            Common.INPUT.next();
            return -1;
        }
    }

    /**
     * 暂停并提示
     */
    public static void pauseAndPrompt(){
        System.out.println("按回车键继续...");
        Common.INPUT.nextLine();
        Common.INPUT.nextLine();
    }
}
