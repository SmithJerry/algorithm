package base.class04;

/**
 * @author Liang
 * @date 2023/5/26 - 12:22
 * https://leetcode.com/problems/count-of-range-sum
 */
public class CountOfRangeSum {
    public static int countRangeSum(int[] arr, int lower, int upper){
        if (arr == null || arr.length == 0){
            return 0;
        }
        long[] sums = new long[arr.length + 1];

        sums[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            sums[i] = sums[i - 1] + arr[i];
        }
        return process(sums, 0, sums.length - 1, lower, upper);
    }

    private static int process(long[] arr, int l, int r, int lower, int upper) {

        if(l == r){
            return arr[l] >= lower && arr[l] <= upper ? 1 : 0;
        }

        int mid = l + ((r - l) >> 1);

        return process(arr, l, mid, lower, upper) + process(arr, mid + 1, r, lower, upper) + merge(arr, l, mid, r, lower, upper);

    }

    private static int merge(long[] arr, int l, int mid, int r, int lower, int upper) {

        int ans = 0;
        int windowsR = l;
        int windowsL = l;
        for(int i = mid + 1; i <= r; i++){

            long min = arr[i] - upper;
            long max = arr[i] - lower;

            while (windowsR <= mid && arr[windowsR] <= max){
                windowsR++;
            }

            while (windowsL <= mid && arr[windowsL] < min){
                windowsL++;
            }
            ans += windowsR - windowsL;
        }

        long[] help = new long[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= mid) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }

        return ans;
    }
}
