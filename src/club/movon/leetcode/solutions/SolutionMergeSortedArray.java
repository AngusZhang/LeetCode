package club.movon.leetcode.solutions;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * @author zhangzhipeng
 * @date 2019-01-30
 */
public class SolutionMergeSortedArray {
    
    /**
     * 计算合并后数组大小
     * 两个数组从右往左遍历，将最大的数放到没有数的最右的空位
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int index1 = m - 1;
        int index2 = n - 1;
        int end = m + n - 1;
        while (index1 >= 0 || index2 >= 0) {
            if (index2 < 0) {
                break;
            }
            if (index1 < 0) {
                nums1[end--] = nums2[index2--];
            } else {
                nums1[end--] = nums1[index1] > nums2[index2] ? nums1[index1--] : nums2[index2--];
            }
        }
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        
        SolutionMergeSortedArray solution = new SolutionMergeSortedArray();
        solution.merge(nums1, 3, nums2, 3);
        for (int i : nums1) {
            System.out.println(i);
        }
        
    }
}
