package club.movon.leetcode.solutions;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * @author zhangzhipeng
 * @date 2019/1/12
 */
public class SolutionLongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();

        if (strs.length == 1) {
            return strs[0];
        }
        int minLen = -1;
        for (String str : strs) {
            if (minLen < 0) {
                minLen = str.length();
            } else if (minLen > str.length()) {
                minLen = str.length();
            }
        }
        for (int i = 0; i < minLen; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }

    /**
     * 官方分治算法
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefixDivide(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        } else {
            int mid = (l + r) / 2;
            String lcpLeft = longestCommonPrefix(strs, l, mid);
            String lcpRight = longestCommonPrefix(strs, mid + 1, r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i))
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }

    public static void main(String[] args) {
        SolutionLongestCommonPrefix solution = new SolutionLongestCommonPrefix();
        String[] strs = {"flower", "flow", "flight"};

        System.out.println(solution.longestCommonPrefix(strs));
    }
}
