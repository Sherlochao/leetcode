package tree;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sherlock
 * @date 2019/4/10 7:20 PM
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        // 叶子结点
        if (null == root.left && null == root.right) {
            result.add(root.val + "");
        }
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        if (left.size() > 0) {
            for (String s : left) {
                result.add(root.val + "->" + s);
            }
        }
        if (right.size() > 0) {
            for (String s : right) {
                result.add(root.val + "->" + s);
            }
        }
        return result;
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
        List<String> strings = new BinaryTreePaths().binaryTreePaths(root);
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
