package company.test01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Liang
 * @date 2023/8/19 - 22:00
 */
public class 迷宫问题 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int m = in.nextInt();

            int[][] arr = new int[n][m];

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    arr[i][j] = in.nextInt();
                }
            }

            function(arr);

        }
    }

    public static void function(int[][] arr){
        List<int[]> list = new ArrayList<>();

        process(arr, 0, 0, list);

        for(int[] nums : list){
            System.out.println("(" +nums[0]+","+ nums[1] +")");
        }
    }

    public static boolean process(int[][] arr, int x, int y, List<int[]> list){
        list.add(new int[]{x, y});

        arr[x][y] = 1;

        if(x == arr.length - 1 && y == arr[0].length - 1){
            return true;
        }

        if(x + 1 < arr.length && arr[x + 1][y] == 0){
            if(process(arr, x + 1, y, list)){
                return true;
            }
        }

        if(y + 1 < arr[0].length && arr[x][y + 1] == 0){
            if(process(arr, x, y + 1, list)){
                return true;
            }
        }

        if(x - 1 > -1 && arr[x - 1][y] == 0){
            if(process(arr, x - 1, y, list)){
                return true;
            }
        }

        if(y - 1 > -1 && arr[x][y - 1] == 0){
            if(process(arr, x, y - 1, list)){
                return true;
            }
        }
        list.remove(list.size() - 1);
        arr[x][y] = 0;
        return false;
    }
}
