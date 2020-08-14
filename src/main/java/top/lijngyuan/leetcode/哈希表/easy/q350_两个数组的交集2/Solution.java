package top.lijngyuan.leetcode.哈希表.easy.q350_两个数组的交集2;

//给定两个数组，编写一个函数来计算它们的交集。
//
//
//
// 示例 1：
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
//
//
// 示例 2:
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9]
//
//
//
// 说明：
//
//
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
// 我们可以不考虑输出结果的顺序。
//
//
// 进阶：
//
//
// 如果给定的数组已经排好序呢？你将如何优化你的算法？
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
// 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
//
// Related Topics 排序 哈希表 双指针 二分查找
// 👍 376 👎 0

import java.util.*;

/**
 * Solution
 *
 * @author <a href="kangjinghang@gmail.com">kangjinghang</a>
 * @date 2020-08-14
 * @since 1.0.0
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        int[] intersect = intersect(nums1, nums2);
        System.out.println(Arrays.toString(intersect));
        nums1 = new int[]{4, 9, 5};
        nums2 = new int[]{9, 4, 9, 8, 4};
        intersect = intersect(nums1, nums2);
        System.out.println(Arrays.toString(intersect));
        nums1 = new int[]{1, 2, 3, 4, 4, 13};
        nums2 = new int[]{1, 2, 3, 9, 10};
        intersect = sortedIntersect(nums1, nums2);
        System.out.println(Arrays.toString(intersect));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        // 遍历第一个数组，并在哈希表中记录第一个数组中的每个数字以及对应出现的次数
        for (int i : nums1) {
            Integer count = map.getOrDefault(i, 0) + 1;
            map.put(i, count);
        }
        List<Integer> list = new ArrayList<>();
        // 遍历第二个数组
        for (int j : nums2) {
            Integer count = map.getOrDefault(j, 0);
            // 对于第二个数组中的每个数字，如果在哈希表中存在这个数字，则将该数字添加到答案，并减少哈希表中该数字出现的次数
            if (count > 0) {
                count--;
                if (count > 0) {
                    map.put(j, count);
                } else {
                    map.remove(j);
                }
                list.add(j);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    /*
     *  进阶
     */
    public static int[] sortedIntersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        int[] result = new int[nums1.length];
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);

        int index = 0, i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            // 如果两个指针的元素不相等，我们将小的一个指针后移
            if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                // 如果两个数字相等，将该数字添加到答案，并将两个指针都右移一位
                result[index++] = nums1[i++];
                j++;
            }
        }
        return Arrays.copyOfRange(result, 0, index);
    }

}
