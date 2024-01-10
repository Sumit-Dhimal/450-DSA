
public class BT_4_InvertTree extends Main{
    public Node invertTree(Node root) { // mirror of a tree
        if(root == null) {
            return null;
        }

        invertTree(root.left);
        invertTree(root.right);

        // swapping by using a temp Node
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

    /*
     * Time complexity : O(N) We are travesing every node
     * Space complexity : O(N) due to recursion stack space
     */
}
