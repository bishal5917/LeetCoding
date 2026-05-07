import numpy as np

def hamming_distance(x, y):
    x = np.array(list(x))
    y = np.array(list(y))

    hamming_dist = np.sum(x!=y)
    print(f"HAMMING DISTANCE: {hamming_dist}")
    return hamming_dist

if __name__ == "__main__":
    x = "catfish"
    y = "cutdish"
    hamming_distance(x,y)