/*
Imagine you are a librarian organizing books on vertical shelves in a grand library. The books are currently scattered across a tree-like structure, where each book (node) has a position determined by its shelf number (column) and row number (level).

Your task is to arrange the books on shelves so that:
1. Books are placed column by column from left to right.
2. Within the same column, books are arranged from top to bottom (i.e., by row).
3. If multiple books belong to the same shelf and row, they should be arranged from left to right, just as they appear in the original scattered arrangement.

Example 1:
Input:
3 9 20 -1 -1 15 7
Output: 
[[9],[3,15],[20],[7]]

Explanation:
         3
       /   \
      9     20
          /    \
         15     7

Shelf 1: [9]
Shelf 2: [3, 15]
Shelf 3: [20]
Shelf 4: [7]

Example 2:
Input:
3 9 8 4 0 1 7
Output: 
[[4],[9],[3,0,1],[8],[7]]

Explanation:
          3
       /     \
      9       8
    /   \   /   \
   4     0 1     7

Shelf 1: [4]
Shelf 2: [9]
Shelf 3: [3, 0, 1]
Shelf 4: [8]
Shelf 5: [7]

Library Organization Rules:
1. Each column represents a shelf from left to right.
2. Books on the same shelf are arranged from top to bottom.
3. If books share the same position, they are arranged left to right in order of appearance.

*/

import java.util.*;

class Node{
    int val;
    Node left,right;
    Node(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class Pair{
    Node root;
    int l;
    int r;
    Pair(Node root,int l,int r){
        this.root = root;
        this.l = l;
        this.r = r;
    }
}
public class program1{
       public static Node buildTree(List<Integer> vals){
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
    public static List<List<Integer>> verticalOrder(Node root){
        TreeMap<Integer,TreeMap<Integer,List<Integer>>> tm = new TreeMap<>();
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(root,0,0));
        while(!q.isEmpty()){
            Pair curr = q.poll();
            Node temp = curr.root;
            int x = curr.l;
            int y = curr.r;
            if(!tm.containsKey(x)) tm.put(x,new TreeMap<>());
            if(!tm.get(x).containsKey(y)) tm.get(x).put(y,new ArrayList<>());
            tm.get(x).get(y).add(temp.val);
            
            if(temp.left!=null) q.add(new Pair(temp.left,x+1,y-1));
            if(temp.right!=null) q.add(new Pair(temp.right,x-1,y+1));
        }
        List<List<Integer>> l = new ArrayList<>();
        for(TreeMap<Integer,List<Integer>> e : tm.values()){
            l.add(new ArrayList<>());
            for(List<Integer> p : e.values()){
                l.get(l.size()-1).addAll(p);
            }          
        }
        return l;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] inp = sc.nextLine().split(" ");
        List<Integer> vals = new ArrayList<>();
        for (String s : inp) {
            vals.add(Integer.parseInt(s));
        }
        Node node = buildTree(vals);
        List<List<Integer>> al = verticalOrder(node);
        Collections.reverse(al);
        System.out.println(al);
    }
}