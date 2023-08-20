package company.test01;

import java.util.Scanner;

/**
 * @author Liang
 * @date 2023/8/18 - 16:22
 */
public class Ip数字转换 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            function(str);
            String str2 = in.nextLine();
            function2(str2);
        }
    }
    public static void function(String str){
        String[] strs = str.split("\\.");

        StringBuffer bin = new StringBuffer();

        for(int i = 0; i < strs.length; i++){
            String res = Integer.toBinaryString(Integer.parseInt(strs[i]));
            while(res.length() < 8){
                res = "0" + res;
            }
            bin.append(res);
        }

        System.out.println(Long.parseLong(bin.toString(), 2));
    }

    public static void function2(String str){
        String num = Long.toBinaryString(Long.parseLong(str));

        while(num.length() < 32){
            num = "0" + num;
        }
        String[] arr = new String[4];

        for(int i = 0; i < 4; i++){
            String s = num.substring(8 * i, 8 * i + 8);
            arr[i] = Integer.toString(Integer.parseInt(s, 2));
        }
        System.out.println(String.join(".", arr));
    }
}
