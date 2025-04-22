
/*
Ganesh has a habit of writing the words in backward order,
and writes the sentence without spaces.
 
Ganesh is given a sentence S (without spaces) and an integer C
His way of backward writing the sentence is as follows:
   - Break the sentence into 2C length words from begining to end.
   - Write the first C letters in backward direction of every 2C length word.
   - if there is a leftover word at the end of S with lenth lessthan 2C, then 
   - if length is lessthan C, write all the letters in backward direction.
   - if length is greater than or equal to C, write the first C letters
          in backward direction and keep the rest as it is.
           
 And return the sentence S after writing is completed.
 
Example of backward writing: 
Given sentence, S= "hellokmit" and C=2
Break the sentence into words: hell, okmi, t
Now apply backward writing on each word: ehll, komi, t
So, the final sentence is "ehllkomit"
 
 
Input Format:
-------------
Space separated string and integer, the word and C value
 
Output Format:
--------------
Print a string as result
 
 
Sample Input-1:
---------------
abcdefghijk 3

Sample Output-1:
----------------
cbadefihgjk
 

Sample Input-2:
---------------
appropriate 4
 
Sample Output-2:
----------------
rppaoprieta

*/
import java.util.*;
public class program1{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int size=s.length();
        int c=sc.nextInt();
        ArrayList<String> arr=new ArrayList<>();
        for(int i=0;i<size;i=i+2*c){
            int end=Math.min(size,i+2*c);
            String temp=s.substring(i,end);
            arr.add(temp);
        }
        StringBuilder result=new StringBuilder();
        for(String i:arr){
            int end2=Math.min(c,i.length());
            String sub=i.substring(0,end2);
            String sub2=i.substring(end2,i.length());
            StringBuilder sb=new StringBuilder(sub);
            sb.reverse();
            String re=sb.toString()+sub2;
            result.append(re);
        }
        System.out.print(result.toString());
    }
}