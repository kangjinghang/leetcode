package top.lijngyuan.leetcode.排序.medium.q56_合并区间;

//给出一个区间的集合，请合并所有重叠的区间。
//
// 示例 1:
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//
//
// 示例 2:
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
// Related Topics 排序 数组
// 👍 550 👎 0

import java.util.*;

/**
 * Solution
 *
 * @author <a href="kangjinghang@gmail.com">kangjinghang</a>
 * @date 2020-08-13
 * @since 1.0.0
 */
public class Solution {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        // [[1,3],[2,6],[8,10],[15,18]] => [[1,6],[8,10],[15,18]]
        int[][] mergedArr = merge(intervals);
        Arrays.stream(mergedArr).forEach(arr -> System.out.print(Arrays.toString(arr)));

        System.out.println();
        System.out.println("-----------");

        intervals = new int[][]{{1, 4}, {4, 5}, {5, 10}};
        // [[1,4],[4,5],[5,10]] => [[1,10]]
        mergedArr = merge(intervals);
        Arrays.stream(mergedArr).forEach(arr -> System.out.print(Arrays.toString(arr)));
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 1) {
            return intervals;
        }
        List<int[]> result = new ArrayList<>();
        // 对起点终点进行排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int i = 0;
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            // 如果有重叠，循环判断哪个起点满足条件
            while (i + 1 < intervals.length && intervals[i + 1][0] <= right) {
                i++;
                right = Math.max(right, intervals[i][1]);
            }
            result.add(new int[]{left, right});
            // 接着判断下一个区间
            i++;
        }
        return result.toArray(new int[0][]);
    }

}
