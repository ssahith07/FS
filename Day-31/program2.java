/*You're working as a network administrator for a new startup that has set up 
N computers in its office. Due to cost constraints, they’ve haphazardly laid out
Ethernet cables between computers. Each cable connects exactly two computers, 
and no two computers are connected by more than one cable.

The management wants every computer to be part of a fully connected network, 
where any computer can reach any other either directly or indirectly. 
You're allowed to reallocate existing cables by removing them from 
one connection and using them to connect a new pair of computers.

However, you cannot create new cables — you can only reuse the existing ones. 
Your task is to determine the minimum number of such cable reallocation 
operations required to make the network fully connected. 
If it’s not possible with the current number of cables, return -1.

Input Format:
-------------
- N and C (integer): number of computers labeled from 0 to n - 1, and number 
of connections.
- C connections (List of integer pairs): each pair [a, b] represents 
a cable directly connecting computers a and b

Output Format:
--------------
An integer result.


Sample Input-1:
---------------
4 3
0 1
0 2
1 2

Sample Output-1:
----------------
1


Sample Input-2:
---------------
6 5
0 1
0 2
0 3
1 2
1 3

Sample Output-2:
----------------
2


Sample Input-3:
---------------
6 4
0 1
0 2
0 3
1 2


Sample Output-3:
----------------
-1
 */
import java.util.*;

public class program2{
    static class DSU{
        int[] parent;
        public DSU(int n){
            parent = new int[n];
            for(int i=0;i<n;i++){
                parent[i] = i;
            }
        }
        public int find(int x){
            if(parent[x]!=x) parent[x] = find(parent[x]);
            return parent[x];
        }
        public void union(int x,int y){
            int r1 = find(x);
            int r2 = find(y);
            if(r1!=r2) parent[r2] = r1;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        if(c<n-1){
            System.out.println(-1);
            return;
        } 
        DSU dsu = new DSU(n);
        for(int i=0;i<c;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            dsu.union(a,b);
        }
        HashSet<Integer> s = new HashSet<>();
        for(int i=0;i<n;i++){
            s.add(dsu.find(i));
        }
        System.out.println(s.size()-1);
    }
}