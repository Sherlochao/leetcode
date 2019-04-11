package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * 例如，给定一个 3叉树 :
 *         1
 *      /  |  \
 *     3   2   4
 *    / \
 *   5   6
 *
 * 返回其前序遍历: [1,3,5,6,2,4]。
 */
public class NaryTreePreorderTraversal {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int val, List<Node> children) {
            val = val;
            children = children;
        }
    }

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        preOrder(root, result);
        return result;
    }

    private void preOrder(Node root, List<Integer> result) {
        if (null != root) {
            result.add(root.val);
            if (null != root.children && root.children.size() > 0) {
                for (Node child : root.children) {
                    preOrder(child, result);
                }
            }
        }
    }

    public List<Integer> preorder1(Node root) {
        List<Integer> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            result.add(root.val);
            if (null != root.children && root.children.size() > 0) {
                for (int i = root.children.size() - 1; i >= 0; i--) {
                    stack.push(root.children.get(i));
                }
            }
        }
        return result;
    }
}
