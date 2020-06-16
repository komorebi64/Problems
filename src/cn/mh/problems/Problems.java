package cn.mh.problems;

import cn.mh.problems.common.Common;
import cn.mh.problems.exception.BusinessException;
import cn.mh.problems.utils.InputUtils;
import cn.mh.problems.view.Menu;

/**
 * 电子读书器高亮选择功能
 *
 * @author komorebi
 */
public class Problems {

    public static void main(String[] args) {
        try {
            mainHandler();
        }catch (Exception e){
            System.out.println("看样子发生了异常情况:" + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void mainHandler() {
        while (true) {
            try {
                Menu.printMainMenu();

                if (Menu.select() == Common.EXIT_SIGN) {
                    return;
                }
            } catch (BusinessException e) {
                System.out.println("操作失败：" + e.getMessage());
                InputUtils.pauseAndPrompt();
            }
        }
    }
}
