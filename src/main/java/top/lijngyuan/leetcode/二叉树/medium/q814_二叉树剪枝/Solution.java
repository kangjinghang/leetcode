package top.lijngyuan.leetcode.二叉树.medium.q814_二叉树剪枝;
//给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。
//
// 返回移除了所有不包含 1 的子树的原二叉树。
//
// ( 节点 X 的子树为 X 本身，以及所有 X 的后代。)
//
//
//示例1:
//输入: [1,null,0,0,1]
//输出: [1,null,0,null,1]
//
//解释:
//只有红色节点满足条件“所有不包含 1 的子树”。
//右图为返回的答案。
//
//
//
//
//
//示例2:
//输入: [1,0,1,0,0,0,1]
//输出: [1,null,1,null,1]
//
//
//
//
//
//
//示例3:
//输入: [1,1,0,1,1,0,1,0]
//输出: [1,1,0,1,1,null,1]
//
//
//
//
//
// 说明:
//
//
// 给定的二叉树最多有 100 个节点。
// 每个节点的值只会为 0 或 1 。
//
// Related Topics 树
// 👍 121 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Solution
 *
 * @author <a href="kangjh@shukun.net">kangjinghang</a>
 * @date 2020-11-11
 * @since 1.0.0
 */
public class Solution {

    public static void main(String[] args) {
        // 1,null,0,0,1
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(0);
        root.right = node2;
        TreeNode node21 = new TreeNode(0);
        TreeNode node22 = new TreeNode(1);
        node2.left = node21;
        node2.right = node22;
        pruneTree(root);
    }

    public static TreeNode pruneTree(TreeNode root) {
        if(root == null){
            return null;
        }
        // 从底层往上递归
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        // 剪枝，如果当前结点的左右节点皆为空，且当前结点为0，我们就将当前节点剪掉即可。
        if(root.left == null && root.right == null && root.val == 0){
            return null;
        }
        return root;
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
}