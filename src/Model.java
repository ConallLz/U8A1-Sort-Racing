/*
 * Progammer: Conall Lorentz, Charles Damian
 * Dates: May 26-X
*/

import java.util.Random;

public class Model{

    int[] initArr;

    void generateArray(int length, int min, int max){
        initArr = new int[length];
        Random r = new Random();
        for(int i = 0; i < length; i++){
            int low = min, high = max;
            initArr[i] = r.nextInt(high - low) + low;
        }
    }

    long[] startRace(int length, int min, int max){
        generateArray(length, min, max);
        
        return new long[] {
            bubbleSort(initArr), 
            selectionSort(initArr), 
            insertionSort(initArr),
            startQuickSort(initArr)
        };
    }

    long bubbleSort(int[] testArr){
        int[] storeArr = testArr.clone();
        int n = storeArr.length;
        boolean swapped;
        long beginTime = System.currentTimeMillis();
        for(int i = 0; i < n - 1; i++){
            swapped = false;
            for(int j = 0; j < n - i - 1; j++){
                if(storeArr[j] > storeArr[j + 1]){
                    int temp = storeArr[j + 1];
                    storeArr[j + 1] = storeArr[j];
                    storeArr[j] = temp;
                    swapped = true;
                }
            }
            if(swapped = false){
                break;
            }
        }
        long endTime = System.currentTimeMillis();

        long tTime = endTime - beginTime;
        return tTime;
    }

    long selectionSort(int[] testArr){
        int[] storeArr = testArr.clone();
        int n = storeArr.length;
        long beginTime = System.currentTimeMillis();

        for(int i = 0; i < n-1; i++){
            int min = i;
            for(int j = i+1; j < n; j++){
                if(storeArr[j] < storeArr[min]){
                    min = j;
                }
            }
            int temp = storeArr[i];
            storeArr[i] = storeArr[min];
            storeArr[min] = temp;
        }

        long endTime = System.currentTimeMillis();
        long tTime = endTime - beginTime;
        return tTime;
    }

    long insertionSort(int[] testArr){
        int[] storeArr = testArr.clone();
        int n = storeArr.length;
        long beginTime = System.currentTimeMillis();
        for(int i = 1; i < n; ++i){
            int key = storeArr[i];
            int j = i - 1;

            while(j >= 0 && storeArr[j] > key){
                storeArr[j+1] = storeArr[j];
                j = j - 1;
            }
            storeArr[j + 1] = key;
        }
        long endTime = System.currentTimeMillis();
        long tTime = endTime - beginTime;
        return tTime;
    }

    void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    int partition(int[] array, int low, int high) {
        int pivot = array[low];
        int left = low - 1;
        int right = high + 1;

        while (true) {
            do {
                left++;
            } while (array[left] < pivot);
    
            do {
                right--;
            } while (array[right] > pivot);
    
            if (left >= right) {
                return right;
            }

            swap(array, left, right);
        }
    }

    void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    long startQuickSort(int[] testArr) {
        int[] storeArr = testArr.clone();

        long beginTime = System.currentTimeMillis();
        
        quickSort(storeArr, 0, storeArr.length - 1);

        long endTime = System.currentTimeMillis();
        long tTime = endTime - beginTime;
        return tTime;
    }
}