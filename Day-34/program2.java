// You are given an array ar[], find the closed subsequence in which we subtract 
// the largest and smallest element in the subsequence, the result is equal to 1.

// Your task is to return the length of its greatest closed subsequence among all
// its possible subsequences.

// A subsequence of array is a sequence that can be taken from the array by removing 
// some or no elements without changing the order of the remaining elements.

// Input Format:
// -------------
// Line-1: An integer n number of elements.
// Line-2: n space separated integers represent the elements.

// Output Format:
// --------------
// Print an integer.

// Constraints:
//  1 <= n <= 10^4
//  -10^4 <= ar[i] <= 10^4

// Sample Input-1:
// ---------------
// 6
// 4 3 5 2 6 3

// Sample Output-1:
// ----------------
// 3

// Explanation:
// ------------
// Subsequence is [4,3,3]

// Sample Input-2:
// ---------------
// 7
// 20 19 19 29 37 35 19

// Sample Output-2:
// ----------------
// 4

// Explanation:
// ------------
// Subsequence is [20 19 19 19]

import java.util.*;

public class program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        // Arrays.sort(a);
        // List<Integer>ans = new ArrayList<>();
        // for(int i=n-1;i>0;i--){
        // if(a[i] - a[i-1] == 1){
        // List<Integer>temp = new ArrayList<>();
        // // temp.add(a[i]);
        // // temp.add(a[i-1]);
        // int val1 = a[i];
        // int val2 = a[i-1];
        // for(int j=i;j>=0;j--){
        // if(a[j] == val1 || a[j] == val2){
        // temp.add(a[j]);
        // }
        // else if(a[j] < val2){
        // break;
        // }
        // else{
        // break;
        // }
        // }
        // if(temp.size() > ans.size()){
        // ans = new ArrayList<>(temp);
        // }
        // }
        // }
        // System.out.println(ans.size());

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : a) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int max = 0;
        for (int key : freq.keySet()) {
            if (freq.containsKey(key + 1)) {
                int sub = freq.get(key) + freq.get(key + 1);
                max = Math.max(max, sub);
            }
        }
        System.out.println(max);
    }
}