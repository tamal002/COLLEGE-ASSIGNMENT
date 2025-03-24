
################################   USING COMPRESS #################################
# from itertools import compress

# nums = []
# for i in range(1, 11):
#     nums.append(i)

# odd_selector = [n % 2 != 0 for n in nums]
# even_selector = [n % 2 == 0 for n in nums]

# odds = list(compress(nums, odd_selector))
# evens = list(compress(nums, even_selector))

# print("Odd numbers : ")
# print(odds)

# print("Even numbers : ")
# print(evens)
#########################################################################################

#################################  USING ITERATOR #########################################

nums = []
for i in range(1, 11):
    nums.append(i)

it = iter(nums)
i = 1
evens = []
odds = []
while(i <= len(nums)):
    num = next(it)
    if(num % 2 == 0):
        evens.append(num)
    else:
        odds.append(num)
    i += 1


print("Odd numbers : ")
print(odds)

print("Even numbers : ")
print(evens)

