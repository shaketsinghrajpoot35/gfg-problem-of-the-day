/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
} */



class Solution {

    int res = 0;

    public int solve(Node root) {

        // Base Case
        if (root == null) {
            return 0;
        }

        // Height of left subtree
        int left = solve(root.left);

        // Height of right subtree
        int right = solve(root.right);

        // Diameter through current node
        int temp = left + right;

        // Update maximum diameter
        res = Math.max(res, temp);

        // Return height
        return Math.max(left, right) + 1;
    }

    public int diameter(Node root)  {

        solve(root);

        return res;
    }
}