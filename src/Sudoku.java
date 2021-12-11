/**
 * Maman 13 - Class Sudoku
 *
 * @author Noa Amir
 * @version 2022a
 */

public class Sudoku {

    // initialize final variables
    private final int SIZE = 3; // sudoku will have SIZE*SIZE Square3x3 cells
    private final int SUDOKU_FIRST_NUM = 1; // first number to check if exists in row, column, square of the sudoku

    // instance variables
    private Square3x3[][] sudoku;

    // constructors

    /**
     * Construct a new Sudoku. Initialize all cells value to -1
     */
    public Sudoku() {
        sudoku = new Square3x3[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                sudoku[i][j] = new Square3x3();
            }
        }
    }

    /**
     * Construct a new Sudoku. Copy values from a given Square3x3 array to sudoku cells
     *
     * @param array - Square3x3 array to copy the values from
     */
    public Sudoku(Square3x3[][] array) {
        sudoku = new Square3x3[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                sudoku[i][j] = new Square3x3(array[i][j]);
            }
        }
    }

    // methods

    // Check if values boolean array has only true values
    private boolean doAllNumbersExist(boolean[] values) {
        for (int i = SUDOKU_FIRST_NUM; i < values.length; i++) {
            if (!values[i])
                return false;
        }
        return true;
    }

    /**
     * Check if all sudoku rows are valid
     * Each row should contain all numbers between 1-9
     * If valid - return true. Otherwise - return false
     *
     * @return true if all sudoku rows are valid
     */
    private boolean isValidRows() {
        // go over rows of Square3x3 objects
        for (int squareRow = 0; squareRow < SIZE; squareRow++) {
            // go over rows inside Square3x3 objects
            for (int row = 0; row < SIZE; row++) {
                // whichNumbersExist array length is the number of cells + 1 in each row.
                // +1 is added to represent an array that can support v[1] to v[SIZE*SIZE].
                // For example, sudoku with 9 3x3 squares. Each row has 9 cells which should contain 1-9 numbers.
                // Indexes 1-9  in the array represent numbers 1-9. Index 0 is not in use.
                // Array length is 10 (number of cells (9) +1)
                boolean[] whichNumbersExist = new boolean[SIZE * SIZE + 1];
                // go over columns of Square3x3 objects
                for (int squareCol = 0; squareCol < SIZE; squareCol++) {
                    // for each sudoku array item (Square 3x3 object), check whosThereRow for row
                    sudoku[squareRow][squareCol].whosThereRow(row, whichNumbersExist);
                }
                if (!doAllNumbersExist(whichNumbersExist))
                    return false; // sudoku row is invalid
            }
        }
        return true; // all sudoku rows are valid
    }

    /**
     * Check if all sudoku columns are valid
     * Each column should contain all numbers between 1-9
     * If valid - return true. Otherwise - return false
     *
     * @return true if all sudoku columns are valid
     */
    private boolean isValidCols() {
        // go over columns of Square3x3 objects
        for (int squareCol = 0; squareCol < SIZE; squareCol++) {
            // go over columns inside Square3x3 objects
            for (int col = 0; col < SIZE; col++) {
                // whichNumbersExist array length is the number of cells + 1 in each column.
                // +1 is added to represent an array that can support v[1] to v[SIZE*SIZE].
                // For example, sudoku with 9 3x3 squares. Each column has 9 cells which should contain 1-9 numbers.
                // Indexes 1-9  in the array represent numbers 1-9. Index 0 is not in use.
                // Array length is 10 (number of cells (9) +1)
                boolean[] whichNumbersExist = new boolean[SIZE * SIZE + 1];
                // go over rows of Square3x3 objects
                for (int squareRow = 0; squareRow < SIZE; squareRow++) {
                    // for each sudoku array item (Square 3x3 object), check whosThereCol for col
                    sudoku[squareRow][squareCol].whosThereCol(col, whichNumbersExist);
                }
                if (!doAllNumbersExist(whichNumbersExist))
                    return false; // sudoku column is invalid
            }
        }
        return true; // all sudoku columns are valid
    }

    /**
     * Check if all sudoku squares are valid
     * Each square should contain all numbers between 1-9
     * If valid - return true. Otherwise - return false
     *
     * @return true if all sudoku columns are valid
     */
    private boolean isValidSquares() {
        // go over rows of Square3x3 objects
        for (int squareRow = 0; squareRow < SIZE; squareRow++) {
            // go over columns of Square3x3 objects
            for (int squareCol = 0; squareCol < SIZE; squareCol++) {
                // for each square item, check if allThere
                boolean validSquare = sudoku[squareRow][squareCol].allThere();
                if (!validSquare)
                    return false; // sudoku square is invalid
            }
        }
        return true; // all sudoku squares are valid
    }

    /**
     * Check if the sudoku is valid
     * Each row should contain all numbers between 1-9
     * Each column should contain all numbers between 1-9
     * Each square should contain all numbers between 1-9
     * If valid - return true. Otherwise - return false
     *
     * @return true if the sudoku is valid
     */
    public boolean isValid() {
        return isValidRows() && isValidCols() && isValidSquares();
    }
}
