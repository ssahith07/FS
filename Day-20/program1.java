/*

"Emphatic Pronunciation" of a given word is where we take the word and
replicate some of the letter to emphasize their impact.

Instead of saying 'oh my god', someone may say "ohhh myyy goddd", 
We define emphatic pronunciation of a word, which is derived by replicating 
a group (or single) of letters in the original word. 

So that the replicated group is atleast 3 characters or more and 
greater than or equal to size of original group. 
For example Good -> Goood is an emphatic pronunciation,
but Goodd is not because in Goodd the 'd' are only occuring twice consecutively.
 
In the question you are given the "Emphatic pronunciation" word, 
you have to findout how many words can legal result in the 
"emphatic pronunciation" word.

Input Format:
-------------
Line-1 -> A String contains a single word, Emphatic Pronunciation word
Line-2 -> Space seperated word/s

Output Format:
--------------
Print an integer as your result


Sample Input-1:
---------------
goood
good goodd

Sample Output-1:
----------------
1

Sample Input-2:
---------------
heeelllooo
hello hi helo

Sample Output-2:
----------------
2
*/
import java.util.*;
class Test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String emp = sc.nextLine();
        String words[] = sc.nextLine().split(" ");
        int count = 0;
        for(String word : words){
            if(isValidEmp(word,emp)){
                count++;
            }
        }
        System.out.println(count);
    }
    
    static boolean isValidEmp(String word, String emp){

        int i=0,j=0;
        while(i < word.length() && j < emp.length()){
            if (word.charAt(i) != emp.charAt(j)) 
                return false;
            
            char c = word.charAt(i);
            int len1 = 0, len2 = 0;
            while (i < word.length() && word.charAt(i) == c){
                len1++;
                i++;
            }
            
            while(j < emp.length() && emp.charAt(j) == c){
                len2++;
                j++;
            }
            
            if (len2 < 3 && len1 != len2) 
            return false;
            
            if (len2 >= 3 && len1 > len2) 
            return false;
        }
        
        return i == word.length() && j == emp.length();
    }

}