package top.lijngyuan.leetcode.二叉树.medium.q450_删除二叉搜索树中的节点;
//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的
//根节点的引用。
//
// 一般来说，删除节点可分为两个步骤：
//
//
// 首先找到需要删除的节点；
// 如果找到了，删除它。
//
//
// 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
//
// 示例:
//
//
//root = [5,3,6,2,4,null,7]
//key = 3
//
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//
//一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//
//    5
//   / \
//  4   6
// /     \
//2       7
//
//另一个正确答案是 [5,2,6,null,4,null,7]。
//
//    5
//   / \
//  2   6
//   \   \
//    4   7
//
// Related Topics 树
// 👍 315 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Solution
 *
 * @author <a href="kangjh@shukun.net">kangjinghang</a>
 * @date 2020-10-29
 * @since 1.0.0
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        root.left = node3;
        root.right = node6;

        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        node3.left = node2;
        node3.right = node4;

        TreeNode node7 = new TreeNode(7);
        node6.right = node7;

        root = deleteNode(root, 3);
        root.print();
    }


    /**
     * 删除以 root 为根结点的子树上 val 是 key 的节点，返回根结点 root
     * <p>
     * 1. 如果要删除的节点是叶子节点，我们直接删除即可。
     * 2. 如果删除的结点不是叶子节点，待删除的节点左子树为空，让待删除节点的右子树替代自己。
     * 3. 如果删除的结点不是叶子节点，待删除的节点右子树为空，让待删除节点的左子树替代自己。
     * 4.1 (方案一)如果待删除的节点的左右子树都不为空。我们需要找到比当前节点小的最大节点（前驱），来替换自己
     * 4.2 (方案二)或者比当前节点大的最小节点（后继），来替换自己。
     */
    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        // 通过递归的方式要先找到要删除的结点
        if (key < root.val) {
            // 要删除的节点在左子树上，返回以 left 作为根结点的结果，仍然赋值给 left
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            // 要删除的节点在右子树上，返回以 right 作为根结点的结果，仍然赋值给 right
            root.right = deleteNode(root.right, key);
        } else {
            // 找到了要删除的节点。
            // 如果左子树为空，我们只需要返回右子树即可
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }
            // 说明两个子节点都不为空，我们可以找左子树的最大值，
            // 也可以找右子树的最小值替换

            // 这里是用右子树的最小值替换
            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);

            // 这里是用左子树的最大值替换
//            TreeNode maxNode = findMax(root.left);
//            root.val = maxNode.val;
//            // 在左子树上删除 替换root节点的这个新节点（因为新节点要替换root）
//            root.left = deleteNode(root.left, maxNode.val);
        }
        return root;
    }

    /**
     * 找到当前节点的左子树上的最小节点，没有比自己节点小的节点返回自己。
     */
    private static TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    /**
     * 找到当前节点的右子树上的最大节点，没有比自己节点大的节点返回自己。
     */
    private static TreeNode findMax(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    void print() {
        if (this.left != null) {
            this.left.print();
        }
        System.out.print("\t" + val);
        if (this.right != null) {
            this.right.print();
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TreeNode{");
        sb.append("val=").append(val);
        sb.append('}');
        return sb.toString();
    }
}
