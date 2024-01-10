
/**
 * Diameter of a tree
 */
public class BT_3_DiameterofTree extends Main{ 
    // brute force method
    int ans = 0;
    int diameter1(Node root) {
        // Your code here
        if(root == null) return 0;
        int op1 = diameter1(root.left);
        int op2 = diameter1(root.right);
        int op3 = height2(root.left) + 1 + height2(root.right);
        
        return Math.max(op1, Math.max(op2, op3));
    }
    
    public int height2(Node node) 
    {
        // code here 
        if(node == null) return 0;
        
        int leftHeight = height2(node.left);
        int rightHeight = height2(node.right);
        int maxHeight = Math.max(leftHeight, rightHeight) + 1;
        
        return maxHeight;
    }
    /*
     * TC : O(N^2)  => Since we are calling for diameter O(N) and height2 O(N)
     * SC : O(N)    => Recursion stack space
     */



    // optimal solution
    public int diameterOfBinaryTree(Node root) {
        // create an array to hold the diameter of a tree
        int[] diameter = new int[1];

        // Recursively calculate the height of the tree and update the diameter
        height(root, diameter);

        return diameter[0];
    }

    public int height(Node root, int[] diameter) {
        // base case
        if(root == null) {
            return 0;
        }

        // recursively calculate the height of the left and right subtree.
        int left = height(root.left, diameter);
        int right = height(root.right, diameter);

        // update the diameter array by taking the maximum diameter that passes through the current node
        diameter[0] = Math.max(diameter[0], left + right);

        // return the maximum depth of the current node by adding 1 to the maximum depth of its deepest sub tree
        return Math.max(left, right) + 1;
    }
    /*
     * Time complexity : O(N) since we are traversing each node
     * Space complexity : O(N) Due to recursion stack
     */

}