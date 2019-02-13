package club.movon.leetcode.solutions;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * @author zhangzhipeng
 * @date 2019-02-12
 */
public class SolutionMultiplyStrings {
    public String multiply(String num1, String num2) {
        
        int flag = 1;
        int len1 = num1.length();
        CharSequence n1;
        if (num1.charAt(0) == '-' || num1.charAt(0) == '+') {
            if (num1.charAt(0) == '-') {
                flag = -1;
            }
            n1 = num1.subSequence(1, len1);
            len1--;
        } else {
            n1 = num1;
        }
        int len2 = num2.length();
        CharSequence n2;
        if (num2.charAt(0) == '-' || num2.charAt(0) == '+') {
            if (num2.charAt(0) == '-') {
                flag = flag * -1;
            }
            n2 = num2.subSequence(1, len2);
            len2--;
        } else {
            n2 = num2;
        }
        
        int len = len1 + len2;
        char[] result = new char[len];
        for (int i = 0; i < len; i++) {
            result[i] = '0';
        }
        
        int index1 = len1 - 1;
        int index = len - 1;
        while (index1 >= 0) {
            int m = ctoi(n1.charAt(index1--));
            int index2 = len2 - 1;
            int currIndex = index;
            int carry = 0;
            while (index2 >= 0) {
                int n = ctoi(n2.charAt(index2--));
                int i = m * n;
                int r = ctoi(result[currIndex]) + i + carry;
                carry = r / 10;
                result[currIndex] = itoc(r % 10);
                currIndex--;
            }
            result[currIndex] = itoc(carry);
            index--;
        }
        
        int start = 0;
        while (start < len && result[start] == '0' ) {
            start++;
        }
        
        if (start == len) {
            return "0";
        }
        
        char[] chars = new char[len - start];
        System.arraycopy(result, start, chars, 0, len - start);
        if (flag < 0) {
            return "-" + new String(chars);
        } else {
            return new String(chars);
        }
    }
    
    int ctoi(char c) {
        return c - '0';
    }
    
    char itoc(int i) {
        return (char) (i + '0');
    }
    
    public static void main(String[] args) {
        SolutionMultiplyStrings solution = new SolutionMultiplyStrings();
        String multiply = solution.multiply("123", "456");
        System.out.println(multiply);
    }
}
