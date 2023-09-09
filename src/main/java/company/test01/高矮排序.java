package company.test01;

import java.util.Scanner;

/**
* @author Liang
* @date 2023/8/25 - 17:49
题目
现在有一队小朋友，他们高矮不同，，我们以正整数数组表示这一队小朋友的身高，如数组{5,3,1,2,3}。
我们现在希望小朋友排队，以“高”“矮”“高”“矮”顺序排列，每一个“高”位置的小朋友要比相邻的位置高或者相等；每一个“矮”位置的小朋友要比相邻的位置矮或者相等；要求小朋友们移动的距离和最小，第一个从“高”位开始排，输出最小移动距离即可。
移动距离的定义如下所示：第二位小朋友移到第三位小朋友后面，移动距离为1，若移动到第四位小朋友后面，移动距离为2。
输入描述：
排序前的小朋友，以英文空格的正整数：4 3 5 7 8
小朋友<100个
输出描述：
排序后的小朋友，以英文空格分割的正整数：4 3 7 5 8
输出结果为最小移动距离，只有5和7交换了位置，移动距离都是1
示例：
输入：
4 1 3 5 2
输出：
4 1 5 2 3
输入：
1 1 1 1 1
输出：
1 1 1 1 1
说明：
相邻位置可以相等
输入：
xxx
输出：
[]
说明：

出现非法参数情况，返回空数组
思路
1：其实题目理解之后就知道，目标是要保证最小移动距离，且以高位为起点。理解最小移动距离为循环比较当前位置和后面位置的大小，然后交换即可。

2：注意题目要输出的是最小移动距离所产生的新数组，不是让你输出最小移动距离。

考点
1：排序*/
public class 高矮排序 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();
        String[] strs = input.split(" ");
        int[] arr = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        int i = 0;
        while (i + 1 < arr.length) {
            //原则奇数位大 偶数位小
            if ((i + 1) % 2 == 0) {
                // 1算奇数位 i要小
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                } else {
                    //0算奇数位 i要大
                    if (arr[i] < arr[i + 1]) {
                        swap(arr, i, i + 1);
                    }
                }
                i++;
            }
        }
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }
    }
    public static  void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
