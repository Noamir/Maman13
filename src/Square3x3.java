/**
 * Maman 13 - Class Square3x3
 *
 * @author Noa Amir
 * @version 2022a
 */

public class Square3x3 {

    // initialize final variables
    private final int SIZE                = 3;  // square will have SIZE*SIZE int cells
    private final int DEFAULT_CELL_VALUE  = -1; // default value to initialize all square cells with
    private final int INVALID_INDEX_VALUE = -1; // default value to return when trying to get a value from invalid square index - out of square range
    private final int SQUARE_FIRST_NUM    = 1;  // first number to check if exists in each square


    // instance variables
    private int[][] square;

    // constructors

    /**
     * Construct a new Square3x3. Initialize all cells value to DEFAULT_CELL_VALUE
     */
    public Square3x3() {
        this.initSquare(DEFAULT_CELL_VALUE);
    }

    /**
     * Construct a new Square3x3. Copy values from a given array to Square3x3 cells
     * If the given array has fewer cells than square, fill the missing cells values with DEFAULT_CELL_VALUE
     *
     * @param array - array to copy the values from
     */
    Square3x3(int[][] array) {
        this(); // Construct a new Square3x3 & Initialize all cells value to DEFAULT_CELL_VALUE

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
        square = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                square[i][j] = other.square[i][j];
            }
        }
    }

    // getters & setters

    /**
     * Returns the value in [row][col] cell of the Square3x3 object
     * If row \ column are invalid (out of range) - return INVALID_INDEX_VALUE
     *
     * @return value in [row][col] cell
     */
    public int getCell(int row, int col) {
        if (validIndex(row) && validIndex(col))
            return square[row][col];
        return INVALID_INDEX_VALUE;
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

    /**
     * Returns true if all numbers 1-9 exists in square
     *
     * @return true if all numbers 1-9 exists in square
     */
    public boolean allThere() {
        // whichNumbersExist array length is the number of cells +1 in square.
        // +1 is added to represent an array that can support v[1] to v[SIZE*SIZE].
        // For example, 3x3 square. Square has 9 cells which should contain 1-9 numbers.
        // Indexes 1-9  of the array represent numbers 1-9. Index 0 is not in use.
        // Array length is 10 (number of cells (9) +1)
        boolean[] whichNumbersExist = new boolean[SIZE*SIZE+1];

        // go over all square rows
        for (int i = 0; i < SIZE; i++) {
            this.whosThereRow(i, whichNumbersExist); // check whosThereRow for each row
        }

        // go over whichNumbersExist boolean array
        for (int j = SQUARE_FIRST_NUM; j < whichNumbersExist.length; j++) {
            if (!whichNumbersExist[j])
                return false; // a number between 1-9 is not in square
        }
        return true; // numbers 1-9 are all in square
    }

    /**
     * Update values boolean array items
     * If square row contains cells with values between 1-9,
     * Update values boolean array item in the corresponding index to true
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
     * Update values boolean array items
     * If square column contains cells with values between 1-9,
     * Update values boolean array item in the corresponding index to true
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
