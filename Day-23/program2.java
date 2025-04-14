/*
Nehanth, a bubbly kid playing with digits and creating numbers using them.
The kid is creating the number called successive number. 
A number is called successive number, if and only if 
each digit in the number is one less than the next digit.

You are given two integers, start and end, both are inclusive.
Your task to find and print all the successive numbers in the given range (start, end).

Input Format:
-------------
Two space separated integers, start and end

Output Format:
--------------
Print the list of successive numbers in the range(start, end).


Sample Input-1:
---------------
50 150

Sample Output-1:
----------------
[56, 67, 78, 89, 123]


Sample Input-2:
---------------
100 600

Sample Output-2:
----------------
[123, 234, 345, 456, 567]

*/
import java.util.*;

class Test{
    static boolean successive(int n){
        String s = Integer.toString(n);
        for(int i=0;i<s.length()-1;i++){
            if((s.charAt(i)-'0')+1!=(s.charAt(i+1)-'0')) return false;
        }
        return true;
    }
    static int nlength(String s,int n){
        String p = "";
        for(int i=0;i<s.length();i++){
            p+='1';
        }
        int num = Integer.parseInt(p);
        return num+n;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        List<Integer> al = new ArrayList<>();
        while(l<=r){
            if(successive(l)){
                al.add(l);
                l = nlength(Integer.toString(l),l);
            }else{
                l++;
            }
        }
        System.out.println(al);
    }
}