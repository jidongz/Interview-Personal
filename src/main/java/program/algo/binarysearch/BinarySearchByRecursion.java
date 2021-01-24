package program.algo.binarysearch;

/**
 * https://blog.csdn.net/maoyuanming0806/article/details/78176957
 */

public class BinarySearchByRecursion {

    public static int binarySearch(int[] array, int key, int low, int high) {
        if (low > high || array[low] > key || array[high] < key) {
            return -1;
        }

        int middle = (low + high) / 2;

        if (array[middle] > key) {
            return binarySearch(array, key, low, middle - 1);
        } else if (array[middle] < key) {
            return binarySearch(array, key, middle + 1, high);
        }

        return middle;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 9, 9, 11};
        int key = 4;

        int position = binarySearch(arr, key, 0, arr.length - 1);
        System.out.println(position);
    }
}
