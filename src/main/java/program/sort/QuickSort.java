package program.sort;

public class QuickSort {

    public void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivot = array[low];
            int i = low;
            int j = high;
            while (i < j) {
                while (i < j && array[j] >= pivot) {
                    j--;
                }
                array[i] = array[j];
                while (i < j && array[i] <= pivot) {
                    i++;
                }
                array[j] = array[i];
            }
            array[i] = pivot;

            quickSort(array, low, i - 1);
            quickSort(array, i + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] list = {34, 3, 53, 2, 23, 7, 7, 14, 10, -3};
        QuickSort qs = new QuickSort();
        qs.quickSort(list, 0, list.length - 1);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }
}
