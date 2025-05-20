// A binary word Bn is formed as follows:
// B[1] = "0"
// B[i+1] = B[i] + "1" + reverse(complement(B[i])) for i > 1

// where $ denotes the concatenation operation, reverse(complement(B)) returns
// the reversed word of complement(B), which perform 1's complement of B
// (0 changes to 1 and 1 changes to 0).

// For example, the first 4 words in the above sequence are:

// B[1] = "0"
// B[2] = "011"
// B[3] = "0111001"
// B[4] = "011100110110001"

// Return the Pth bit in B[N]. It is guaranteed that P is valid for the given N.

// Input Format:
// -------------
// Line-1: Two space seperated integers represents N and P.

// Output Format:
// --------------
// Return a bit (0 or 1).

// Sample Input-1:
// ---------------
// 3 4

// Sample Output-1:
// ----------------
// 1

// Explanation:
// ------------
// B[3] = "0111001" and 4th bit is 1.

// Sample Input-2:
// ---------------
// 4 10

// Sample Output-2:
// ----------------
// 1

// Explanation:
// -------------
// B[4] = "011100110110001" and 10th bit is 1.
/*
B[1] = "0"

B[n] = B[n-1] + "1" + reverse(complement(B[n-1]))

*/

import java.util.*;

public class program2 {
    public static String complement(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == '0') {
                res.append(1);
            } else {
                res.append(0);
            }
        }
        res.reverse();
        return res.toString();
    }

    public static String one(int n) {
        if (n == 1) {
            return "0";
        }
        String prev = one(n - 1);
        String comp = complement(prev);

        return prev + "1" + comp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        String ans = one(n);
        System.out.println(ans.charAt(p - 1));

    }
}