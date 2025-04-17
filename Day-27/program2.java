/*Naresh is working on expression of words.
If you give him an expression like, [p,q,r]s[t,u],
Naresh will form the words like as follows : [pst, psu, qst,qsu, rst, rsu]
Another example, [a,b]c[d,e] will be converted as: [acd, ace, bcd, bce].

Naresh will be given an expression as a string EXP, like the above format.
He needs to return all words that can be formed in like mentioned above, 
Can you help Naresh to convert iven expression into a list of words, in lexicographical order.

NOTE: 
Expression consist of lowercase alphabets, comma, and square brackets only.

Input Format:
-------------
A string EXP, expression.

Output Format:
--------------
Print list of words, formed from the expression.


Sample Input-1:
---------------
[b]c[e,g]k

Sample Output-1:
----------------
[bcek, bcgk]


Sample Input-2:
---------------
[a,b][c,d]

Sample Output-2:
----------------
[ac, ad, bc, bd]


Sample Input-3:
---------------
[xyz]a[b,c]

Sample Output-3:
----------------
[xyzab, xyzac]

*/

import java.util.*;

public class program2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String exp = sc.nextLine();
        List<String> result = generate(exp);
        Collections.sort(result);
        System.out.println(result);
    }
    public static List<String> generate(String exp){
        if (!exp.contains("[")){
            List<String> result = new ArrayList<>();
            result.add(exp);
            return result;
        }
        List<String> result = new ArrayList<>();

        int firstOpen = exp.indexOf('[');
        int firstClose = match(exp, firstOpen);

        String prefix = exp.substring(0, firstOpen);
        String options = exp.substring(firstOpen + 1, firstClose);
        String suffix = exp.substring(firstClose + 1);

        String[] optionArray = options.split(",");
        for (String option : optionArray){
            List<String> subResults = generate(prefix + option + suffix);
            result.addAll(subResults);
        }
        return result;
    }

    private static int match(String exp, int openIndex){
        int count = 1;
        for (int i = openIndex + 1; i < exp.length(); i++){
            if (exp.charAt(i) == '['){
                count++;
            } 
            else if (exp.charAt(i) == ']'){
                count--;
                if (count == 0){
                    return i;
                }
            }   
        }
        return -1;
    }
}
