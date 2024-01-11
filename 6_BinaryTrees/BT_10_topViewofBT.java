import java.util.*;

/*
 * Logic : Add top element at each horizontal distance
 */

public class BT_10_topViewofBT extends Main {
     static class Pair {
        Node root;
        int hd; // horizontal distance
        
        Pair(Node root, int hd) {
            this.root = root;
            this.hd = hd;
        }
    }
    
    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(root, 0));
        
        // lvl order traversal
        while(!q.isEmpty()) {
            Pair it = q.poll();
            int hd = it.hd;
            Node temp = it.root;
            
            // if there is no element in hd add
            if(map.get(hd) == null) {
                map.put(hd, temp.data);
            }
            
            if(temp.left != null) {
                q.add(new Pair(temp.left, hd-1));
            }
            
            if(temp.right != null) {
                q.add(new Pair(temp.right, hd+1));
            }
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        
        return ans;
    }
}

/*
 * Time complexity : O(N)
 *      We are traversing every node of tree
 * 
 * Space complexity : O(N) + O(N) ~ O(N)
 *      We are using external queue and map of size N
 * 
 *
 */
