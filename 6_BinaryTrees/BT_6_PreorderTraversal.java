
/*
 * PreOrderTraveral = You first visit root, then left node and right node
 */

import java.util.*;

public class BT_6_PreorderTraversal extends Main {

    //Recursive solution
    List<Integer> ans = new ArrayList<>();
    public List<Integer> preorderTraversal(Node root) {
        if(root == null) {
            return ans;
        }
        ans.add(root.data);
        preorderTraversal(root.left);
        preorderTraversal(root.right);

        return ans;
    }
    //Time complexity = O(N)  Since, we are traversing each and every node
    //Space complexity = O(N) due to recursive stack space


    // Morris Traversal
    public List<Integer> preorderTraversal3(Node root) {
        List<Integer> ans = new ArrayList<>();
        Node curr = root;

        while(curr != null) {
            if(curr.left == null) {
                ans.add(curr.data);
                curr = curr.right;
            }
            else {
                // find predecessor of inorder
                Node pred = curr.left;
                while(pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                if(pred.right == null) {
                    ans.add(curr.data);
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    pred.right = null;
                    curr = curr.right;
                }
            }
        }
        return ans;
    }

    // TC = O(N)
    // Sc = O(1)


}
