package club.movon.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，
 * 判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * @author zhangzhipeng
 * @date 2019-01-24
 */
public class SolutionValidParentheses {
    
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>(3);
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        
        int size = s.length() / 2;
        char[] st = new char[size];
        int top = -1;
        
        for (char c : s.toCharArray()) {
            if (map.keySet().contains(c)) {
                if (++top >= size) {
                    return false;
                }
                st[top] = c;
            } else {
                if (top < 0) {
                    return false;
                }
                char pop = st[top--];
                char right = map.get(pop);
                if (c != right) {
                    return false;
                }
            }
        }
        return top == -1;
    }
    
    public static void main(String[] args) {
        SolutionValidParentheses solution = new SolutionValidParentheses();
        
        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("(]"));
        System.out.println(solution.isValid("([)]"));
        System.out.println(solution.isValid("]"));
        System.out.println(solution.isValid("["));
        
    }
}
