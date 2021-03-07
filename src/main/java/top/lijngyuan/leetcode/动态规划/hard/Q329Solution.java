package top.lijngyuan.leetcode.动态规划.hard;
//给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
//
// 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
//
//
//
// 示例 1：
//
//
//输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
//输出：4
//解释：最长递增路径为 [1, 2, 6, 9]。
//
// 示例 2：
//
//
//输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
//输出：4
//解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
//
//
// 示例 3：
//
//
//输入：matrix = [[1]]
//输出：1
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 200
// 0 <= matrix[i][j] <= 231 - 1
//
// Related Topics 深度优先搜索 拓扑排序 记忆化
// 👍 433 👎 0

/**
 * q320 solution
 *
 * @author <a href="kangjh@shukun.net">kangjinghang</a>
 * @date 2021-03-07
 * @since 1.0.0
 */
public class Q329Solution {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{new int[]{9, 9, 4}, new int[]{6, 6, 8}, new int[]{2, 1, 1}};
        System.out.println(longestIncreasingPath(matrix));
    }

    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int res = 0;
        int row = matrix.length;
        int col = matrix[0].length;

        // 同一个单元格会被访问多次，每次访问都要重新计算。由于同一个单元格对应的最长递增路径的长度是固定不变的，因此可以使用记忆化的方法进行优化。
        // 用矩阵 dp 作为缓存矩阵，已经计算过的单元格的结果存储到缓存矩阵中，相邻的搜索过了就不用再次搜索了
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 如果dp[i][j] == 0，说明以当前单元格为起点，还没有搜索过，就是调用dfs()去搜索
                if (dp[i][j] == 0) {
                    dfs(matrix, i, j, Integer.MIN_VALUE, dp);
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }

    /**
     * 使用深度优先搜索，返回以当前单元格(row,col)为起点的，最大递增路径的长度。
     * 如果 dp[row][col] != 0，说明该单元格的结果已经搜索过，则直接从缓存中读取结果，
     * 如果 dp[row][col] == 0，说明该单元格的结果尚未被计算过，则进行搜索，并将计算得到的结果存入 dp 中。
     */
    private static int dfs(int[][] matrix, int row, int col, int prev, int[][] dp) {
        // prev 是相邻的单元格的值，从那个相邻单元格搜索过来，如果相邻单元格的值 >= 当前单元格，就是不符合条件，返回0
        // （从当前单元格开始，四个方向都没有能递增起来的长度）
        if (row > matrix.length - 1 || row < 0 || col > matrix[0].length - 1 || col < 0 || prev >= matrix[row][col]) {
            return 0;
        }
        if (dp[row][col] != 0) {
            return dp[row][col];
        }
        int left = dfs(matrix, row, col - 1, matrix[row][col], dp);
        int right = dfs(matrix, row, col + 1, matrix[row][col], dp);
        int up = dfs(matrix, row - 1, col, matrix[row][col], dp);
        int down = dfs(matrix, row + 1, col, matrix[row][col], dp);
        // 找到四个方向的能递增的最大路径长度，加上1，就是当前单元格能递增的最大路径长度
        dp[row][col] = Math.max(left, Math.max(right, Math.max(up, down))) + 1;
        return dp[row][col];
    }

}
