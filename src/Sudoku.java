/**
 * Maman 13 - Class Sudoku
 *
 * @author Noa Amir
 * @version 2022a
 */

public class Sudoku {

    // initialize final variables
    private final int SIZE = 3;
    private final boolean[] WHICH_NUMBERS_APPEAR = new boolean[SIZE*SIZE+1];

    // instance variables
    private Square3x3[][] sudoku;

    // constructors

    /**
     * Construct a new Sudoku. Initialize all Square3x3 cells value to -1
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
        this(); // initialize sudoku cells value to -1

        if (array != null) { // only if array parameter is not null, copy its values to the sudoku
            sudoku = new Square3x3[SIZE][SIZE];
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    sudoku[i][j] = new Square3x3(array[i][j]);
                }
            }
        }
    }

    // methods

    // Initialize WHICH_NUMBERS_APPEAR boolean array
    // [0] item value with true
    // [1] - [9] items value with false
    private void initWhichNumbersAppear() {
        WHICH_NUMBERS_APPEAR[0] = true;
        for (int i = 1; i < WHICH_NUMBERS_APPEAR.length; i++) {
            WHICH_NUMBERS_APPEAR[i] = false;
        }
    }

    // Check if WHICH_NUMBERS_APPEAR boolean array has only true values
    private boolean validateWhichNumbersAppear() {
        for (int i = 0; i < WHICH_NUMBERS_APPEAR.length; i++) {
            if (!WHICH_NUMBERS_APPEAR[i])
                return false;
        }
        return true;
    }

    // print sudoku grid
    // TODO: Delete! Only for tests prints
    public void printGrid() {
        for (int squareLine = 0; squareLine < SIZE; squareLine++) {
            for (int row = 0; row < SIZE; row++) {
                sudoku[squareLine][0].printRow(row);
                System.out.print("\t");
                sudoku[squareLine][1].printRow(row);
                System.out.print("\t");
                sudoku[squareLine][2].printRow(row);
                System.out.print("\n");
            }
            System.out.print("\n");
        }
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
                initWhichNumbersAppear(); // for each row, initialize WHICH_NUMBERS_APPEAR boolean array
                // go over columns of Square3x3 objects
                for (int squareCol = 0; squareCol < SIZE; squareCol++) {
                    // for each sudoku array item (Square 3x3 object), check whosThereRow for row
                    sudoku[squareRow][squareCol].whosThereRow(row, WHICH_NUMBERS_APPEAR);
                }
                if (!validateWhichNumbersAppear())
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
                initWhichNumbersAppear(); // for each column, initialize WHICH_NUMBERS_APPEAR boolean array
                // go over rows of Square3x3 objects
                for (int squareRow = 0; squareRow < SIZE; squareRow++) {
                    // for each sudoku array item (Square 3x3 object), check whosThereCol for col
                    sudoku[squareRow][squareCol].whosThereCol(col, WHICH_NUMBERS_APPEAR);
                }
                if (!validateWhichNumbersAppear())
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
    public Boolean isValid() {
        return isValidRows() && isValidCols() && isValidSquares();
    }

}
