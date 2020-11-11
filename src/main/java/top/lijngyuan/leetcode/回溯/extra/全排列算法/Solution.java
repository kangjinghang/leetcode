package top.lijngyuan.leetcode.回溯.extra.全排列算法;

//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
//示例1:
//输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
//

import java.util.ArrayList;
import java.util.List;

/**
 * Solution
 *
 * @author <a href="kangjh@shukun.net">kangjinghang</a>
 * @date 2020-11-11
 * @since 1.0.0
 */
public class Solution {

    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        return dfs(nums, new ArrayList<>());
    }

    public static List<List<Integer>> dfs(int[] nums, List<Integer> temp) {
        // 当枚举到最后一位的时候，这个就是我们要的排列结果，所以我们要放入到全排列结果集中。
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
        } else {
            for (int num : nums) {
                if (!temp.contains(num)) {
                    temp.add(num);
                    dfs(nums, temp);
                    // 在回到上一位时，我们要就把上一次的选择结果撤销掉。不然如果你之前选过了，后面不就不能继续用了
                    // 即，为 temp.add(num); 的撤销操作，避免 temp.add(num) 后 没有回退，对 !temp.contains(num) 产生的影响
                    temp.remove(temp.size() - 1);
                }
            }
        }
        return result;
    }

}
