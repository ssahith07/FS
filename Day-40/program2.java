// Venkatadri is a maths teacher.
// He is teaching matrices to his students.
// He is given a matrix of size m*n, and it contains only positive numbers.
// He has given a task to his students to find the special matrix,
// in the iven matrix A[m][n].
// A special matrix has following property:
// - The sum of elements in each row, each column and the two diagonals are
// equal.
// - Every 1*1 matrix is called as a special matrix.
// - The size of the special matrix should be a square, i.e., P*P.

// Your task is to help the students to find the speical matrix with max size P.

// Input Format:
// -------------
// Line-1: Two space separated integers M and N, size of the matrix.
// Next M lines: N space separated integers m and n.

// Output Format:
// --------------
// Print an integer, maximum size P of the special matrix.

// Sample Input-1:
// ---------------
// 5 5
// 7 8 3 5 6
// 3 5 1 6 7
// 3 5 4 3 1
// 6 2 7 3 2
// 5 4 7 6 2

// Sample Output-1:
// ----------------
// 3

// Explanation:
// ------------
// The special square is:
// 5 1 6
// 5 4 3
// 2 7 3

// Sample Input-2:
// ---------------
// 4 4
// 7 8 3 5
// 3 2 1 6
// 3 2 3 3
// 6 2 3 3

// Sample Output-2:
// ----------------
// 2

// Explanation:
// ------------
// The special square is:
// 3 3
// 3 3
import java.util.*;

public class program2 {

    public static boolean check(int[][] a, int m, int n, int size) {
        int target = 0;

        for (int i = 0; i < size; i++) {
            target += a[m][n + i];
        }

        for (int i = m; i < m + size; i++) {
            int f1 = 0;
            for (int j = n; j < n + size; j++) {
                f1 += a[i][j];
            }
            if (f1 != target) {
                return false;
            }
        }

        for (int j = n; j < n + size; j++) {
            int f2 = 0;
            for (int i = m; i < m + size; i++) {
                f2 += a[i][j];
            }
            if (f2 != target) {
                return false;
            }
        }

        int f3 = 0;
        for (int i = 0; i < size; i++) {
            f3 += a[m + i][n + i];
        }
        if (f3 != target) {
            return false;
        }

        int f4 = 0;
        for (int i = 0; i < size; i++) {
            f4 += a[m + i][n + size - i - 1];
        }
        if (f4 != target) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int maxSize = Math.min(m, n);

        for (int i = maxSize; i > 0; i--) {
            for (int j = 0; j <= m - i; j++) {
                for (int k = 0; k <= n - i; k++) {
                    if (check(a, j, k, i)) {
                        System.out.println(i);
                        return;
                    }
                }
            }
        }
        System.out.println(1);
    }
}
