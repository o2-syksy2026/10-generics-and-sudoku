package grid;

/**
 * This class represents a grid, which is a two-dimensional array of cells. A
 * grid can be used to represent a game board, such as a chess board, a
 * tic-tac-toe board, a sudoku or a crossword puzzle.
 *
 * The items in the grid could be numbers, strings or other objects, depending
 * on the game. In a single grid, all cells should be of the same type. That is
 * why this class is *generic*, meaning that it can be used with different types
 * of objects, just like the List and Map classes.
 *
 * The cells in the grid can be accessed by their rows and columns. Some games
 * have a fixed size grid, such as a chess board or a sudoku, but in some
 * scenarios the grid can be dynamic, so that the playing area can grow or
 * shrink as needed. This class should be able to handle dynamic sizes. You
 * might also accept negative rows and columns, although those won't be strictly
 * required.
 *
 * Your task is to implement the storage for the grid as well as getter and
 * setter methods for accessing the cells. Both the getter and setter methods
 * should take both the row and column indices as separate parameters. Note that
 * the grid may be filled and accessed in any order, so you should not assume
 * that preceding cells have been filled before you access a cell. In case a
 * cell has not been filled, the getter should return null.
 *
 * In this exercise, you can choose the internal data structure for storing the
 * grid freely. You can use arrays, lists, maps or any other data structure that
 * you see fit, but make sure that dynamic sizing and large grids are supported.
 *
 * You can also create new classes and methods, but make sure that the public
 * methods are implemented as described.
 *
 * @param <Type> Similar to the List or Map classes, this class is generic and
 *               can store any type of objects. The type is defined when a new
 *               object is created, for example new Grid<String>() or new
 *               Grid<Integer>(). Always refer to the stored objects as Type,
 *               not as a specific class such as String or Integer.
 */
public class Grid<Type> {

    /**
     * Creates a new empty grid. The size of the grid is not fixed and the cells can
     * be filled and accessed in any order.
     */
    public Grid() {
        // TODO: consider instantiating your internal data structure here
    }

    /**
     * Sets the given value to the cell at the given row and column. The row and
     * column do not have to be within the bounds of the grid, but the grid should
     * grow dynamically as needed.
     *
     * @param row   the row index
     * @param col   the column index
     * @param value the value to store in the cell
     */
    public void set(int row, int col, Type value) {
        // TODO: use the row and col to store the given value
    }

    /**
     * Returns the value in the cell at the given row and column. If the cell is
     * empty, the method returns null.
     *
     * @param row the row index
     * @param col the column index
     * @return the value in the cell or null if the cell is empty
     */
    public Type get(int row, int col) {
        // TODO: use the row and col to retrieve the value
        return null;
    }
}
