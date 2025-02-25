import java.util.*;
import java.lang.*;
import java.io.*;

class BankAccount{
  String accNum;
  double balance;
  float intRate;
  double profit;

}

class SavingsAccount extends BankAccount{
  String accStatus;

  SavingsAccount(String accNum, double balance, float intRate){
    accStatus = "savings";
    this.accNum = accNum;
    this.balance = balance;
    this.intRate = intRate;
    this.profit = balance * (intRate / 100);
  }
}

class CurrentAccount extends BankAccount{
  String accStatus;
  double overDraft;

  CurrentAccount(String accNum, double balance, float intRate){
    accStatus = "current";
    overDraft = 100000.00;
    this.accNum = accNum;
    this.balance = balance;
    this.intRate = intRate;
    this.profit = balance * (intRate / 100);
  }

}

class Operator{
  ArrayList<SavingsAccount> savingsAccList = new ArrayList<>();
  ArrayList<CurrentAccount> currentAccList = new ArrayList<>();

  void addAccount(SavingsAccount acc){
    savingsAccList.add(acc);
  }

  // OVERLOADED addAccount() method
  void addAccount(CurrentAccount acc){
      currentAccList.add(acc);
  }

  void displaySavingsAccount(){
    if(savingsAccList.size() == 0){
      System.out.println("No savings account is listed yet.");
      return;
    }
    System.out.println("All savings a/c details: ");
    for(SavingsAccount i : savingsAccList){
      System.out.println("a/c status : " + i.accStatus);
      System.out.println("a/c number: " + i.accNum);
      System.out.println("avialable balance : " + i.balance);
      System.out.println("interest rate : " + i.intRate);
      System.out.println("gained profit : " + i.profit);
      System.out.println("==============");
    }
  }

  void displayCurrentAccount(){
    if(currentAccList.size() == 0){
      System.out.println("No current account is listed yet.");
      return;
    }
    System.out.println("All savings a/c details: ");
    for(CurrentAccount i : currentAccList){
      System.out.println("a/c status : " + i.accStatus);
      System.out.println("over draft : " + i.overDraft);
      System.out.println("a/c number: " + i.accNum);
      System.out.println("avialable balance : " + i.balance);
      System.out.println("interest rate : " + i.intRate);
      System.out.println("gained profit : " + i.profit);
      System.out.println("==============");
    }
  }
}

class A2_Q4{
  public static void main(String args[]){

    Operator obj = new Operator();
    Scanner in = new Scanner(System.in);
    
    System.out.println("INPUT OF SAVINGS ACCOUNT");
    System.out.print("enter a/c id: ");
    String acc = in.next();
    System.out.print("enter balance: ");
    double bal = in.nextDouble();
    System.out.print("enter interest rate: ");
    float intRate = in.nextFloat();


    SavingsAccount s1 = new SavingsAccount(acc, bal, intRate);
    //SavingsAccount s2 = new SavingsAccount("345BOI25", 363.60, 4.89f);
    //SavingsAccount s3 = new SavingsAccount("567BOI26", 3477.75, 4.89f);

    

    // ADDING SAVINGS ACCOUNTS
    obj.addAccount(s1);
    // obj.addAccount(s2);
    // obj.addAccount(s3);

    // INITIATING CURRENT ACCOUNTS
    System.out.println();
    System.out.println("INPUT OF CURRENT ACCOUNT");
    System.out.print("enter a/c id: ");
    acc = in.next();
    System.out.print("enter balance: ");
    bal = in.nextDouble();
    System.out.print("enter interest rate: ");
    intRate = in.nextFloat();
    CurrentAccount c1 = new CurrentAccount(acc, bal, intRate);
    // CurrentAccount c2 = new CurrentAccount("002BOI28", 67454.10, 12.78f);
    // CurrentAccount c3 = new CurrentAccount("003BOI29", 85947.78, 12.78f);


    // ADDING CURRENT ACCOUNTS
    obj.addAccount(c1);
    // obj.addAccount(c2);
    // obj.addAccount(c3);

    obj.displaySavingsAccount();
    System.out.println();
    obj.displayCurrentAccount();

    in.close();
  }
}