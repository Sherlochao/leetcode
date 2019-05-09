package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 *
 * 示例 1:
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 *  [
 *      [7],
 *      [2,2,3]
 *  ]
 *
 * 示例 2:
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 *  [
 *      [2,2,2,2],
 *      [2,3,3],
 *      [3,5]
 *  ]
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            cur.add(candidates[i]);
            backtracking(result, candidates, target - candidates[i], i, cur);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[] {2, 3, 6, 7}, 7));
    }
}
