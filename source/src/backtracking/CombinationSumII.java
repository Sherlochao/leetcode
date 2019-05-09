package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 *
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 *  [
 *      [1, 7],
 *      [1, 2, 5],
 *      [2, 6],
 *      [1, 1, 6]
 *  ]
 *
 * 示例 2:
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 *  [
 *      [1,2,2],
 *      [5]
 *  ]
 */
public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(result, candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void backtracking(List<List<Integer>> result, int[] candidates, int target, int start, List<Integer> cur) {
        if (target == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
            // 去重
            if (i == start || candidates[i] != candidates[i - 1]) {
                cur.add(candidates[i]);
                backtracking(result, candidates, target - candidates[i], i + 1, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSumII().combinationSum2(new int[] {10, 1, 2, 7, 6, 1, 5}, 8));
    }

}
