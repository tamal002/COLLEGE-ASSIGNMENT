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
        System.out.println();
        normalAccList.add(cust);
        System.out.println("normal customer with a/c id: " + cust.id + " added successfully.");
        System.out.println();
    }

    // ADDING PRIVILEGED CUSTOMER
    void addPrivilegedCustomer(PrivilegedAccount cust){
        System.out.println();
        privAccList.add(cust);
        System.out.println("previleged customer with a/c id: " + cust.id + " added successfully.");
        System.out.println();
    }

    // SHOWING PRIVILEGED ACCOUNTS DETAILS
    void showNormalDetails(){
        System.out.println();
        if(normalAccList.size() == 0){
            System.out.println("NO NORMAL ACCOUNTS LISTED YET.");
            System.out.println();
            return;
        }
        System.out.println("NORMAL BANK_ACCOUNTS ARE LISTED AS BELOW");
        System.out.println("--------------------");
        int count = 1;
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
        System.out.println();
    }

    // SHOWING PRIVILEGED ACCOUNTS DETAILS
    void showPrivilegedDetails(){
        System.out.println();
        if(privAccList.size() == 0){
            System.out.println("NO PRIVILEGED ACCOUNTS LISTED YET.");
            System.out.println();
            return;
        }
        System.out.println("PRIVILEGED BANK_ACCOUNTS ARE LISTED AS BELOW");
        System.out.println("--------------------");
        int count = 1;
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
        System.out.println();
    }

    void showLoanDetails(){
        System.out.println();
        // IN CASE THERE NO ACCOUNT LISTED YET.
        if(normalAccList.size() == 0 && privAccList.size() == 0){
            System.out.println("NO ACCOUNTS ARE LISTED YET.");
            System.out.println();
            return;
        }

        // DETAILS OF NORMAL ACCOUNT.
        if(normalAccList.size() == 0){
            System.out.println("NO NORMAL LOANED ACCOUNT LISTED YET.");
            System.out.println();
        }
        else{
            System.out.println("LOANED NORMAL ACCOUNTS ARE SHOWN BELOW.");
            for(NormalAccount i : normalAccList){
                if(i.loaned == true){
                    System.out.println("a/c id: " + i.id);
                    System.out.println("a/c holder name: " + i.name);
                    System.out.println("current loaned ammount : " + i.curLoan);
                    System.out.println("interest rate: " + NormalAccount.intRate);
                    System.out.println("credit limit: " + NormalAccount.credLimit);
                    System.out.println("avialable limit : " + (NormalAccount.credLimit - i.curLoan));
                }
                System.out.println("-----------------");
            }
        }

        // DETAILS OF PRIVILEGED ACCOUNT.
        if(privAccList.size() == 0){
            System.out.println("NO PRIVILEGED LOANED ACCOUNT LISTED YET.");
            System.out.println();
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
                    System.out.println("avialable limit : " + (PrivilegedAccount.credLimit - i.curLoan));
                }
                System.out.println("-----------------");
            }
        }
        System.out.println();
    }

    void changePersonalDetails(String id, String phone){
        System.out.println();
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
        System.out.println();
    }

    void loanRequest(String id, double amount){
        System.out.println();

        
        if(id.charAt(0) == 'N'){
            if(normalAccList.size() == 0){ // NO ACCOUT IS CREATED YET.
                System.out.println("NO NORMAL ACCOUNT IS LISTED YET.");
                System.out.println();
                return;
            }
            else if(amount > NormalAccount.credLimit){ // AMOUNT EXCEED CREDIT LIMIT
                System.out.println("SORRY, NORMAL CUSTOMER CREDIT LIMIT: " + NormalAccount.credLimit);
                System.out.println();
                return;
            }
            else{
                for(NormalAccount i : normalAccList){
                    if(i.id.equals(id)){
                        if(i.loaned == true){
                            System.out.println("LOAN REQUEST ALREADY ACCEPTED.");
                            System.out.println();
                            return;
                        }
                        i.loaned = true;
                        i.curLoan = amount;
                        System.out.println("LOAN SANCTIONED SUCCESFULLY FOR ID: " + i.id);
                        System.out.println();
                        return;
                    }
                }
                System.out.println("ID: " + id + " NOT FOUND."); // WRONG ID PASSED
                System.out.println();
                return;
            }
        }

        
            else{
                if(privAccList.size() == 0){ // NO ACCOUT IS CREATED YET.
                    System.out.println("NO PRIVILEGED ACCOUNT IS LISTED YET.");
                    System.out.println();
                    return;
                }
                else if(amount > PrivilegedAccount.credLimit){ // AMOUNT EXCEED CREDIT LIMIT
                    System.out.println("SORRY, PRIVILEGED CUSTOMER CREDIT LIMIT: " + PrivilegedAccount.credLimit);
                    System.out.println();
                    return;
                }
                else{
                    for(PrivilegedAccount i : privAccList){
                        if(i.id.equals(id)){
                            if(i.loaned == true){
                                System.out.println("LOAN REQUEST ALREADY ACCEPTED.");
                                System.out.println();
                                return;
                            }
                            i.loaned = true;
                            i.curLoan = amount;
                            System.out.println("LOAN SANCTIONED SUCCESFULLY FOR ID: " + i.id);
                            System.out.println();
                            return;
                        }
                    }
                    System.out.println("ID: " + id + " NOT FOUND."); // WRONG ID PASSED
                    System.out.println();
                    return;
                }
            }
    }



}

public class A2_Q5{
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
            System.out.println("press 7 to request for loan.");
            System.out.println("press 8 to terminate the session.");
            System.out.print("your choice: ");
            int choice = input.nextInt();
            System.out.println();
            switch (choice) {
                case 1:
                    System.out.print("Enter the customer [NORMAL] id: ");
                    String idNormal = input.next();
                    input.nextLine();
                    System.out.print("Enter the name of customer [NORMAL] : ");
                    String nameNormal = input.nextLine();
                    System.out.println("Enter phone number of customer [NORMAL] : ");
                    String phoneNormal = input.next();
                    NormalAccount custNormal = new NormalAccount(idNormal, nameNormal, phoneNormal);
                    obj.addNormalCustomer(custNormal);
                    break;
                
                case 2:
                    System.out.print("Enter the customer [PRIVILEGED] id: ");
                    String idPriv = input.next();
                    input.nextLine();
                    System.out.print("Enter the name of customer [PRIVILEGED] : ");
                    String namePriv = input.nextLine();
                    System.out.println("Enter phone number of customer [PRIVILEGED] : ");
                    String phonePriv = input.next();
                    PrivilegedAccount custPrivileged = new PrivilegedAccount(idPriv, namePriv, phonePriv);
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
                    String id = input.next();
                    System.out.print("Enter the new phone number: ");
                    String newPhone = input.next();
                    obj.changePersonalDetails(id, newPhone);
                    break;

                case 7:
                    System.out.print("Loan requesting for id: ");
                    String loanId = input.next();
                    input.nextLine();
                    
                    System.out.print("Loan amount: ");
                    double amount = input.nextDouble();
                    obj.loanRequest(loanId, amount);
                    break;
                
                case 8:
                    System.out.println("Exiting the program...");
                    input.close(); // Close Scanner when exiting
                    return;
                
                default:
                    System.out.println("invalid choice.");
            }
        }
        
    }
}