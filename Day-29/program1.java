
/*
In the world of secret codes and cryptography, you are entrusted with deciphering a hidden message. 
You have two encoded keys, key1 and key2, both of equal length. Each character 
in key1 is paired with the corresponding character in key2. 

This relationship follows the standard rules of an equivalence cipher:
• Self-Mapping: Every character inherently maps to itself.  
• Mutual Mapping: If a character from key1 maps to one in key2, then that 
  character in key2 maps back to the one in key1.  
• Chain Mapping: If character A maps to B, and B maps to C, then A, B, and C 
  are all interchangeable in this cipher.

Using this mapping, you must decode a cipherText, by replacing every character 
with the smallest equivalent character from its equivalence group. 
The result should be the relatively smallest possible decoded message.


Input Format:
-------------
Three space separated strings, key1 , key2 and cipherText

Output Format:
--------------
Print a string, decoded message which is relatively smallest string of cipherText.

Example 1: 
input=
attitude progress apriori
output=
aaogoog


Explanation: The mapping pairs form groups: [a, p], [o, r, t], [g, i], [e, u], 
[d, e, s]. By substituting each character in cipherText with the smallest from 
its group, you decode the message to "aaogoog".


Constraints:  
• 1 <= key1.length, key2.length, cipherText.length <= 1000  
• key1.length == key2.length  
• key1, key2, and cipherText consist solely of lowercase English letters.

*/

import java.util.*;

public class program1{
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
            if(r1==r2) return;
            
            if(r1<r2) parent[r2] = r1;
            else parent[r1] = r2;
        }
    }
    public static String decode(String k1,String k2,String c){
        DSU dsu = new DSU();
        for(int i=0;i<k1.length();i++){
            int ch1 = k1.charAt(i)-'a';
            int ch2 = k2.charAt(i)-'a';
            dsu.union(ch1,ch2);
        }
        StringBuilder sb = new StringBuilder();
        for(char ch:c.toCharArray()){
            int sm = dsu.find(ch-'a');
            sb.append((char) (sm+'a'));
        }
        return sb.toString();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] s = new String[3];
        for(int i=0;i<s.length;i++){
            s[i] = sc.next();
        }
        String ans = decode(s[0],s[1],s[2]);
        System.out.println(ans);
    }
}