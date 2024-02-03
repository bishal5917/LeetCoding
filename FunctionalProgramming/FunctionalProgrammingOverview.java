package FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//WHAT IS FUNCTIONAL PROGRAMMING ???
// Functional programming is all about giving first class definitions to the functions.
public class FunctionalProgrammingOverview {

        public static void main(String[] args) {
                List<String> animes = new ArrayList<>(Arrays.asList("NARUTO", "AOT", "FMAB"));
                List<Integer> nums = new ArrayList<>(Arrays.asList(5, 3, 0, 8, 8));
                // In Normal ways or Object oriented programming
                // for (String anime : animes) {
                // System.out.println(anime);
                // }
                // In functional programming
                // Lets understand about streams a bit
                // We generally perform two operations in streams
                // Intermediate operations and Terminal operations
                // Filter is an intermediate operation.The output of filter is another stream
                // ForEach is a terminal operation.Generally we consume each values from stream
                // and do something with it.
                animes.stream()
                                .filter(element -> element.endsWith("O"))
                                .forEach(anime -> System.out.println(anime));
                // find sum of numbers using reduce in functional programming
                int sum = nums.stream()
                                .reduce(0, (num1, num2) -> num1 + num2);
                System.out.println(sum);
                // find the sum of only the even nums
                int evenSum = nums.stream()
                                .filter(element -> element % 2 == 0)
                                .reduce(0, (num1, num2) -> num1 + num2);
                System.out.println(evenSum);

                // Exploring other intermediate operation
                System.out.println("SORTED");
                nums
                                .stream().sorted().forEach(element -> System.out.println(element));
                System.out.println("DISTINCT");
                nums
                                .stream().sorted()
                                .distinct()
                                .forEach(element -> System.out.println(element));
                System.out.println("MAP");
                nums
                                .stream().sorted()
                                .distinct()
                                .map(e -> e * e)
                                .forEach(element -> System.out.println(element));
                // EXERCISE
                // PRINT SQUARES OF FIRST 10 NUMBERS
                System.out.println("SQUARES OF FIRST 10 NUMS");
                IntStream.range(0, 10)
                                .map(e -> e * e)
                                .forEach(e -> System.out.println(e));
                System.out.println("SQUARES OF FIRST 10 NUMS AND COLLECT IT TO A LIST");
                List<Integer> first10NumsSquares = IntStream.range(0, 10)
                                .map(e -> e * e)
                                .boxed()
                                .collect(Collectors.toList());
                System.out.println(first10NumsSquares);

        }

}
