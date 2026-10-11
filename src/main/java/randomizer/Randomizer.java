package randomizer;

import java.util.List;

/**
 * This class provides utility methods for getting random elements from lists,
 * which can be useful in various applications and with different types of
 * objects.
 *
 * Your first task is to implement the methods so that they pass the tests in
 * RandomizerTest. You can utilize the Math.random() method and Random class
 * from the Java standard library to generate random numbers, which you can then
 * use to get random elements from the lists. You can also use the Collections
 * class in the Java standard library to shuffle lists. In the first task you
 * don't need to worry about the <Type> parameter, just implement the methods to
 * work with strings.
 *
 * The second task is to make all methods in this class **generic**. This means
 * that the class should work with any type used in the <Type> parameter, not
 * just strings. As the methods do not actually depend on the items on the lists
 * being strings, this should be relatively straightforward. You only need to
 * change the method signatures.
 *
 * The second task is tested with the GenericRandomizerTest class. This class
 * will not compile until the methods have been made generic, so we have not
 * included it in the source code directories. Instead, it is located in the
 * root of the project and you can move it to the correct directory once you are
 * ready to work on it.
 */
public class Randomizer<Type> {

    /**
     * This method returns a random element from the given list.
     *
     * @param list a non-empty list
     * @return a random element from the list
     */
    public String getRandom(List<String> list) {
        // you can assume that the given list is not empty

        return null; // TODO: implement this method
    }

    /**
     * This method shuffles the given list in place, so that the order of the
     * elements is changed randomly. This method modifies the original list and
     * does not return anything.
     *
     * @param list the list to be shuffled (possibly empty)
     */
    public void shuffle(List<String> list) {
        // TODO: implement this method
    }

    /**
     * This method returns a new list that contains the elements of the given list
     * in random order. The original list is not modified.
     *
     * @param list a list of elements (possibly empty)
     * @return a copy of the list with elements in random order
     */
    public List<String> getShuffled(List<String> list) {
        // hint: you can potentially use the shuffle method you implemented earlier...

        return null; // TODO: implement this method
    }

    /**
     * This method returns a random sample of the given size from the list. The
     * sample is returned as a new list, and the original list is not modified.
     * The sample should not contain duplicates (unless the original list contains
     * duplicates).
     *
     * @param list       a list of elements (possibly empty)
     * @param sampleSize the size of the sample
     * @return a random sample of the given size from the list
     */
    public List<String> getRandomSample(List<String> list, int sampleSize) {
        // You can assume that the sample size is never larger than the list size.

        return null; // TODO: implement this method
    }
}
