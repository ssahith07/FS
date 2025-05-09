// Pramod plans to design a program that generates all possible valid IP addresses from a given string S.
// It is guaranteed that S contains only digits.

// Help Pramod by designing a program that returns all valid IP addresses generated from S.
// The IP addresses must be printed in lexicographic order.

// Note:

// - A valid IP address consists of exactly four integers, each ranging from 0 to 255, separated by single dots (.).
// - IP address segments cannot contain leading zeros.
// - Valid IP addresses must fall within the range 0.0.0.0 to 255.255.255.255.

// Examples of invalid IP addresses: 123.012.234.255, 123.234.345.34.

// Input Format:
// -------------
// A string S, contains only digits [0-9].

// Output Format:
// --------------
// Print all possible IP addresses which are valid.


// Sample Input-1:
// ---------------
// 23323311123

// Sample Output-1:
// ----------------
// [233.233.11.123, 233.233.111.23]


// Sample Input-2:
// ---------------
// 12345678

// Sample Output-2:
// ----------------
// [1.234.56.78, 12.34.56.78, 123.4.56.78, 123.45.6.78, 123.45.67.8]


// Sample Input-3:
// ---------------
// 02550255

// Sample Output-3:
// ----------------
// [0.25.50.255, 0.255.0.255]

import java.util.*;

public class program1 {
    public static void backtrack(String s, int ind, List<String> result, List<String> current) {
        if (current.size() == 4) {
            if (ind == s.length()) {
                result.add(String.join(".", current));
            }
            return;
        }
        for (int i = 1; i <= 3 && ind + i <= s.length(); i++) {
            String ss = s.substring(ind, ind + i);
            if ((ss.startsWith("0") && ss.length() > 1) || Integer.parseInt(ss) > 255) {
                continue;
            }
            current.add(ss);
            backtrack(s, ind + i, result, current);
            current.remove(current.size() - 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        List<String> result = new ArrayList<>();
        backtrack(s, 0, result, new ArrayList<>());
        System.out.println(result);
    }
}