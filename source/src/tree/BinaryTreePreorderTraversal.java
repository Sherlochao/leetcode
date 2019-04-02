package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 * 示例:
 * 输入: [1,null,2,3]
 *  1
 *   \
 *    2
 *   /
 *  3
 *  输出: [1,2,3]
 */
public class BinaryTreePreorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (null != root) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                root = stack.pop();
                list.add(root.val);
                if (null != root.right) {
                    stack.push(root.right);
                }
                if (null != root.left) {
                    stack.push(root.left);
                }
            }
        }
        return list;
    }

    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        this.preOrder(list, root);
        return list;
    }

    private void preOrder(List<Integer> list, TreeNode root) {
        if (null == root) {
            return;
        }
        list.add(root.val);
        preOrder(list, root.left);
        preOrder(list, root.right);
    }

    public static void main(String[] args) throws Exception {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);

        List<Integer> result = new BinaryTreePreorderTraversal().preorderTraversal(root);
        System.out.println(result);

        result = new BinaryTreePreorderTraversal().preorderTraversal1(root);
        System.out.println(result);
    }
}
