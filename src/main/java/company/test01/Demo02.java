package company.test01;

/**
 * @author Liang
 * @date 2023/8/16 - 11:42
 */
public class Demo02 {

    public static void main(String[] args) {
        String s1 = "9230";
        String s2 = "99567";
        String res = sum(s1, s2);
        System.out.println(res);
    }
//4690
    private static String sum(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        int index = n1 > n2 ? n2: n1;

        char[] c1 = new StringBuffer(s1).reverse().toString().toCharArray();
        char[] c2 = new StringBuffer(s2).reverse().toString().toCharArray();

        StringBuffer result = new StringBuffer();
        int flag = 0;
        for(int i = 0; i < index; i++){
            int a = c1[i] - '0';
            int b = c2[i] - '0';
            int res = a + b + flag;
            if(res >= 10){
                flag = 1;
                result.append(res % 10);
            }else {
                flag = 0;
                result.append(res);
            }
        }

        if(index == n1){
            int i = index;
            while (i < n2){
                int res = c2[i] - '0' + flag;
                if(res >= 10){
                    flag = 1;
                    result.append(res % 10);
                }else {
                    flag = 0;
                    result.append(c2[i]);
                }
                i++;
            }
            if(flag == 1){
                result.append(1);
            }
        }
        if(index == n2){
            int i = index;
            while (i < n1){
                int res = c1[i] - '0' + flag;
                if(res >= 10){
                    flag = 1;
                    result.append(res % 10);
                }else {
                    flag = 0;
                    result.append(c1[i]);
                }
                i++;
            }
            if(flag == 1){
                result.append(1);
            }

        }
        if(n1 == n2){
            if(c1[n1 - 1] + c2[n2 - 1] + flag >= 10){
                result.append(1);
            }
        }
        return result.reverse().toString();
    }

}