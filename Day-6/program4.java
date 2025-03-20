// In a distant galaxy, an ancient civilization built a hierarchical communication 
// network of interconnected relay stations. The structure of this network can be 
// reconstructed using two ancient data logs:
//     - Beacon Activation Order (analogous to in-order traversal)
//     - Final Signal Sent Order (analogous to post-order traversal)

// Using these logs, we can reconstruct the original relay network and process 
// queries about signals reaching specific hierarchical levels.

// Given the Beacon Activation Order and the Final Signal Sent Order of a galactic 
// communication network, reconstruct the relay network. After reconstructing the 
// hierarchy, process multiple queries to identify which stations transmitted 
// signals within a given range of levels. Each query consists of a lower level 
// and an upper level, and the output should list the relay stations in the order 
// they appear in a level-wise transmission sequence.

// Input Format:
// -------------
// An integer N representing the number of relay stations in the network.
// A space-separated list of N integers representing the Beacon Activation Order (similar to in-order traversal).
// A space-separated list of N integers representing the Final Signal Sent Order (similar to post-order traversal).
// An integer Q representing the number of queries.
// Q pairs of integers, each representing a query in the form:
// Minimum Transmission Depth (L)
// Maximum Transmission Depth (U)

// Output Format:
// --------------
// For each query, print the relay stations in order of their signal transmissions within the given depth range


// Sample Input:
// -------------
// 7
// 4 2 5 1 6 3 7
// 4 5 2 6 7 3 1
// 2
// 1 2
// 2 3

// Sample Output:
// --------------
// [1, 2, 3]
// [2, 3, 4, 5, 6, 7]


// Explanation:
// ------------
// The logs correspond to the following hierarchical relay network:
//         1
//        / \
//       2   3
//      / \  / \
//     4   5 6  7
// Query 1 (Transmission Levels 1 to 2): 1 2 3
// Query 2 (Transmission Levels 2 to 3): 2 3 4 5 6 7

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class TreeNode{
    int val;
    TreeNode left,right;
    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
public class program4 {
    static int postIndex;
    static TreeNode build_tree(int[] inord,int[] postord,int st,int end,HashMap<Integer,Integer> hm){
        if(st>end) return null;
        
        int rootVal = postord[postIndex--];
        TreeNode root = new TreeNode(rootVal);
        int ind = hm.get(rootVal);
        root.right = build_tree(inord, postord, ind+1, end, hm);
        root.left = build_tree(inord, postord, st, ind-1, hm);
        return root;
    }
    static List<Integer> hnet(TreeNode root,int l,int u){
        List<Integer> al = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level=1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                if (l<=level && level<=u) {
                    al.add(temp.val);
                }
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
            level++;
        }
        return al;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read N (number of nodes)
        int N = sc.nextInt();
        int[] inorder = new int[N];
        int[] postorder = new int[N];

        // Read inorder traversal
        for (int i = 0; i < N; i++) {
            inorder[i] = sc.nextInt();
        }

        // Read postorder traversal
        for (int i = 0; i < N; i++) {
            postorder[i] = sc.nextInt();
        }

        // Read number of queries Q
        int Q = sc.nextInt();
        int[] L = new int[Q];
        int[] U = new int[Q];

        // Read Q pairs (L, U)
        for (int i = 0; i < Q; i++) {
            L[i] = sc.nextInt();
            U[i] = sc.nextInt();
        }

        // Build the tree
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(inorder[i], i);
        }

        postIndex = N - 1;
        TreeNode root = build_tree(inorder, postorder, 0, N - 1, map);

        // Process each query
        for (int i = 0; i < Q; i++) {
            List<Integer> result = hnet(root, L[i], U[i]);
            System.out.println(result);
        }
    }
}
