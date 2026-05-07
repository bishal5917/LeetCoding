import numpy as np

def one_hot_encoding(labels):
    classes = sorted(set(labels))

    class_to_index = {
        cls : idx for idx, cls in enumerate(classes)
    }

    n_samples = len(labels)
    n_classes = len(classes)

    encoded = np.zeros((n_samples, n_classes), dtype=int)

    for i, label in enumerate(labels):
        class_index = class_to_index[label]
        encoded[i, class_index] = 1

    print(class_to_index)

    print("One-Hot Encoded Matrix:")
    print(encoded)

if __name__ == "__main__":
    labels = ["cat", "dog", "cat", "bird"]
    one_hot_encoding(labels)


