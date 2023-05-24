package base.class01;

/**
 * @author Liang
 * @date 2023/5/23 - 19:17
 * O(n^2)
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] > arr[j]){
                    swap(arr, i, j);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 8, 4, 7, 6, 9};

        bubbleSort(arr);

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
        }
    }
}
