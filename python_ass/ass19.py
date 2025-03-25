import cProfile

def find_pythagorean_triples(limit):
    """
    Finds all Pythagorean triples (a, b, c) where a² + b² = c² 
    and a, b, c are less than or equal to the given limit.
    
    :param limit: The upper bound for a, b, and c.
    :return: List of found Pythagorean triples.
    """
    triples = []
    for a in range(1, limit + 1):
        for b in range(a, limit + 1):  # Avoid duplicates (a ≤ b)
            c_squared = a**2 + b**2
            c = int(c_squared**0.5)
            if c * c == c_squared and c <= limit:
                triples.append((a, b, c))
    return triples

# Take user input
N = int(input("Enter the limit for Pythagorean triples: "))

# Run the function with profiling
cProfile.run('print(find_pythagorean_triples(N))')