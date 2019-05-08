package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 *
 * 输出:
 *      [
 *          [1,2,3],
 *          [1,3,2],
 *          [2,1,3],
 *          [2,3,1],
 *          [3,1,2],
 *          [3,2,1]
 *      ]
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == nums || nums.length == 0) {
            return result;
        }
        backtracking(result, nums, 0);
        return result;
    }

    private void backtracking(List<List<Integer>> result, int[] nums, int start) {
        // 终止条件
        if (start == nums.length - 1) {
            List<Integer> list = new ArrayList<>(nums.length);
            for (int i : nums) {
                list.add(i);
            }
            result.add(list);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            // 交换节点
            swap(nums, i, start);
            // 回溯
            backtracking(result, nums, start + 1);
            // 恢复
            swap(nums, i, start);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(new Permutations().permute(new int[] {1, 2, 3}));
    }
}
