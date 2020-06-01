package tree;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 中序 遍历。
 * 示例:
 * 输入: [1,null,2,3]
 *  1
 *   \
 *    2
 *   /
 *  3
 *  输出: [1,3,2]
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (null != root) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || null != root) {
                if (null != root) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    list.add(root.val);
                    root = root.right;
                }
            }
        }
        return list;
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        this.inOrder(list, root);
        return list;
    }

    private void inOrder(List<Integer> list, TreeNode root) {
        if (null == root) {
            return;
        }
        inOrder(list, root.left);
        list.add(root.val);
        inOrder(list, root.right);
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

        List<Integer> result = new BinaryTreeInorderTraversal().inorderTraversal(root);
        System.out.println(result);

        result = new BinaryTreeInorderTraversal().inorderTraversal1(root);
        System.out.println(result);
    }
}

