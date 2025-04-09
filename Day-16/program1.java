/*
In the context of linguistic harmony, we define a "harmonious string" as a string where 
every alphabet it contains appears both in uppercase and lowercase forms. For instance, 
a string like "pqQpP" is harmonious because it has both 'P' and 'p' as well as 'Q' and 'q'. 
Conversely, a string like "pqP" is not harmonious as it fails to meet this condition, 
with 'q' present while 'Q' is absent.

Your are given a string S, your task is  to return the longest harmonious substring in S. 
If there are multiple answers meeting this criterion, you should return the one that appears 
earliest in the string. If there is no harmonious substring, you should return an empty string.

Input Format:
-------------------
A string S

Output Format:
-------------------
Prin the longest harmonious string.


Sample Input:
--------------
QcvcCcq

Sample Output:
---------------
cCc


Sample Input:
--------------
pqrs

Sample Output:
--------------
""
*/
import java.util.*;

public class program1 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int max=0;
        String result="";
        String s=sc.next();
        for(int i=0;i<s.length()-1;i++){
            for(int j=i+1;j<=s.length();j++){
                String sub=s.substring(i,j);
                if(isharmonic(sub) && sub.length() > max){
                    max=sub.length();
                    result=sub;
                }
            }
        }
        System.out.print(result);
    }
    private static boolean isharmonic(String sub){
        HashSet<Character> hs=new HashSet<>();
        for(char c:sub.toCharArray()){
            hs.add(c);
        }
        for (Character c : hs){
            if (Character.isLowerCase(c) && !hs.contains(Character.toUpperCase(c))) {
                return false;
            }
            if (Character.isUpperCase(c) && !hs.contains(Character.toLowerCase(c))){
                return false;
            }
        }
        return true;
    }
}