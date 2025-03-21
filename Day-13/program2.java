/*
Mr. Chandra has an portrait photo with size M*N pixels, 
where M is the length of the portrait and N is width of the portrait.

You are given an integer S in pixels,
Your task is to help Mr. Chammak Chandra to find the actual values 
[M, N] using the following specifications:
- The size of portrait should be equal to S. i.e., S = M*N.
 - N is always smaller than in M, i.e., N <= M
 - The diffrence between length and width, (M-N) should be minimum.
And print the result as a pair M and N.

NOTE: S is always a positive integer.


Input Format:
-------------
Line-1 -> An integer S, size of the portrait.

Output Format:
--------------
Print the result as a pair of integers.


Sample Input-1:
---------------
24

Sample Output-1:
----------------
6 4


Sample Input-2:
---------------
550

Sample Output-2:
----------------
25 22
 
*/
import java.util.*;

public class program2{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int m = s;
        int n = 1;
        for(int i=1;i<=s/2;i++){
            if(s%i == 0){
                int f1 = i;
                int f2 = s/i;
                
                if(f1 <= f2 && (f2-f1) < (m-n)){
                    m = f2;
                    n = f1;
                }
            }
        }
        System.out.println(m+" "+n);
    }
}