// * VishnuVardan is working with Decision Trees for AI-based predictions.
// * To analyze alternative outcomes, Kishore has planned to flip the decision
// * tree horizontally to simulate a reverse processing approach.
// *
// * Rules for Flipping the Decision Tree:
// * - The original root node becomes the new rightmost node.
// * - The original left child becomes the new root node.
// * - The original right child becomes the new left child.
// * This transformation is applied level by level recursively.
// *
// * Note:
// * ------
// * - Each node in the given tree has either 0 or 2 children.
// * - Every right node in the tree has a left sibling sharing the same parent.
// * - Every right node has no further children (i.e., they are leaf nodes).
// *
// * Your task is to help VishnuVardan flip the Decision Tree while following
// * the given transformation rules.
// *
// * Input Format:
// * -------------
// * Space separated integers, nodes of the tree.
// *
// * Output Format:
// * --------------
// * Print the list of nodes of flipped tree as described below.
// *
// *
// * Sample Input-1:
// * ---------------
// * 4 2 3 5 1
// *
// * Sample Output-1:
// * ----------------
// * 5 1 2 3 4
// *
// *
// * Sample Input-2:
// * ---------------
// * 4 2 5
// *
// * Sample Output-2:
// * ----------------
// * 2 5 4
// */

import java.util.*;

class TreeNode

{
    int val;
    TreeNode left, right;

    public TreeNode(int val)

    {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class day10program1 {
    public static TreeNode createTree(int l[])

    {

        if (l.length == 0)
            return null;
        TreeNode root = new TreeNode(l[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < l.length)

        {

            TreeNode node = queue.poll();
            if (l[i] != -1)

            {
                node.left = new TreeNode(l[i]);
                queue.add(node.left);

            }
            i++;
            if (l[i] != -1)

            {
                node.right = new TreeNode(l[i]);
                queue.add(node.right);

            }
            i++;

        }
        return root;
    }

    public static List<Integer> levelOrder(TreeNode root)

    {

        List<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())

        {

            TreeNode node = queue.poll();
            result.add(node.val);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
        }
        return result;
    }

    public static TreeNode flip(TreeNode root)

    {
        if (root == null)
            return root;
        if (root.left == null)
            return root;
        TreeNode newroot = flip(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = root.right = null;
        return newroot;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s[] = sc.nextLine().split("\\s+");
        int a[] = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        TreeNode root = createTree(a);
        TreeNode Fliproot = flip(root);
        List<Integer> res = levelOrder(Fliproot);
        for (int i = 0; i < res.size(); i++)
            System.out.print(res.get(i) + " ");
    }
}