package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaExercises {
    public static void main(String[] args) {
        List<String> toUpperCase = Arrays.asList("Lorem",
                "ipsum", "dolor", "sit amet",
                "consectetur",
                "adipiscing elit");

        System.out.println(upperCase(toUpperCase));

        // Avarage with streams
        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(average(ints));

        // Filter example
        List<String> toFilter = Arrays.asList("Lorem",
                "ipsum", "dolor", "sit amet",
                "consectetur", "arg",
                "adipiscing elit", "arr");

        System.out.println(search(toFilter));

        System.out.println(getString(ints));

    }

    public static List<String> upperCase(List<String> list) {
        return list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    private static double average(List<Integer> ints) {
        return ints.stream()
                .mapToInt(x -> x)
                .average()
                .getAsDouble();
    }

    private static List<String> search(List<String> list) {
        return list.stream()
                .filter(x -> x.startsWith("a") && x.length() == 3)
                .collect(Collectors.toList());
    }

    private static String getString(List<Integer> list) {
        return list.stream()
                .map(x -> x % 2 == 0 ? "e" + x : "o" + x)
                .collect(Collectors.joining(","));
    }
}

