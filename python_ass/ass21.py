import re
# import inflect

def number_to_words(match):
    """
    Converts a regex match (number) to words.
    """
    p = inflect.engine()
    number = match.group()  # Extract matched number
    return p.number_to_words(int(number)).replace(",", "")

def convert_numbers_in_file(file_name):
    """
    Reads a file, identifies numerical chunks, converts them to words, 
    and prints the modified text with numbers replaced.
    """
    try:
        with open(file_name, 'r', encoding='utf-8') as file:
            text = file.read()

        # Replace numbers using regex and a function call
        modified_text = re.sub(r'\b\d+\b', number_to_words, text)

        print("\nModified Text:")
        print(modified_text)

    except FileNotFoundError:
        print("Error: File not found. Please enter a valid file name.")

# Take input from user
file_name = input("Enter the filename: ").strip()
convert_numbers_in_file(file_name)
