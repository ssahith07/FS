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
    static boolean isHarmonic(String s){
        int flag=0;
        for(int i=0;i<s.length();i++){
            if(s.contains((s.charAt(i)+32)+"")||s.contains((s.charAt(i)-32)+"")){
                flag = 1;
            }else{
                flag=0;
            }
        }
        return flag==0?false:true;
    }
    public static void main(String[] args) {
        String s = "QcvcCcq";
        String s1 = "";
        String res = "";
        for(int i=0;i<s.length();i++){
            s1+=s.charAt(i);
            for (int j = 0; j < s.length(); j++) {
                s1+=s.charAt(j);
                if(isHarmonic(s1) && res.length()<s1.length()){
                    res = s1;
                }
            }
            s1="";
        }
        System.out.println(res);
    }
}