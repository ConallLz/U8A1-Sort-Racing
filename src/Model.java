/*
 * Progammer: Conall Lorentz, Charles Damian
 * Dates: May 26 - June 3
*/

import java.util.Random;

public class Model{

    int[] initArr;//declares the array for testing

    /**
     * function to generate a random array of length length, with min and max as the end points
     * @param length the length of the array
     * @param min the min range of the array
     * @param max the max range of the array
     */
    void generateArray(int length, int min, int max){
        initArr = new int[length];//creates an array with length length
        Random r = new Random();//creates a object r of type Random
        for(int i = 0; i < length; i++){//loop to loop through the array and assigning a value between min and max both inclusive
            int low = min, high = max;
            initArr[i] = r.nextInt(high - low + 1) + low;
        }
    }

    /**
     * start race funciton that is called from the controller class
     * @param length length needed for the generate array function
     * @param min min value needed for the generate array function
     * @param max max value needed for the generate array funciton
     * @return it returns a long array each with the time it took for each algorithm to run
     */
    long[] startRace(int length, int min, int max){
        generateArray(length, min, max);//generates the array
        
        return new long[] {//returns an array of times it took each algorithm
            bubbleSort(initArr), 
            selectionSort(initArr), 
            insertionSort(initArr),
            startQuickSort(initArr)
        };
    }

    /**
     * function for running bubble sort algorithm
     * @param testArr array to clone and then sort
     * @return returns the time taken
     */
    long bubbleSort(int[] testArr){
        int[] storeArr = testArr.clone();//clones the array
        int n = storeArr.length;//gets the length of the array
        boolean swapped;
        long beginTime = System.nanoTime();//it gets the starting time the algorithm begins to function 
        for(int i = 0; i < n - 1; i++){//loops from zero to the length of the array - 1
            swapped = false;//it sets swapped to false before it begins
            for(int j = 0; j < n - i - 1; j++){//it loops from zero to the length - current index - 1
                if(storeArr[j] > storeArr[j + 1]){//if the value at the current index is greater than the next, it swaps thEM
                    int temp = storeArr[j + 1];
                    storeArr[j + 1] = storeArr[j];
                    storeArr[j] = temp;
                    swapped = true;
                }
            }
            if(swapped == false){//IF NO VALUE WAS SWAPPED, THAT IS SWAPPED IS STILL FALSE THE ARRAYT 
                break;
            }
        }
        long endTime = System.nanoTime();//gets the nano time at the end of the algorithm

        long tTime = endTime - beginTime;//gets and returns the difference
        return tTime;
    }

    long selectionSort(int[] testArr){
        int[] storeArr = testArr.clone();
        int n = storeArr.length;
        long beginTime = System.nanoTime();

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

        long endTime = System.nanoTime();
        long tTime = endTime - beginTime;
        return tTime;
    }

    long insertionSort(int[] testArr){
        int[] storeArr = testArr.clone();
        int n = storeArr.length;
        long beginTime = System.nanoTime();
        for(int i = 1; i < n; ++i){
            int key = storeArr[i];
            int j = i - 1;

            while(j >= 0 && storeArr[j] > key){
                storeArr[j+1] = storeArr[j];
                j = j - 1;
            }
            storeArr[j + 1] = key;
        }
        long endTime = System.nanoTime();
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

        long beginTime = System.nanoTime();
        
        quickSort(storeArr, 0, storeArr.length - 1);

        long endTime = System.nanoTime();
        long tTime = endTime - beginTime;
        return tTime;
    }
}