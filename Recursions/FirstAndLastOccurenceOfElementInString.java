package Recursions;

import java.util.Arrays;

public class FirstAndLastOccurenceOfElementInString {

    public int[] findFirstAndLastOccurence(String str, char c) {
        // 0 index will have first occurence
        // 1 index will have last occurence
        int[] occurences = { -1, -1 };
        return findFirstAndLastOccurenceHelper(str, c, occurences, 0);
    }

    private int[] findFirstAndLastOccurenceHelper(String str, char c, int[] occurences, int idx) {
        if (idx >= str.length()) {
            return occurences;
        }
        // While going up track the last index
        if (str.charAt(idx) == c) {
            occurences[1] = idx;
        }
        occurences = findFirstAndLastOccurenceHelper(str, c, occurences, idx + 1);
        // While stack unwinding track the index & thats gonna be first
        if (str.charAt(idx) == c) {
            occurences[0] = idx;
        }
        return occurences;
    }

    public static void main(String[] args) {
        FirstAndLastOccurenceOfElementInString obj = new FirstAndLastOccurenceOfElementInString();
        String str = "bdfgacdaefaah";
        char c = 'a';
        int[] ans = obj.findFirstAndLastOccurence(str, c);
        System.out.println(Arrays.toString(ans));
    }

}
