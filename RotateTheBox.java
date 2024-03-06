import java.util.Arrays;

public class RotateTheBox {

    public char[][] rotateTheBox(char[][] box) {
        // Now first of all move all the stones to the right as possible
        // do this row by row
        for (char[] row : box) {
            // now move the elements to the right as possible
            int st = 0;
            for (int i = 0; i < row.length; i++) {
                if (row[i] == '*') {
                    shiftToRight(row, st, i - 1);
                    st = i + 1;
                }
            }
            shiftToRight(row, st, row.length - 1);
        }
        // Now let's create a new char array and place the elements
        char[][] rotated = new char[box[0].length][box.length];
        // And place the elements
        for (int i = 0; i < rotated.length; i++) {
            for (int j = 0; j < rotated[0].length; j++) {
                rotated[i][j] = box[box.length - 1 - j][i];
            }
        }
        printBox(box);
        printBox(rotated);
        return rotated;
    }

    private void shiftToRight(char[] row, int l, int r) {
        while (l <= r) {
            if (row[l] == '#' && row[r] == '.') {
                row[l] = '.';
                row[r] = '#';
                l += 1;
                r -= 1;
            } else if (row[l] == '.' && row[r] == '#') {
                l += 1;
                r -= 1;
            } else if (row[l] == '.' && row[r] == '.') {
                l += 1;
            } else {
                r -= 1;
            }
        }
    }

    private void printBox(char[][] box) {
        for (char[] row : box) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        RotateTheBox obj = new RotateTheBox();
        char[][] box = {
                { '#', '#', '*', '.', '*', '.' },
                { '#', '#', '#', '*', '.', '.' },
                { '#', '#', '#', '.', '#', '.' } };
        obj.rotateTheBox(box);
    }
}
