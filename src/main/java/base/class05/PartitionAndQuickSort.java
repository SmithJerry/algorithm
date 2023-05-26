package base.class05;

/**
 * @author Liang
 * @date 2023/5/26 - 12:24
 */
public class PartitionAndQuickSort {

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static int[] netherlandsFlag(int[] arr, int l, int r){
        if(l > r){
            return new int[]{-1, -1};
        }

        if(l == r){
            return new int[]{l, r};
        }

        int less = l - 1;
        int more = r;
        int index =l;

        while (index < more){
            if(arr[index] == arr[r]){
                index++;
            }else if(arr[index] < arr[r]){
                swap(arr, index++, ++less);
            }else {
                swap(arr, index, --more);
            }
        }
        swap(arr, r, more);

        return new int[]{less+1, more};
    }

    public static void quickSort1(int[] arr){
        if(arr == null || arr.length == 0){
            return;
        }
        process1(arr, 0, arr.length -1);
    }

    private static void process1(int[] arr, int l, int r) {
        if(l >= r){
            return;
        }
        int m = partition(arr, l, r);
        process1(arr, l, m - 1);
        process1(arr, m + 1, r);
    }

    public static int partition(int[] arr, int L, int R) {
        if (L > R) {
            return -1;
        }
        if (L == R) {
            return L;
        }
        int lessEqual = L - 1;
        int index = L;
        while (index < R) {
            if (arr[index] <= arr[R]) {
                swap(arr, index, ++lessEqual);
            }
            index++;
        }
        swap(arr, ++lessEqual, R);
        return lessEqual;
    }

    public static void quickSort2(int[] arr){
        if(arr == null || arr.length == 0){
            return;
        }
        process2(arr, 0, arr.length -1);
    }

    private static void process2(int[] arr, int l, int r) {
        if(l >= r){
            return;
        }

        int[] res = netherlandsFlag(arr, l, r);
        process2(arr, l, res[0] - 1);
        process2(arr, res[1] + 1, r);

    }

    public static void quickSort3(int[] arr){
        if(arr == null || arr.length == 0){
            return;
        }
        process3(arr, 0, arr.length -1);
    }

    private static void process3(int[] arr, int l, int r) {
        if(l >= r){
            return;
        }
        swap(arr, l + (int)((r - l + 1) * Math.random()), r);

        int[] res = netherlandsFlag(arr, l, r);
        process2(arr, l, res[0] - 1);
        process2(arr, res[1] + 1, r);

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
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            quickSort1(arr1);
            quickSort2(arr2);
            quickSort3(arr3);
            if (!isEqual(arr1, arr2) || !isEqual(arr2, arr3)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Oops!");

    }
}
