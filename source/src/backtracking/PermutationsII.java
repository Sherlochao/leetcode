package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 * 输入: [1,1,2]
 * 输出:
 *  [
 *      [1,1,2],
 *      [1,2,1],
 *      [2,1,1]
 *  ]
 */
public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == nums || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
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
            if (canSwap(nums, start, i)) {
                // 交换节点
                swap(nums, i, start);
                // 回溯
                backtracking(result, nums, start + 1);
                // 恢复
                swap(nums, i, start);
            }
        }
    }

    private boolean canSwap(int[] nums, int start, int end) {
        for (int i = start; i < end; i++) {
            if (nums[i] == nums[end]) {
                return false;
            }
        }
        return true;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(new PermutationsII().permuteUnique(new int[] {0, 1, 0, 0, 9}));
    }
}
