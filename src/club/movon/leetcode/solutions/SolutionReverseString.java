package club.movon.leetcode.solutions;


/**
 * 反转字符串
 *
 * @author zhangzhipeng
 * @date 2019-01-08
 */
public class SolutionReverseString {
    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        int i = s.length() - 1;
        int j = 0;
        while (j < i) {
            char tmp = chars[j];
            chars[j] = chars[i];
            chars[i] = tmp;
            i--;
            j++;
        }
        
        return new String(chars);
    }
}
