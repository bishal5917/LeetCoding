import numpy as np
import matplotlib.pyplot as plt

def pr_curve(y_true, y_scores, visualize = True):
    y_true = np.array(y_true)
    y_scores = np.array(y_scores)

    # Sort by descending scores
    sorted_indices = np.argsort(-y_scores)
    y_true = y_true[sorted_indices]
    y_scores = y_scores[sorted_indices]

    precisions = []
    recalls = []

    tp=0
    fp=0

    total_positives = np.sum(y_true == 1)

    for i in range(len(y_true)):
        if y_true[i] == 1:
            tp+=1
        else:
            fp+=1

        precision = tp / (tp+fp)
        recall = tp / total_positives

        precisions.append(precision)
        recalls.append(recall)

    # Compute area under PR curve
    auc = 0.0

    for i in range(1, len(recalls)):
        auc += (
            (recalls[i] - recalls[i - 1]) *
            (precisions[i] + precisions[i - 1]) / 2
        )

    if visualize:
        plt.figure(figsize=(7,6))

        plt.plot(recalls, precisions, marker='o')

        plt.xlabel("Recall")
        plt.ylabel("Precision")
        plt.title("Precision-Recall Curve")

        plt.grid(True)
        plt.show()

    return auc


if __name__ == "__main__":
    y_true = [0, 0, 1, 1]
    y_scores = [0.1, 0.4, 0.35, 0.8]
    
    auc = pr_curve(y_true, y_scores)
    print(f"Area Under Curve: {auc}")
