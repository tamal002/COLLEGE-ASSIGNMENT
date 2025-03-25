import heapq

def get_n_largest_smallest(nums, N, find_largest=True):
    if find_largest:
        return heapq.nlargest(N, nums)  # Finds N largest items
    else:
        return heapq.nsmallest(N, nums)  # Finds N smallest items

# Taking input from the user
numbers = list(map(int, input("Enter numbers separated by spaces: ").split()))
N = int(input("Enter the number of items to find (N): "))
choice = input("Find (L)argest or (S)mallest N items? (L/S): ").strip().lower()

if choice == 'l':
    result = get_n_largest_smallest(numbers, N, find_largest=True)
    print(f"The {N} largest numbers are: {result}")
elif choice == 's':
    result = get_n_largest_smallest(numbers, N, find_largest=False)
    print(f"The {N} smallest numbers are: {result}")
else:
    print("Invalid choice! Please enter 'L' for largest or 'S' for smallest.")