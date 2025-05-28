/*
 * Progammer: Conall Lorentz, Charles Damian
 * Dates: May 26-X
*/

import java.util.Random;

import javax.swing.SwingUtilities;
import javax.swing.text.View;

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
        if (initArr == null) { return null; }
        
        return new long[] {
            bubbleSort(initArr), 
            selectionSort(initArr), 
            insertionSort(initArr)
        };
    }

    long bubbleSort(int[] testArr){
        int[] storeArr = testArr.clone();
        int n = storeArr.length;
        boolean swapped = false;
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

    int[] quickSort(int[] testArr){
        long currentTime = System.currentTimeMillis();
        int[] storeArr = new int[100];
        return storeArr;
    }
}