import numpy as np

def softmax(logits):
    logits = np.array(logits, dtype=np.float64)

    # Stability (To Prevent NaN probs for larger logits [1001, 1000, 1002])
    logits = logits - np.max(logits)

    exp_x = np.exp(logits)
    probs = exp_x / np.sum(exp_x)

    print(f"LOGITS: {logits}")
    print(f"PROBABILITIES: {probs}")

    return probs

if __name__ == "__main__":
    logits = [1.15, 3.20, 3.21]
    softmax(logits)
