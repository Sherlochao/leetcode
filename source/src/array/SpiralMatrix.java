package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 * 输入:
 *      [
 *         [ 1, 2, 3 ],
 *         [ 4, 5, 6 ],
 *         [ 7, 8, 9 ]
 *      ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 *
 * 示例 2:
 * 输入:
 *      [
 *         [1, 2, 3, 4],
 *         [5, 6, 7, 8],
 *         [9,10,11,12]
 *      ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        int lr = 0, lc = 0;
        int dr = matrix.length - 1, dc = matrix[0].length - 1;
        while (lr <= dr && lc <= dc) {
            matrix(list, lr++, lc++, dr--, dc--, matrix);
        }
        return list;
    }

    private void matrix(List<Integer> list, int lr, int lc, int dr, int dc, int[][] matrix) {
        if (lr == dr) {
            while (lc <= dc) {
                list.add(matrix[lr][lc++]);
            }
        } else if (lc == dc) {
            while (lr <= dr) {
                list.add(matrix[lr++][lc]);
            }
        } else {
            int i = lc;
            while (i < dc) {
                list.add(matrix[lr][i++]);
            }
            i = lr;
            while (i < dr) {
                list.add(matrix[i++][dc]);
            }
            i = dc;
            while (lc < i) {
                list.add(matrix[dr][i--]);
            }
            i = dr;
            while (lr < i) {
                list.add(matrix[i--][lc]);
            }
        }
    }

    public static void main(String[] args) {
        //        int[][] matrix = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        //        int[][] matrix = new int[][] {{1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}, {10}};
        int[][] matrix = new int[][] {{3}, {2}};
        new SpiralMatrix().spiralOrder(matrix);
    }
}
