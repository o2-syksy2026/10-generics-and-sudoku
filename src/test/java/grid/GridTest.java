package grid;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GridTest {

    @Test
    @SuppressWarnings("unused")
    void gridsCanContainDifferentTypesOfObjects() {
        // This test should pass without any changes to the Grid class. It just
        // demonstrates how the Grid class can be used with different types:
        Grid<String> stringGrid = new Grid<String>();
        Grid<Integer> integerGrid = new Grid<Integer>();

        // As with Lists and Maps, you can omit the type parameter on the right side:
        Grid<Double> doubleGrid = new Grid<>();
    }

    @Test
    @SuppressWarnings("unused")
    void theReturnTypeOfTheGetterMethodMatchesTheTypeOfTheGrid() {
        // This test does not require any changes in the class. It just demonstrates
        // how the compiler infers the correct type for the variables s and i based on
        // the type of the grid.

        Grid<String> stringGrid = new Grid<String>();
        String s = stringGrid.get(0, 0); // the compiler knows that s is a String (or null)

        Grid<Integer> integerGrid = new Grid<Integer>();
        Integer i = integerGrid.get(0, 0); // the compiler knows that i is an Integer (or null)
    }

    @Test
    void gridsCanBeFilledInAnyOrder() {
        Grid<Integer> sudoku = new Grid<Integer>();

        sudoku.set(4, 2, 1);
        sudoku.set(4, 8, 2);
    }

    @Test
    void valuesStoredInGridCanBeAccessedWithRowsAndColumns() {
        Grid<String> ticTacToe = new Grid<>();

        ticTacToe.set(0, 1, "x");
        ticTacToe.set(1, 1, "o");
        ticTacToe.set(0, 0, "x");

        assertEquals("x", ticTacToe.get(0, 1));
        assertEquals("o", ticTacToe.get(1, 1));
        assertEquals("x", ticTacToe.get(0, 0));
    }

    @Test
    void theSizeOfTheGridIsDynamic() {
        // See https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life
        Grid<Boolean> gameOfLife = new Grid<>();

        // sets an arbitrary cell to true
        gameOfLife.set(100_000, 200_000, true);

        assertEquals(true, gameOfLife.get(100_000, 200_000),
                "The grid should be able to expand to 100 000 rows and 200 000 columns");
    }

    @Test
    void getterMethodReturnsNullIfACellIsEmpty() {
        Grid<String> crosswordPuzzle = new Grid<>();

        assertEquals(null, crosswordPuzzle.get(0, 0));
        assertEquals(null, crosswordPuzzle.get(100, 100));
        assertEquals(null, crosswordPuzzle.get(10_000, 100_000));
    }
}
