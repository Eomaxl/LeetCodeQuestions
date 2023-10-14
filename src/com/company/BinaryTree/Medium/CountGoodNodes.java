package com.company.BinaryTree.Medium;


/**
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
 * Return the number of good nodes in the binary tree.
 *
 * Example 1:
 * Input: root = [3,1,4,3,null,1,5]
 * Output: 4
 *
 * Example 2:
 * Input: root = [3,3,null,4,2]
 * Output: 3
 *
 * */

class  TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val){this.val = val;}
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class CountGoodNodes {
    private int numGoodNodes = 0;

    public int goodNodes(TreeNode root){
        dfs(root,Integer.MIN_VALUE);
        return numGoodNodes;
    }

    private void dfs(TreeNode root, int maxSoFar){
        if(root.val >=maxSoFar){
            numGoodNodes++;
        }

        if(root.right != null){
            dfs(root,Math.max(root.val,maxSoFar));
        }

        if(root.left != null){
            dfs(root,Math.max(root.val,maxSoFar));
        }
    }

    public static void main(String[] args){

    }
}
