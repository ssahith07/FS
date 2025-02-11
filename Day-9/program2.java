//day9program2
// Balbir Singh is working with Binary Trees.
// The elements of the tree are given in level-order format.

// Balbir is observing the tree from the right side, meaning he
// can only see the rightmost nodes (one node per level).

// You are given the root of a binary tree. Your task is to determine
// the nodes visible from the right side and return them in top-to-bottom order.

// Input Format:
// -------------
// Space separated integers, elements of the tree.

// Output Format:
// --------------
// A list of integers representing the node values visible from the right side

// Sample Input-1:
// ---------------
// 1 2 3 4 -1 -1 5

// Sample Output-1:
// ----------------
// [1, 3, 5]

// Sample Input-2:
// ---------------
// 3 1 4 5 2

// Sample Output-2:
// ----------------
// [3, 4, 2]

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
    static TreeNode build_tree(int[] a){
        if(a.length==0||a[0]==-1) return null;
        TreeNode root = new TreeNode(a[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i=1;
        while (!q.isEmpty() && i<a.length) {
            TreeNode curr = q.poll();
            if (i<a.length && a[i]!=-1) {
                curr.left = new TreeNode(a[i]);
                q.add(curr.left);
            }
            i++;
            if (i<a.length && a[i]!=-1) {
                curr.right = new TreeNode(a[i]);
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }

    static void rightSide(TreeNode root, List<Integer> l){
        if(root==null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                l.add(curr.val);
                if(curr.right!=null) q.add(curr.right);
            }
        }
    }
    public static void main(String[] args) {
        int[] a = {1,2,3,4,-1,-1,5};
        TreeNode root = build_tree(a);
        List<Integer> l = new ArrayList<>();
        rightSide(root,l);
        System.out.println(l);
    }    
}










// import java.util.*;

// class node {
//     int val;
//     node left, right;

//     node(int val) {
//         this.val = val;
//         left = right = null;
//     }
// }

// public class day9program2 {
//     public static node buildTree(List<Integer> vals) {
//         if (vals == null || vals.isEmpty() || vals.get(0) == -1)
//             return null;

//         node root = new node(vals.get(0));
//         Queue<node> q = new LinkedList<>();
//         q.add(root);
//         int i = 1;

//         while (i < vals.size()) {
//             node curr = q.poll();
//             if (i < vals.size() && vals.get(i) != -1) {
//                 curr.left = new node(vals.get(i));
//                 q.add(curr.left);
//             }
//             i++;
//             if (i < vals.size() && vals.get(i) != -1) {
//                 curr.right = new node(vals.get(i));
//                 q.add(curr.right);
//             }
//             i++;
//         }
//         return root;
//     }

//     public static List<Integer> right_view(node root) {
//         List<Integer> res = new ArrayList<>();
//         if (root == null)
//             return null;
//         Queue<node> q = new LinkedList<>();
//         q.add(root);
//         while (!q.isEmpty()) {
//             int size = q.size();
//             node flag = null;
//             for (int i = 0; i < size; i++) {
//                 node curr = q.poll();
//                 flag = curr;
//                 if (curr.left != null)
//                     q.add(curr.left);
//                 if (curr.right != null)
//                     q.add(curr.right);
//             }
//             res.add(flag.val);
//         }
//         return res;
//     }

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         String[] input = sc.nextLine().split(" ");
//         List<Integer> vals = new ArrayList<>();
//         for (String s : input) {
//             vals.add(Integer.parseInt(s));
//         }
//         node root = buildTree(vals);
//         System.out.println(right_view(root));
//     }
// }
