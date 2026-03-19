
class Solution {

    static class NodeValue {
        int minNode, maxNode, maxSize;

        NodeValue(int minNode, int maxNode, int maxSize) {
            this.minNode = minNode;
            this.maxNode = maxNode;
            this.maxSize = maxSize;
        }
    }

    static NodeValue helper(Node root) {

        // Base Case
        if (root == null) {
            return new NodeValue(Integer.MAX_VALUE,
                                 Integer.MIN_VALUE,
                                 0);
        }

        NodeValue left = helper(root.left);
        NodeValue right = helper(root.right);

        // If current subtree is BST
        if (left.maxNode < root.data &&
            root.data < right.minNode) {

            return new NodeValue(
                Math.min(left.minNode, root.data),
                Math.max(right.maxNode, root.data),
                left.maxSize + right.maxSize + 1
            );
        }

        // If not BST
        return new NodeValue(
            Integer.MIN_VALUE,
            Integer.MAX_VALUE,
            Math.max(left.maxSize, right.maxSize)
        );
    }

    static int largestBst(Node root) {
        return helper(root).maxSize;
    }
}
