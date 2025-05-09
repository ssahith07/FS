// Jadav Payeng, "The Forest Man of India",
// started planting the seeds in a M*N grid land.
// Each cell in the grid land is planted with a seed.
// After few days, some seeds grow into saplings indicates with '1',
// and the rest are dead seeds indicates with '0'.

// One or more saplings are connected either horizontally, vertically or
// diagonally
// with each other, form a sapling-group.
// There may be zero more sapling-groups in the grid land.

// Jadav Payeng wants to know the biggest sapling-group in that grid land.

// You are given the M * N grid, filled with 0's and 1's.
// You are task is to help Jadav Payeng to find the number of saplings in
// the largest sapling-group.

// Input Format:
// -------------
// Line-1: Two integers M and N, the number of rows and columns in the
// grid-land.
// Next M lines: contains N space-separated integers .

// Output Format:
// --------------
// Print an integer, the number of saplings in the
// largest sapling-group in the given grid-land.

// Sample Input-1:
// ---------------
// 5 4
// 0 0 1 1
// 0 0 1 0
// 0 1 1 0
// 0 1 0 0
// 1 1 0 0

// Sample Output-1:
// ----------------
// 8

// Sample Input-2:
// ---------------
// 5 5
// 0 1 1 1 1
// 0 0 0 0 1
// 1 1 0 0 0
// 1 1 0 1 1
// 0 0 0 1 0

// Sample Output-2:
// ----------------
// 5

import java.util.*;

public class program2 {

    static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

    static int dfs(int[][] arr, boolean visited[][], int i, int j) {
        visited[i][j] = true;
        int m = arr.length, n = arr[0].length;
        int size = 1;
        for (int d = 0; d < 8; d++) {
            int nx = i + dx[d];
            int ny = j + dy[d];

            if (nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[nx][ny] && arr[nx][ny] == 1) {
                size += dfs(arr, visited, nx, ny);
            }
        }
        return size;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] in = sc.nextLine().split("\\s+");
        int m = Integer.parseInt(in[0]), n = Integer.parseInt(in[1]);

        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int maxl = 0;
        boolean visited[][] = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    int size = dfs(arr, visited, i, j);
                    maxl = Math.max(size, maxl);
                }
            }
        }

        System.out.println(maxl);

    }
}