import java.util.*;
import java.util.*;
import java.lang.*;
import java.io.*;

class BankAccount{
    String id;
    String name;
    String phone;
}

class NormalAccount extends BankAccount{
    boolean  loaned;
    double curLoan;
    static double credLimit = 100000.00d; // FIXED FOR ALL NORMAL CUSTOMERS
    static float intRate = 3.21f; // FIXED FOR ALL NORMAL CUSTOMERS

    NormalAccount(String id, String name, String phone){
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.loaned = false;
        this.curLoan = 0.0d;
    }
}

class PrivilegedAccount extends BankAccount{
    boolean loaned;
    double curLoan;
    static double credLimit = 1000000.00d; // FIXED FOR ALL NORMAL CUSTOMERS
    static float intRate = 5.68f; // FIXED FOR ALL NORMAL CUSTOMERS

    PrivilegedAccount(String id, String name, String phone){
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.loaned = false;
        this.curLoan = 0.0d;
    }
}

class Operator{
    ArrayList<NormalAccount> normalAccList = new ArrayList<>();
    ArrayList<PrivilegedAccount> privAccList = new ArrayList<>();

    // ADDING NORMAL CUSTOMER
    void addNormalCustomer(NormalAccount cust){
        normalAccList.add(cust);
        System.out.println("normal customer with a/c id: " + cust.id + " added successfully.");
    }

    // ADDING PRIVILEGED CUSTOMER
    void addPrivilegedCustomer(PrivilegedAccount cust){
        privAccList.add(cust);
        System.out.println("previleged customer with a/c id: " + cust.id + " added successfully.");
    }

    // SHOWING PRIVILEGED ACCOUNTS DETAILS
    void showNormalDetails(){
        if(normalAccList.size() == 0){
            System.out.println("NO NORMAL ACCOUNTS LISTED YET.");
            return;
        }
        System.out.println("NORMAL BANK_ACCOUNTS ARE LISTED AS BELOW");
        int count = 0;
        for( NormalAccount i : normalAccList){
            System.out.println("account no: "+  count);
            System.out.println("a/c id: " + i.id);
            System.out.println("a/c holder name: "+ i.name);
            System.out.println("phone: " + i.phone);
            if(i.loaned == true){
                System.out.println("current loan ammount: " + i.curLoan);
                System.out.println("credit limit: " + NormalAccount.credLimit);
                System.out.println("interest rate: " + NormalAccount.intRate);
            }
            System.out.println("--------------------");
            count++;
        }
    }

    // SHOWING PRIVILEGED ACCOUNTS DETAILS
    void showPrivilegedDetails(){
        if(privAccList.size() == 0){
            System.out.println("NO PRIVILEGED ACCOUNTS LISTED YET.");
            return;
        }
        System.out.println("PRIVILEGED BANK_ACCOUNTS ARE LISTED AS BELOW");
        int count = 0;
        for( PrivilegedAccount i : privAccList){
            System.out.println("account no: "+  count);
            System.out.println("a/c id: " + i.id);
            System.out.println("a/c holder name: "+ i.name);
            System.out.println("phone: " + i.phone);
            if(i.loaned == true){
                System.out.println("current loan ammount: " + i.curLoan);
                System.out.println("credit limit: " + PrivilegedAccount.credLimit);
                System.out.println("interest rate: " + PrivilegedAccount.intRate);
            }
            System.out.println("--------------------");
            count++;
        }
    }

