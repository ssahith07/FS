// In an Intelligence Agency, each senior officer supervises either two junior officers 
// or none. The senior officer is assigned a clearance level equal to the higher clearance 
// level of the two junior officers they supervise.

// The clearance levels are represented as integer values in the range [1, 50], and 
// multiple officers may have the same clearance level.

// At the end, all officers (senior and junior) are collectively referred to as 
// agents in the system.

// You are provided with a hierarchical clearance level tree where each node represents 
// an officer's clearance level. The tree structure follows these rules:
// 	- If a node has two children, its clearance level is the maximum of the two children's
// 	  clearance levels.
// 	- If a node has no children, it's clearance level is same as exists.
// 	- The value -1 indicates an empty (null) position.
// Your task is to find the second highest clearance level among all agents in the agency. 
// If no such level exists, return -2.

// Input Format:
// -------------
// A single line of space separated integers, clearance levels of each individual.

// Output Format:
// --------------
// Print an integer, second top agent based on rank.


// Sample Input-1:
// ---------------
// 5 5 4 -1 -1 2 4

// Sample Output-1:
// ----------------
// 4


// Sample Input-2:
// ---------------
// 3 3 3 3 3

// Sample Output-2:
// ----------------
// -2

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

public class program3 {
    static TreeNode build_tree(int[] ord,int ind,int n,int[] a){
        if(ind>=n || ord[ind]==-1) return null;
        a[0] = Math.max(a[0],ord[ind]);
        TreeNode root = new TreeNode(ord[ind]);
        root.left = build_tree(ord,2*ind+1,n,a);
        root.right = build_tree(ord,2*ind+2,n,a);
        return root;
    }
    static void secondMax(TreeNode node,int[] a,int[] b){
        if(node==null) return;
        if(node.val!=a[0]){
            b[0] = Math.max(b[0],node.val);
        }
        secondMax(node.left,a,b);
        secondMax(node.right,a,b);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] ord = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            ord[i] = Integer.parseInt(input[i]);
        }
        int n = ord.length;
        int[] a = new int[1];
        int[] b = new int[1];
        TreeNode node = build_tree(ord,0,n,a);
        secondMax(node,a,b);
        if(b[0]!=0){
            System.out.println(b[0]);
        }else{
            System.out.println(-2);
        }
    }
}
