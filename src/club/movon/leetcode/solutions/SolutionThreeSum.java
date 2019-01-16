package club.movon.leetcode.solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 *
 * @author zhangzhipeng
 * @date 2019-01-14
 */

public class SolutionThreeSum {
    
    
    /**
     * 思路：
     * 1.排序
     * 2.从左往右依次计算 twoSum答案，如果当前元素与前一个元素相同则跳过
     * <p>
     * 排序可以保证：
     * 1.排序之后 相同元素跳过，不会返回重复的答案
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        qSort(nums, 0, nums.length - 1);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = 0 - nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            List<List<Integer>> lists = twoSumHashOnce(nums, target, start, end);
            result.addAll(lists);
        }
        
        return result;
    }
    
    public List<List<Integer>> twoSumHashOnce(int[] nums, int target, int start, int end) {
        Set<Integer> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            int diff = target - nums[i];
            if (set.contains(diff)) {
                List<Integer> list = new ArrayList<>();
                list.add(0 - target);
                list.add(diff);
                list.add(nums[i]);
                result.add(list);
            }
            set.add(nums[i]);
        }
        return result;
    }
    
    void qSort(int[] arr, int head, int tail) {
        if (head >= tail || arr == null || arr.length <= 1) {
            return;
        }
        int i = head, j = tail, pivot = arr[(head + tail) / 2];
        while (i <= j) {
            while (arr[i] < pivot) {
                ++i;
            }
            while (arr[j] > pivot) {
                --j;
            }
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                ++i;
                --j;
            } else if (i == j) {
                ++i;
            }
        }
        qSort(arr, head, j);
        qSort(arr, i, tail);
    }
    
    public static void main(String[] args) {
        SolutionThreeSum solution = new SolutionThreeSum();
        int[] nums = {-1, 0, 1, 1, 2, -1, -1 - 4};
        
        List<List<Integer>> lists = solution.threeSum(nums);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.printf("%d ", integer);
            }
            
            System.out.println();
        }
    }
}
