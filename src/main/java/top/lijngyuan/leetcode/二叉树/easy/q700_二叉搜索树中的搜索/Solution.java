package top.lijngyuan.leetcode.二叉树.easy.q700_二叉搜索树中的搜索;
//给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
//
// 例如，
//
//
//给定二叉搜索树:
//
//        4
//       / \
//      2   7
//     / \
//    1   3
//
//和值: 2
//
//
// 你应该返回如下子树:
//
//
//      2
//     / \
//    1   3
//
//
// 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
// Related Topics 树
// 👍 95 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Solution
 *
 * @author <a href="kangjh@shukun.net">kangjinghang</a>
 * @date 2020-10-28
 * @since 1.0.0
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        root.left = node2;
        root.right = node7;
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node2.left = node1;
        node2.right = node3;
        System.out.println(searchBST(root, 2).left.val);
        System.out.println(searchBST(root, 2).right.val);
        System.out.println(searchBST1(root, 2).left.val);
        System.out.println(searchBST1(root, 2).right.val);
    }

    /**
     * 递归
     */
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    /**
     * 迭代
     */
    public static TreeNode searchBST1(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) {
                return root;
            } else if (root.val > val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
