/*
There are some pages in a website, each page links with atmost two other pages.
Each page displays a number on it. The complete website is given as binary tree 
using the level order insertion technique.

You need to return the number of pages where the number in the page is equal to 
the sum of the numbers of its descendants. A descendant refers to any page that 
is linked but lower down the tree stucture of the website, no matter how many 
levels lower.

Input Format:
-------------
Single line of comma separated integers, numbers displayed in web-pages as Tree.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
11 3 5 2 1

Sample Output-1:
----------------
2


Sample Input-2:
---------------
3 2 1 0 0

Sample Output-2:
----------------
3

Explanation:
------------
For the pages diplaying the number 0: The sum of descendants is 0,
since they have no descendant pages.

*/
import java.util.*;

class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class program3t {
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

    public static int numPages(Node root, int[] a) {
        if(root==null) return 0;
        int l = numPages(root.left, a);
        int r = numPages(root.right, a);
        if(l+r==root.val){
            a[0]++;
        }
        return l+r+root.val;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inp = sc.nextLine().split(" ");
        List<Integer> vals = new ArrayList<>();
        for (String s : inp) {
            vals.add(Integer.parseInt(s));
        }
        int[] a = new int[1];
        Node root = buildTree(vals);
        numPages(root,a);
        System.out.println(a[0]);
    }
}