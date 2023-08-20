package company.test01;

import java.util.Scanner;
import java.util.Set;

/**
 * @author Liang
 * @date 2023/8/18 - 10:23
 */
public class 进制之间相互转换 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            // 十六进制十进制
            String str = in.nextLine();
            System.out.println(Integer.parseInt(str.substring(2, str.length()), 16));
            String n = in.nextLine();
            Integer x = Integer.parseInt(n);
            System.out.println(Integer.toHexString(x));

            // 八进制十进制
            String str1 = in.nextLine();
            System.out.println(Integer.parseInt(str1, 8));
            String n1 = in.nextLine();
            Integer x1 = Integer.parseInt(n1);
            System.out.println(Integer.toOctalString(x1));

            // 二进制十进制
            String str2 = in.nextLine();
            System.out.println(Integer.parseInt(str2, 2));
            String n2 = in.nextLine();
            Integer x2 = Integer.parseInt(n2);
            System.out.println(Integer.toBinaryString(x2));

        }
    }
    public static void process(String str){

        }

}
