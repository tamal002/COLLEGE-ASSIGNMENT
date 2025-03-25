from collections import Counter

class CustomString:
    def __init__(self, text):
        self.text = text

    def __len__(self):
        words = self.text.split()
        word_counts = Counter(words)

        # If no word is repeated, return the length of the string
        if max(word_counts.values()) == 1:
            return len(self.text)

        # Otherwise, sum up the lengths of only the repeated words
        total_repetitive_length = sum(len(word) * count for word, count in word_counts.items() if count > 1)
        return total_repetitive_length

    def most_common_words(self, n=1):
        word_counts = Counter(self.text.split())
        return word_counts.most_common(n)  # Returns the most frequent word(s)

# Taking input from the user
user_text = input("Enter a text: ")
custom_str = CustomString(user_text)

# Display results
print("\nOverloaded len() result:", len(custom_str))  # Uses __len__() method
print("Most common words:", custom_str.most_common_words())  # Uses most_common_words()