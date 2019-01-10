package club.movon.leetcode.solutions;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * @author zhangzhipeng
 * @date 2019-01-09
 */
public class SolutionLongestPalindromicSubstring {
    
    /**
     * 动态规划法
     * <p>
     * 字符串长度为 n
     * table[n][n] -> table[i][j] 标识 si ... sj 是否为回文串
     * P (i, j) = P(i + 1, j - 1) && s[i] == s[j]
     * i>j
     * |
     * | 1       1
     * | 1     1
     * | 1   1
     * | 1 1
     * | 0 1 1 1 1
     * |-----------i
     * j
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        boolean[][] table = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            table[i][i] = true;
        }
        
        for (int i = 0; i < n - 1; i++) {
            table[i][i + 1] = chars[i] == chars[i + 1];
            table[i + 1][i] = chars[i] == chars[i + 1];
        }
        
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                table[j][i] = table[j + 1][i - 1] && chars[i] == chars[j];
            }
        }
        
        int maxLen = 0;
        int indexLeft = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int len = i - j;
                if (table[j][i] && maxLen < len) {
                    maxLen = Math.max(maxLen, len);
                    indexLeft = j;
                }
            }
        }
        return s.substring(indexLeft, indexLeft + maxLen + 1);
    }
    
    public static void main(String[] args) {
        SolutionLongestPalindromicSubstring solution = new SolutionLongestPalindromicSubstring();
        System.out.println(solution.longestPalindrome("abcba"));
    }
}
