/*
Bablu is working in a construction field.
He has N number of building blocks, where the height and width of all the blocks are same.
And the length of each block is given in an array, blocks[].

Bablu is planned to build a wall in the form of a square.
The rules to cunstruct the wall are as follows:
	- He should use all the building blocks.
	- He should not break any building block, but you can attach them with other.
	- Each building-block must be used only once.
	
Your task is to check whether Bablu can cunstruct the wall as a square
with the given rules or not. If possible, print true. Otherwise, print false.

Input Format:
-------------
Line-1: An integer N, number of BuildingBlocks.
Line-2: N space separated integers, length of each block.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
6
1 2 6 4 5 6

Sample Output-1:
----------------
true


Sample Input-2:
---------------
6
5 3 2 5 5 6

Sample Output-2:
----------------
false
*/

import java.util.*;

public class program1{
    static boolean backtrack(int ind, int[] a,int[] s,int side){
        if(ind==a.length){
            for(int i=0;i<4;i++){
                if(s[i]!=side) return false;
            }
            return true;
        }
        for(int i=0;i<4;i++){
            if(s[i]+a[ind]<=side){
                s[i]+=a[ind];
                if(backtrack(ind+1,a,s,side)) return true;
                s[i]-=a[ind];
            }
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int sum = Arrays.stream(a).sum();
        if(sum%4==0){
            int[] s = new int[4];
            System.out.println(backtrack(0,a,s,sum/4) );
        }
        else System.out.println(false);
    }
}