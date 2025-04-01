// In a distant future, humanity has begun interstellar colonization, establishing 
// zones of habitation and control on a new planet. Scientists have recorded two 
// types of data regarding how these zones were structured:

// 1. Survey Order (analogous to pre-order traversal) – This record details how 
// the colonization started, with the first zone established and then expanding 
// into new zones following a systematic approach.
// 2. Planetary Layout (analogous to in-order traversal) – This document shows 
// how zones were positioned relative to each other on the map, based on 
// territorial boundaries.

// Using this information, scientists need to reconstruct the colonization hierarchy 
// (binary tree of zones) and analyze areas within a specific range of levels. 
// However, due to security concerns, patrol teams will scan these zones in a 
// zigzag pattern:
//     - Odd levels (starting from 1) should be inspected from left to right.
//     - Even levels should be inspected from right to left.

// Input Format:
// -------------
// An integer N representing the number of zones colonized.
// N space-separated integers representing the Planetary Layout Order (in-order).
// N space-separated integers representing the Survey Order (pre-order).
// Two space sepaarted integers,Lower Level (L), Upper Level (U)

// Output Format:
// --------------
// Print all zone IDs within the specified levels, but in spiral order:
//     - Odd levels → Left to Right.
//     - Even levels → Right to Left.

// Sample Input:
// -------------
// 7
// 4 2 5 1 6 3 7
// 1 2 4 5 3 6 7
// 2 3

// Sample Output:
// --------------
// 3 2 4 5 6 7

// Explanation:
// ------------
// The given Planetary Layout (in-order) and Survey Order (pre-order) correspond 
// to the following colonization hierarchy:

//         1
//        / \
//       2   3
//      / \  / \
//     4   5 6  7

// Levels 2 to 3 in Regular Order:
// Level 2 → 2 3
// Level 3 → 4 5 6 7 

// Spiral Order:
// Level 2 (Even) → 3 2 (Right to Left)
// Level 3 (Odd) → 4 5 6 7 (Left to Right)

import java.util.*;
class Treenode{
    int root;
    Treenode left,right;
    Treenode(int root){
        this.root = root;
        this.left = null;
        this.right = null;
    }
}

public class program2{
    static int preIndex;
    static Treenode create_tree(int[] inord,int[] preord, int st, int end, Map<Integer, Integer> inMap) {
        if (st > end) {
            return null;
        }

        int rootVal = preord[preIndex++];
        // System.out.println(preIndex);
        Treenode root = new Treenode(rootVal);
        int rootIndex = inMap.get(rootVal);

        root.right = create_tree(inord,preord, rootIndex + 1, end, inMap);
        root.left = create_tree(inord,preord, st, rootIndex - 1, inMap);

        return root;
    }
    static List<Integer> levelOrder(Treenode root,int low,int up) { 
        List<Integer> res = new ArrayList<>();
        Queue<Treenode> q = new LinkedList<>();
        int t = 1;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Treenode temp = q.poll();
                if (t>=low && t<=up) {
                    l.add(temp.root);
                }
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }
            if (t>=low && t<=up) {
                if (t%2==0) {
                    Collections.reverse(l);
                }
            }
            res.addAll(l);
            t++;
        }
        return res;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = 7;
        int[] inord = {4,2,5,1,6,3,7};
        int[] preord =  {1,2,4,5,3,6,7};
        // int n = sc.nextInt();
        // int[] inord = new int[n];
        // int[] preord = new int[n];
        // for(int i=0;i<n;i++) inord[i] = sc.nextInt();
        // for(int i=0;i<n;i++) preord[i] = sc.nextInt();
        // int low = sc.nextInt();
        // int up = sc.nextInt();
        int low = 2;
        int up = 3;
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inord.length; i++) {
            inMap.put(inord[i], i);
        }
        preIndex = 0;
        Treenode root = create_tree(inord, preord, 0, n - 1, inMap);
        List<Integer> result = levelOrder(root,low,up);
        System.out.println(result);
    }
}
