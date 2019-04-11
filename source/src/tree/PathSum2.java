package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *          5
 *         / \
 *        4   8
 *       /   / \
 *      11  13  4
 *     /  \      \
 *    7    2      1
 * 返回:
 *  [
 *     [5,4,11,2],
 *     [5,8,4,5]
 *  ]
 */
public class PathSum2 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        dfs(root, sum, result, list);
        return result;
    }

    private void dfs(TreeNode root, int sum, List<List<Integer>> result, List<Integer> list) {
        if (null != root) {
            list.add(root.val);
            if (null == root.left && null == root.right && sum == root.val) {
                result.add(new ArrayList<>(list));
            }
            dfs(root.left, sum - root.val, result, list);
            dfs(root.right, sum - root.val, result, list);
            //每返回一次, 删掉一个节点
            list.remove(list.size() - 1);
        }
    }
}
