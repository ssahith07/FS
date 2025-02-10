// Mr. Rakesh is interested in working with Data Structures.

// He has constructed a Binary Tree (BT) and asked his friend 
// Anil to check whether the BT is a self-mirror tree or not.

// Can you help Anil determine whether the given BT is a self-mirror tree?
// Return true if it is a self-mirror tree; otherwise, return false.

// Note:
// ------
// In the tree, '-1' indicates an empty (null) node.

// Input Format:
// -------------
// A single line of space separated integers, values at the treenode

// Output Format:
// --------------
// Print a boolean value.


// Sample Input-1:
// ---------------
// 2 1 1 2 3 3 2

// Sample Output-1:
// ----------------
// true


// Sample Input-2:
// ---------------
// 2 1 1 -1 3 -1 3

// Sample Output-2:
// ----------------
// false


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
public class Test{
   static TreeNode build_treel(int[] a, int ind, int n) {
        if (ind>=n || a[ind] == -1) return null;
        TreeNode root = new TreeNode(a[ind]);
        root.left = build_treel(a, 2*ind+1, n);
        root.right = build_treel(a, 2*ind+2, n);
        return root;
   }

    static TreeNode build_treer(int[] a, int ind, int n) {
        if (ind>=n || a[ind]==-1) return null;
        TreeNode root = new TreeNode(a[ind]);
        root.right = build_treer(a, 2*ind+1, n);
        root.left = build_treer(a, 2*ind+2, n);
        return root;
    }

    static boolean isSame(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val) &&
               isSame(t1.left, t2.left) &&
               isSame(t1.right, t2.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] a = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            a[i] = Integer.parseInt(input[i]);
        }

        int n = a.length;
        TreeNode r1 = build_treel(a, 0, n);
        TreeNode r2 = build_treer(a, 0, n);

        // System.out.println(isSame(r1, r2));
    }
}



// class TreeNode {
//     int val;
//     TreeNode left, right;
    
//     TreeNode(int val) {
//         this.val = val;
//         this.left = null;
//         this.right = null;
//     }
// }

// public class Trees {
//     static TreeNode build_treel(int[] ord) {
//         if (ord.length == 0 || ord[0] == -1) return null;
        
//         TreeNode root = new TreeNode(ord[0]);
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);
        
//         int i = 1;
//         while (!q.isEmpty() && i < ord.length) {
//             TreeNode curr = q.poll();

//             if (i < ord.length && ord[i] != -1) {
//                 curr.left = new TreeNode(ord[i]);
//                 q.add(curr.left);
//             }
//             i++;

//             if (i < ord.length && ord[i] != -1) {
//                 curr.right = new TreeNode(ord[i]);
//                 q.add(curr.right);
//             }
//             i++;
//         }
//         return root;
//     }

//     static boolean mirror(TreeNode r1, TreeNode r2) {
//         if (r1 == null && r2 == null) return true;
//         if (r1 == null || r2 == null) return false;
        
//         return (r1.val == r2.val) &&
//               mirror(r1.left, r2.right) &&
//               mirror(r1.right, r2.left);
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         String s = sc.nextLine(); 
//         String[] ch = s.split(" ");
//         int[] ord = new int[ch.length];

//         for (int i = 0; i < ch.length; i++) {
//             ord[i] = Integer.parseInt(ch[i]);
//         }

//         TreeNode r1 = build_treel(ord);

//         if (mirror(r1.left, r1.right)) { 
//             System.out.println(true);
//         } else {
//             System.out.println(false);
//         }
//     }
// }
