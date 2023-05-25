package base.class02;

/**
 * @author Liang
 * @date 2023/5/24 - 16:34
 */
public class EvenTimesOddTimes {
    public static void printOddTimesNum1(int[] arr){
        int res = 0;
        for(int i = 0; i < arr.length; i++){
            res ^= arr[i];
        }
        System.out.println(res);
    }

    public static  void printOddTimesNum2(int[] arr){
        int res = 0;
        int tmp = 0;

        for(int i = 0; i < arr.length; i++){
            tmp ^= arr[i];
        }

        // 去数中最右为1的值
        int rightOne = tmp & (-tmp);

        for(int i = 0; i < arr.length; i++){
            if((rightOne & arr[i]) != 0){
                res ^= arr[i];
            }
        }

        System.out.println(res + " " +  " " + (res ^ tmp));
    }


    public static void main(String[] args) {
        int a = 5;
        int b = 7;

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a);
        System.out.println(b);

        int[] arr1 = { 3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1 };
        printOddTimesNum1(arr1);

        int[] arr2 = { 4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2 };
        printOddTimesNum2(arr2);

    }
}
