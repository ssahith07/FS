// /*
// Mr. Rakesh is interested in working with Data Structures.

// He has constructed a Binary Tree (BT) and asked his friend
// Anil to check whether the BT is a self-mirror tree or not.

// Can you help Rakesh determine whether the given BT is a self-mirror tree?
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
// */

import java.util.*;

class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class program1 {
    public static Node buildTree(List<Integer> vals) {
        if (vals == null || vals.size() == 0 || vals.get(0) == -1)
            return null;
        Node root = new Node(vals.get(0));
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (i < vals.size()) {
            Node curr = q.poll();
            if (i < vals.size() && vals.get(i) != -1) {
                curr.left = new Node(vals.get(i));
                q.add(curr.left);
            }
            i++;
            if (i < vals.size() && vals.get(i) != -1) {
                curr.right = new Node(vals.get(i));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }

    public static boolean mirror(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        if (root1.val != root2.val)
            return false;
        return (mirror(root1.left, root2.right) && mirror(root1.right, root2.left));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inp = sc.nextLine().split(" ");
        List<Integer> vals = new ArrayList<>();
        for (String s : inp) {
            vals.add(Integer.parseInt(s));
        }
        Node root = buildTree(vals);
        if (root == null) {
            System.out.println(false);
        } else {
            System.out.println(mirror(root.left, root.right));
        }
        List<List<Integer>> al = new ArrayList<>();
        
    }
}