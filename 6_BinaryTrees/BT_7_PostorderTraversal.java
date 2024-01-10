import java.util.*;


public class BT_7_PostorderTraversal extends Main {

    //Recursion
    List<Integer> ans = new ArrayList<>();
    public List<Integer> postorderTraversal(Node root) {
        if(root == null) {
            return ans;
        }

        postorderTraversal(root.left);
        postorderTraversal(root.right);
        ans.add(root.data);

        return ans;
    }

    // Time & Space complexity = O(N)

    // Morris Traversal
    public List<Integer> postorderTraversal2(Node root) {
        List<Integer> ans = new ArrayList<>();
        Node curr = root;

        while(curr != null) {
            if(curr.right == null) {
                ans.add(curr.data);
                curr = curr.left;
            }
            else {
                Node succ = curr.right;
                while(succ.left != null && succ.left != curr) {
                    succ = succ.left;
                } 
                if(succ.left == null) {
                    ans.add(curr.data);
                    succ.left = curr;
                    curr = curr.right;
                }
                else {
                    succ.left = null;
                    curr = curr.left;
                }
            }
        }
        Collections.reverse(ans);
        return ans;
    }
    /*
     * TC = O(N) // since we are traversing each node
     * SC = O(N) // after reversing it will be O(N)
     */
}
