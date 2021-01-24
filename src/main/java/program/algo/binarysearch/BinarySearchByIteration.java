package program.algo.binarysearch;

public class BinarySearchByIteration {

    public static int binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;

        if (low > high || array[low] > key || array[high] < key) {
            return -1;
        }

        while (low <= high) {
            int middle = (low + high) / 2;
            if (array[middle] < key) {
                low = middle + 1;
            } else if (array[middle] > key) {
                high = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 9, 9, 11};
        int key = 4;

        int position = binarySearch(arr, key);
        System.out.println(position);
    }
}