    void showLoanDetails(){
        // IN CASE THERE NO ACCOUNT LISTED YET.
        if(normalAccList.size() == 0 && privAccList.size() == 0){
            System.out.println("NO ACCOUNTS ARE LISTED YET.");
            return;
        }

        // DETAILS OF NORMAL ACCOUNT.
        if(normalAccList.size() == 0){
            System.out.println("NO NORMAL LOANED ACCOUNT LISTED YET.");
        }
        else{
            System.out.println("LOANED NORMAL ACCOUNTS ARE SHOWN BELOW.");
            for(NormalAccount i : normalAccList){
                if(i.loaned == true){
                    System.out.println("a/c id: " + i.id);
                    System.out.println("a/c holder name: " + i.name);
                    System.out.println("cuu=rrent loaned ammount : " + i.curLoan);
                    System.out.println("interest rate: " + NormalAccount.intRate);
                    System.out.println("credit limit: " + NormalAccount.credLimit);
                }
                System.out.println("-----------------");
            }
        }

        // DETAILS OF PRIVILEGED ACCOUNT.
        if(privAccList.size() == 0){
            System.out.println("NO PRIVILEGED LOANED ACCOUNT LISTED YET.");
        }
        else{
            System.out.println("LOANED PRIVILEGED ACCOUNTS ARE SHOWN BELOW.");
            for(PrivilegedAccount i : privAccList){
                if(i.loaned == true){
                    System.out.println("a/c id: " + i.id);
                    System.out.println("a/c holder name: " + i.name);
                    System.out.println("cuu=rrent loaned ammount : " + i.curLoan);
                    System.out.println("interest rate: " + PrivilegedAccount.intRate);
                    System.out.println("credit limit: " + PrivilegedAccount.credLimit);
                }
                System.out.println("-----------------");
            }
        }
    }

    void changePersonalDetails(String id, String phone){
        for(NormalAccount i : normalAccList){
            if(i.id == id){
                i.phone = phone;
                System.out.println("for normal customer id: " + i.id + " phone is changed cucessfully.");
                return;
            }
        }
        for(PrivilegedAccount i : privAccList){
            if(i.id == id){
                i.phone = phone;
                System.out.println("for privileged customer id: " + i.id + " phone is changed cucessfully.");
                return;
            }
        }
        System.out.println("no account found with id: " + id);
        System.out.println("try again later !");
    }


}

public class A2_Q4{
    public static void main(String[] args) {
        
        Operator obj = new Operator();
        Scanner input = new Scanner(System.in);
        while(true){
            
            System.out.println("press 1 to add normal customer.");
            System.out.println("press 2 to add privileged customer.");
            System.out.println("press 3 to show normal a/c details.");
            System.out.println("press 4 to show privileged a/c details.");
            System.out.println("press 5 to show the entire loan details.");
            System.out.println("press 6 to chane the the personal details.");
            System.out.println("press 7 to terminate the session.");
            System.out.print("your choice: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the customer id: ");
                    String id1 = input.next();
                    System.out.print("Enter the name of customer: ");
                    String name1 = input.next();
                    System.out.println("Enter phone number of customer: ");
                    String phone1 = input.next();
                    NormalAccount custNormal = new NormalAccount(id1, name1, phone1);
                    obj.addNormalCustomer(custNormal);
                    break;
                
                case 2:
                    System.out.print("Enter the customer id: ");
                    String id2 = input.next();
                    System.out.print("Enter the name of customer: ");
                    String name2 = input.next();
                    System.out.println("Enter phone number of customer: ");
                    String phone2 = input.next();
                    PrivilegedAccount custPrivileged = new PrivilegedAccount(id2, name2, phone2);
                    obj.addPrivilegedCustomer(custPrivileged);
                    break;

                case 3:
                    obj.showNormalDetails();
                    break;
            
                case 4:
                    obj.showPrivilegedDetails();
                    break;

                case 5:
                    obj.showLoanDetails();
                    break;

                case 6:
                    System.out.print("Enter the id:");
                    String id3 = input.next();
                    System.out.print("Enter the new phone number: ");
                    String newPhone = input.next();
                    obj.changePersonalDetails(id3, newPhone);
                    break;
                
                case 7:
                    System.out.println("Exiting the program...");
                    input.close(); // Close Scanner when exiting
                    return;
                
                default:
                    System.out.println("invalid choice.");
            }
        }
        
    }
}