// In an Intelligence Agency, each senior officer supervises either two junior officers 
// or none. The senior officer is assigned a clearance level equal to the lowest clearance 
// level of the two junior officers they supervise.

// The clearance levels are represented as integer values in the range [1, 50], and multiple 
// officers may have the same clearance level.

// At the end, all officers (senior and junior) are collectively referred to as agents in the system.

// You are provided with a hierarchical clearance level tree where each node represents 
// an officer's clearance level. The tree structure follows these rules:
// 	- If a node has two children, its clearance level is the minimum of the two children's
// 	  clearance levels.
// 	- If a node has no children, it's clearance level is same as exists.
// 	- The value -1 indicates an empty (null) position.
// Your task is to find the highest clearance level among all agents in the agency. 
// If no such level exists, return -2.

// Input Format:
// -------------
// A single line of space separated integers, clearance levels of each individual.

// Output Format:
// --------------
// Print an integer, the highest clearance level.


// Sample Input-1:
// ---------------
// 2 5 2 -1 -1 2 4

// Sample Output-1:
// ----------------
// 5


// Sample Input-2:
// ---------------
// 3 3 3 3 3

// Sample Output-2:
// ----------------
// 3

import java.util.*;

class TreeNode{
    int val;
    TreeNode left,right;
    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}


public class program2 {
    static TreeNode build_tree(int[] ord,int ind,int n){
        if(ind>=n || ord[ind]==-1) return null;
        TreeNode root =  new TreeNode(ord[ind]);
        root.left = build_tree(ord, 2*ind+1,n);
        root.right = build_tree(ord, 2*ind+2,n);
        return root;
    }
    static void maxEle(TreeNode node,int[] a){
        if(node==null) return;
        a[0] = Math.max(a[0],node.val);
        maxEle(node.left,a);
        maxEle(node.right,a);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] ord = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            ord[i] = Integer.parseInt(input[i]);
        }
        int n = ord.length;
        TreeNode node = build_tree(ord,0,n);
        int[] a = new int[1];
        maxEle(node,a);
        System.out.println(a[0]);
    }
}
