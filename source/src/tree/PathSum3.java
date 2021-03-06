package tree;

import base.TreeNode;

/**
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 找出路径和等于给定数值的路径总数。
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 * 示例：
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * 10
 * /  \
 * 5   -3
 * / \    \
 * 3   2   11
 * / \   \
 * 3  -2   1
 * 返回 3。和等于 8 的路径有:
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 */
public class PathSum3 {

    private int result = 0;

    public int pathSum(TreeNode root, int sum) {
        if (null == root) {
            return 0;
        }
        // 先序遍历所有节点
        path(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return result;
    }

    private void path(TreeNode root, int sum) {
        if (null != root) {
            if (sum == root.val) {
                result++;
            }
            path(root.left, sum - root.val);
            path(root.right, sum - root.val);
        }
    }

    public static void main(String[] args) throws Exception {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(-2);
        root.left.left.left = new TreeNode(-1);
        System.out.println(new PathSum3().pathSum(root, -1));
    }
}
