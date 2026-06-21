class KNN(object):

    def __init__(self, space, k, point):
        self.space = space
        self.k = k
        self.point = point

    def euclidean_distance(self, point1, point2):
        distance = 0
        x0, y0 = point1[0], point1[1]
        x1, y1 = point2[0], point2[1]
        distance += (x0 - x1) ** 2
        distance += (y0 - y1) ** 2
        return distance ** 0.5
    
    def manhattan_distance(self, point1, point2):
        distance = 0
        x0, y0 = point1[0], point1[1]
        x1, y1 = point2[0], point2[1]
        distance += abs(x0 - x1)
        distance += abs(y0 - y1)
        return distance

    def get_neighbors(self):
        distances = []
        for key in self.space:
            distance = self.euclidean_distance(self.point, self.space[key])
            distances.append((key, distance))

        distances.sort(key=lambda x: x[1])
        neighbors = []
        for i in range(self.k):
            neighbors.append(distances[i][0])
        print(distances)
        return "".join(neighbors)
    
    def visualize(self):
        import matplotlib.pyplot as plt

        for key in self.space:
            x, y = self.space[key]
            plt.scatter(x, y, color="DarkBlue", s = 20)
            plt.text(x, y, key, fontsize=10, ha='right', va='bottom')

        plt.scatter(self.point[0], self.point[1], color="red", s = 10)

        plt.show()

if __name__ == "__main__":
    space = {
        "A":  [2, 5],
        "B":  [-4, 7],
        "C":  [8, -2],
        "D":  [1, 10],
        "E":  [-6, -1],
        "F":  [5, 4],
        "G":  [9, 9],
        "H":  [-3, 2],
        "I":  [11, -5],
        "J":  [0, -3],
        "K":  [-8, 6],
        "L":  [6, -7],
        "M":  [3, 12],
        "N":  [-10, 0],
        "O":  [7, 1],
        "P":  [-2, -6],
        "Q":  [12, 5],
        "R":  [-7, 10],
        "S":  [4, -4],
        "T":  [-1, 8],
        "U":  [10, 3],
        "V":  [-9, -4],
        "W":  [13, -1],
        "X":  [2, -9],
        "Y":  [-5, 11],
        "Z":  [6, 8],
    }
    k = 3
    point = [8,2]
    knn = KNN(space, k, point)
    print(knn.get_neighbors())
    knn.visualize()


