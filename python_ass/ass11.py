import string
from collections import Counter

class TextProcessor:
    @classmethod
    def find_palindromes_and_unique_words(cls, text):
        # Convert text to lowercase for uniformity
        text = text.lower()

        # Remove punctuation using string translation
        text = text.translate(str.maketrans('', '', string.punctuation))

        # Split text into words
        words = text.split()

        # Find palindromes (word should be same when reversed)
        palindromes = [word for word in words if word == word[::-1]]

        # Count occurrences of each word
        word_counts = Counter(words)

        # Find unique words (words appearing only once)
        unique_words = [word for word, count in word_counts.items() if count == 1]

        return palindromes, unique_words

# MAIN
text = input("Enter the text: ")
palindromes, unique_words = TextProcessor.find_palindromes_and_unique_words(text)

print("Palindromes found:", palindromes)
print("Unique words found:", unique_words)
