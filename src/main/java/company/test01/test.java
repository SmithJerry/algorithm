package company.test01;

import java.util.Scanner;

/**
 * @author Liang
 * @date 2023/8/18 - 14:27
 */
public class test {
//    public static void main(String[] args) {
////        int i = Integer.parseInt("1A");
////        System.out.println(i);
//
//        String str = "A10;S20;W10;D30;X;A1A;B10A11;;A10;";
//        String[] split = str.substring(0, str.length() - 2).split(";");
//        System.out.println(split);
////        str.isEmpty();
//        int[] nums = {1, 2, 3, 3};
//
//        System.out.println(nums.length);
//
//    }
public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    // 注意 hasNext 和 hasNextLine 的区别
    while (in.hasNextLine()) { // 注意 while 处理多个 case
        int n = Integer.parseInt(in.nextLine());
        int[][] nums = new int[n][2];

        String str = in.nextLine();
        String[] strs = str.split(" ");
        String str1 = in.nextLine();
        String[] strs1 = str1.split(" ");
        for(int i = 0; i < n; i++){
            nums[i][0] = Integer.parseInt(strs[i]);
            nums[i][1] = Integer.parseInt(strs1[i]);
        }
    }
}
}
