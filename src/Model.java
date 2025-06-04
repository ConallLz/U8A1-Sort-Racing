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

        for(int i = 0; i < n-1; i++){//loops from zero to the length - 1
            int min = i;//sets the minimum to the current index
            for(int j = i+1; j < n; j++){//it loops from the next index to the length of the array, if any value at the indexes up till that point is the minimum, minimum becomes that index
                if(storeArr[j] < storeArr[min]){
                    min = j;
                }
            }
            //it then swaps the current index with the index at the minimum
            int temp = storeArr[i];
            storeArr[i] = storeArr[min];
            storeArr[min] = temp;
        }

        long endTime = System.nanoTime();
        long tTime = endTime - beginTime;//gets the endtime and returns the difference
        return tTime;
    }

    /**
     * insertion sort algorithm put into code
     * @param testArr
     * @return
     */
    long insertionSort(int[] testArr){
        int[] storeArr = testArr.clone();
        int n = storeArr.length;
        long beginTime = System.nanoTime();//it gets the time it begins the algorithm
        for(int i = 1; i < n; ++i){//it loops from the next value of the array up to the length of the array
            int key = storeArr[i];//the key becomes the current index
            int j = i - 1;//gets the value of 

            while(j >= 0 && storeArr[j] > key){//it loops from the all the values of the array before the key and switches them to correct order 
                storeArr[j+1] = storeArr[j];
                j = j - 1;
            }
            storeArr[j + 1] = key;
        }
        long endTime = System.nanoTime();//it gets the endtime and returns the difference between the start and endtime
        long tTime = endTime - beginTime;
        return tTime;
    }

    /**
     * @param array - The array containing the values which will be swapped
     * @param a - The index of the first value which will be swapped
     * @param b - The index of the second value which will be swapped
     */
    void swap(int[] array, int a, int b) {
        int temp = array[a]; // Create a temporary variable to hold the first value
        array[a] = array[b]; // Set the first value to the second
        array[b] = temp; // Set the second value to the first (temp)
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

    /**
     * 
     * @param array - The array to sort
     * @param low the lower value
     * @param high the higher value
     */
    void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    // Quick sort is split up like this because it is recursive
    /**
     * @param testArr - The array to sort
     * @return - The time it took for the algorithm to finish sorting the array
     */
    long startQuickSort(int[] testArr) {
        int[] storeArr = testArr.clone(); // A clone of the array to sort. We do not want to use the array given because the other algorithms are given the same one.

        long beginTime = System.nanoTime(); // The time in nano seconds when starting, more precise than System.currentTimeMillis()
        
        quickSort(storeArr, 0, storeArr.length - 1); // Call the quick sort method on the array

        long endTime = System.nanoTime(); // The time when ending
        long tTime = endTime - beginTime; // The difference between the two times (time it took for the algorithm to complete)
        return tTime; // Return the time
    }
}