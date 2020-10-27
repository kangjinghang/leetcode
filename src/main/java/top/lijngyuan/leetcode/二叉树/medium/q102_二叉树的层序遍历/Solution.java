package top.lijngyuan.leetcode.二叉树.medium.q102_二叉树的层序遍历;
//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//
//
//
// 示例：
//二叉树：[3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其层次遍历结果：
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
//
// Related Topics 树 广度优先搜索
// 👍 675 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Solution
 *
 * @author <a href="kangjh@shukun.net">kangjinghang</a>
 * @date 2020-10-27
 * @since 1.0.0
 */
public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        root.left = node9;
        root.right = node20;
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        node20.left = node15;
        node20.right = node7;
        List<List<Integer>> res = levelOrder1(root);
        System.out.println(res);
    }

    public static List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int currentLevelSize = queue.size();
            // 使用Queue的数据结构。我们将root节点初始化进队列，通过消耗尾部，插入头部的方式来完成BFS。
            for (int i = 1; i <= currentLevelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }


    public static List<List<Integer>> levelOrder(TreeNode root) {
        // 用来存放最终结果
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    /**
     * dfs的方式逐层遍历二叉树
     *
     * @param node  二叉树上的每个节点
     * @param level 当前处理的二叉树上的哪一层
     * @param res   最终结果
     */
    public static void dfs(TreeNode node, int level, List<List<Integer>> res) {
        if (node == null) {
            return;
        }
        List<Integer> nums;
        if (level == res.size()) {
            // 假设res 现在是[ [3],[9,20] ]，level到了下一层，是2，就再插入一个空list放到res中
            nums = new ArrayList<>();
            res.add(nums);
        } else {
            nums = res.get(level);
        }
        // 将当前节点的值加入到res中，level代表当前层，假设index是2，节点值是7
        // res是[ [3],[9,20], [15] ]，加入后res就变为 [ [3],[9,20], [15,7] ]
        nums.add(node.val);

        // 递归的处理左子树，右子树的下一层，同时将层数level+1
        dfs(node.left, level + 1, res);
        dfs(node.right, level + 1, res);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}