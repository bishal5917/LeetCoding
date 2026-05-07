import numpy as np

def f1_score(y_true, y_pred):
    y_true = np.array(y_true)
    y_pred = np.array(y_pred)

    # tp, fp, tn, fn
    tp = np.sum((y_true == 1) & (y_pred == 1))
    fp = np.sum((y_true == 0) & (y_pred == 1))
    tn = np.sum((y_true == 0) & (y_pred == 0))
    fn = np.sum((y_true == 1) & (y_pred == 0))

    # Precision and Recall
    precision = tp / (tp + fp) if (tp + fp) != 0 else 0
    recall = tp / (tp + fn) if (tp + fn) != 0 else 0

    print(f"PRECISION: {precision}")
    print(f"RECALL: {recall}")

    print(f"F1 SCORE: { (2 * precision * recall) / (precision + recall) }")
    
    print(f"HARMONIC MEAN: {(2 * precision * recall) / (precision + recall)}")
    print(f"GEOMETRIC MEAN: {(precision * recall) ** 0.5}")
    print(f"ARITHMETIC MEAN: {(precision + recall) / 2}")


if __name__ == "__main__":
    y_true = [1, 1, 1, 1, 1, 0, 1]
    y_pred = [1, 0, 0, 1, 0, 1, 0]

    f1_score(y_true, y_pred)
