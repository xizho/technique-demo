package com.example.design.pattern.algorithms.datastructure.linked;

/**
 * @Title: Node.java
 * @Package com.example.other.test.datastructure
 * @Description: 自定义循环链表
 * @author: Seen
 * @date: 2019.02.20 上午 11:00
 */

public class LoopNode {

    private int data;

    private LoopNode next = this;

    public LoopNode() {

    }

    public LoopNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    /**
     * @return void
     * @Author Seen
     * @Description 指定节点后，增加新节点
     * @Date 下午 2:07 2019-2-20
     * @Param [node]
     */
    public void after(LoopNode node) {
        LoopNode newNext = next;
        next = node;
        node.next = newNext;
    }

    /**
     * @return Node
     * @Author Seen
     * @Description 删除当前节点的后一个节点
     * @Date 下午 2:08 2019-2-20
     * @Param []
     */
    public LoopNode remove() {
        if (next != null) {
            LoopNode newNext = next.next;
            LoopNode oldNext = next;
            next = null;
            next = newNext;

            return oldNext;
        }

        return new LoopNode();
    }

    /**
     * @return Node
     * @Author Seen
     * @Description 获取下个节点
     * @Date 下午 2:08 2019-2-20
     * @Param []
     */
    public LoopNode next() {
        return next;
    }

}
