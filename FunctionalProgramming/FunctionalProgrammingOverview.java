package FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//Using Predicate
class EvenNumberPredicate implements Predicate<Integer> {

        @Override
        public boolean test(Integer t) {
                return t % 2 == 0;
        }

}

// Using consumer
class SysOutConsumer implements Consumer<Integer> {

        @Override
        public void accept(Integer t) {
                System.out.println(t);
        }

}

// Using mapper or map interface
// Function<InputType,OutputType>
class SquareMapper implements Function<Integer, Integer> {

        @Override
        public Integer apply(Integer t) {
                return t * t;
        }

}

// WHAT IS FUNCTIONAL PROGRAMMING ???
// Functional programming is all about giving first class definitions to the
// functions.
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
                // Using method references (System.out::println points to e-> )
                // We get same output
                IntStream.range(0, 10)
                                .map(e -> e * e)
                                .forEach(System.out::println);
                System.out.println("SQUARES OF FIRST 10 NUMS AND COLLECT IT TO A LIST");
                List<Integer> first10NumsSquares = IntStream.range(0, 10)
                                .map(e -> e * e)
                                .boxed()
                                .collect(Collectors.toList());
                System.out.println(first10NumsSquares);

                // USING PREDICATES (BEHIND THE SCENES WHAT IS HAPPENING)
                // NORMALLY
                System.out.println("Normal");
                nums.stream()
                                .filter(e -> e % 2 == 0).forEach(e -> System.out.println(e));
                // SAME OUTPUT USING PREDICATES
                System.out.println("Using predicates");
                nums.stream()
                                .filter(new EvenNumberPredicate()).forEach(e -> System.out.println(e));
                // USING PREDICATES AS WELL AS CONSUMERS
                // SAME OUTPUT USING PREDICATES AND CONSUMERS
                System.out.println("Using predicates and consumers");
                nums.stream()
                                .filter(new EvenNumberPredicate()).forEach(new SysOutConsumer());
                System.out.println("Using Predicate,Consumer and Mapper");
                nums.stream()
                                .filter(new EvenNumberPredicate())
                                .map(new SquareMapper())
                                .forEach(new SysOutConsumer());

                // Passing functions into variables
                Predicate<? super Integer> evenPredicate = n -> n % 2 == 0;
                Predicate<? super Integer> oddPredicate = n -> n % 2 == 1;
                // AND NOW WE CAN USE THEM
                nums.stream()
                                .filter(evenPredicate)
                                .forEach(e -> System.out.println(e));
                nums.stream()
                                .filter(oddPredicate)
                                .forEach(e -> System.out.println(e));

        }

}
