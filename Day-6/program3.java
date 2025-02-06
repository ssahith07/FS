import java.util.*;

class Node{
    int root;
    Node left,right;
    Node(int root){
        this.root = root;
        this.left = null;
        this.right = null;
    }
}

public class program3 {
    static Node built_tree(int[] ord,int ind,int n){
        if(ind>=n) return null;
        Node root = new Node(ord[ind]);
        root.left = built_tree(ord, 2*ind+1, n);
        root.right = built_tree(ord, 2*ind+2, n);
        return root;
    }
    static void inorder(Node root,List<Integer> l){
        if(root==null) return;
        inorder(root.left, l);
        l.add(root.root);
        inorder(root.right, l);
    }
    static void preorder(Node root, List<Integer>l1){
        if(root==null) return;
        l1.add(root.root);
        preorder(root.left,l1);
        preorder(root.right, l1);
    }
    static void postorder(Node root, List<Integer>l2){
        if(root==null) return;
        postorder(root.left, l2);
        postorder(root.right, l2);
        l2.add(root.root);
    }
    public static void main(String[] args) {
        int[] ord = {1,2,3,4,5,6,7};
        int n = ord.length;
        List<Integer> l = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        Node root = built_tree(ord,0,n);
        inorder(root,l);
        preorder(root,l1);
        postorder(root,l2);
        System.out.println(l);
        System.out.println(l1);
        System.out.println(l2);
    }
}