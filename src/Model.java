/*
 * Progammer: Conall Lorentz, Charles Damian
 * Dates: May 26-X
*/

import java.util.Random;

import javax.swing.SwingUtilities;
import javax.swing.text.View;

public class Model{

    static int[] initArr;

    static void generateArray(int length, int min, int max){
        initArr = new int[length];
        Random r = new Random();
        for(int i = 0; i < length; i++){
            int low = min, high = max;
            initArr[i] = r.nextInt(high - low) + low;
        }
    }

    void startRace(){
        getTimes(initArr);
    }
    
    void getTimes(int[] testArr){
        //long bTime = bubbleSort(testArr), sTime = 0, iTime = 0;
    }

    static long bubbleSort(int[] testArr){
        int[] storeArr = testArr;
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

    static long selectionSort(int[] testArr){
        int[] storeArr = testArr;
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

    int[] insertionSort(int[] testArr){
        int[] storeArr = testArr;
        int n = storeArr.length;
        long currentTime = System.currentTimeMillis();
        return storeArr;
    }

    int[] quickSort(int[] testArr){
        long currentTime = System.currentTimeMillis();
        int[] storeArr = new int[100];
        return storeArr;
    }

    public static void main(String args[]) {
        int[] testArr = {5, 3, 6, 4, 1};
        generateArray(50000, -200, 200);
        System.out.println("BUBBLE SORT TIME: " + bubbleSort(initArr));
        System.out.println("SELECTION SORT TIME: " + selectionSort(initArr));
        //int[] finalArr = selectionSort(testArr);
        /*for (int i : finalArr) {
            System.out.print(i);
        }*/
        System.out.println();
        System.out.println("hello from model");
    }
}