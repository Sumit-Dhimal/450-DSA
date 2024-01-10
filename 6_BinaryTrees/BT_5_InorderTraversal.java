import java.util.*;
/*
 * Inorder traveral = you first visit the left subtree, 
then the root node, and finally the right subtree

 */

public class BT_5_InorderTraversal extends Main{

    //Recursive solution /*Focus this one */
    List<Integer> ans = new ArrayList<>();
    public List<Integer> inorderTraversal(Node root) {
        if(root == null) {
            return ans;
        }

        inorderTraversal(root.left);
        ans.add(root.data);
        inorderTraversal(root.right);

        return ans;
    }
    /*
     * Time complexity : O(N)   We are traverseing the whole tree
     * Space complexity : O(N) + O(N) ~ O(N) We recursion stack space and an external array.
     */


     // iterative solution
      public List<Integer> inorderTraversal2(Node root) {
        List<Integer> ans = new ArrayList<>();
        Stack<Node> s = new Stack<>(); // it's a stack of node
        Node curr = root;

        while(true) {
            if(curr != null) {
                s.push(curr);
                curr = curr.left;
            } else {
                if(s.isEmpty()) break;
                curr = s.peek(); 
                ans.add(curr.data);
                s.pop();
                curr = curr.right;
            }
        }
        return ans;
    }
    /*
     * Time complexity : O(N)   We are traverseing the whole tree
     * Space complexity : O(N)  we are using an stack of size n
     */


    
    /*Moris traversal */
    public List<Integer> inorderTraversal3(Node root) {
        List<Integer> ans = new ArrayList<>();
        Node curr = root;

        while(curr != null) {
            if(curr.left == null) {
                ans.add(curr.data);
                curr = curr.right;
            }
            else {
                // find predecessor
                Node temp = curr.left;
                while(temp.right != null && temp.right != curr) { /*IMP */
                    temp = temp.right;
                }

                if(temp.right == null) {
                    temp.right = curr;
                    curr = curr.left;
                } else {
                    temp.right = null;
                    ans.add(curr.data);
                    curr = curr.right;
                }
            }
        }
        return ans;
    }
}
