/**
 * Maman 13 - Class Square3x3
 *
 * @author Noa Amir
 * @version 2022a
 */

public class Square3x3 {

    // initialize final variables
    private final int SIZE = 3;
    private final int DEFAULT_CELL_VALUE = -1;
    private final boolean[] WHICH_NUMBERS_APPEAR = new boolean[SIZE*SIZE+1];

    // instance variables
    private int[][] square;

    // constructors

    /**
     * Construct a new Square3x3. Initialize all cells value to -1
     */
    public Square3x3() {
        this.initSquare(DEFAULT_CELL_VALUE);
    }

    /**
     * Construct a new Square3x3. Copy values from a given array to Square3x3 cells
     *
     * @param array - array to copy the values from
     */
    Square3x3(int[][] array) {
        this.initSquare(DEFAULT_CELL_VALUE);

        int rows = Math.min(array.length, SIZE);

        for (int i = 0; i < rows; i++) {
            int cols = Math.min(array[i].length, SIZE);
            for (int j = 0; j < cols; j++) {
                square[i][j] = array[i][j];
            }
        }
    }

    /**
     * Construct a new Square3x3 using another Square3x3
     *
     * @param other - The Square3x3 from which to construct the new object
     */
    public Square3x3(Square3x3 other) {
        if (other != null){
            square = new int[SIZE][SIZE];
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    this.setXY(i, j, other.getCell(i, j));
                }
            }
        }
        else
            this.initSquare(DEFAULT_CELL_VALUE);
    }

    // getters & setters

    /**
     * Returns the value in [row][col] cell of the Square3x3 object
     *
     * @return value in [row][col] cell
     */
    public int getCell(int row, int col) {
        if (validIndex(row) && validIndex(col))
            return square[row][col];
        return -1;
    }

    /**
     * Sets the value in [row][col] cell of the Square3x3 object
     *
     * @param row   - the row of the Square3x3
     * @param col   - the col of the Square3x3
     * @param value - the new value to set in [row][col] cell
     */
    public void setXY(int row, int col, int value) {
        if (validIndex(row) && validIndex(col))
            square[row][col] = value;
    }

    // methods

    // Check if index is valid for Square3x3 object
    private boolean validIndex(int index) {
        return 0 <= index && index < SIZE;
    }

    // Create a new Square3x3 object. Initialize all cells value with the given value parameter
    private void initSquare(int value) {
        square = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                this.square[i][j] = value;
            }
        }
    }

    // Initialize WHICH_NUMBERS_APPEAR boolean array
    // [0] item value with true
    // [1] - [9] items value with false
    private void initWhichNumbersAppear() {
        WHICH_NUMBERS_APPEAR[0] = true;
        for (int i = 1; i < WHICH_NUMBERS_APPEAR.length; i++) {
            WHICH_NUMBERS_APPEAR[i] = false;
        }
    }

    /**
     * Returns a string representation of the Square3x3 object
     *
     * @return a string represent the Square3x3 object, For example:
     * 1   2   3
     * 4   5   6
     * 7   8   9
     */
    public String toString() {
        String msg = "";
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                msg += square[i][j];
                if (j < SIZE - 1)
                    msg += "\t";
            }
            msg += "\n";
        }
        return msg;
    }

    // print a row in square
    //TODO: delete - only for tests
    public void printRow(int row) {
        for (int col = 0; col < SIZE; col++)
            System.out.print(getCell(row, col) + "\t");
    }

    /**
     * Returns true if all numbers 1-9 exists in square
     *
     * @return true if all numbers 1-9 exists in square
     */
    public boolean allThere() {
        initWhichNumbersAppear(); // init WHICH_NUMBERS_APPEAR boolean array

        // go over all square rows
        for (int i = 0; i < SIZE; i++) {
            this.whosThereRow(i, WHICH_NUMBERS_APPEAR); // check whosThereRow for each row
        }

        // go over WHICH_NUMBERS_APPEAR boolean array
        for (int j = 0; j < WHICH_NUMBERS_APPEAR.length; j++) {
            if (!WHICH_NUMBERS_APPEAR[j])
                return false; // a number between 1-9 is not in square
        }
        return true; // numbers 1-9 are all in square
    }

    /**
     * Check if square row contains cells with values between 1-9
     * If yes - update values boolean array item in the corresponding index to true
     * For example:
     * Row 1 cells are: 10  7   1
     * whosThereRow will update values[7] and values[1] to true
     *
     * @param row    - row in square to check
     * @param values - boolean array to update correspondingly to cells in row
     */
    public void whosThereRow(int row, boolean[] values) {
        // check if values is not null and row param is valid index
        if (values != null && validIndex(row)) {
            // go over row's columns
            for (int i = 0; i < SIZE; i++) {
                if (square[row][i] > 0 && square[row][i] < values.length) // check if cell value is between 1-9
                    values[square[row][i]] = true; // update values array item in the corresponding index to true
            }
        }
    }

    /**
     * Check if square column contains cells with values between 1-9
     * If yes - update values boolean array item in the corresponding index to true
     * For example:
     * Column 1 cells are: 10  7   1
     * whosThereCol will update values[7] and values[1] to true
     *
     * @param col    - column in square to check
     * @param values - boolean array to update correspondingly to cells in row
     */
    public void whosThereCol(int col, boolean[] values) {
        // check if values is not null and col param is valid index
        if (values != null && validIndex(col)) {
            // go over column's rows
            for (int i = 0; i < SIZE; i++) {
                if (square[i][col] > 0 && square[i][col] < values.length) // check if cell value is between 1-9
                    values[square[i][col]] = true; // update values array item in the corresponding index to true
            }
        }
    }
}
