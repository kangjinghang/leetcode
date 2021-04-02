package top.lijngyuan.leetcode.二叉树.medium.q144_二叉树展开为链表;
//给你二叉树的根结点 root ，请你将它展开为一个单链表：
//
//
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。
//
//
//
//
// 示例 1：
//
//
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
//
//
// 示例 2：
//
//
//输入：root = []
//输出：[]
//
//
// 示例 3：
//
//
//输入：root = [0]
//输出：[0]
//
//
//
//
// 提示：
//
//
// 树中结点数在范围 [0, 2000] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
// Related Topics 树 深度优先搜索
// 👍 768 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * q144 solution
 *
 * @author <a href="kangjinghang@gmail.com">kangjinghang</a>
 * @date 2021-04-02
 * @since 1.0.0
 */
public class Q144Solution {

    public static void main(String[] args) {
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5);
        node5.right = node6;

        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2, node3, node4);

        TreeNode node1 = new TreeNode(1, node2, node5);
        flatten(node1);
    }

    /**
     * 将以 root 为根的树拉平为链表
     */
    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        // root 的左右子树拉平
        flatten(root.left);
        flatten(root.right);

        /**** 后序遍历位置 ****/
        // 1、左右子树已经被拉平成一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 2、将左子树作为右子树
        root.left = null;
        root.right = left;

        // 3、将原先的右子树接到当前右子树（left）的末端
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }

    public static List<TreeNode> preorderTravel(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        res.add(root);
        if (root.left != null) {
            res.addAll(preorderTravel(root.left));
        }
        if (root.right != null) {
            res.addAll(preorderTravel(root.right));
        }
        return res;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

}
