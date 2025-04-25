/*You are a database integrity engineer working for a global cloud company. 
Your team maintains a distributed database network, where each server either:
    - Stores equivalent data to another server (serverX == serverY).
    - Stores different data from another server (serverX != serverY).

The transitive consistency rule must be followed:
    - If A == B and B == C, then A == C must be true.
    - If A == B and B != C, then A != C must be true.

Your task is to analyze the given constraints and determine whether they 
follow transitive consistency. If all relations are consistent, return true; 
otherwise, return false

Input Format:
-------------
Space separated strnigs, list of relations

Output Format:
--------------
Print a boolean value, whether transitive law is obeyed or not.


Sample Input-1:
---------------
a==b c==d c!=e e==f

Sample Output-1:
----------------
true


Sample Input-2:
---------------
a==b b!=c c==a

Sample Output-2:
----------------
false

Explanation:
------------
{a, b} form one equivalence group.
{c} is declared equal to {a} (c == a), which means {a, b, c} should be equivalent.
However, b != c contradicts b == a and c == a.

Sample Input-3:
---------------
a==b b==c c!=d d!=e f==g g!=d

Sample Output-3:
----------------
true
*/

import java.util.*;

public class program2{
    static class DSU{
        int[] parent;
        public DSU(){
            parent = new int[26];
            for(int i=0;i<26;i++){
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
            if(r1!=r2) {
                parent[r2] = r1;
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String sp = sc.nextLine();
        String[] s = sp.split(" ");
        DSU dsu = new DSU();
        ArrayList<String> l = new ArrayList<>();
        for(String st : s){
            if(st.charAt(1)=='!') l.add(st);
            else{
                int c1 = st.charAt(0)-'a';
                int c2 = st.charAt(3)-'a';
                dsu.union(c1,c2);
            }
        }
        boolean flag = true;
        for(String ss : l){
            int c1 = ss.charAt(0)-'a';
            int c2 = ss.charAt(3)-'a';
            int p1 = dsu.find(c1);
            int p2 = dsu.find(c2);
            if(p1==p2){
                flag = false;
                break;
            }
        }
        System.out.println(flag);
    }
}