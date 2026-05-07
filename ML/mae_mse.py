import numpy as np

def mae(y_true, y_pred):
    y_true = np.array(y_true)
    y_pred = np.array(y_pred)

    mae = np.mean(np.abs(y_true - y_pred))
    print(f"MEAN AVERAGE ERROR= {mae}")

def mse(y_true, y_pred):
    y_true = np.array(y_true)
    y_pred = np.array(y_pred)

    mae = np.mean((y_true - y_pred) ** 2)
    print(f"MEAN SQUARED ERROR= {mae}")

if __name__ == "__main__":
    y_true = [3, -0.5, 2, 7]
    y_pred = [2.5, 0.0, 2, 8]
    mae(y_true, y_pred)
    mse(y_true, y_pred)
