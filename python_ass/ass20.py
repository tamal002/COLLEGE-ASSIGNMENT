def process_text_file(filepath):
    #Reads lines from a file, tokenizes them, converts tokens to unique numerical values,
    #and pads lines to the maximum length.
    #
    try:
        with open(filepath, 'r') as file:
            lines = file.readlines()

        token_to_num = {}  # Dictionary to store token-to-number mapping
        num_to_token = {} # Dictionary to store number-to-token mapping
        next_num = 1  # Start numbering tokens from 1

        tokenized_lines = []
        for line in lines:
            line = line.strip()  # Remove leading/trailing whitespace
            tokens = line.split()  # Split line into tokens
            tokenized_lines.append(tokens)

        # Convert tokens to numerical values
        numerical_lines = []
        for line_tokens in tokenized_lines:
            numerical_line = []
            for token in line_tokens:
                if token not in token_to_num:
                    token_to_num[token] = next_num
                    num_to_token[next_num] = token
                    next_num += 1
                numerical_line.append(token_to_num[token])
            numerical_lines.append(numerical_line)

        # Pad lines to the maximum length
        max_length = max(len(line) for line in numerical_lines) if numerical_lines else 0
        padded_lines = []
        for line in numerical_lines:
            padded_line = line + [0] * (max_length - len(line))  # Pad with 0s
            padded_lines.append(padded_line)

        return padded_lines, token_to_num, num_to_token

    except FileNotFoundError:
        return "File not found.", None, None

file_path = "Tamal.txt"

#create test file
with open(file_path, "w") as f:
    f.write("apple banana orange are very good fruits to eat. An apple a day keeps the doctor away""\n")
    f.write("banana cherry are sweet\n")
    f.write("apple grape kiwi lemon are sour\n")

padded_lines, token_to_num, num_to_token = process_text_file(file_path)

if isinstance(padded_lines, str):
    print(padded_lines)
else:
    print("Padded Numerical Lines:", padded_lines)
    print("Token to Number Mapping:", token_to_num)
    print("Number to Token Mapping:", num_to_token)