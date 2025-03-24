import re

def validate_phone_number(phone):
    pattern = r"^\+?(\d{1,3})?[-.\s]?\(?\d{3}\)?[-.\s]?\d{3}[-.\s]?\d{4}$"
    if re.fullmatch(pattern, phone):
        print(f"'{phone}' is a valid phone number.")
    else:
        print(f"'{phone}' is not a valid phone number.")
        

phone = input("Enter the phone number : ")
validate_phone_number(phone)