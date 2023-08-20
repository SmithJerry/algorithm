package company.test01;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Liang
 * @date 2023/8/18 - 13:48
 */
public class 字符串无重复的字符数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            function(str);
        }
    }
    public static void function(String str) {
        char[] s1 = str.toCharArray();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < s1.length; i++) {
            set.add(s1[i]+"");
        }

        System.out.println(set.size());
    }
}
