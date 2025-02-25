import java.util.*;
import java.lang.*;
import java.lang.reflect.Array;
import java.io.*;



class A2_Q7{

    // ELEMINATING LEADING SPACES.
    static String trimLeadingSpaces(String str){
        if(str.length() == 0) return null;
        int i = 0;
        for(i = 0; i < str.length(); i++){
            if(str.charAt(i) != ' ') break;
        }
        return str.substring(i);
    }

    // COUNTING NUMBER OF 'a'
    static int number_of_a(String str){
        str = trimLeadingSpaces(str);
        if(str.length() == 0) return 0;
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'a' || str.charAt(i) == 'A') count++;
        }
        return count;
    }

    // COUNTING NUMBER OF "and"
    static int number_of_and(String str){
        str = trimLeadingSpaces(str);
        if(str.length() < 3) return 0;
        int count = 0;
        for(int i = 0; i < str.length() - 2; i++){
            if(str.charAt(i) == ' ') continue;
            if(str.substring(i, i + 3).equals("and")) count++;
        }
        return count;
    }

    static boolean start_with_the(String str){
        str = trimLeadingSpaces(str);
        if(str.length() == 0) return false;
        if(str.length() < 3) return false;
        if(str.substring(0, 4).equals("the") || str.substring(0, 4).equals("The")) return true;
        else return false;
    }

    static ArrayList contsinerize(String str){
        str = trimLeadingSpaces(str);
        if(str.length() == 0) return null;
        ArrayList<Character> list = new ArrayList<>();
        for(int i = 0; i < str.length(); i++){
            list.add(str.charAt(i));
        }
        return list;
    }

    static void show_tokens(String str){
        str = trimLeadingSpaces(str);
        if(str.length() == 0){
            System.out.println("no tokens to show.");
            return;
        }

        int x = 0;
        //System.out.println("TOKENS ARE IN THE TRIMMED STRING:");
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' ' || str.charAt(i) == '.' || str.charAt(i) == '@'){
                if(x == 0){
                    System.out.println();
                    x++;
                }
            }
            else{
                x = 0;
                System.out.print(str.charAt(i));
            }
        }
    }

    static boolean isPalindrome(String str){
        if(str.length() == 0)  return false;
        int left = 0;
        int right = str.length() - 1;
        while(left < right){
            if(str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    static String longestPalindrome(String str){
        str = trimLeadingSpaces(str);
        if(str.length() == 0) return null;

        String ans = "";
        int size = 0;

        String[] words = str.split("[ .@]+");
        for(String i : words){
            if(isPalindrome(i)){
                if(i.length() >= size){
                    size = i.length();
                    ans = i;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String str;
        Scanner input = new Scanner(System.in);
        System.out.print("ENTER A STRING: ");
        str = input.nextLine();

        System.out.println("total appearence of 'a' in the string: " + number_of_a(str));
        System.out.println("total appearence of 'and' in the string: " + number_of_and(str));
        System.out.println("string start with the or The: " + start_with_the(str));
        System.out.print("containerizing the string and printing the container: ");
        ArrayList <Character> list = contsinerize(str);
        for(Character i : list){
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.print("tokens in the string: ");
        show_tokens(str);

        System.out.println("longest palindrome: " + longestPalindrome(str));

        input.close();
       
    }
    
}