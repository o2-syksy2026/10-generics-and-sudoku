package sudoku;

import grid.Grid;

/**
 * This exercise has been heavily inspired by the programming exercises in the
 * MOOC course held by the University of Helsinki:
 *
 * https://ohjelmointi-24.mooc.fi/osa-5/1-lisaa-listoja
 * https://programming-24.mooc.fi/part-5/1-more-lists
 *
 * In the original exercise, the focus is in validating the different rows,
 * columns and subgrids of a Sudoku board represented as nested lists. This
 * exercise takes a bit different approach by separating the logic of the Sudoku
 * game into this class and using the Grid class to store the numbers in a
 * two-dimensional grid.
 */
public class Sudoku {

    // The Sudoku uses the Grid class to store the numbers on the board:
    private final Grid<Integer> board;

    /**
     * Creates a new Sudoku board with the given numbers. The board is a 9x9 grid
     * where each cell can contain a number from 1 to 9. The given board can be
     * partially filled, but it must be a valid Sudoku board.
     *
     * @param board a partially filled Sudoku board
     */
    public Sudoku(Grid<Integer> board) {
        this.board = board;
    }

    /**
     * This method places the given number in the given row and column. The row and
     * column indices are zero-based, so they should be in the range of 0-8. The
     * number should be between 1 and 9. If the number is already in the same row,
     * column or 3x3 subgrid, the method should throws an IllegalArgumentException.
     *
     * @param row    the row index (0-8)
     * @param col    the column index (0-8)
     * @param number the number to place in the cell (1-9)
     * @throws IllegalArgumentException if the number cannot be placed
     */
    public void setNumber(int row, int col, int number) throws IllegalArgumentException {
        /*
         * Before placing the number, you should check that the number is not already
         * in the same row, column or 3x3 subgrid. You should also check that the given
         * row and column are within the bounds of the board and that the number is
         * between 1 and 9. If any of these conditions are not met, you should throw an
         * IllegalArgumentException.
         *
         * You will likely want to create separate private methods for checking the row,
         * column and subgrid!
         */

        // TODO: use the board object to check if the given number can be placed
        throw new IllegalArgumentException();
    }

    /**
     * This method returns the number in the given row and column. If the cell is
     * empty, the method returns null.
     *
     * @param row the row index (0-8)
     * @param col the column index (0-8)
     * @return the number in the cell or null if the cell is empty
     */
    public Integer getNumber(int row, int col) throws IllegalArgumentException {
        // TODO: use the board object to get the number in the given row and column

        return null; // TODO: implement this method
    }

    /**
     * This method checks if the Sudoku board is solved. The board is solved if all
     * cells are filled and the numbers are valid.
     *
     * @return true if the board is solved, false otherwise
     */
    public boolean isSolved() {
        return false; // TODO: implement this method
    }

    /**
     * This method returns a string representation of the Sudoku board. The board
     * should be formatted as a 9x9 grid with the numbers separated by spaces. Empty
     * cells should be represented with a dot. Pipes and dashes should be used to
     * separate the 3x3 subgrids. For example:
     *
     * 2 6 7 | 8 3 9 | 5 . 4
     * 9 8 3 | 5 1 . | 6 . 2
     * 4 5 1 | 6 . . | 8 3 9
     * ------ ------- ------
     * 5 1 9 | . 4 6 | 3 2 8
     * 8 . 2 | 1 . 5 | 7 . 6
     * 6 7 4 | 3 2 . | . . 5
     * ------ ------- ------
     * . . . | 4 5 7 | 2 6 3
     * 3 2 . | . 8 . | . 5 7
     * 7 4 5 | . . 3 | 9 . 1
     *
     * The game above has been borrowed from the mooc course held by the University
     * of Helsinki. https://ohjelmointi-24.mooc.fi/osa-5/1-lisaa-listoja
     */
    @Override
    public String toString() {
        // TODO: Build the string representation of the Sudoku in the correct format
        return """
                ? ? ? | ? ? ? | ? ? ?
                ? ? ? | ? ? ? | ? ? ?
                ? ? ? | ? ? ? | ? ? ?
                ------ ------- ------
                ? ? ? | ? ? ? | ? ? ?
                ? ? ? | ? ? ? | ? ? ?
                ? ? ? | ? ? ? | ? ? ?
                ------ ------- ------
                ? ? ? | ? ? ? | ? ? ?
                ? ? ? | ? ? ? | ? ? ?
                ? ? ? | ? ? ? | ? ? ?
                """;
    }
}
