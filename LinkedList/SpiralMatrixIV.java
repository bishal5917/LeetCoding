package LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrixIV {

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] grid = new int[m][n];
        List<List<Integer>> order = spiralOrder(m, n, grid);
        // Time to populate the grid correctly now
        // we traverse the linked list and populate the grid
        int idx = 0;
        ListNode temp = head;
        while (temp != null) {
            List<Integer> curr = order.get(idx);
            int i = curr.get(0);
            int j = curr.get(1);
            grid[i][j] = temp.val;
            temp = temp.next;
            idx++;
        }
        printGrid(grid);
        return grid;
    }

    private List<List<Integer>> spiralOrder(int rows, int cols, int[][] grid) {
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        int prevRow = i;
        int prevCol = j;
        while (true) {
            boolean entered = false;
            // RIGHT
            while (isWithinGrid(i, j, rows, cols) && grid[i][j] != -1) {
                ans.add(Arrays.asList(i, j));
                grid[i][j] = -1;
                j++;
                entered = true;
            }
            // DOWN
            j--;
            i++;
            while (isWithinGrid(i, j, rows, cols) && grid[i][j] != -1) {
                ans.add(Arrays.asList(i, j));
                grid[i][j] = -1;
                i++;
                entered = true;
            }
            // LEFT
            i--;
            j--;
            while (isWithinGrid(i, j, rows, cols) && grid[i][j] != -1) {
                ans.add(Arrays.asList(i, j));
                grid[i][j] = -1;
                j--;
                entered = true;
            }
            // UP
            j++;
            i--;
            while (isWithinGrid(i, j, rows, cols) && grid[i][j] != -1) {
                ans.add(Arrays.asList(i, j));
                grid[i][j] = -1;
                i--;
                entered = true;
            }
            i = prevRow + 1;
            j = prevCol + 1;
            prevRow = i;
            prevCol = j;
            if (entered == false) {
                break;
            }
        }
        return ans;
    }

    private void printGrid(int[][] grid) {
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
    }

    private boolean isWithinGrid(int i, int j, int rows, int cols) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }

    public static void main(String[] args) {
        SpiralMatrixIV obj = new SpiralMatrixIV();
        int m = 3;
        int n = 5;
        MyLinkedList ll = new MyLinkedList();
        ll.addAtTail(3);
        ll.addAtTail(0);
        ll.addAtTail(2);
        ll.addAtTail(6);
        ll.addAtTail(8);
        ll.addAtTail(1);
        ll.addAtTail(7);
        ll.addAtTail(9);
        ll.addAtTail(4);
        ll.addAtTail(2);
        ll.addAtTail(5);
        ll.addAtTail(5);
        ll.addAtTail(0);
        obj.spiralMatrix(m, n, ll.head);
    }
}