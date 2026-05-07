import numpy as np

def k_fold_cross_validation(X, y, k=5, shuffle=True, random_state=None):
    X = np.array(X)
    y = np.array(y)

    n_samples = len(X)

    if k > n_samples:
        raise ValueError("k cant be greater than samples...")
    
    indices = np.arange(n_samples)

    # Shuffle indices
    if shuffle:
        np.random.seed(random_state)
        np.random.shuffle(indices)

    # Fold sizes
    fold_sizes = np.full(k, n_samples // k)
    fold_sizes[:n_samples % k] += 1
    current = 0

    for fold_size in fold_sizes:
        start = current
        stop = current + fold_size

        test_indices = indices[start:stop]
        train_indices = np.concatenate((indices[:start], indices[stop:]))

        X_train = X[train_indices]
        X_test = X[test_indices]

        y_train = y[train_indices]
        y_test = y[test_indices]

        yield X_train, X_test, y_train, y_test

        current = stop


if __name__ == "__main__":
    X = np.array([
        [1], [2], [3], [4], [5],
        [6], [7], [8], [9], [10]
    ])

    y = np.array([0,1,0,1,0,1,0,1,0,1])

    k = 5

    for fold, (X_train, X_test, y_train, y_test) in enumerate(k_fold_cross_validation(X, y, k=k, random_state=42),start=1):
        print(f"\nFold {fold}")

        print("Train X:", X_train.flatten())
        print("Test X :", X_test.flatten())

        print("Train y:", y_train)
        print("Test y :", y_test)
