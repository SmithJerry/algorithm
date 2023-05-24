package base.class01;

/**
 * @author Liang
 * @date 2023/5/23 - 11:14
 * O(n^2)
 */
public class SelectionSort {
    public static void selectionSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }

        for(int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++){
                minIndex = arr[minIndex] > arr[j] ? j : minIndex;
            }
            swap(i, minIndex, arr);
        }
    }

    private static void swap(int i, int minIndex, int[] arr) {
        int index = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = index;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 8, 4, 7, 6, 9};

        selectionSort(arr);

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
        }
    }
}
