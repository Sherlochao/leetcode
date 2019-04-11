package tree;

/**
 * @author sherlock
 * @date 2019/4/11 8:46 PM
 */
public class SumRootToLeafNumbers {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int result = 0;

    public int sumNumbers(TreeNode root) {
        if (null == root) {
            return 0;
        }
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int tmp) {
        if (null != root) {
            int k = (tmp * 10 + root.val);
            if (null == root.left && null == root.right) {
                result += k;
            }
            dfs(root.left, k);
            dfs(root.right, k);
        }
    }

    public static void main(String[] args) throws Exception {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        System.out.println(new SumRootToLeafNumbers().sumNumbers(root));
    }
}
