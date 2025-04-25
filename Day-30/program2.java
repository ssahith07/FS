// There are N people in a private party. Initially all are strangers to each other,
// and the people are identified by unique ID from 0 to N-1.

// In the party, whenever two persons (person-A and person-B) become friends, they 
// took a photo. Each of the photo has some information, photos[i]=[T-i, P-j,P-k],
// here T-i indicates time of the photo taken, P-j person with ID 'j', and 
// P-k indicates person with ID 'k'.

// Friendship is symmetric[i.e., If P-j is friend of P-k, then P-k is a friend of P-j].
// Additionally, if person-A is "a friend of person-B OR a friend of someone who is 
// friend of person-B", then person-A is friend of person-B.

// You are given L photos information, Your task is to find the earliest time 
// for which every person became friend with every other person in the party.
// If there is no such earliest time, return -1.


// Input Format:
// -------------
// Line-1: Two space separated integers, N and L.
// Next L lines: Three space separated integers, log[i], 0<=i<L.

// Output Format:
// --------------
// Print an integer result.


// Sample Input-1:
// ---------------
// 6 8
// 5 0 1
// 7 3 4
// 12 2 3
// 21 1 5
// 34 2 4
// 37 0 3
// 42 1 2
// 93 4 5

// Sample Output-1:
// ----------------
// 37


// Sample Input-2:
// ---------------
// 7 6
// 2 0 3
// 5 1 5
// 8 2 5
// 7 3 6
// 9 4 6
// 6 4 5

// Sample Output-2:
// ----------------
// 9

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
            if(parent[x]!=x) return parent[x] = find(parent[x]);
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
        int l = sc.nextInt();
        DSU dsu = new DSU(n);
        List<List<Integer>> li = new ArrayList<>();
        int time=0;
        boolean flag = false;
        for(int i=0;i<l;i++){
            List<Integer> al = new ArrayList<>();
            for(int j=0;j<3;j++) al.add(sc.nextInt());
            li.add(al);
        }
        li.sort((a,b)->Integer.compare(a.get(0),b.get(0)));
        // System.out.println(li);
        for(int i=0;i<li.size();i++){
            int x = dsu.find(li.get(i).get(1));
            int y = dsu.find(li.get(i).get(2));
            dsu.union(x,y);
            int c=0;
            for(int j=0;j<n;j++){
                if(dsu.parent[j]==j) c++;
            }
            if(c==1){
                time = li.get(i).get(0);
                System.out.println(time);
                return;
            }
        }
        System.out.println(-1);
    }
}