import numpy as np
import matplotlib.pyplot as plt


def roc_auc(y_true, y_scores, visualize=True):
    y_true = np.array(y_true)
    y_scores = np.array(y_scores)

    # sort by descending scores
    sorted_indices = np.argsort(-y_scores)
    y_true = y_true[sorted_indices]
    y_scores = y_scores[sorted_indices]

    print(sorted_indices)
    print(y_true)
    print(y_scores)

    # count positives and negatives
    P = np.sum(y_true == 1)
    N = np.sum(y_true == 0)

    # ROC plots
    tpr = [0]
    fpr = [0]

    tp = 0
    fp = 0

    for label in y_true:
        if label == 1:
            tp+=1
        else:
            fp+=1

        tpr.append(tp/P)
        fpr.append(fp/N)

    # AUC using trapezoidal rule
    auc = 0.0
    for i in range (1, len(tpr)):
        auc += (fpr[i] - fpr[i - 1]) * (tpr[i] + tpr[i - 1]) / 2

    if visualize:
        plt.figure(figsize=(7,6))

        plt.plot(fpr, tpr, linewidth = 2, label=f"ROC Curve (AUC = {auc:.3f})")

        plt.plot([0, 1], [0, 1], linestyle='--', label="Random Classifier")

        plt.xlabel("False Positive Rate (FPR)")
        plt.ylabel("True Positive Rate (TPR)")
        plt.title("ROC Curve")
        plt.legend()
        plt.grid(True)

        plt.show()

    return auc


if __name__ == "__main__":
    y_true = [0, 0, 1, 1]
    y_scores = [0.1, 0.4, 0.35, 0.8]

    auc = roc_auc(y_true, y_scores)

    print("ROC-AUC Score:", auc)
