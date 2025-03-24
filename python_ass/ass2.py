
from datetime import datetime

def cuponCode(curDay):
    discount = {
        "Monday": 10,
        "Tuesday": 15,
        "Wednesday": 20,
        "Thursday": 25,
        "Friday": 30,
        "Saturday": 20,
        "Sunday": 15
    }
    return discount[curDay]

curDay = datetime.now().strftime("%A")
off = cuponCode(curDay)
code = f"{curDay}-{off}%"
print(f"Today is {curDay}, aplly {curDay}-{off}% to get {off}% off on your current order.")
apply_code = input("Enter cupon code : ")
if(apply_code == code):
    print(f"you got {off}% on your current order.")
else:
    print("Wrong cupon code applied, try again later.")
