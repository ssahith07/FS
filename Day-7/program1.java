/*
Write a program to construct a binary tree from level-order input, while treating -1 
as a placeholder for missing nodes. The program reads input, constructs the tree, 
and provides an in-order traversal to verify correctness.

Input Format:
---------------
Space separated integers, level order data (where -1 indiactes null node).

Output Format:
-----------------
Print the in-order data of the tree.


Sample Input:
----------------
1 2 3 -1 -1 4 5

Sample Output:
----------------
2 1 4 3 5

Explanation:
--------------
    1
   / \
  2   3
     / \
    4   5


Sample Input:
----------------
1 2 3 4 5 6 7

Sample Output:
----------------
4 2 5 1 6 3 7

Explanation:
--------------
        1
       / \
      2   3
     / \  / \
    4  5 6  7

====================================
*/

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

public class program1 {
    static TreeNode build_tree(int[] ord){
        if(ord[0]==-1 || ord.length==0) return null;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(ord[0]);
        int i=1;
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (i < ord.length && ord[i] != -1) {
                node.left = new TreeNode(ord[i]);
                q.add(node.left);
            }
            i++;
            if (i<ord.length && ord[i]!=-1) {
                node.right = new TreeNode(ord[i]);
                q.add(node.right);
            }
            i++;
        }
        return root;
    }
    static void inorder(TreeNode root, List<Integer> l){
        if (root==null) {
            return;
        }
        Stack<TreeNode> st = new Stack<>();
        while (!st.isEmpty()||root!=null) {
            while (root!=null) {
                st.push(root);
                root=root.left;
            }
            root = st.pop();
            l.add(root.val);
            root = root.right;
        }
        
    }
    public static void main(String[] args) {
        int[] ord = {1,2,3,4,5,6,7};
        TreeNode root = build_tree(ord);
        List<Integer> l = new ArrayList<>();
        inorder(root,l);
        System.out.println(l);
    }
}
