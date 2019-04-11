package tree;

/**
 * 翻转一棵二叉树。
 * 示例：
 * 输入：
 *        4
 *      /   \
 *     2     7
 *    / \   / \
 *   1   3 6   9
 * 输出：
 *        4
 *      /   \
 *     7     2
 *    / \   / \
 *   9   6 3   1
 */
public class InvertBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return root;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        return root;
    }
}
