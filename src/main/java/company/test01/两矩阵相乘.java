package company.test01;

import java.util.Scanner;

/**
 * @author Liang
 * @date 2023/8/18 - 19:17
 */
public class 两矩阵相乘 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            int m = Integer.parseInt(in.nextLine());
            int n = Integer.parseInt(in.nextLine());
            int p = Integer.parseInt(in.nextLine());

            int[][] A = new int[m][n];
            int[][] B = new int[n][p];

            for (int i = 0; i < m; i++) {
                String str = in.nextLine();
                String[] strs = str.split(" ");
                for (int j = 0; j < n; j++) {
                    A[i][j] = Integer.parseInt(strs[j]);
                }
            }

            for (int i = 0; i < n; i++) {
                String str = in.nextLine();
                String[] strs = str.split(" ");
                for (int j = 0; j < p; j++) {
                    B[i][j] = Integer.parseInt(strs[j]);
                }
            }

            function(A, B, m, p);

        }
    }

    public static void function(int[][] A, int[][] B, int m, int p) {
        int[][] ans = new int[A.length][B[0].length];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                ans[i][j] = yunsuan(A, B, i, j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int yunsuan(int[][] A, int[][] B, int n, int m) {
        int res = 0;
        int k = A[0].length;
        for(int i = 0; i < k; i++){
            res += A[n][i] * B[i][m];
        }

        return res;
    }
}
