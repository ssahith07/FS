/*
You are provided a chocolate array, represented by the integer array "chocolates," which represents the number of chocolates in different boxes. Every second, you perform the following steps:

1. Choose the box with the most number of chocolates.
2. If there are multiple boxes with the most chocolates, you may select any one of them.
3. Take all the chocolates in that box, except for a square root number of chocolates that you leave behind.
4. Repeat the above steps for 'p' seconds.

You have to calculate how many chocolates left after k seconds.

Input Format:
-------------
Line-1: Two space separated integers, number of boxes N and number of seconds P.
Line-2: N space seprated integers, chocolates[].

Output Format:
--------------
Print an integer result, the number of chocolates left.


Sample Input-1:
---------------
5 4
16 100 625 81 9

Sample Output-1:
----------------
49

Explanation: 
-------------
- In the first second, the middle box is chosen and 25 chocoloates are left behind.
- Then the second box is chosen and 10 chocoloates are left behind.
- After that the fourth box is chosen and 9 chocoloates are left behind.
- Finally, the middle box is chosen again and 5 chocoloates are left behind.
The final remaining chocoloates are [16,10,5,9,9], 
so the total number of chocoloates remaining is 49.

Sample Input-2:
---------------
5 8
1 1 1 1 1

Sample Output-2:
----------------
5

import java.util.*;

public class Test{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int i=0;i<n;i++){
            pq.add(sc.nextInt());
        }
        while(k>0){
            int p = pq.poll();
            pq.add((int) Math.sqrt(p));
            k--;
        }
        System.out.println(pq.stream().mapToInt(Integer::intValue).sum());
    }
}




/*
Arjun is playing a word game in his tab. When he start the game , It displays a
word and he has to check for any two adjacent characters which are same.If found 
he has to select those two characters by tapping, so that both characters will
be deleted from the word and the word size shrinks by 2. This process to be 
repeated until the word has no two adjacent characters are same.
You task is to help Arjun to perform the above task and Return the final word
obtained.

Input Format:
-------------
Line-1: A string represents the word.

Output Format:
--------------
Return a string or empty string.

Constraints:
------------   
    1 <= word.length <= 10^5   
    word consists only lower case letters.

Sample Input-1:
---------------
pqqprs

Sample Output-1:
----------------
rs

Explanation:
-------------
Initially , Delete two 'q's then the word will be 'pprs'. Now Delete two 'p's 
then the word will be rs.

Sample Input-2:
---------------
pqqqprrs

Sample Output-2:
----------------
pqps

Explanation:
-------------
Initially , Delete two 'q's then the word will be 'pqprrs'. Now Delete two 'r's
then the word will be pqps.

*/

import java.util.*;

public class program1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!st.isEmpty() && st.peek()==s.charAt(i)){
                st.pop();
            }else{
                st.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        System.out.println(sb.reverse().toString());
    }
}
