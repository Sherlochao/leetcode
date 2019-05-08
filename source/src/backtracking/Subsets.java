package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 *      [
 *          [3],
 *          [1],
 *          [2],
 *          [1,2,3],
 *          [1,3],
 *          [2,3],
 *          [1,2],
 *          []
 *      ]
 */
public class Subsets {

    /**
     * 回溯
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result, nums, 0, new ArrayList<>());
        return result;
    }

    private void backtracking(List<List<Integer>> result, int[] nums, int start, List<Integer> cur) {
        if (start == nums.length) {
            result.add(cur);
            return;
        }
        backtracking(result, nums, start + 1, cur);
        List<Integer> newCur = new ArrayList<>(cur);
        newCur.add(nums[start]);
        backtracking(result, nums, start + 1, newCur);
    }

    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, nums, 0, new ArrayList<>());
        return list;
    }

    private void backtrack(List<List<Integer>> list, int[] nums, int start, List<Integer> cur) {
        list.add(new ArrayList<>(cur));
        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            backtrack(list, nums, i + 1, cur);
            // 回退
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Subsets().subsets1(new int[] {1, 2, 3}));
    }

}
