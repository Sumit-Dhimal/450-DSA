/*
 * height2 of a binary tree
 */

public class BT_2_HeightofTree extends Main {
    public static int height2(Node node) 
    {
        // code here 
        if(node == null) return 0;
        
        int leftHeight = height2(node.left);
        int rightHeight = height2(node.right);
        int maxHeight = Math.max(leftHeight, rightHeight) + 1;
        
        return maxHeight;
    }
}

/*
 * Time complexity : O(N)
 *      since we are traversing the whole tree
 * Space complexiy : O(N)
 *      Due to recursive stack
 */