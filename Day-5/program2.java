// You are an architect designing a street with houses represented as a 0-indexed 
// array house_heights of n integers, where each element represents the height of 
// a house. Additionally, a binary array visibility_mask of length n is provided, 
// where 1 indicates a house that contributes to the neighborhood's skyline, and 
// 0 indicates a house that does not.

// For any house located at index i, you are tasked with determining the average 
// skyline height within a k-radius neighborhood centered at i. The average skyline
// height is the average of all house heights between indices i - k and i + k 
// (inclusive) that have a corresponding visibility value of 1 in the visibility_mask. 

// If no houses with a visibility of 1 exist in the range, or if the range extends 
// beyond the boundaries of the array, the average skyline height for that house is -1.

// s[i] is the average 
// skyline height for the neighborhood centered at index i.

// Input Format:
// ---------------
// Line-1: Two space separated integers, N, K
// Line-2: N space separated integers, house_heights[].
// Line-3: N space separated integers, visibility_mask[].

// Output Format:
// -----------------
// An integer array, priority_sums[], of length n - k + 1


// Sample Input-1:
// ---------------
// 7 2
// 10 15 20 5 30 25 40
// 1 0 1 1 0 1 1

// Sample Output-2:
// ----------------
// [-1, -1, 11, 16, 22, -1, -1]


// Explanation:
// ------------
// - For index 0, there are less than k houses in the left neighborhood, 
//   so skyline_avgs[0] = -1.
// - For index 1, there are less than k houses in the left neighborhood, 
//   so skyline_avgs[1] = -1.
// - For index 2, the neighborhood is [10, 15, 20, 5, 30]. From the visibility_mask, 
//   only the houses with heights [10, 20, 5] contribute to the skyline. 
//   The average is (10 + 20 + 5) / 3 = 11.
// - For index 3, the neighborhood is [15, 20, 5, 30, 25]. From the visibility_mask, 
//   only the houses with heights [20, 5, 25] contribute. 
//   The average is (20 + 5 + 25) / 3 = 16.
// - For index 4, the neighborhood is [20, 5, 30, 25, 40]. 
//   From the visibility_mask, only the houses with heights [20, 5, 25, 40] contribute. 
//   The average is (20 + 5 + 25 + 40) / 4 = 22.
// - For index 5, there are less than k houses in the right neighborhood, 
//   so skyline_avgs[5] = -1.
// - For index 6, there are less than k houses in the right neighborhood, 
//   so skyline_avgs[6] = -1.


// Sample Input-2:
// ---------------
// 3 1
// 50 60 70
// 1 1 1

// Sample Output-2:
// ----------------
// [-1, 60, -1]

// Constraints:
// ------------
// 1. n == house_heights.length == visibility_mask.length
// 2. 1 <= n <= 10^5
// 3. 0 <= house_heights[i] <= 10^5
// 4. visibility_mask[i] is either 0 or 1
// 5. 0 <= k <= n

import java.util.Arrays;
import java.util.Scanner;

public class program2 {
    
    public static void main(String[] args) {
        Scanner s2=new Scanner(System.in);
        int n=s2.nextInt();
        
        int a[] = new int[n];
        int k = s2.nextInt();
        for(int i=0;i<n;i++){
            a[i]=s2.nextInt();
        }
        int a1[] = new int[n];
         for(int i=0;i<n;i++){
            a1[i]=s2.nextInt();
         }

        // int r1 = k + 1;
        int s = 0;
        int s1 = 0;
        int c1 = 0;
        int c2 = 0;
        int f[] = new int[a.length];
        for (int r = 0; r < a.length; r++) {
            if (a1[r] == 1) {
                s += a[r];
                c1++;
            }

            if (r + k < a.length && a1[r + k] == 1) {
                s1 += a[r + k];
                c2++;
            }

            if (r - k - 1 >= 0 && a1[r - k - 1] == 1) {
                s -= a[r - k - 1];
                c1--;
            }
            if (r - k >= 0 && a1[r] == 1) {
                s1 -= a[r];
                c2--;
            }

            if (r - k >= 0 && r +k < a.length) {
                int avg = c1 + c2;
                f[r] = (s + s1) / avg;

            } else {
                f[r] = -1;
            }
        }
        System.out.println(Arrays.toString(f));
        
    }
}
