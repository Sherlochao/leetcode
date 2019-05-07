package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * 满足要求的四元组集合为：
 *      [
 *          [-1,  0, 0, 1],
 *          [-2, -1, 1, 2],
 *          [-2,  0, 0, 2]
 *      ]
 */
public class FourSum {

    /**
     * O(n * n * n)
     * 待优化不必要的计算
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == nums || nums.length < 4) {
            return result;
        }
        // Dual-Pivot Quick sort
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            // 去除重复项
            if (i == 0 || nums[i] != nums[i - 1]) {
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j == i + 1 || (j > i + 1 && nums[j] != nums[j - 1])) {
                        int l = j + 1, r = nums.length - 1, sum = target - nums[j] - nums[i];
                        while (l < r) {
                            if (nums[l] + nums[r] == sum) {
                                result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                                while (l < r && nums[l] == nums[l + 1]) {
                                    l++;
                                }
                                while (l < r && nums[r] == nums[r - 1]) {
                                    r--;
                                }
                                l++;
                                r--;
                            } else if (nums[l] + nums[r] < sum) {
                                while (l < r && nums[l] == nums[l + 1]) {
                                    l++;
                                }
                                l++;
                            } else {
                                while (l < r && nums[r] == nums[r - 1]) {
                                    r--;
                                }
                                r--;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
