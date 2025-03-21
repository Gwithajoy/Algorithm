package Sorting.ComparisonBasedSorting;// 힙 정렬

import java.util.Arrays;

public class HeapSort {
    
    public static void heapSort(int[] arr) {
        for (int i = arr.length / 2 -1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }

    }

    public static void heapify(int[] arr, int parentIdx, int size) {
        int leftIdx = 2 * parentIdx + 1;
        int rightIdx = 2 * parentIdx + 2;
        int maxIdx = parentIdx;

        if (leftIdx < size && arr[leftIdx] > arr[maxIdx]) {
            maxIdx = leftIdx;
        }
        if (rightIdx < size && arr[rightIdx] > arr[maxIdx]) {
            maxIdx = rightIdx;
        }
        if (parentIdx != maxIdx) {
            swap(arr, parentIdx, maxIdx);
            heapify(arr, maxIdx, size); // 이거 필수!
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {3, 5, 2, 7, 1, 4, 6};
        heapSort(arr);
        System.out.println("힙 정렬: " + Arrays.toString(arr));
    }
}
