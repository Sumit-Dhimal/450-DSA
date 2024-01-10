import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Level order traversal is used to traverse the tree with respect to the level of tree
 * 
 */
public class BT_1_levelOrder extends Main{

    static ArrayList <Integer> levelOrder(Node node) 
    {
        // Your code here
        ArrayList<Integer> list = new ArrayList<>();
        
        if(node == null) {
            return list;
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        q.add(null);
        
        while(!q.isEmpty()) {
            Node currNode = q.poll(); // poll == remove  : you can use remove too
            if(currNode == null) {
                if(q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                list.add(currNode.data);
                if(currNode.left != null) {
                    q.add(currNode.left);
                }
                
                if(currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
        return list;
    }
}

/*
 * Time Complexity : O(n)
 *          Since we are moving towards every node
 * 
 * Space complexity : O(n)
 * 
 */