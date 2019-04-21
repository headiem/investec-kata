package za.co.tsheporachidi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class HighestCommonFactor {
    /**
     * This method receives an array of integers and finds the highest denominator of the integers
     * @param numbers int[]
     * @return the highest denominator/common factor
     */
    public int highestCommonFactor(int[] numbers) {
        int highestCommonFactor = 0;
        List<Integer> integers = Arrays.asList(numbers);

                .stream()
                .sorted(Comparator.reverseOrder());
        return highestCommonFactor;
    }
}
