
from datetime import date

# Bank_account
class Bank_account:
    def __init__(self, acc_no, customer_name, pin,  balance = 0):
        self.acc_no = acc_no
        self.customer_name = customer_name
        self.acc_openning_date = date.today()
        self.pin = pin
        self.balance = balance
        
        
# Savings_account
class Savings_account(Bank_account):
    def __init__(self, acc_no, customer_name, balance, pin,  interest_rate = 7.78):
        self.interest_rate = interest_rate
        super().__init__(acc_no, customer_name, pin, balance)
        
# Fee_savings_account 
class Fee_savings_account(Bank_account):
    def __init__(self, acc_no, customer_name, balance, pin):
        self.fee = 4.78
        super().__init__(acc_no, customer_name, pin, balance)
        
        
# SYSTEM OPERATROR
class Operator:
    def __init__(self):
        self.savings_list = {}
        self.fee_savings_list = {}


    def add_savings_user(self, acc_no, customer_name, pin,balance, int_rate):
        customer = Savings_account(acc_no, customer_name, balance, pin)
        self.savings_list[acc_no] = customer
        print(f"{acc_no} is added successfully.")

    def add_fee_savings_user(self, acc_no, customer_name, pin,balance):
        customer = Fee_savings_account(acc_no, customer_name, balance, pin)
        self.fee_savings_list[acc_no] = customer
        print(f"{acc_no} is added successfully.")

    
    def money_withdraw(self, acc_no, amount):
        if acc_no in self.savings_list:
            name, pin, balance,  int_rate = self.savings_list[acc_no]
            security = input("Enter your  4 digit pin: ")
            if(security != pin):
                print("you have enter wrong pin. TRY AGAIN LATER.")
                return
            if(balance < amount):
                print(f"you current balance => INR{balance}, can't withdraw INR{amount}")
                return
            balance -= amount
            self.savings_list[acc_no] = (name, balance, int_rate)
            print(f"UPDATE [{acc_no}] : INR{amount} is debitted from your savings account.")
        
        elif acc_no in self.fee_savings_list:
            name, pin, balance, fee = self.fee_savings_list[acc_no]
            if(security != pin):
                print("you have enter wrong pin. TRY AGAIN LATER.")
                return
            if(balance < amount):
                print(f"you current balance => INR{balance}, can't withdraw INR{amount}")
                return
            balance -= amount + ((fee/100) * balance)
            self.fee_savings_list[acc_no] = (name, pin, balance, fee)
            print(f"UPDATE [{acc_no}] : INR{amount} is debitted from your savings account.")
        
        else:
            print(f"{acc_no} not found !")


    def money_deposite(self, acc_no, amount):
        if acc_no in self.savings_list:
            name, pin, balance,  int_rate = self.savings_list[acc_no]
            security = input("Enter your  4 digit pin: ")
            if(security != pin):
                print("you have enter wrong pin. TRY AGAIN LATER.")
                return
            balance += amount
            self.savings_list[acc_no] = (name, pin, balance, int_rate)
            print(f"UPDATE [{acc_no}] : INR{amount} deposited successfully.")
        elif acc_no in self.fee_savings_list:
            name, pin, balance, fee = self.fee_savings_list[acc_no]
            security = input("Enter your  4 digit pin: ")
            if(security != pin):
                print("you have enter wrong pin. TRY AGAIN LATER.")
                return
            balance += amount
            self.fee_savings_list[acc_no] = (name, pin, balance, fee)
            print(f"UPDATE [{acc_no}] : INR{amount} deposited successfully.")
        else:
            print(f"{acc_no} not found !")

    
    def pin_cahnge(self, acc_no):
        if acc_no in self.savings_list:
            name, pin, balance,  int_rate = self.savings_list[acc_no]
            new_pin = input("Enter nre 4 digit pin: ")
            self.savings_list[acc_no] = (name, pin, balance, int_rate)
            print(f"UPDATE [{acc_no}] : pin changed successfully.")
        elif acc_no in self.savings_list:
            name, pin, balance,  fee = self.fee_savings_list[acc_no]
            new_pin = input("Enter nre 4 digit pin: ")
            self.fee_savings_list[acc_no] = (name, pin, balance, fee)
            print(f"UPDATE [{acc_no}] : pin changed successfully.")
        else:
            print(f"{acc_no} not found.")

    def show_all_details(self):
        if(len(self.savings_list) == 0):
            print("NO SAVINGS_ACCOUNT LISTED YET.")
        else:
            print("SAVINGS_ACCOUNTS ARE LISTED BELOW.")
            print(self.savings_list)

        if(len(self.fee_savings_list) == 0):
            print("NO FEE_SAVINGS_ACCOUNT LISTED YET.")
        else:
            print("FEE_SAVINGS_ACCOUNTS ARE LISTED BELOW.")
            print(self.fee_savings_list)


def switch_case(option, operator):

    if option == 1:
        acc_no1 = input("Enter saving_account account no: ")
        name1 = input("Enter saving_account customer name: ")
        pin1 = input("Create a 4 digit pin: ")
        balance1 = float(input("Enter the openning balance: "))
        operator.add_savings_user(acc_no1, name1, pin1, balance1)

    elif option == 2:
        acc_no2 = input("Enter fee_saving_account account no: ")
        name2 = input("Enter fee_saving_account custo2mer name: ")
        pin2 = input("Create a 4 digit pin: ")
        balance2 = float(input("Enter the openning balance: "))
        operator.add_fee_savings_user(acc_no2, name2, pin2,balance2)
    
    elif option == 3:
        acc_no3 = input("Enter Account_number: ")
        amount3 = float(input("Enter the amount to deposite: "))
        operator.money_deposite(acc_no3, amount3)

    elif option == 4:
        acc_no4 = input("Enter Account_number: ")
        amount4 = float(input("Enter the amount to withdraw: "))
        money_withdraw(acc_no, amount)

    elif option == 5:
        acc_no5 = input("Enter Account_number: ")
        pin_cahnge(acc_no5)

    elif option == 6:
        operator.show_all_details()





# MAIN
operator = Operator()
while True:
    print("press 1 to add SAVINGS_ACCOUNT.")
    print("press 2 to add FEE_SAVINGS_ACCOUNT.")
    print("press 3 to DEPOSITE MONEY.")
    print("press 4 to WITHDRAW MONEY..")
    print("press 5 to CHANGE THE PIN.")
    print("press 6 to see the all account details.")
    print("press 7 to end the session.")
    option = int(input("Enter your choice: "))
    if option == 7 or option < 1:
        print("ENDING THE SESSION.")
    
    else:
        switch_case(option, operator)

    
                
    
        
    