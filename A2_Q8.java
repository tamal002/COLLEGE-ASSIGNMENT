import java.util.*;
import java.lang.*;
import java.io.*;

class ReverseCharSequence implements CharSequence{
    public String str;

    ReverseCharSequence(String s){
        this.str = s;
    }

    public char charAt(int index){
        System.out.print("charAt[" + index + "] = ");
        return new StringBuilder(str).reverse().charAt(index);
    }

    public int length(){
        System.out.print("string length = ");
        return str.length();
    }

    public CharSequence subSequence(int start, int end){
        System.out.print("subsequence from " + start + " to " + end + " = ");
        return new StringBuilder(str).reverse().subSequence(start, end);
    }


    public String toString(){
        System.out.print("toString = ");
        return new StringBuilder(str).reverse().toString();
    }
}

class A2_Q8{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str;
        System.out.print("ENTER A STRING: ");
        str = input.nextLine();
        ReverseCharSequence obj = new ReverseCharSequence(str);

        System.out.println(obj.charAt(2));
        
        System.out.println(obj.length());
        
        System.out.println("'" + obj.subSequence(2, 5) + "'");
        
        System.out.println(obj.toString());

        input.close();
    }
}