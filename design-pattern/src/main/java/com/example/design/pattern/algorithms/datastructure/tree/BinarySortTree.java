package com.example.design.pattern.algorithms.datastructure.tree;

/**
 * 二叉排序树，特点是当前节点的权大于其做节点且小于其右节点，类似于中序遍历
 */
public class BinarySortTree {

    BinarySortTreeNode root;

    /**
     * 添加节点
     *
     * @param node
     */
    public void add(BinarySortTreeNode node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    /**
     * 中序遍历
     */
    public void midShow() {
        if (root != null) {
            root.midShow(root);
        }
    }

    /**
     * 查找某个节点
     *
     * @param value
     * @return
     */
    public BinarySortTreeNode search(int value) {
        if (root == null) {
            return null;
        }

        return root.search(value);
    }

    /**
     * 根据值删除某个节点，分三种情况：
     * 1.删除叶子节点
     * 2.删除非叶子节点且只有一个子节点
     * 3.删除非叶子节点且有两个子节点
     *
     * @param value
     */
    public void delete(int value) {
        // 根节点为空，直接返回
        if (root == null) {
            return;
        }

        // 通过值找到该节点
        BinarySortTreeNode target = search(value);
        // 若为空直接返回
        if (target == null) {
            return;
        }

        // 找到其父节点
        BinarySortTreeNode parent = searchParentNode(value);

        // 该节点没有子节点
        if (target.left == null && target.right == null) {
            // 如果其父节点的左子节点的值等于value，则将父节点的左子节点置为null
            if (parent.left.value == value) {
                parent.left = null;
            } else {
                // 如果其父节点的右子节点的值等于value，则将父节点的右子节点置为null
                parent.right = null;
            }
        } else if (target.left != null && target.right != null) {
            // 该节点有两个子节点
            // 找到除了该节点的后继节点，并删除
            int after = deleteAfter(target.right);
            // 将后继节点的值赋给该节点，即可完成该节点的删除
            target.value = after;
        } else {
            // 该节点只有一个子节点
            // 如果是左子节点
            if (target.left != null) {
                // 如果其父节点的左子节点等于value，则将其左子节点赋给其父节点的左子节点
                if (parent.left.value == value) {
                    parent.left = target.left;
                } else {
                    // 否则，则将其左子节点赋给其父节点的右子节点
                    parent.right = target.left;
                }
            } else {
                // 如果是右子节点
                // 如果其父节点的左子节点等于value，则将其右子节点赋给其父节点的左子节点
                if (parent.left.value == value) {
                    parent.left = target.right;
                } else {
                    // 否则，则将其右子节点赋给其父节点的右子节点
                    parent.right = target.right;
                }
            }
        }
    }

    /**
     * 找到目标节点的后继节点，其后继节点一定在其右子森林中，然后删除之，并且将其值付给目标节点
     *
     * @param node
     * @return
     */
    private int deleteAfter(BinarySortTreeNode node) {
        // 初始化后继节点
        BinarySortTreeNode after = node;
        // 如果后继节点有左子节点，说明后继节点不是真正后继的节点，则将其左子节点付给后继节点，且一直循环遍历直到后继节点没有左子节点，则为真正的后继节点
        while (after.left != null) {
            after = after.left;
        }

        // 删除后继节点，必为左叶子节点
        delete(after.value);

        // 返回后继节点的值
        return after.value;
    }

    /**
     * 通过值找到其父节点
     *
     * @param value
     * @return
     */
    public BinarySortTreeNode searchParentNode(int value) {
        // 根节点为空，直接返回
        if (root == null) {
            return null;
        }

        return root.searchParentNode(value);
    }

}
