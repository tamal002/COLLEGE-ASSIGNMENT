import java.util.*;
import java.lang.*;
import java.io.*;

class A2_Q6{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int exampleInt;
        Integer objInt;
        String str;

        System.out.println("---CONVERTION FROM BASIC DATA_TYPE[INTEGER] TO OBJECT---");
        System.out.print("ENTER AN INTEGER[BASIC DATA_TYPE]: ");
        exampleInt = input.nextInt();
        objInt = Integer.valueOf(exampleInt);
        System.out.println("VALUE OF INTEGER OBJECT: " + objInt.intValue());
        System.out.println();

        System.out.println("---CONVERTION FROM OBJECT TO BASIC DATA_TYPE[INTEGER]---");
        System.out.print("ENTER THE VALUE OF INTEGER OBJECT: ");
        objInt = input.nextInt();
        exampleInt = objInt.intValue();
        System.out.println("VALUE OF INTEGER[BASIC DATA_TYPE]: " + exampleInt);
        System.out.println();


        System.out.println("---CONVERTION FROM BASIC DATA_TYPE[INTEGER] TO STRING---");
        System.out.print("ENTER AN INTEGER[BASIC DATA_TYPE]: ");
        exampleInt = input.nextInt();
        str = Integer.toString(exampleInt);
        System.out.println("HOLDING CONTENT OF THE STRING IS: " + str.toString());
        System.out.println();

        System.out.println("---CONVERTION FROM STRING TO BASIC NUMERIC DATA_TYPE[INTEGER]---");
        System.out.print("ENTER THE CONTENT OF STRING: ");
        str = input.next();
        exampleInt = Integer.valueOf(str);
        System.out.println("VALUE OF EXTRACTED NUMERIC DATA FROM STRING IS: " + exampleInt);
        System.out.println();

        System.out.println("---CONVERTION FROM OBJECT [INTEGER OBJECT] TO STRING---");
        System.out.print("ENTER THE VALUE OF INTEGER OBJECT: ");
        objInt = input.nextInt();
        str = objInt.toString();
        System.out.println("INTEGER CONTENT EXTRACED TO STRING IS: " + str.toString());
        System.out.println();

        input.close();
    }
}