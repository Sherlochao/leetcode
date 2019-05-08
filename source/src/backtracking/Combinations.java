package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 * 输入: n = 4, k = 2
 * 输出:
 *      [
 *          [2,4],
 *          [3,4],
 *          [2,3],
 *          [1,2],
 *          [1,3],
 *          [1,4],
 *      ]
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n < 1 || k > n) {
            return result;
        }
        backtracking(result, n, k, 1, new ArrayList<>());
        return result;
    }

    private void backtracking(List<List<Integer>> result, int n, int k, int start, List<Integer> cur) {
        // 终止条件
        if (k == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            cur.add(i);
            backtracking(result, n, k - 1, i + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Combinations().combine(4, 2));
    }
}
