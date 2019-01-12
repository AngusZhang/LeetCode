package club.movon.leetcode.solutions;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * @author zhangzhipeng
 * @date 2019/1/12
 */
public class SolutionReverseInteger {

    /**
     * 判断是否溢出可以在乘以10之前判断
     * 第一次做法使用long来接收结果值越过了判断越界的步骤没错但是越过了一个考察的点
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            boolean overMax = result > 214748364 || (result == 214748364 && pop > 7);
            boolean overMin = result < -214748364 || (result == -214748364 && pop < -8);
            if (overMax || overMin) {
                return 0;
            }
            result = result * 10 + pop;
        }

        return result;
    }

    public static void main(String[] args) {
        SolutionReverseInteger solution = new SolutionReverseInteger();
        System.out.printf("%d\n", (int) Math.pow(2, 31) - 1);
        System.out.printf("%d", Integer.MIN_VALUE);

    }
}
