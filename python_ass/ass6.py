

# CUSTOM EXCEPTIONS. 

class InvalidUsername(Exception):
    
    def __init__(self, user_name):
        self.user_name = user_name
        super().__init__(f"{user_name} is not uinque USER_NAME! {user_name} can't be added.")
    
class NegativeAge(Exception):
    
    def __init__(self, age, user_name):
        self.age = age
        super().__init__(f"{age} is invalid AGE (NEGATIVE AGE). {user_name} can't be added.")
        
class UnderAge(Exception):
    
    def __init__(self, user_name):
        super().__init__(f"Age should be greater or equal to 16. {user_name} can't be added.")
        

class InvalidEmail(Exception):
    def __init__(self, email, user_name):
        self.email = email
        super().__init__(f"{email} is invalid EMAIL_ID. {user_name} can't be added.")
        
        

#  METHOD FOR ADDING VALID USERS TO DIRECTORY.

def add_user(user_name, email, age, directory):
    
    if user_name in directory:
        raise InvalidUsername(user_name)
    if email.find("@gmail.com") == -1:
        raise InvalidEmail(email)
    if age < 0:
        raise NegativeAge(age)
    if age < 16:
        raise UnderAge(age)
    
    directory[user_name] = email
    print(f"{user_name} added successfully.")
    
    

# MAIN 
n = int(input("Enter the number of users: "))
users = []
i = 1
while(i <= n):
    user_name = input(f"Enter user_name {i} : ")
    email = input(f"Enter user email_id {i} : ")
    age = int(input(f"Enter user age {i} : "))
    users.append((user_name, email, age))
    i += 1

directory = {}

for user_name, email, age in users:
    try:
        add_user(user_name, email, age, directory)
    except InvalidUsername as e:
        print(f"Error: {e}")
    except NegativeAge as e:
        print(f"Error: {e}")
    except UnderAge as e:
        print(f"Error: {e}")
    except InvalidEmail as e:
        print(f"Error: {e}")

print("list of vaild users:")
print(directory)
        
    

