package cn.mh.problems;

import cn.mh.problems.common.Common;
import cn.mh.problems.utils.InputUtil;

/**
 * 电子读书器高亮选择功能
 *
 * @author komorebi
 */
public class Problems {

    public static void main(String[] args) {
        try {
            mainHandle();
        }catch (Exception e){
            System.out.println("看样子发生了异常情况:" + e.getMessage());
            // e.printStackTrace();
        }
    }

    private static void mainHandle() {
        while(true) {
            try {
                Menu.printMainMenu();

                if (Menu.select() == Common.EXIT_SIGN){
                    return;
                }
            }catch (IllegalArgumentException e){
                System.out.println("啊输入错误了！"+e.getMessage());
                InputUtil.pauseAndPrompt();
            }
        }
    }
}
