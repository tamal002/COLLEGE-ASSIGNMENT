

import os

def findfields(directory):
    files_list = []
    
    try:
        for item in os.listdir(directory):
            full_path = os.path.join(directory, item)
        if os.path.isfile(full_path):
            files_list.append(full_path)
        elif os.path.isdir(full_path):
            files_list.extend(findfields(full_path))
    except PermissionError:
        print(f"permission Denied for {directory}")
    except FileNotFoundError:
        print(f"{directory} not found.")
    
    return files_list
    

# MAIN
directory = input("provide the directory paths : ")
files_list = findfields(directory)
print(files_list)













