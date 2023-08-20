package company.test01;

import java.util.Scanner;

/**
 * @author Liang
 * @date 2023/8/18 - 14:33
 */
public class 上下左右工具 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();

            function(str);
        }
    }

    public static void function(String str){

        String[] strs = str.substring(0, str.length() - 1).split(";");

        int x = 0;
        int y = 0;
        for(int i = 0; i < strs.length; i++){

            if(isTrue(strs[i])){
                if(strs[i].charAt(0) == 'A'){
                    int num = Integer.parseInt(strs[i].substring(1, strs[i].length()));
                    x -= num;
                }
                if(strs[i].charAt(0) == 'D'){
                    int num = Integer.parseInt(strs[i].substring(1, strs[i].length()));
                    x += num;
                }
                if(strs[i].charAt(0) == 'W'){
                    int num = Integer.parseInt(strs[i].substring(1, strs[i].length()));
                    y += num;
                }
                if(strs[i].charAt(0) == 'S'){
                    int num = Integer.parseInt(strs[i].substring(1, strs[i].length()));
                    y -= num;
                }
            }
        }
        System.out.println(x + "," + y);
    }

    public static boolean isTrue(String str){
        if( str == null || str.isEmpty()){
            return false;
        }
        char[] s = str.toCharArray();
        if(s[0] != 'A' && s[0] != 'D' && s[0] != 'W' && s[0] != 'S' ){
            return false;
        }
        int len = s.length;

        String numStr = str.substring(1, len);
        try{
            int num = Integer.parseInt(numStr);
        }catch(Exception e){
            return false;
        }

        return true;
    }
}
