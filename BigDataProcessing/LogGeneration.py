import random

if __name__ == '__main__':
    log_levels = ["ERROR", "INFO", "WARN"]

    for i in range(1, 11):
        file_name = f"log_{i}.txt"

        with open(file_name, "w") as file:
            for _ in range(100):
                log_level = random.choice(log_levels)
                file.write(log_level + "\n")

        print(f"Generated log file: {file_name}")