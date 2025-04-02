/*
You are given two words W1 and W2.
You need find all the mapping of W2 in W1, and 
return all the statrting indices of the mappings.

The mapping of the words w2 and w1 is as follows:
	- A shuffled word contains all the characters as original word.
	The length of the words and occurrence count of each character are same.
	- find shuffled word of W2 as a substring in W1, and 
	return the starting index of substring.


Input Format:
-------------
Single line space separated strings, two words.

Output Format:
--------------
Print the list of integers, indices.


Sample Input-1:
---------------
abcabcabc abc
 
Sample Output-1:
----------------
[0, 1, 2, 3, 4, 5, 6]



Sample Input-2:
---------------
bacacbacdcab cab

Sample Output-2:
----------------
[0, 3, 4, 5, 9]
 
*/
// use hashmap--------. 

import java.util.*;

public class program2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String w1 = sc.next();
        String w2 = sc.next();
        char[] key = w2.toCharArray();
        Arrays.sort(key);
        List<Integer> al = new ArrayList<>();
        int l = w2.length();
        for(int i=1,j=0;i<=w1.length();i++){
            if(l==i-j){
                String s = w1.substring(j,i);
                char[] arr = s.toCharArray();
                Arrays.sort(arr);
                if(Arrays.equals(key, arr)){
                    al.add(j);
                }
                j++;
            }
        }
        System.out.println(al);
    }
}