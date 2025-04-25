/*
There are N cities, and M routes[], each route is a path between two cities.
routes[i] = [city1, city2], there is a travel route between city1 and city2.
Each city is numbered from 0 to N-1.
 
There are one or more Regions formed among N cities. 
A Region is formed in such way that you can travel between any two cities 
in the region that are connected directly and indirectly.
 
Your task is to findout the number of regions formed between N cities. 
 
Input Format:
-------------
Line-1: Two space separated integers N and M, number of cities and routes
Next M lines: Two space separated integers city1, city2.
 
Output Format:
--------------
Print an integer, number of regions formed.
 
 
Sample Input-1:
---------------
5 4
0 1
0 2
1 2
3 4
 
Sample Output-1:
----------------
2
 
 
Sample Input-2:
---------------
5 6
0 1
0 2
2 3
1 2
1 4
2 4
 
Sample Output-2:
----------------
1
 
Note: Look HINT for explanation.
*/

import java.util.*;

public class program3{
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
            if(r1==r2) return;
            if(r1<r2) parent[r2] = r1;
            else parent[r1] = r2;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nc = sc.nextInt();
        int roads = sc.nextInt();
        DSU dsu = new DSU(nc);
        // int[] a = new int[roads];
        // int[] b = new int[roads];
        for(int i=0;i<roads;i++){
            int u= sc.nextInt();
            int v= sc.nextInt();
            dsu.union(u,v);
        }
        
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<nc;i++){
            hs.add(dsu.find(i));
        }
        System.out.println(hs.size());
    }
}