import java.util.ArrayList;

/*
 * Look from left side and print the first visible node at each level
 */

public class BT_8_LeftViewofBT extends Main {
    int max_level = 0;
    ArrayList<Integer> leftView(Node root)
    {
      ArrayList<Integer> list = new ArrayList<>();
      int lvl = 1; // it should be greater than max_level

      findLeftView(root, list, lvl);
      
      return list;
    }
    
    void findLeftView(Node root, ArrayList<Integer> list, int lvl) {
        if(root == null) {
            return;
        }   
        
        // check if it's the first occurance of the level
        // current level first time aako hoki haina check garney
        if(max_level < lvl) {
            list.add(root.data);
            max_level = lvl;
        }
        
        findLeftView(root.left, list, lvl+1);
        findLeftView(root.right, list, lvl+1);
    }
    /*
     * TC = O(N) : Since we travel whole tree
     * SC = O(H) : Height of the tree (Recursive stack space)
     */
}
