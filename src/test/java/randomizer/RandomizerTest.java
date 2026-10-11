package randomizer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

public class RandomizerTest {

    private Randomizer<String> randomizer = new Randomizer<>();
    private List<String> locations = List.of("pasila", "malmi", "haaga", "porvoo", "vierumäki");

    @Test
    void getRandomReturnsRandomItemsFromTheGivenList() {
        // get lots of random items from the list and collect the results
        Set<String> results = new HashSet<>();
        for (int i = 0; i < 10_000; i++) {
            results.add(randomizer.getRandom(locations));
        }

        // make sure that each item was returned at least once
        assertContentsEqual(locations, List.copyOf(results));
    }

    @Test
    void shuffleModifiesTheGivenListInPlace() {
        // make a copy that will be shuffled in place
        List<String> shuffled = new ArrayList<>(locations);
        randomizer.shuffle(shuffled);

        // make sure that the shuffled list contains the same items as the original list
        assertContentsEqual(locations, shuffled);

        // make sure that the method returns random results
        assertFunctionReturnsRandomizedLists(() -> {
            randomizer.shuffle(shuffled);
            return shuffled;
        });
    }

    @Test
    void getShuffledMakesAndReturnsANewShuffledList() {
        // make sure that the shuffled list contains the same items as the original list
        assertContentsEqual(locations, randomizer.getShuffled(locations));

        // make sure that the method returns random results
        assertFunctionReturnsRandomizedLists(() -> randomizer.getShuffled(locations));
    }

    @Test
    void getRandomSampleReturnsASubsetOfTheGivenList() {
        List<String> sample = randomizer.getRandomSample(locations, 3);

        // the sample should contain the correct number of items
        assertEquals(3, sample.size(), "The sample should contain 3 items");

        // the sample should not contain duplicates
        assertEquals(3, Set.copyOf(sample).size(), "The sample should not contain duplicates");

        // make sure that the method returns random results and not the same list
        assertFunctionReturnsRandomizedLists(() -> randomizer.getRandomSample(locations, 3));
    }

    /**
     * This method takes a supplier function that returns a list, which should be
     * randomized. The method calls the supplier repeatedly and verifies that the
     * results are in fact randomized. If the results are the same every time, the
     * test fails.
     *
     * @param function a supplier function that should return a random list
     */
    protected static <T> void assertFunctionReturnsRandomizedLists(Supplier<List<T>> function) {
        // Get the first results and make a copy, so we can compare that to others
        List<T> randomized = List.copyOf(function.get());

        // Call the function repeatedly and verify we get randomized results
        for (int i = 0; i < 1_000; i++) {
            List<T> newRandomized = function.get();

            if (!randomized.equals(newRandomized)) {
                return; // the lists are different, the test passes
            }
        }

        // if we get here, the lists were the same every time, and the test fails
        throw new AssertionError("the returned elements %s were not random".formatted(randomized));
    }

    /**
     * This utility method checks that the two lists contain the same items, but not
     * necessarily in the same order. This is achieved by converting the lists to
     * sets and comparing the sets. Sets are used because they do not contain
     * duplicates, and their order is not significant.
     *
     * @param expected the expected list of items to compare against
     * @param actual   the actual list of items
     */
    protected static <T> void assertContentsEqual(List<T> expected, List<T> actual) {
        String message = "The lists %s and %s should contain the same items in any order"
                .formatted(expected, actual);

        assertEquals(new HashSet<>(expected), new HashSet<>(actual), message);
        assertEquals(expected.size(), actual.size(), message);
    }
}
