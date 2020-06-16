package cn.mh.problems.linked;

import java.util.Iterator;
import java.util.Objects;

/**
 * 自己尝试写的一个链表工具类 操作Node类
 *
 * @author komorebi
 * @date  2019/8/4 15:16
 */
public class DoublyLinkedList<T> implements LinkedList<T> {
    /**记录开头的地址值*/
    private Node<T> initiate;
    /**记录上一个地址*/
    private Node<T> last;
    /**记录长度*/
    private int size;

    @Override
    public void append(T date) {
        if (Objects.isNull(last)) {
            initiate = new Node<>(date, null, null);
            last = initiate;
        } else {
            Node<T> temp = last;
            // 创建后面的节点 并且加上 前后的节点值
            last = new Node<>(date, last, initiate);
            temp.next=last;
            // 判断头节点值的下一个节点是否为null否则加上节点
            if (initiate.next == null) {
                initiate.next=last;
            }
            initiate.last=last;
        }
        size++;
    }

    @Override
    public boolean exist(T value) {
        Node<T> temp = initiate;

        for (int i = 0; i < size; i++) {
            if (temp.date.equals(value)) {
                return true;
            }
            temp = temp.last;
        }
        return false;
    }

    @Override
    public boolean remove(T value) {
        if (isEmpty()) {
            throw new RuntimeException("Empty Doubly Linked List");
        }else if(size == 1){
            initiate = null;
            last = null;
            size =0;
            return true;
        }

        Node<T> temp = search(value);

        Node<T> last = temp.last;
        Node<T> terminate = temp.next;
        last.next= terminate;
        terminate.last=last;
        size--;
        return true;
    }

    @Override
    public void clear() {
        last = null;
        initiate = null;
        size = 0;
    }

    @Override
    public void show() {
        if (isEmpty()) {
            return;
        }
        Node<T> temp = initiate;

        for (int i = 0; i < size; i++) {
            System.out.println(temp.date);
            temp = temp.next;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return Objects.isNull(initiate);
    }


    private Node<T> search(T value) {
        Node<T> temp = initiate;

        for (int i = 0; i < size; i++) {
            if (temp.date.equals(value)) {
                return temp;
            }
            temp = temp.next;
        }
        throw new IllegalArgumentException("Target Not Found");
    }

    @Override
    public Iterator<T> iterator() {
        return new Iter();
    }

    public class Iter implements Iterator<T> {
        // 当前指针位置
        int cursor;
        Node<T> node = initiate;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public T next() {
            T date = node.date;
            node = node.next;
            cursor++;
            return date;
        }

        @Override
        public void remove() {
            DoublyLinkedList.this.remove(node.date);
        }
    }
}