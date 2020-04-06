package com.example.design.pattern.algorithms.datastructure.tree;

public class BinarySortTreeNode {
    int value;
    BinarySortTreeNode left;
    BinarySortTreeNode right;

    public BinarySortTreeNode(int value) {
        this.value = value;
    }

    public void add(BinarySortTreeNode node) {
        // 如果node为空直接返回
        if (node == null) {
            return;
        }

        // node值小于当前值，将其加到左子森林
        if (node.value < this.value) {
            // 当前值的无左节点，将node加到左节点
            if (this.left == null) {
                this.left = node;
            } else {
                // 如果有则递归
                this.left.add(node);
            }
        } else {
            // node值大于当前值，将其加到右子森林
            // 当前值的无右节点，将node加到右节点
            if (this.right == null) {
                this.right = node;
            } else {
                // 如果有则递归
                this.right.add(node);
            }
        }

        /***********************************/
        // 以下代码将二叉搜索树转化为平衡二叉树
        /***********************************/

        // 查询是否平衡
        if (leftHeight() - rightHeight() > 1) {
            // 双旋转
            if (left != null && left.leftHeight() < left.rightHeight()) {
                left.leftRotate();
            }
            rightRotate();
        }

        if (leftHeight() - rightHeight() < -1) {
            // 双旋转
            if (right != null && right.leftHeight() < right.rightHeight()) {
                right.rightHeight();
            }
            leftRotate();
        }
    }

    /**
     * 左旋，当左子树高度-右子树高度<-1时，以当前节点的基础上左旋
     * 当前节点为右子节点的左子节点，原右子节点的左子节点为当前节点的右子节点
     */
    private void leftRotate() {
        // 已当前节点的value新建一个节点
        BinarySortTreeNode newLeft = new BinarySortTreeNode(value);
        // 把当前节点的左子节点赋给新节点的左子节点
        newLeft.left = left;
        // 把当前节点的右子节点的左子节点符合新节点的右子节点
        newLeft.right = right.left;
        // 把当前节点值更新为其右子节的值
        value = right.value;
        // 把当前节点的右子节点赋值为右子节点的右子节点
        right = right.right;
        // 把当前节点的左子节点赋值为新节点
        left = newLeft;
    }

    /**
     * 右旋，当左子树高度-右子树高度>1时，以当前节点的基础上右旋
     * 当前节点为左子节点的右子节点，原左子节点的右子节点为当前节点的左子节点
     */
    private void rightRotate() {
        // 已当前节点的value新建一个节点
        BinarySortTreeNode newRight = new BinarySortTreeNode(value);
        // 把当前节点的右子节点赋给新节点的右子节点
        newRight.right = right;
        // 把当前节点的左子节点的右子节点符合新节点的左子节点
        newRight.left = left.right;
        // 把当前节点值更新为其左子节的值
        value = left.value;
        // 把当前节点的左子节点赋值为左子节点的左子节点
        left = left.left;
        // 把当前节点的右子节点赋值为新节点
        right = newRight;
    }

    public int leftHeight() {
        if (left == null) {
            return 0;
        }

        return left.height();
    }

    public int rightHeight() {
        if (right == null) {
            return 0;
        }

        return right.height();
    }

    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    public void midShow(BinarySortTreeNode node) {
        if (node == null) return;

        midShow(node.left);
        System.out.println(node.value);
        midShow(node.right);
    }

    /**
     * 搜索某个节点
     *
     * @param value
     * @return
     */
    public BinarySortTreeNode search(int value) {
        // 如果value等于当前节点值，返回
        if (this.value == value) {
            return this;
        }

        // 当前节点值大于value，则在左子森林中判断
        if (this.value > value) {
            // 当前节点的左子树不为空，递归
            if (left != null) {
                return left.search(value);
            }
        }

        // 当前节点值小于value，则在右子森林中判断
        if (this.value < value) {
            // 当前节点的右子树不为空，递归
            if (right != null) {
                return right.search(value);
            }
        }

        return null;
    }

    /**
     * 找到其父节点
     *
     * @param value
     * @return
     */
    public BinarySortTreeNode searchParentNode(int value) {
        // 当前节点的左/右子节点不为空且等于value，则返回当前节点
        if ((this.left != null && this.left.value == value)
                || (this.right != null && this.right.value == value)) {
            return this;
        } else {
            // 当前节点的值大于value且有左子节点，则在其左子森林中找父节点
            if (this.value > value && this.left != null) {
                return this.left.searchParentNode(value);
            }

            // 当前节点的值小于value且有右子节点，则在其右子森林中找父节点
            if (this.value < value && this.right != null) {
                return this.right.searchParentNode(value);
            }

            return null;
        }
    }
}
