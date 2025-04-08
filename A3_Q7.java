import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A3_Q7 {

    public static List<Object> customFizzBuzz(int n) {
        List<Object> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            int finalI = i;
            Runnable r = () -> {
                if (finalI % 5 == 0 && finalI % 7 == 0) {
                    result.add("fizzbuzz");
                } else if (finalI % 5 == 0 && finalI % 9 != 0) {
                    result.add("fizz");
                } else if (finalI % 7 == 0 && finalI % 3 != 0) {
                    result.add("buzz");
                } else {
                    result.add(finalI);
                }
            };
            r.run(); // Execute the lambda
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Object> output = customFizzBuzz(n);
        System.out.println(output); // Output: [1, 2, 3, 4, fizz, 6, buzz, 8, 9, fizz]
        in.close();
    }
}