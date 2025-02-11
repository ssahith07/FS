//day9program1
// A security team is setting up surveillance cameras in a multi-floor building.
// Each floor has a certain number of cameras, and every camera is assigned
// a resolution value (in megapixels). The placement follows a hierarchical
// structure, similar to a tree:
// - Floor 0 (Ground Floor) has a single main camera (root camera).
// - From the next floor onward, each camera can have at most two sub-cameras,
// one on the left side and one on the right side.
// - If a camera does not have a sub-camera at a position, it is represented as
// -1.

// The goal is to identify the camera with the highest resolution on each floor
// to
// ensure optimal security coverage.

// Input Format:
// -------------
// A single line of space separated integers, the resolution values of cameras

// Output Format:
// --------------
// A list of integers, where eech integer represents the maximum resolution
// camera
// on that floor.

// Sample Input-1:
// ---------------
// 2 4 3 6 4 -1 9

// Sample Output-1:
// ----------------
// [2, 4, 9]

// Sample Input-2:
// ---------------
// 3 4 7 7 3 8 4

// Sample Output-2:
// ----------------
// [3, 4, 8]

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
    static void maxRes(TreeNode root, List<Integer> l){
        if (root==null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                max = Math.max(max, curr.val);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            l.add(max);
        }
    }
    public static void main(String[] args) {
        int[] a = {2,4,3,6,4,-1,9};
        List<Integer> l = new ArrayList<>();
        TreeNode root = build_tree(a);
        maxRes(root, l);
        System.out.println(l);
    }
}