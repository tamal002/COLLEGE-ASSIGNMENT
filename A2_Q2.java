import java.util.*;
import java.lang.*;
import java.io.*;

//ANOTHER APPROACH : USING NESTED LOOP [TC => O(N*N) SC => O(1)]
// TC => O(N)   SC => O(1)
class A2_Q1 {
    public static void main(String[] args) throws java.lang.Exception {
        int size;
        Scanner input = new Scanner(System.in);
        System.out.print("Number of containers: ");
        size = input.nextInt();
        int[] arr = new int[size];
        System.out.print("Enter the hight of containers: ");
        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }
        input.close();
        int left = 0; // LEFT POINTER
        int right = size - 1; // RIGHT POINTER
        int maxArea = 0;
        while(left < right){
            int width = right - left;
            int height = Math.min(arr[left], arr[right]);
            maxArea = Math.max(maxArea, (width * height));
            if(arr[left] < arr[right]) left++;
            else right--;
        }

        System.out.println("MAXIMUM AMMOUNT OF WATER CAN BE HOLD IS : " + maxArea);
        // int[] result = { 0, 0, 0 };
        // for (int i = 0; i < size - 1; i++) {
        //     int widgth = (size - 1) - i;
        //     int height;
        //     if (arThe message you submitted war[i] <= arr[size - 1])
        //         height = arr[i];
        //     else
        //         height = arr[size - 1];
        //     int ammount = height * widgth;
        //     if (ammount > result[0]) {
        //         result[0] = ammount;
        //         result[1] = i;
        //         result[2] = size - 1;
        //     }
        // }
        // System.out.println("maximun contained water : " + result[0]);
        // System.out.println("maximun water contained betwee : " + result[1] + " and " + result[2]);
        // input.close();
    }
}
