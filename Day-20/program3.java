/*
Imagine you're designing a sequence of signals for a high-tech robot. 
The robot receives its instructions as list of integers, where each integer 
represents one byte of the command data. A complete command can be composed of 
1 to 4 bytes, following these strict rules:

- For a 1-byte command, the first bit must be 0, followed by the command's code.
- For a multi-byte command (with n bytes), the first byte starts with n 
  consecutive 1’s, immediately followed by a 0. Each of the following n – 1 bytes 
  must begin with the bit pattern 10.

This is how the robot interprets the byte sequences:

 Number of Bytes   |        Robot Signal Sequence
				   |              (binary)
-------------------+---------------------------------------
		1          |   0xxxxxxx
		2          |   110xxxxx 10xxxxxx
		3          |   1110xxxx 10xxxxxx 10xxxxxx
		4          |   11110xxx 10xxxxxx 10xxxxxx 10xxxxxx

Here, each x represents a bit that can be either 0 or 1.

Note: Only the least significant 8 bits of each integer in the input list of 
integers are used, meaning each integer stands for exactly one byte of data.

Your challenge is to verify whether the provided sequence of robot instructions 
strictly follows the defined encoding rules.

Example 1:
----------
Input=
197 130 1

Output=
true

Explanation: 
- The array corresponds to the binary sequence: 11000101 10000010 00000001.  
- This is a valid encoding: a 2-byte command (11000101 10000010) followed by a 
  valid 1-byte command (00000001).

Example 2:
----------
Input=
234 140 4

Output=
false

Explanation:
- The array corresponds to the binary sequence: 11101011 10001100 00000100.  
- The first three bits of the first byte are 1’s with a following 0, indicating 
  a 3-byte command. The second byte starts correctly with 10, but the third byte 
  does not begin with 10, so the command sequence is invalid.

Constraints:

- 1 <= instructions.length <= 2 * 10^4
- 0 <= instruction <= 255

*/
import java.util.*;
public class program3{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String[] arr=s.split(" ");
        int i=0;
        while(i<arr.length){
           String temp=String.format("%8s",Integer.toBinaryString(Integer.valueOf(arr[i]))).replace(' ','0');
           int by=function(temp);
           if(by==-1){
               System.out.println("false");
               return;
            }
           if(by==1){
               i++;
               continue;
            }
           int j=i+1;
           while(j<i+by && j<arr.length){
               String temp2=String.format("%8s",Integer.toBinaryString(Integer.valueOf(arr[j]))).replace(' ','0');
               if(!temp2.startsWith("10")){
                   System.out.println("false");
                   return;
                }
               j++;
            }
            if(j!=i+by){
                System.out.println("false");
                return;
            }
           i=j;
        }
        System.out.print("true");
    }
    public static int function(String s){
        if(s.startsWith("0"))return 1;
        else if(s.startsWith("110"))return 2;
        else if(s.startsWith("1110"))return 3;
        else if(s.startsWith("11110"))return 4;
        return -1;
    }

}