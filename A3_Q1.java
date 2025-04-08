import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

class Sweets{
    static HashSet<ArrayList<Integer>> getSweets(ArrayList<Integer> s, int n){

        HashSet<ArrayList<Integer>> hset = new HashSet<>();
        
        int win_size = (n / 2);
        int left = 0, right = win_size - 1;
        while(right < s.size()){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = left; i <= right; i++){
                temp.add(s.get(i));
            }
            Collections.sort(temp);
            hset.add(temp);
            left++; 
            right++;
        }

        return hset;

    }
}

public class A3_Q1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n, k;
        ArrayList<Integer> s = new ArrayList<>();
        System.out.print("Ente the total number of sweets: ");
        n = input.nextInt();
        System.out.print("Enter the number of varities of sweets: ");
        k = input.nextInt();
        if(k >= n){
            System.out.println("IMPOSSOBLE to try all combo of sweets in (n/2) contraints.");
            input.close();
            return;
        }
        //int type = (n/k);
        for(int i = 1, j = 1; i <= n; i++){
            s.add(j);
            if(j == k) j = 1;
            else j++;
        }
        HashSet<ArrayList<Integer>> l = Sweets.getSweets(s, n);
        System.out.println("Only " + l.size() + " combinations of sweets will be taken.");
        System.out.println("Valid combinations of sweets: ");
        for(ArrayList<Integer> combo : l){
            System.out.println(combo);
        }

        input.close();
    }
}