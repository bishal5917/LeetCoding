import numpy as np

def min_max_normalization(data):
    data = np.array(data, dtype=np.float64)

    min_val = np.min(data)
    max_val = np.max(data)

    if max_val == min_val:
        return

    normalized = (data - min_val) / (max_val - min_val)

    print(f"DATA: {data}")
    print(f"MIN-MAX NORMALIZED: {normalized}")

def z_score_normalization(data):
    data = np.array(data, dtype=np.float64)

    mean = np.mean(data)
    standard_deviation = np.std(data)

    normalized = (data - mean) / (standard_deviation)

    print(f"DATA: {data}")
    print(f"Z-SCORE NORMALIZED: {normalized}")

if __name__ == "__main__":
    data = [10, 20, 30, 40, 50]
    min_max_normalization(data)
    z_score_normalization(data)


