def prime_generator(limit):
    primes = []  # List to store prime numbers
    num = 2  # Starting number to check for prime

    while num <= limit:
        is_prime = True

        # Check divisibility using only previously found primes
        for prime in primes:
            if prime * prime > num:
                break
            if num % prime == 0:
                is_prime = False
                break

        if is_prime:
            primes.append(num)
            print(num, end=" ")

        num += 1

# User input for limit
limit = int(input("Generate primes up to: "))
prime_generator(limit)
