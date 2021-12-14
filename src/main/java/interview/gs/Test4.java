package interview.gs;

/*
https://www.youtube.com/watch?v=bBbs6YPA6yc

Goldman Sachs Coderpad | Snow Pack Problem | Java Shastra

int [] array = new int[](0,1,3,0,1,2,0,4,2,0,3,0);
output = 13;

int [] array = new int[](0,1,3,0,1,2,0,4,2,0,2,0);
output = 11;

int [] array = new int[](0,1,2,0,1,2,0,4,2,0,3,0);
output = 9;

 */

import java.util.Arrays;

public class Test4 {

    public static int[] array = new int[]{0, 1, 2, 0, 1, 2, 0, 4, 2, 0, 3, 0};

    public static int solution() {
        if (array.length == 0) {
            return 0;
        }

        int length = array.length;

        int[] left = new int[length];
        left[0] = array[0];
        for (int i = 1; i < length; i++) {
            if (array[i] > left[i - 1]) {
                left[i] = array[i];
            } else {
                left[i] = left[i - 1];
            }
        }

        System.out.println(Arrays.toString(left));

        int[] right = new int[length];
        right[length - 1] = array[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            if (array[i] > right[i + 1]) {
                right[i] = array[i];
            } else {
                right[i] = right[i + 1];
            }
        }

        System.out.println(Arrays.toString(right));

        int[] combined = new int[length];
        for (int i = 0; i < length; i++) {
            if (left[i] > right[i]) {
                combined[i] = right[i];
            } else {
                combined[i] = left[i];
            }
        }

        int[] result = new int[length];
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum = sum + (combined[i] - array[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(Test4.solution());
    }
}
