package cn.mh.problems.service;

import cn.mh.problems.linked.DoublyLinkedList;
import cn.mh.problems.linked.LinkedList;

import java.util.List;

/**
 * 文字高亮逻辑
 *
 * @author komorebi
 */
public class TextHighlightService {

    /**
     * 高亮状态值
     */
    private List<Boolean> highlightState;

    /**
     * 操作记录
     */
    private final LinkedList<List<Boolean>> operationRecord = new DoublyLinkedList<>();

    /**
     * 进行高亮选择
     */
    public void selectString() {
        init();
    }

    /**
     * 初始化
     */
    private void init() {
    }
}
