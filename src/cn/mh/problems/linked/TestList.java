package cn.mh.problems.linked;

/**
 * 对链表工具类进行测试
 *
 * @author komorebi
 * @date  2019/8/4 15:18
 */
public class TestList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new DoublyLinkedList<>();

        list.append(123);
        list.append(213);
        list.append(223);
        list.append(333);

        // 输出全部节点的信息
        list.show();

        // 节点的长度（多少个）
        System.out.println("长度"+list.size());
        System.out.println("----------");

        // 查询一个节点值是否存在
        System.out.println("查找"+list.exist(223));
        System.out.println("----------");

        // list.clear();
        // 删除一个值 返回布尔类型
        System.out.println("删除"+list.remove(213));
        System.out.println("删除"+list.remove(213));
        System.out.println("----------");
        list.show();
        System.out.println("长度"+list.size());

    }
}
