// Write a program that takes an IP address and subnet mask (in CIDR notation, 
// e.g., 192.168.1.1/24) as input and calculates the subnet mask in dotted decimal 
// format.

// Input Format:
// ---------------
// An integer, CIDR

// Output Format:
// ---------------
// String, Subnet's IP Address


// Sample Input-1:
// ---------------
// 25

// Sample Output-1:
// ----------------
// 255.255.255.128


// Sample Input-2:
// ---------------
// 22

// Sample Output-2:
// ----------------
// 255.255.252.0

import java.util.Scanner;

public class program3 {
   public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cidr = sc.nextInt();
        int mask = (cidr == 0) ? 0 : 0xffffffff << (32 - cidr);

        int octet1 = (mask >> 24) & 0xff;
        int octet2 = (mask >> 16) & 0xff;
        int octet3 = (mask >> 8) & 0xff;
        int octet4 = mask & 0xff;

        // Format the subnet mask in dotted decimal notation
        String res =  String.format("%d.%d.%d.%d", octet1, octet2, octet3, octet4);
        System.out.println(res);
    }
}