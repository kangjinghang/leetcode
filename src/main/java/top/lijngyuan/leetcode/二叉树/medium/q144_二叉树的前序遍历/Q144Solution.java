package top.lijngyuan.leetcode.二叉树.medium.q144_二叉树的前序遍历;

//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
//
//
//
// 示例 1：
//
//
//输入：root = [1,null,2,3]
//输出：[1,2,3]
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
//输入：root = [1]
//输出：[1]
//
//
// 示例 4：
//
//
//输入：root = [1,2]
//输出：[1,2]
//
//
// 示例 5：
//
//
//输入：root = [1,null,2]
//输出：[1,2]
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [0, 100] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？
// Related Topics 栈 树
// 👍 514 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

import java.util.*;

/**
 * Solution
 *
 * @author <a href="kangjh@shukun.net">kangjinghang</a>
 * @date 2021-02-22
 * @since 1.0.0
 */
public class Q144Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root.right = node2;
        node2.left = node3;
        System.out.println(preorderTraversal(root));
    }

    public static List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        res.add(root.val);
        if (root.left != null) {
            res.addAll(preorderTraversal(root.left));
        }
        if (root.right != null) {
            res.addAll(preorderTraversal(root.right));
        }
        return res;
    }

    /**
     * 迭代式
     * 前序遍历，父节点，左子节点，右子节点
     * <br>
     * 1
     * /   \
     * 2     3
     * stack reversed order，假设只有 父 左 右，则需要把父放进栈，然后pop出父，然后放进右，放进左，pop出左，pop出右，这样的话就能先打印左，再打印右了
     * <ol>
     *  <li>push root to stack
     *  <li>loop:
     *  <li>cur = stack.pop()
     *      <br>
     *      print(cur.val)
     *  <li>push cur.right to stack
     *      <br>
     *      push cur.left to stack
     * </ol>
     *
     * @param root root
     * @return result
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }

    private static class TreeNode {
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

}

