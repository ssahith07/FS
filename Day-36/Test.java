// There are N people having some amount in their credit cards, both +ve or -ve.
// You are given the amounts as an integer array cards[], in rupees.

// You are allowed to perform only one operation:
//     - pick N-1 credit cards add 1rupee to each card.
    
// Your task is to return the minimum number of operations required to
// make all the credit cards to have the same amount.

// Input Format:
// -------------
// Line-1: An integer N
// Line-2: N space separated integers, cards[]

// Output Format:
// --------------
// Print an integer result.


// Sample Input-1:
// ---------------
// 4
// 2 5 4 3

// Sample Output-1:
// ----------------
// 6

// Explanation:
// ------------
// 6 operations are required.
// [2, 5, 4, 3]  =>  [3, 5, 5, 4]  =>  [4, 5, 6, 5]  =>  [5, 6, 6, 6]
// =>  [6, 7, 7, 6] => [7, 8, 7, 7] => [8, 8, 8, 8]


// Sample Input-2:
// ---------------
// 5
// 4 5 9 8 5

// Sample Output-2:
// ----------------
// 11

import java.util.*;

public class Test{
    static boolean unique(int[] a){
        for(int i=0;i<a.length-1;i++){
            if(a[i]!=a[i+1]) return false;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int c=0;
        Arrays.sort(a);
        while(!unique(a)){
            for(int i=0;i<n-1;i++){
                a[i]++;
            }
            Arrays.sort(a);
            c++;
        }
        System.out.println(c);
    }
}