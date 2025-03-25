from datetime import date

# Bank_account
class Bank_account:
    def __init__(self, acc_no, customer_name, pin, balance=0):
        self.acc_no = acc_no
        self.customer_name = customer_name
        self.acc_opening_date = date.today()
        self.pin = pin
        self.balance = balance
        
# Savings_account
class Savings_account(Bank_account):
    def __init__(self, acc_no, customer_name, pin, balance, interest_rate=7.78):
        super().__init__(acc_no, customer_name, pin, balance)
        self.interest_rate = interest_rate
        
# Fee_savings_account 
class Fee_savings_account(Bank_account):
    def __init__(self, acc_no, customer_name, pin, balance):
        super().__init__(acc_no, customer_name, pin, balance)
        self.fee = 4.78
        
# SYSTEM OPERATOR
class Operator:
    def __init__(self):
        self.savings_list = {}
        self.fee_savings_list = {}

    def add_savings_user(self, acc_no, customer_name, pin, balance):
        customer = Savings_account(acc_no, customer_name, pin, balance)
        self.savings_list[acc_no] = customer
        print(f"Account {acc_no} added successfully.")

    def add_fee_savings_user(self, acc_no, customer_name, pin, balance):
        customer = Fee_savings_account(acc_no, customer_name, pin, balance)
        self.fee_savings_list[acc_no] = customer
        print(f"Account {acc_no} added successfully.")

    def money_withdraw(self, acc_no, amount):
        if acc_no in self.savings_list:
            account = self.savings_list[acc_no]
        elif acc_no in self.fee_savings_list:
            account = self.fee_savings_list[acc_no]
        else:
            print(f"Account {acc_no} not found!")
            return

        security = input("Enter your 4-digit PIN: ")
        if security != account.pin:
            print("Incorrect PIN. Try again later.")
            return

        if account.balance < amount:
            print(f"Insufficient balance: INR {account.balance}")
            return

        if isinstance(account, Fee_savings_account):
            amount += (account.fee / 100) * amount  # Apply transaction fee
        
        account.balance -= amount
        print(f"UPDATE [{acc_no}]: INR {amount} withdrawn successfully.")

    def money_deposit(self, acc_no, amount):
        if acc_no in self.savings_list:
            account = self.savings_list[acc_no]
        elif acc_no in self.fee_savings_list:
            account = self.fee_savings_list[acc_no]
        else:
            print(f"Account {acc_no} not found!")
            return

        security = input("Enter your 4-digit PIN: ")
        if security != account.pin:
            print("Incorrect PIN. Try again later.")
            return

        account.balance += amount
        print(f"UPDATE [{acc_no}]: INR {amount} deposited successfully.")

    def pin_change(self, acc_no):
        if acc_no in self.savings_list:
            account = self.savings_list[acc_no]
        elif acc_no in self.fee_savings_list:
            account = self.fee_savings_list[acc_no]
        else:
            print(f"Account {acc_no} not found!")
            return

        new_pin = input("Enter new 4-digit PIN: ")
        account.pin = new_pin
        print(f"UPDATE [{acc_no}]: PIN changed successfully.")

    def show_all_details(self):
        if not self.savings_list:
            print("No savings accounts listed yet.")
        else:
            print("SAVINGS ACCOUNTS:")
            for acc in self.savings_list.values():
                print(f"Account No: {acc.acc_no}, Name: {acc.customer_name}, Balance: INR {acc.balance}")

        if not self.fee_savings_list:
            print("No fee savings accounts listed yet.")
        else:
            print("FEE SAVINGS ACCOUNTS:")
            for acc in self.fee_savings_list.values():
                print(f"Account No: {acc.acc_no}, Name: {acc.customer_name}, Balance: INR {acc.balance}")

def switch_case(option, operator):
    if option == 1:
        acc_no = input("Enter saving account number: ")
        name = input("Enter customer name: ")
        pin = input("Create a 4-digit PIN: ")
        balance = float(input("Enter opening balance: "))
        operator.add_savings_user(acc_no, name, pin, balance)

    elif option == 2:
        acc_no = input("Enter fee saving account number: ")
        name = input("Enter customer name: ")
        pin = input("Create a 4-digit PIN: ")
        balance = float(input("Enter opening balance: "))
        operator.add_fee_savings_user(acc_no, name, pin, balance)

    elif option == 3:
        acc_no = input("Enter account number: ")
        amount = float(input("Enter deposit amount: "))
        operator.money_deposit(acc_no, amount)

    elif option == 4:
        acc_no = input("Enter account number: ")
        amount = float(input("Enter withdrawal amount: "))
        operator.money_withdraw(acc_no, amount)

    elif option == 5:
        acc_no = input("Enter account number: ")
        operator.pin_change(acc_no)

    elif option == 6:
        operator.show_all_details()

# MAIN
operator = Operator()
while True:
    print("\nMenu:")
    print("1 - Add Savings Account")
    print("2 - Add Fee Savings Account")
    print("3 - Deposit Money")
    print("4 - Withdraw Money")
    print("5 - Change PIN")
    print("6 - Show All Account Details")
    print("7 - Exit")
    
    option = int(input("Enter your choice: "))
    if option == 7:
        print("Ending the session.")
        break
    switch_case(option, operator)
