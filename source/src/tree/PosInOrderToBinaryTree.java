package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 例如，给出
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *      3
 *     / \
 *    9  20
 *      /  \
 *     15   7
 */
public class PosInOrderToBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (null == inorder || null == postorder) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return posIn(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    public static TreeNode posIn(int[] p, int pi, int pj, int[] n, int ni, int nj, HashMap<Integer, Integer> map) {
        if (pi > pj) {
            return null;
        }
        TreeNode head = new TreeNode(p[pj]);
        int index = map.get(p[pj]);
        head.left = posIn(p, pi, pi + index - ni - 1, n, ni, index - 1, map);
        head.right = posIn(p, pi + index - ni, pj - 1, n, index + 1, nj, map);
        return head;
    }

    public static void main(String[] args) {
        int[] in = {4, 2, 8, 5, 9, 1, 6, 3, 7};
        int[] pos = {4, 8, 9, 5, 2, 6, 7, 3, 1};
        List<List<Integer>> result = levelOrder(new PosInOrderToBinaryTree().buildTree(in, pos));
        System.out.println(result);
    }

    private static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (null != root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int len = queue.size();
                List<Integer> list = new ArrayList<>();
                while (len > 0) {
                    root = queue.poll();
                    list.add(root.val);
                    if (null != root.left) {
                        queue.offer(root.left);
                    }
                    if (null != root.right) {
                        queue.offer(root.right);
                    }
                    len--;
                }
                result.add(list);
            }
        }
        return result;
    }
}
