/* 
Two brothers want to play a game, 
The rules of the game are: one player gives two sorted lists of 
numerical elements and a number (sum). 
The opponent has to find the closest pair of elements 
to the given sum.
-> pair consists of elements from each list

Please help those brothers to develop a program, that takes 
two sorted lists as input and return a pair as output.

Input Format:
-------------
size of list_1
list_1 values
size of list_2
list_2 values
closest number

Output Format:
--------------
comma-separated pair

Sample Input-1:
---------------
4
1 4 5 7
4
10 20 30 40
32
Sample Output-1
---------------
1,30

Sample Input-2
---------------
3
2 4 6
4
5 7 11 13
15
sample output-2
---------------
2,13


*/

import java.util.*;
public class program4{
    public static int[] close(int []a,int []b,int target){
        int i = 0;
        int j = b.length - 1;
        int []ans = new int[2];
        int closest = Integer.MAX_VALUE;
        
        while(i < a.length && j >= 0){
            int curr = a[i]+b[j];
            int diff = Math.abs(target-curr);
            if(diff < closest){
                closest = diff;
                ans[0] = a[i];
                ans[1] = b[j];
            }
            if(curr < target)  i++; 
            else j--;
        }
        return ans;
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int []a = new int[n1];
        for(int i = 0;i<n1;i++){
            a[i] = sc.nextInt();
        }
        int n2 = sc.nextInt();
        int []b = new int[n2];
        for(int i = 0;i<n2;i++){
            b[i] = sc.nextInt();
        }
        int close = sc.nextInt();
        sc.close();
        
        int []res = close(a,b,close);
   
            System.out.println(res[0]+" "+res[1]);
        
        
    }
}