package com.lspringtrain.liduoan.day03;


/**
 * @author liduoan
 * @date 2021年12月04日 21:04
 */
public class Main {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static int maxNum = Integer.MIN_VALUE;

    public TreeNode convertBST(TreeNode root) {
        bst(root);
        return root;
    }

    public void bst(TreeNode root) {
        if (root == null) {
            return;
        }

        bst(root.right);

        if (root.val > maxNum) {
            maxNum = root.val;
        } else {
            root.val += maxNum;
            maxNum = root.val;
        }

        bst(root.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = null;
        root.right = new TreeNode(1);
        root.right.left = null;
        root.right.right = null;
        Main main = new Main();
        main.convertBST(root);
    }
}
