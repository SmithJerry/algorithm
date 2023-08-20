package company.test01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Liang
 * @date 2023/7/19 - 18:04
 */
public class Main {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        List<Integer> list = new ArrayList<>();
//        while (in.hasNextInt()) { // 注意 while 处理多个 case
//            int num = in.nextInt();
//            if(num == 0){
//                break;
//            }
//            list.add(num);
//        }

//        function(list);

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        System.out.println(list1.toString());
    }
    public static void function(List<Integer> list){
        for(int i = 0; i < list.size(); i++){
            int num = list.get(i);
            int p1 = num / 3;
            int p2 = num % 3;

            int result = p1;
            while(p1 != 0){
                int res = p1 / 3;
                p2 += p1 % 3;
                result += res;
                p1 = res;
            }

            System.out.println(result + (p2 > 1 ? p2 / 2 : 0)) ;

        }
    }
}

