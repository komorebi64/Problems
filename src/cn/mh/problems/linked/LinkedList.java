package cn.mh.problems.linked;

/**
 * ClassName Linked
 *
 * @author komorebi
 * @date 2019
 */
public interface LinkedList<T> extends Iterable<T> {

    /**
     * 将一个新项添加到链表的末尾  使其成为集合中的最后一项
     *
     * @param value 待添加的值
     */
    void append(T value);

    /**
     * 从链表中删除该项
     *
     * @param value 需要 value 作为参数并修改链表
     * @return 修改成功
     */
    boolean remove(T value);

    /**
     * 搜索链表中的项目
     *
     * @param value 需要 item 作为参数 返回一个布尔值
     * @return 传递的 value 是否存在于链表中
     */
    boolean exist(T value);

    /**
     * 检查链表是否为空
     *
     * @return 链表是否为空
     */
    boolean isEmpty();

    /**
     * 清除整个链表
     */
    void clear();

    /**
     * 返回链表中的项数
     * @return 链表中的项数
     */
    int size();

    /**
     * 输出整个链表内容 仅供测试
     */
    @Deprecated
    void show();

}


