import string

l = {}
for index, letter in enumerate(string.ascii_lowercase, start = 1):
    l[index] = letter

print(l)