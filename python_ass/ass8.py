n = int(input("Calculate multiples_of_5 upto : "))
multiples_list = list(filter(lambda x : x % 5 == 0, range(1, n+1)))
print(multiples_list)