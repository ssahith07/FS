/*You are given a crystal with an energy level n. Your goal is to discover all 
the different ways this crystal could have been created by combining smaller shards.

Each combination must:
- Use only shards with energy values between 2 and n - 1.
- Be represented as a list of shard values whose product equals n.
- Use any number of shards (minimum 2), and the order is ascending order.

Your task is to return all unique shard combinations that can multiply together
to recreate the original crystal.

Example 1:
---------
Input:
28

Output:
[[2, 14], [2, 2, 7], [4, 7]]

Example 2:
----------
Input:
23

Output:
[]



Constraints:
- 1 <= n <= 10^4
- Only shards with energy between 2 and n - 1 can be used.
*/

import java.util.*;

public class program3{
    public static void backtrack(int s,int n,int p,List<List<Integer>> al,List<Integer> l){
        if(p>n+1 || s>=n) return;
        if(p==n+1){
            al.add(new ArrayList<>(l));
            return;
        }
        p*=s;
        l.add(s);
        backtrack(s,n,p,al,l);
        l.remove(l.size()-1);
        p/=s;
        backtrack(s+1,n,p,al,l);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> al = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        backtrack(2,n-1,1,al,l);
        System.out.println(al);
    }
}