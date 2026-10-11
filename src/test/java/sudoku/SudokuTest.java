package sudoku;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import grid.Grid;

public class SudokuTest {

    // this board is used in all of the tests
    private final int[][] board = {
            // 0 1, 2, 3, 4, 5, 6, 7, 8 ← columns
            { 0, 0, 0, 0, 0, 6, 0, 0, 0 }, // 0 ↓ rows
            { 0, 0, 0, 0, 0, 0, 7, 0, 0 }, // 1
            { 0, 0, 0, 0, 0, 0, 0, 8, 0 }, // 2
            { 0, 0, 0, 0, 0, 0, 0, 0, 9 }, // 3
            { 0, 0, 0, 0, 5, 0, 0, 0, 0 }, // 4
            { 1, 0, 0, 0, 0, 0, 0, 0, 0 }, // 5
            { 0, 2, 0, 0, 0, 0, 0, 0, 0 }, // 6
            { 0, 0, 3, 0, 0, 0, 0, 0, 0 }, // 7
            { 0, 0, 0, 4, 0, 0, 0, 0, 0 } // 8
    };

    private Grid<Integer> grid;
    private Sudoku sudoku;

    @BeforeEach
    void setUp() {
        // create new grid and sudoku before each test
        this.grid = SudokuUtil.createGridFromArrays(board);
        this.sudoku = new Sudoku(this.grid);
    }

    @Test
    void sudokuReturnsCorrectNumbersFromTheBoard() {
        assertEquals(1, sudoku.getNumber(5, 0));
        assertEquals(2, sudoku.getNumber(6, 1));
    }

    @Test
    void sudokuReturnsNullForEmptyCells() {
        assertEquals(null, sudoku.getNumber(0, 0));
        assertEquals(null, sudoku.getNumber(8, 8));
    }

    @Test
    void sudokuAcceptsValidNumbersAndStoresThemInTheGrid() {
        sudoku.setNumber(0, 0, 9);
        assertEquals(9, grid.get(0, 0));

        sudoku.setNumber(2, 1, 5);
        assertEquals(5, grid.get(2, 1));
    }

    @Test
    void sudokuDoesNotAllowDuplicatesOnTheSameRow() {
        assertThrows(IllegalArgumentException.class, () -> sudoku.setNumber(0, 0, 6));
        assertThrows(IllegalArgumentException.class, () -> sudoku.setNumber(8, 8, 4));

        // make sure that the grid was not modified
        assertEquals(null, grid.get(0, 0));
    }

    @Test
    void sudokuDoesNotAllowDuplicatesOnTheSameColumn() {
        assertThrows(IllegalArgumentException.class, () -> sudoku.setNumber(0, 4, 5));
        assertThrows(IllegalArgumentException.class, () -> sudoku.setNumber(7, 8, 9));

        // make sure that the grid was not modified
        assertEquals(null, grid.get(0, 4));
    }

    @Test
    void sudokuDoesNotAllowDuplicatesInTheSameSubgrid() {
        assertThrows(IllegalArgumentException.class, () -> sudoku.setNumber(1, 3, 6));
        assertThrows(IllegalArgumentException.class, () -> sudoku.setNumber(1, 1, 7));

        // make sure that the grid was not modified
        assertEquals(null, grid.get(1, 3));
    }

    @Test
    void sudokuDoesNotAllowRowsOrColumnsOutOfBounds() {
        assertThrows(IllegalArgumentException.class, () -> sudoku.setNumber(-1, -1, 1));
        assertThrows(IllegalArgumentException.class, () -> sudoku.setNumber(9, 9, 1));
    }

    @Test
    void sudokuDoesNotAllowNumbersOutOfBounds() {
        assertThrows(IllegalArgumentException.class, () -> sudoku.setNumber(0, 0, -1));
        assertThrows(IllegalArgumentException.class, () -> sudoku.setNumber(0, 0, 10));
    }

    @Test
    void sudokuHasAWorkingToStringMethod() {
        String sudokuString = sudoku.toString();

        // empty cells should be represented with a dot, subgrids should be separated by
        // pipes and dashes:
        assertTrue(sudokuString.startsWith(". . . | . . 6 | . . ."),
                "First line of toString is incorrect: " + sudokuString);
    }
}
