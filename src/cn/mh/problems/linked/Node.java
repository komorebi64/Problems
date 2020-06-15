package cn.mh.problems.linked;

/**
     * 第一项叫做链表的头节点，必须明确指定链表的头节点；
     * 最后一项叫做链表的尾节点，必须指明尾节点没有下一项。
     *
     * 每个节点必须保存对下一个节点的引用。
     *
     * @author komorebi
     * @date  2019/8/4 15:54
     */
    public class Node<T> {
        /**存储内容*/
        T date;
        /**记录上一个地址*/
        Node<T> last;
        /**记录下一个地址*/
        Node<T> next;

        /**
         * 创建一个节点
         */
        public Node(T date, Node<T> last, Node<T> next) {
            this.date = date;
            this.last = last;
            this.next = next;
        }
    }