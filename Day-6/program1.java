// In a distant galaxy, an ancient civilization built a hierarchical communication 
// network of interconnected relay stations. The structure of this network can be 
// reconstructed using two ancient data logs:
//     - Beacon Activation Order (analogous to in-order traversal)
//     - Final Signal Sent Order (analogous to post-order traversal)
    
// Using these logs, we can reconstruct the original relay network and process q
// ueries about signals reaching specific hierarchical levels.

// Given the Beacon Activation Order and the Final Signal Sent Order of a galactic 
// communication network, reconstruct the relay network. After reconstructing 
// the hierarchy, and the output should list the relay stations in the order they 
// appear in a level-wise transmission sequence.

// Input Format:
// -------------
// - An integer N representing the number of relay stations in the network.
// - A space-separated list of N integers representing the Beacon Activation Order 
//     (similar to in-order traversal).
// - A space-separated list of N integers representing the Final Signal Sent Order 
//     (similar to post-order traversal).

// Output Format:
// --------------
// A list of integers, level-wise transmission sequence.


// Sample Input:
// -------------
// 7
// 4 2 5 1 6 3 7
// 4 5 2 6 7 3 1
// Sample Output:
// ---------------
// [1, 2, 3, 4, 5, 6, 7]


// Explanation:
// The logs correspond to the following hierarchical relay network:
//         1
//        / \
//       2   3
//      / \  / \
//     4   5 6  7
// The level order is : 1 2 3 4 5 6 7 


import java.util.*;

class Treenode {
    int root;
    Treenode left, right;

    Treenode(int root) {
        this.root = root;
        this.left = null;
        this.right = null;
    }
}

public class program1 {
    static int postIndex;

    static Treenode create_tree(ArrayList<Integer> l, ArrayList<Integer> al, int st, int end, Map<Integer, Integer> inMap) {
        if (st > end) {
            return null;
        }

        int rootVal = al.get(postIndex--);
        Treenode root = new Treenode(rootVal);
        int rootIndex = inMap.get(rootVal);

        root.right = create_tree(l, al, rootIndex + 1, end, inMap);
        root.left = create_tree(l, al, st, rootIndex - 1, inMap);

        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> l = new ArrayList<>();
        ArrayList<Integer> al = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            l.add(sc.nextInt());
        }
        for (int i = 0; i < n; i++) {
            al.add(sc.nextInt());
        }

        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < l.size(); i++) {
            inMap.put(l.get(i), i);
        }

        postIndex = n - 1;
        Treenode root = create_tree(l, al, 0, n - 1, inMap);
        System.out.println(root.root);
    }
}
