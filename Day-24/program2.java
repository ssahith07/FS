/*
A number is called self-supportive if all the digits of the number are factors 
of the number. For example, 48 is a self-supportive number because 48 % 4 == 0, 
and 48 % 8 == 0.

A number is not a self-supportive if it has any digit as zero.

Given two Positive numbers start and end, return a set of all 
the self-supportive numbers in between start and end (both inclusive).

1<=start<=end<=10^4

Input Format:
-------------
Line: 2 space seperated integers start and end.
 
Output Format:
--------------
Print a space seperated list.
 

Sample Input-1:
---------------
20 25
 
Sample Output-1:
----------------
22 24

Explanation:
-----------
20 has 0 as digit so it's not self - supportive.
21 is not divisible by 2. so it's not self - supportive.
22 is divisible 2. so it's self - supportive.
23 is not divisible by both the digits 2 and 3. so it's not self - supportive.
24 is divisible by both 2 and 4. so it is self - supportive.
So 22 and 24 are self-supportive.

 
Sample Input-2:
---------------
50 80

Sample Output-2:
----------------
55 66 77
*/

import java.util.*;
public class program2{
    public static boolean check(int n){
        String s = String.valueOf(n);
        if(s.contains("0")) return false;
        char a[] = s.toCharArray();
        for(char c : s.toCharArray()){
            int digit = Character.getNumericValue(c);
            if(n % digit != 0)  return false;
        }
        return true; 
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();
        List<Integer>l = new ArrayList<>();
        for(int i = s;i<=e;i++){
            if(check(i))    l.add(i);
        }
        System.out.println(l);
    }
}