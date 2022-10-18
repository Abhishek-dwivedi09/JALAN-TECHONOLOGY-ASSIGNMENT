package problemOne;

import java.util.*;
public class ArrayRearrange {
        public static void arrayRearrange(int arr[], int n)
        {
            int maxElementIndex = n - 1, minElementIndex = 0,currElement = arr[n - 1] + 1;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    arr[i] += (arr[maxElementIndex] % currElement) * currElement;
                    maxElementIndex--;
                }
                else {
                    arr[i] += (arr[minElementIndex] % currElement) * currElement;
                    minElementIndex++;
                }
            }

            for (int i = 0; i < n; i++)
                arr[i] = arr[i] / currElement;
        }
        public static void main(String args[])
        {
            int arr[] = { 2,4,6,8};
            int n = arr.length;
            arrayRearrange(arr, n);
            for (int i = 0; i < n; i++)
                System.out.print(arr[i] + " ");
        }
    }

    // TIME COMPLEXITY- O(n)
    // Space complexity -O(1)
 /* test cases for above program arr[] = {1,2,3,4,5},
 {12,14,18,20},
 {20, 40, 60, 80,100};
  */




