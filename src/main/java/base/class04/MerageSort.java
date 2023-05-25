package base.class04;

/**
 * @author Liang
 * @date 2023/5/25 - 11:46
 */
public class MerageSort {
    // 递归方式实现
    public static void mergeSort1(int[] arr){
        if(arr == null || arr.length == 0){
            return;
        }

        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int l, int r) {
        if(l == r){
            return;
        }
        int mid = l + ((r - l) >> 1);
        process(arr, l, mid);
        process(arr, mid + 1, r);
        merage(arr, l, mid, r);
    }

    private static void merage(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r){
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2 ++];
        }

        while (p1 <= mid){
            help[i++] = arr[p1++];
        }
        while (p2 <= r){
            help[i++] = arr[p2++];
        }
        for(i = 0; i < help.length; i++){
            arr[l + i] = help[i];
        }
    }

    public static void mergeSort2(int[] arr){
        if(arr == null || arr.length == 0){
            return;
        }
        int N = arr.length;
        int merageSize = 1;

        while (merageSize < N){
            int l = 0;
            while (l < N){
                if(merageSize >= N - l){
                    break;
                }

                int mid = l + merageSize - 1;
                int r = mid + Math.min(merageSize, N - mid - 1);
                merage(arr, l, mid, r);
                l = r + 1;
            }

            if(merageSize > (N >> 1)){
                break;
            }
            merageSize <<= 1;
        }
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            mergeSort1(arr1);
            mergeSort2(arr2);
            if (!isEqual(arr1, arr2)) {
                System.out.println("出错了！");
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println("测试结束");
    }

}
