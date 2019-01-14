package club.movon.leetcode.solutions;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * <p>
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * <p>
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * <p>
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * <p>
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * <p>
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 *
 * @author zhangzhipeng
 * @date 2019-01-14
 */
public class SolutionStringToIntegerAtoi {
    
    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        
        boolean firstFound = false;
        int flag = 1;
        int result = 0;
        for (char aChar : chars) {
            if (!firstFound) {
                if (aChar == ' ') {
                    continue;
                }
                if (aChar != '+' && aChar != '-' && !isNum(aChar)) {
                    return 0;
                } else if (!isNum(aChar)) {
                    if (aChar == '-') {
                        flag = -1;
                    }
                } else {
                    result = flag * (aChar - '0');
                }
                firstFound = true;
            } else {
                if (isNum(aChar)) {
                    int pop = (aChar - '0') * flag;
                    boolean overMax = result > 214748364 || (result == 214748364 && pop > 7);
                    boolean overMin = result < -214748364 || (result == -214748364 && pop < -8);
                    if (overMax) {
                        return Integer.MAX_VALUE;
                    } else if (overMin) {
                        return Integer.MIN_VALUE;
                    }
                    result = result * 10 + pop;
                } else {
                    break;
                }
            }
            
            
        }
        return result;
    }
    
    private boolean isNum(char aChar) {
        return aChar >= '0' && aChar <= '9';
    }
    
    public static void main(String[] args) {
        SolutionStringToIntegerAtoi solution = new SolutionStringToIntegerAtoi();

        System.out.println(solution.myAtoi("+42"));
        System.out.println(solution.myAtoi("   -42"));
        System.out.println(solution.myAtoi("4193 with words"));
        System.out.println(solution.myAtoi("words and 987"));
        System.out.println(solution.myAtoi("-91283472332"));
        
    }
    
}
