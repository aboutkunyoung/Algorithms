import os

def count_java_files_in_parent_directories():
    current_dir = os.getcwd()
    parent_dir = os.path.dirname(current_dir)
    parent_directories = [os.path.join(parent_dir, d) for d in os.listdir(parent_dir) if os.path.isdir(os.path.join(parent_dir, d))]
    
    total_count = 0
    for parent_dir in parent_directories:
        for root, dirs, files in os.walk(parent_dir):
            java_files = [file for file in files if file.endswith('.java')]
            total_count += len(java_files)
    
    return total_count

# Java 파일의 총 갯수 출력
java_file_count = count_java_files_in_parent_directories()
print(f"Total number of Java files: {java_file_count}")
