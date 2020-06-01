package tree;

import base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
 * 示例 1:
 * 输入:
 *      3
 *     / \
 *    9  20
 *      /  \
 *     15   7
 * 输出: [3, 14.5, 11]
 * 解释:
 * 第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
 * 注意：
 * 节点值的范围在32位有符号整数范围内。
 */
public class AverageOfLevelsInBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size, i;
        Double sum;
        while (!queue.isEmpty()) {
            size = queue.size();
            i = size;
            sum = 0d;
            while (i != 0) {
                root = queue.poll();
                sum += root.val;
                if (null != root.left) {
                    queue.offer(root.left);
                }
                if (null != root.right) {
                    queue.offer(root.right);
                }
                i--;
            }
            result.add(sum / size);
        }
        return result;
    }
}
