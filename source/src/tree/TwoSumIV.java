package tree;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 * 案例 1:
 * 输入:
 *          5
 *         / \
 *        3   6
 *       / \   \
 *      2   4   7
 * Target = 9
 * 输出: True
 * 案例 2:
 * 输入:
 *          5
 *         / \
 *        3   6
 *       / \   \
 *      2   4   7
 * Target = 28
 * 输出: False
 */
public class TwoSumIV {

    // 中序遍历 + 双指针
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        if (list.size() < 2) {
            return false;
        }
        int size = list.size();
        if (list.get(0) + list.get(1) > k || list.get(size - 1) + list.get(size - 2) < k) {
            return false;
        }
        int l = 0, r = size - 1;
        while (l < r) {
            int val = list.get(l) + list.get(r);
            if (val == k) {
                return true;
            } else if (val < k) {
                l++;
            } else {
                r--;
            }
        }
        return false;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (null != root) {
            inOrder(root.left, list);
            list.add(root.val);
            inOrder(root.right, list);
        }
    }
}
