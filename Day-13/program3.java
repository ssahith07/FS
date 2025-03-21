/*
A digit sum is the sum of all the digits of a number.
e.g., 123=> 1 + 2 + 3 => 6, So, digit sum of 123 is 6.

You are given an integer N. 
Find the digit sum of each number from 1 to N.
And group them according to their digit sum.

Your task is to find and print the number of groups have the largest size.

Input Format:
-------------
An integer N

Output Format:
--------------
Print an integer, number of groups with largest size.

Sample Input-1:
---------------
13

Sample Output-1:
----------------
4

Explanation:
------------
There are 9 groups formed: [1,10], [2,11], [3,12], [4,13], [5], [6], [7], [8], [9]. 
There are 4 groups having largest size-2.

13

Sample Input-2:
---------------
24

Sample Output-2:
----------------
5


*/

import java.util.*;

public class program3 {
    static int sum(int k){
        int res=0;
        while (k>0) {
            res += k%10;
            k/=10;
        }
        return res;
    }
    public static void main(String[] args) {
        int n=13;
        HashMap<Integer,Integer> hm = new HashMap<>();
        int max=0,count=0;
        for (int i = 1; i <= n; i++) {
            int sum_val = sum(i);
            hm.put(sum_val, hm.getOrDefault(sum_val, 0)+1);
            int size = hm.get(sum_val);
            if(max<size){
                max = size;
                count=1;
            }else if(max==size){
                count++;
            }
        }
        System.out.println(hm);
        System.out.println(count);
    }
}