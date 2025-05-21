// Indus Infra Ltd purchased a land of size L * W acres, for their upcoming
// venture.
// The land is divided into rectangular plots, using fences. They have kept some
// H horizontal fences as hfences[] and V vertical fences as vfences[] on the
// land,
// where hfence[i] is the distance from the top of the land to the i-th
// horizontal
// fence and, vfence[j] is the distance from the top of the land to the j-th
// vertical fence. Each 1*1 cell is one acre plot.

// Mr.RGV wants to purchase the biggest plot available to build a Guest-house.
// Your task is to help Mr.RGV to find the biggest plot vailable after the
// fences
// are setup in the venture.
// NOTE: The answer can be a large number, return the modulo of 10^9 + 7.

// Input Format:
// -------------
// Line-1: 4 space separated integers, L,W,H and V
// Line-2: H space separated integers, hfence[] in the range [0, L]
// Line-3: V space sepaarted integers, vfence[] in the range [0, W]

// Output Format:
// --------------
// Print an integer result, the area of biggest plot.

// Sample Input-1:
// ---------------
// 5 6 2 2
// 2 3
// 2 5

// Sample Output-1:
// ----------------
// 6

// Sample Input-2:
// ---------------
// 5 6 1 1
// 3
// 4

// Sample Output-2:
// ----------------
// 12

import java.util.*;

public class program2 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int W = sc.nextInt();
        int h = sc.nextInt();
        int v = sc.nextInt();
        int hfe[] = new int[h];
        int vfe[] = new int[v];
        for (int i = 0; i < h; i++)
            hfe[i] = sc.nextInt();
        for (int i = 0; i < v; i++)
            vfe[i] = sc.nextInt();
        Arrays.sort(hfe);
        Arrays.sort(vfe);
        int maxL = hfe[0];
        for (int i = 1; i < h; i++) {
            int x = hfe[i];
            int y = hfe[i - 1];
            maxL = Math.max(maxL, x - y);
        }
        maxL = Math.max(maxL, L - hfe[h - 1]);
        int maxW = vfe[0];
        for (int i = 1; i < v; i++) {
            int x = vfe[i];
            int y = vfe[i - 1];
            maxW = Math.max(maxW, x - y);
        }
        maxW = Math.max(maxW, W - vfe[v - 1]);
        System.out.println((long) maxL * maxW % 1000000007);
    }

}