package interview.gs;

/*
https://www.geeksforgeeks.org/goldman-sachs-interview-experience-for-java-backend-engineer/

There is a list of unsorted integer array elements given. We are given a float value.
The solution is to finding the interval it fits in the best.
Example : 4,6 8, 1, 3 , 5 ,10
Given number : 2.3
2.3 can fall in the interval
(1,10), (1,5) and so on.

But the expected solution is (1,3)
This needs to be done without sorting the array.

Follow-up question on the same input.
Find the second smallest element without sorting.

expected answer: 3

 */

public class Test1 {
    ThreadLocal
    private static int[] result = new int[2];
    private static int secSmallest = 0;

    public boolean solution(int[] array, float target) {
        if (array.length == 0) {
            return false;
        }

        int low = Integer.MIN_VALUE;
        int high = Integer.MAX_VALUE;

        int length = array.length;
        if (target <= array[0]) {
            high = array[0];
        } else {
            low = array[0];
        }

        for (int i = 0; i < length; i++) {
            if (target <= array[i]) {
                if (array[i] < high) {
                    high = array[i];
                }
            }
            if (target >= array[i]) {
                if (array[i] > low) {
                    low = array[i];
                }
            }
        }
        if (low != Integer.MIN_VALUE && high != Integer.MAX_VALUE) {
            result[0] = (int) low;
            result[1] = (int) high;
            return true;
        }
        return false;
    }

    public boolean solution2(int[] array) {
        if (array.length < 2) {
            return false;
        }
        int smallest = 0;
        int smaller = 0;

        if (array[0] < array[1]) {
            smallest = array[0];
            smaller = array[1];
        }

        for (int i = 2; i < array.length; i++) {
            if (array[i] < smaller) {
                if (array[i] < smallest) {
                    smaller = smallest;
                    smallest = array[i];
                } else {
                    smaller = array[i];
                }
            }
        }
        secSmallest = smaller;
        return true;
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 6, 8, 1, 3, 5, 10};
        Test1 test1 = new Test1();
        boolean outcome = test1.solution(array, 7);
        if (outcome) {
            System.out.println(result[0]);
            System.out.println(result[1]);
        } else {
            System.out.println("not found");
        }
        System.out.println("----------------");
        outcome = test1.solution2(array);
        if (outcome) {
            System.out.println(secSmallest);
        } else {
            System.out.println("second smallest not found");
        }


    }
}
