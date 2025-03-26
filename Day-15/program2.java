// /*
// Ram and Bheem are using a Desktop Computer.One day they found that keyboard 
// is defective in which if you type backspace button,it will print '$', 
// instead of removing one previous character.

// Bheem and Ram have tried to type one word each on the same keyboard.
// Return true, if both tried to type the same word. Otherwise return false.

// Note:backspace for an empty text will continue empty.

// Input Format:
// -------------
// Line-1:Two space seperated strings represents words w1,w2.

 
// Output Format:
// --------------
// Print a boolean result.
 
// Constraints:

//     1 <= w1.length, w2.length <= 200
//     w1 and w2 only contain lowercase letters and '$' characters.


 
// Sample Input-1:
// ---------------
// pq$r  pt$r

// Sample Output-1:
// ----------------
// true

// Explanation:
// ------------
// Both wants to type 'pr'

// Sample Input-2:
// ---------------
// se$$at cea$$t

// Sample Output-2:
// ----------------
// false

// Sample Input-3:
// ---------------
// s$$at ce$$at

// Sample Output-2:
// ----------------
// true

// Explanation:
// ------------
// Both wants to type 'at'.

import java.util.Stack;

public class program2 {
    public static void main(String[] args) {
        String s1 = "pq$r";
        String s2 = "pt$r";
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        int i=0,j=0;
        while (s1.charAt(i)=='$') {
            i++;
        }
        st1.push(s1.charAt(i));
        i++;
        while (s2.charAt(j)=='$') {
            j++;
        }
        st2.push(s2.charAt(j));
        j++;
        while (i<s1.length()) {
            if(s1.charAt(i)=='$'){
                if(!st1.isEmpty()) st1.pop();
            }else{
                st1.push(s1.charAt(i));
            }
            i++;
        }
        while (j<s2.length()) {
            if(s2.charAt(j)=='$'){
                if(!st2.isEmpty()) st2.pop();
            }else{
                st2.push(s2.charAt(j));
            }
            j++;
        }
        System.out.println(st1);
        System.out.println(st2);
        if (st1.equals(st2)) {
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
}