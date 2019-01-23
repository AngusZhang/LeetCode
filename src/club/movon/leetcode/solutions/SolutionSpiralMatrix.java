package club.movon.leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），
 * 请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * @author zhangzhipeng
 * @date 2019-01-22
 */
public class SolutionSpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n;
        if (m > 0) {
            n = matrix[0].length;
            if (n > 0) {
                int direct = 0;
                int i = 0;
                int j = 0;
                byte[][] table = new byte[m][n];
                int len = m * n;
                List<Integer> result = new ArrayList<>(len);
                do {
                    result.add(matrix[i][j]);
                    table[i][j] = 1;
                    switch (direct) {
                        case 0:
                            if (j + 1 == n || table[i][j + 1] != 0) {
                                direct = 1;
                                i++;
                            } else {
                                j++;
                            }
                            break;
                        case 1:
                            if (i + 1 == m || table[i + 1][j] != 0) {
                                direct = 2;
                                j--;
                            } else {
                                i++;
                            }
                            break;
                        case 2:
                            if (j - 1 < 0 || table[i][j - 1] != 0) {
                                direct = 3;
                                i--;
                            } else {
                                j--;
                            }
                            break;
                        case 3:
                            if (i - 1 < 0 || table[i - 1][j] != 0) {
                                direct = 0;
                                j++;
                            } else {
                                i--;
                            }
                            break;
                        default:
                            break;
                    }
                } while (result.size() < len);
                return result;
            }
        }
        return new ArrayList<>();
    }
    
    public static void main(String[] args) {
        int[][] ints = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        SolutionSpiralMatrix solution = new SolutionSpiralMatrix();
        List<Integer> integers = solution.spiralOrder(ints);
        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }
    }
}
