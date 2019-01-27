package club.movon.leetcode.solutions;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * @author zhangzhipeng
 * @date 2019/1/26
 */
public class SolutionMedianOfTwoSortedArrays {

    /**
     * 单次循环 复杂度O(m+n)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int index1 = 0;
        int index2 = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        int target = len / 2;
        int[] num = new int[len1 + len2];
        int index = 0;
        while (index1 < len1 || index2 < len2) {
            if (index1 == len1) {
                num[index++] = nums2[index2++];
            } else if (index2 == len2) {
                num[index++] = nums1[index1++];
            } else {
                if (nums1[index1] > nums2[index2]) {
                    num[index++] = nums2[index2++];
                } else {
                    num[index++] = nums1[index1++];
                }
            }
            if (index == target + 1) {
                break;
            }
        }
        if (len % 2 == 1) {
            return num[target];
        } else {
            return ((double) (num[target] + num[target - 1])) / 2;
        }
    }
    
    

    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {2};

        SolutionMedianOfTwoSortedArrays solution = new SolutionMedianOfTwoSortedArrays();
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }
}
