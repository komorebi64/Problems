package cn.mh.problems;

import cn.mh.problems.common.Common;
import cn.mh.problems.service.InputService;
import cn.mh.problems.service.TextHighlightService;
import cn.mh.problems.utils.InputUtils;

/**
 * 菜单输出
 *
 * @author komorebi
 */
public class Menu {

    private static final InputService inputService = new InputService();
    private static final TextHighlightService highlightService = new TextHighlightService();

    /**
     * 主菜单输出
     */
    public static void printMainMenu(){
        System.out.println("------------------------------\n" +
                "\t1. 输入字符串\n" +
                "\t2. 查看当前输入内容\n" +
                "\t3. 进行字符串选择\n" +
                "\t4. 清除输入的内容\n" +
                "\t5. 回滚至上一步操作\n" +
                "\t6. 撤销回滚\n" +
                "\t7. 查看操作记录\n" +
                "\t8. 退出\n" +
                "------------------------------");
    }

    /**
     * 菜单选择
     */
    public static int select() {

        int inputInt = InputUtils.nextInt();
        switch (inputInt) {
            case 1:
                inputService.inputString();
                highlightService.init();
                break;
            case 2:
                System.out.println("您的当前输入字符串：\n\t" + Common.CONTENT);
                InputUtils.pauseAndPrompt();
                break;
            case 3:
                highlightService.selectString();
                break;
            case 4:
                Common.CONTENT = null;
                System.out.println("完成清除");
                break;
            case 5:
            case 6:
            case 7:
                highlightService.showOperationRecord();
                InputUtils.pauseAndPrompt();
                break;
            case 8:
                System.out.println("拜拜ヾ(•ω•`)o");
                return inputInt;
            default:
                System.out.println("错误的输入？");
                InputUtils.pauseAndPrompt();
        }
        return inputInt;
    }
}
