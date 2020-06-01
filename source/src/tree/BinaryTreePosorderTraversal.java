package tree;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，返回它的 后序 遍历。
 * 示例:
 * 输入: [1,null,2,3]
 *  1
 *   \
 *    2
 *   /
 *  3
 *  输出: [3,2,1]
 */
public class BinaryTreePosorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (null != root) {
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            stack1.push(root);
            while (!stack1.isEmpty()) {
                root = stack1.pop();
                stack2.push(root);
                if (null != root.left) {
                    stack1.push(root.left);
                }
                if (null != root.right) {
                    stack1.push(root.right);
                }
            }
            while (!stack2.isEmpty()) {
                list.add(stack2.pop().val);
            }
        }
        return list;
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        this.posOrder(list, root);
        return list;
    }

    private void posOrder(List<Integer> list, TreeNode root) {
        if (null == root) {
            return;
        }
        posOrder(list, root.left);
        posOrder(list, root.right);
        list.add(root.val);
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

        List<Integer> result = new BinaryTreePosorderTraversal().postorderTraversal(root);
        System.out.println(result);

        result = new BinaryTreePosorderTraversal().postorderTraversal1(root);
        System.out.println(result);
    }
}
