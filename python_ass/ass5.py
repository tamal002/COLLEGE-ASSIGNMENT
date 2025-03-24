# List to store memorized Fibonacci numbers
fib_list = []

# Fibonacci generator function
def fibonacci():
    a, b = 0, 1  # Starting two numbers
    while True:  # Infinite loop for continuous generation
        fib_list.append(a)  # Memorize the Fibonacci number
        yield a  # Yield the current number
        a, b = b, a + b  # Update to the next Fibonacci numbers

# Function to check if a given number is a Fibonacci number
def is_fibonacci(num):
    # Generate more numbers if the list length is insufficient
    while len(fib_list) == 0 or fib_list[-1] < num:
        next(gen)  # Generate next Fibonacci number
    return num in fib_list

# Create a generator object
gen = fibonacci()

# Print the first seven Fibonacci numbers
print("First seven Fibonacci numbers:")
for _ in range(7):
    print(next(gen), end=" ")
print()  # Newline for better output format

# Print the memorized Fibonacci numbers
print("Memorized Fibonacci Numbers:", fib_list)

# Prompt the user to enter a number to check
user_number = int(input("\nEnter a number to check if it is a Fibonacci number: "))

# Check and print whether the number is Fibonacci or not
if is_fibonacci(user_number):
    print(f"{user_number} is a Fibonacci number.")
else:
    print(f"{user_number} is not a Fibonacci number.")
