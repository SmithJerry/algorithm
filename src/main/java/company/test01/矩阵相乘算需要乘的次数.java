package company.test01;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Liang
 * @date 2023/8/18 - 18:29
 */
public class 矩阵相乘算需要乘的次数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            int n = Integer.parseInt(in.nextLine());
            int[][] arr = new int[n][2];

            for (int i = 0; i < n; i++) {
                String str = in.nextLine();
                String[] strs = str.split(" ");
                arr[i][0] = Integer.parseInt(strs[0]);
                arr[i][1] = Integer.parseInt(strs[1]);
            }
            String flag = in.nextLine();

            function(arr, flag);
        }
    }

    public static void function(int[][]arr, String flag) {
        Stack<int[]> stack = new Stack<>();

        char[] str = flag.toCharArray();
        int ans = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '(') {
                continue;
            } else if(str[i] == ')'){


                int[] arr2 = stack.pop();
                int[] arr1 = stack.pop();

                int m = arr1[0];
                int n = arr1[1];
                int p = arr2[1];

                ans += m * n * p;
                stack.push(new int[]{m, p});

            }else{
                stack.push(arr[str[i] - 'A']);
            }
        }
        System.out.println(ans);
    }
}
