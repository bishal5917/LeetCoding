import numpy as np

def log_loss(y_true, y_pred_probs):
    y_true = np.array(y_true)
    y_pred_probs = np.array(y_pred_probs)

    epsilon = 1e-15
    # Prevent log(0) by clipping
    y_pred_probs = np.clip(y_pred_probs, epsilon, 1 - epsilon)

    # Binary Cross Entropy Loss (Heavily penalize confident wrong predictions)
    loss = -np.mean(
        y_true * np.log(y_pred_probs) +
        (1 - y_true) * np.log(1 - y_pred_probs)
    )

    return loss

if __name__ == "__main__":
    y_true = [0, 1, 1, 0]
    y_pred_probs = [0.1, 0.9, 0.9, 0.11]

    loss = log_loss(y_true, y_pred_probs)

    print("Log Loss:", loss)
