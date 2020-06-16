package cn.mh.problems.service;

import cn.mh.problems.common.Common;
import cn.mh.problems.exception.BusinessException;
import cn.mh.problems.linked.DoublyLinkedList;
import cn.mh.problems.linked.LinkedList;
import cn.mh.problems.pojo.TextHighlightDO;
import cn.mh.problems.utils.Collections;
import cn.mh.problems.utils.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 文字高亮逻辑
 *
 * @author komorebi
 */
public class TextHighlightService {

    /**
     * 文本内容的 hashcode 用于检查文本内容被替换
     */
    private int contentHashcode;

    /**
     * 操作记录
     */
    private LinkedList<TextHighlightDO> operationRecord;


    /**
     * 初始化
     */
    public void init() {
        if (this.stringChanges()) {
            operationRecord = new DoublyLinkedList<>();
            contentHashcode = Common.CONTENT.hashCode();
        }
    }

    /**
     * 进行高亮选择
     */
    public void selectString() {
        this.validateInput();
        System.out.println("请输入开始位置：");
        int begin = Common.INPUT.nextInt();
        System.out.println("请输入结束位置：");
        int end = Common.INPUT.nextInt();

        this.validateInputNumber(begin, end);

        TextHighlightDO highlightDO = new TextHighlightDO(begin, end);
        operationRecord.append(highlightDO);
    }

    /**
     * 展示操作记录
     */
    public void showOperationRecord() {
        this.validateInput();
        System.out.println("字符串长度\t" + Common.CONTENT.length() + "\n操作次数\t\t" + operationRecord.size());

        for (TextHighlightDO highlightDO : operationRecord) {
            System.out.println(highlightDO.getBegin() + "\t\t" + highlightDO.getEnd());
        }
    }

    /**
     * 高亮统计
     */
    public int highlightCount() {
        this.validateInput();
        List<Boolean> highlightState = this.initHighlightState();

        for (TextHighlightDO highlightDO : operationRecord) {
            Integer begin = highlightDO.getBegin();
            Integer end = highlightDO.getEnd();

            if (begin.equals(end)) {
                // 选择了一格 则反转即可
                highlightState.set(begin, !highlightState.get(begin));
            }else if (Collections.isSameContent(highlightState, begin, end)) {
                // 选择区域内容相同 反转
                Collections.fill(highlightState, !highlightState.get(begin), begin, end);
            }else {
                // 选择区域内容不相同 区域全部设置为 TRUE
                Collections.fill(highlightState, Boolean.TRUE, begin, end);
            }
        }

        return Collections.counter(highlightState, Boolean.TRUE);
    }

    /**
     * 验证输入的高亮区域是否合法
     *
     * @throws BusinessException 验证失败时抛出
     */
    private void validateInputNumber(Integer begin, Integer end) {
        if (begin > end | begin < 0 & end >= 0 |
                begin > Common.CONTENT.length() |
                end > Common.CONTENT.length()) {

            throw new BusinessException("输入的数字不可小于等于 0，且不能大于字符串长度\n" +
                    "当前字符串长度：" + Common.CONTENT.length());
        }
    }

    /**
     * 初始化选中状态
     */
    private List<Boolean> initHighlightState() {
        int length = Common.CONTENT.length();
        List<Boolean> list = new ArrayList<>(Arrays.asList(new Boolean[length]));

        Collections.fill(list, Boolean.FALSE);
        return list;
    }

    /**
     * 字符串是否发生变化
     *
     * @return 发生变化则返回 true 反之 false
     */
    private boolean stringChanges(){
        return !Objects.equals(Common.CONTENT.hashCode(), contentHashcode);
    }

    private void validateInput(){
        if (StringUtils.isEmpty(Common.CONTENT)) {
            throw new BusinessException("还没有输入字符串...");
        }
    }
}
