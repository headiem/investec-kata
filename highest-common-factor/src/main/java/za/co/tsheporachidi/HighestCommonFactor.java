package za.co.tsheporachidi;


import za.co.tsheporachidi.exception.HighestCommonDenominatorException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;


public class HighestCommonFactor {
    /**
     * This method receives an array of integers and finds the highest denominator of the integers
     *
     * @param numbers int[]
     * @return the highest denominator/common factor
     */
    public int highestCommonFactor(int[] numbers) {
        Map<Integer, List<Integer>> divisors = new HashMap<>(numbers.length);
        Set<Integer> allDivisor = new HashSet<>();
        for (int number :
                numbers) {
            if (number == 0) {
                throw new HighestCommonDenominatorException("Zero is not allowed");
            } else {
                List<Integer> numberDivisors = new ArrayList<>();
                for (int i = 1; i <= number; i++) {
                    if (number % i == 0) {
                        numberDivisors.add(i);
                        allDivisor.add(i);
                    }
                }
                divisors.put(number, numberDivisors);
            }
        }

        Set<Integer> copyOfAllDivisor = new HashSet<>(allDivisor);

        for (Integer num :
                allDivisor) {
            divisors.keySet()
                    .forEach(
                            key -> {
                                if (!divisors.get(key).contains(num)) {
                                    copyOfAllDivisor.remove(num);
                                }
                            }
                    );
        }

        Optional<Integer> highestOrLast = copyOfAllDivisor.stream().max(Comparator.naturalOrder());
        int highestCommonDivisor = 1;
        if (highestOrLast.isPresent()) {
            highestCommonDivisor = highestOrLast.get();
        }
        return highestCommonDivisor;
    }
}
