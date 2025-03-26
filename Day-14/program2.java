// In Marketing Job, each agent will mentor atmost two sub-agents. 
// At the end, all mentor agents and sub agents, will be treated as agents only.

// Now, you are given the sales data of two months as a tree, tree contains the 
// count of the items sold by each agent, few agents might join the job and 
// few might left the job.

// You are given the sales data as month-1 and month-2.
// Your task is to find get the combined report of two months data.

// Implement the class Solution:
//    1. public TreeNode combinedReport(TreeNode root1, TreeNode root2): 
//     returns the root node of the combined data.

// NOTE:
// 	- In the tree '-1', indicates no sales(null).

// Input Format:
// -------------
// Line-1: space separated integers, sales data of month-1
// Line-2: space separated integers, sales data of month-2

// Output Format:
// --------------
// Print list of integers, with combined sales data.


// Sample Input-1:
// ---------------
// 2 5 2 -1 -1 -1 4
// 1 2 3 4 5

// Sample Output-1:
// ----------------
// 3 7 5 4 5 4


// Sample Input-2:
// ---------------
// 1 2 3 4
// 1

// Sample Output-2:
// ----------------
// 2 2 3 4



/*
TreeNode for Reference.

class TreeNode {
    Integer val;
    TreeNode left, right;
    
    TreeNode(Integer val) {
        this.val = val;
        this.left = this.right = null;
    }
}
*/
import java.util.*;
class Solution{
    public ArrayList<Integer> levelOrder(TreeNode root){
        ArrayList<Integer> l = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            l.add(temp.val);
            if(temp.left!=null) q.add(temp.left);
            if(temp.right!=null) q.add(temp.right);
        }
        return l;
    }
    public TreeNode combinedReport(TreeNode root1, TreeNode root2){
        // Implement the logic
        if(root1==null && root2==null) return null;
        if(root1==null) return root2;
        if(root2==null) return root1;
        TreeNode res = new TreeNode(root1.val+root2.val);
        res.left = combinedReport(root1.left,root2.left);
        res.right = combinedReport(root1.right,root2.right);
        ArrayList<Integer> l = levelOrder(res);
        return res;
    }
}