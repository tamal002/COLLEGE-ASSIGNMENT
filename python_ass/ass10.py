import time

# Taking input from the user
a = float(input("Enter the first term (a): "))
q = float(input("Enter the common ratio (q): "))

def geometric_progression(a, q):
    term = a
    while term <= 100000:
        yield term
        term *= q
    return  # Stops the generator when term > 100000

# Measuring total execution time
start_total = time.time()

# Measuring loop execution time
start_loop = time.time()
for term in geometric_progression(a, q):
    print(term)
end_loop = time.time()

end_total = time.time()

# Computing times
loop_time = end_loop - start_loop
total_time = end_total - start_total

# Display results
print(f"\nTime within the loop: {loop_time:.6f} seconds")
print(f"Total execution time: {total_time:.6f} seconds")