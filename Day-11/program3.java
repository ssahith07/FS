// /*
// Bubloo is working with computer networks, where servers are connected
// in a hierarchical structure, represented as a Binary Tree. Each server (node)
// is uniquely identified by an integer value.

// Bubloo has been assigned an important task: find the shortest communication
// path (in terms of network hops) between two specific servers in the network.

// Network Structure:
// ------------------
// The network of servers follows a binary tree topology.
// Each server (node) has a unique identifier (integer).
// If a server does not exist at a certain position, it is represented as '-1'
// (NULL).

// Given the root of the network tree, and two specific server IDs (E1 & E2),
// determine the minimum number of network hops (edges) required to
// communicate between these two servers.

// Input Format:
// -------------
// Space separated integers, elements of the tree.

// Output Format:
// --------------
// Print an integer value.

// Sample Input-1:
// ---------------
// 1 2 4 3 5 6 7 8 9 10 11 12
// 4 8

// Sample Output-1:
// ----------------
// 4

// Explanation:
// ------------
// The edegs between 4 and 8 are: [4,1], [1,2], [2,3], [3,8]

// Sample Input-2:
// ---------------
// 1 2 4 3 5 6 7 8 9 10 11 12
// 6 6

// Sample Output-2:
// ----------------
// 0

// Explanation:
// ------------
// No edegs between 6 and 6.
// */
import java.util.*;

public class program3{
    static TreeNode create_tree(int[] ord){
        if(ord.length==0||ord[0]==-1) return null;
        TreeNode root = new TreeNode(ord[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i=1;
        while (!q.isEmpty() && i<ord.length) {
            TreeNode curr = q.poll();
            if (i<ord.length && ord[i]!=-1) {
                curr.left = new TreeNode(ord[i]);
                q.add(curr.left);
            }
            i++;
            if(i<ord.length && ord[i]!=-1){
                curr.right = new TreeNode(ord[i]);
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }

    static TreeNode lca(TreeNode root, int p, int q){
        if(root==null || root.val==p || root.val==q) return root;
        TreeNode l = lca(root.left, p, q);
        TreeNode r = lca(root.right, p, q);
        if(l==null) return r;
        else if(r==null) return l;
        else return root;
    }
    static int dist(TreeNode root, int t,int d){
        if(root==null) return -1;
        if(root.val==t) return d;
        int left = dist(root.left, t, d+1);
        if (left!=-1) {
            return left;
        }
        return dist(root.right,t,d+1);
    }
    static int count(TreeNode root, int p, int q){
        TreeNode temp = lca(root, p, q);
        int d1 = dist(temp, p, 0);
        int d2 = dist(temp, q, 0);
        return d1+d2;
    }
    public static void main(String[] args) {
        int[] ord = {1,2,4,3,5,6,7,8,9,10,11,12};
        int p = 4;
        int q = 8;
        for (int i = 0; i < ord.length-2; i++) {
            System.out.println(ord[i+1]);
        }
        TreeNode root = create_tree(ord);
        int d = count(root, p, q);
        System.out.println(d);
    }
}