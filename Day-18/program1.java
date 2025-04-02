/*
In an institution there is a special keyboard.
It contains only one row of 26-keys, keys[]

The order of keys will be given, You need to findout the time taken to type a word.

The rules to find the time is as follows:
Initially you will be at first key .i.e, keys[0].
To type a character, you have to move to a key having desired character, key[j].
Time taken to type the character from key at ith index to key at jth index is |i - j|.

You will be given two strings, Keys and Word W.
Your task is to find how much time it takes to type the Word W 
using the given order of keys

NOTE: You have to use only one finger to type the word.

Input Format:
-------------
Line-1: A String Keys order.
Line-2: A String word W to type.

Output Format:
--------------
An integer T, time to type the word.


Sample Input-1:
---------------
poiuytrewqasdfghjklmnbvcxz
kmit

Sample Output-1:
----------------
39


Sample Output-2:
----------------
abcdefghijklmnopqrstuvwxyz
code

Sample Output-2:
----------------
26

*/
// use hashmap for optimization.

import java.util.*;

public class program1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String key = sc.next();
        int l = key.length();
        int i=0,j=0,k=0;
        int total=0;
        while(k<l && i<s.length()){
            if(s.charAt(i)==key.charAt(k)){
                total+=Math.abs(i-j);
                k++;
                j=i;
                i=-1;
            }
            i++;
        }
        System.out.println(total);
    }
}
