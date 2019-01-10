package club.movon.leetcode.solutions;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * @author zhangzhipeng
 * @date 2019-01-10
 */
public class SolutionSpiralMatrix_2 {
    /**
     * 0 - n^2 一次排序应该遵循右 下 左 上的顺序填充
     * 每逢遇到越界被占用就改变方向
     *
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] table = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                table[i][j] = -1;
            }
        }
        
        int i = 0;
        int j = 0;
        int count = 1;
        // 右 j++ 下 i++ 左 j-- 上 i-- 
        int direct = 0;
        do {
            table[i][j] = count;
            
            switch (direct) {
                case 0:
                    if (j + 1 == n || table[i][j + 1] > 0) {
                        direct = 1;
                        i++;
                    } else {
                        j++;
                    }
                    break;
                case 1:
                    if (i + 1 == n || table[i + 1][j] > 0) {
                        direct = 2;
                        j--;
                    } else {
                        i++;
                    }
                    break;
                case 2:
                    if (j - 1 < 0 || table[i][j - 1] > 0) {
                        direct = 3;
                        i--;
                    } else {
                        j--;
                    }
                    break;
                case 3:
                    if (i - 1 < 0 || table[i - 1][j] > 0) {
                        direct = 0;
                        j++;
                    } else {
                        i--;
                    }
                    break;
                default:
                    break;
            }
        } while (count++ < n * n);
        
        return table;
    }
    
    public static void main(String[] args) {
        SolutionSpiralMatrix_2 solution = new SolutionSpiralMatrix_2();
        int[][] ints = solution.generateMatrix(4);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.printf("  %d  ", i);
            }
            System.out.println();
        }
    }
    
}
