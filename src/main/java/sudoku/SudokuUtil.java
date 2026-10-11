package sudoku;

import grid.Grid;

/**
 * You don't need to modify this class. It contains a utility method for
 * creating a Sudoku board from a two-dimensional array of integers.
 *
 * We use this utility class both in the tests and in the SudokuGame class to
 * easily initialize a Sudoku board with specific numbers.
 */
public class SudokuUtil {

    /**
     * Creates a new Sudoku board with the given numbers. The board is a 9x9 grid
     * where each cell can contain a number from 1 to 9. The given board can be
     * partially filled, but it must be a valid Sudoku board.
     *
     * @param board a two-dimensional array of integers from 0 to 9
     * @return a new Sudoku board with the given numbers in corresponding cells
     */
    public static Grid<Integer> createGridFromArrays(int[][] board) {
        Grid<Integer> grid = new Grid<>();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != 0) {
                    grid.set(row, col, board[row][col]);
                }
            }
        }

        return grid;
    }
}
