import os

def findfields(directory):
    files_list = []

    try:
        # Check if the directory exists before proceeding
        if not os.path.exists(directory):
            print(f"{directory} not found.")
            return []

        for item in os.listdir(directory):
            full_path = os.path.join(directory, item)

            if os.path.isfile(full_path):
                files_list.append(full_path)
            elif os.path.isdir(full_path):
                files_list.extend(findfields(full_path))  # Recursive call for subdirectories

    except PermissionError:
        print(f"Permission Denied for {directory}")

    return files_list

# MAIN
directory = input("Provide the directory path: ").strip()

files_list = findfields(directory)
print("Files found:", files_list)
