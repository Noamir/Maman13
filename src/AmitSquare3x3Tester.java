import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Maman 13 tester - square3x3 Tester
 * Amit Yanay
 */
public class AmitSquare3x3Tester {

    // Don't touch these, it's for colour purposes in Intellij
    public static final String ANSI_RESET = "";
    public static final String ANSI_RED = "";
    public static final String ANSI_GREEN = "";
    public static final String ANSI_YELLOW = "";
    // Don't touch these, it's for colour purposes in Intellij

    public static void main(String[] args) {

        // DECLARATIONS
        Square3x3 firstC = new Square3x3();


        Object[] obj = square3x3Generator(3, 3);
        Square3x3 secondC1 = (Square3x3) obj[0];
        int[][] secondCA1 = (int[][]) obj[1];

        obj = square3x3Generator(3, 2);
        Square3x3 secondC2 = (Square3x3) obj[0];
        int[][] secondCA2 = (int[][]) obj[1];

        obj = square3x3Generator(2, 3);
        Square3x3 secondC3 = (Square3x3) obj[0];
        int[][] secondCA3 = (int[][]) obj[1];

        obj = square3x3Generator(1, 1);
        Square3x3 secondC4 = (Square3x3) obj[0];
        int[][] secondCA4 = (int[][]) obj[1];

        obj = square3x3Generator(4, 4);
        Square3x3 secondC5 = (Square3x3) obj[0];
        int[][] secondCA5 = (int[][]) obj[1];

        obj = square3x3Generator(5, 6);
        Square3x3 secondC6 = (Square3x3) obj[0];
        int[][] secondCA6 = (int[][]) obj[1];

        obj = square3x3Generator(7, 8);
        Square3x3 secondC7 = (Square3x3) obj[0];
        int[][] secondCA7 = (int[][]) obj[1];

        obj = square3x3Generator(11, 20);
        Square3x3 secondC8 = (Square3x3) obj[0];
        int[][] secondCA8 = (int[][]) obj[1];

        obj = square3x3Generator(12, 22);
        Square3x3 secondC9 = (Square3x3) obj[0];
        int[][] secondCA9 = (int[][]) obj[1];

        obj = square3x3Generator(2, 2);
        Square3x3 secondC10 = (Square3x3) obj[0];
        int[][] secondCA10 = (int[][]) obj[1];

        obj = square3x3Generator(5, 8);
        Square3x3 secondC11 = (Square3x3) obj[0];
        int[][] secondCA11 = (int[][]) obj[1];

        obj = square3x3Generator(12, 12);
        Square3x3 secondC12 = (Square3x3) obj[0];
        int[][] secondCA12 = (int[][]) obj[1];

        obj = square3x3Generator(3, 3);
        Square3x3 thirdC1C = (Square3x3) obj[0];
        Square3x3 thirdC2C = new Square3x3(thirdC1C);
        int[][] thirdCA1C = (int[][]) obj[1];

        int[][] squareCheckArr = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        Square3x3 squareGetCell = new Square3x3(squareCheckArr);

        Square3x3 squareSetXY = new Square3x3(squareCheckArr);

        Square3x3 squareToString = new Square3x3(squareCheckArr);
        String expectedString = "1\t2\t3\n4\t5\t6\n7\t8\t9\n";

        Square3x3 squareAllThereTrue = new Square3x3(squareCheckArr);
        Square3x3 squareAllThereFalse = new Square3x3(new int[][]{{-1,-2,-3}});

        Square3x3 sWhosThere = new Square3x3(squareCheckArr);
        boolean[] whosThereRow = new boolean[10];
        boolean[] whosThereCol = new boolean[10];

        obj = square3x3Generator(3, 3);
        Square3x3 SCA = (Square3x3) obj[0];
        int[][] SCAA = (int[][]) obj[1];

        obj = square3x3Generator(3, 3);
        Square3x3 TCAH = (Square3x3) obj[0];
        int[][] TCAA = (int[][]) obj[1];
        Square3x3 TCA = new Square3x3(TCAH);

        // DECLARATIONS

        // ACTIONS

        boolean allMinus1 = true;
        for (int r = 0; r < 3 && allMinus1; r++) {
            for (int c = 0; c < 3 && allMinus1; c++) {
                if (firstC.getCell(r, c) != -1) allMinus1 = false;
            }
        }

        int r1c1g, r2c2g;
        r1c1g = squareGetCell.getCell(1, 1); // 5
        r2c2g = squareGetCell.getCell(2, 2); // 9
        try {
            squareGetCell.getCell(3, 3);
            squareGetCell.getCell(4, 2);
            squareGetCell.getCell(2, 4);
            squareGetCell.getCell(5, 5);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(ANSI_RED + "ERROR: Before we begin check if your getCell method validates row and col between 0 and 2");
            return;
        }

        // setXY methods:
        squareSetXY.setXY(1, 1, 500);
        squareSetXY.setXY(2, 2, 500);
        try {
            squareSetXY.setXY(3, 3, 500);
            squareSetXY.setXY(4, 4, 500);
            squareSetXY.setXY(2, 4, 500);
            squareSetXY.setXY(5, 2, 500);
            squareSetXY.setXY(6, 6, 500);
        }  catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(ANSI_RED + "ERROR: Before we begin check if your setXY method validates row and col between 0 and 2");
            return;
        }

        boolean toStringMethod = expectedString.equals(squareToString.toString());
        boolean allThereTrue = squareAllThereTrue.allThere();
        boolean allThereFalse = squareAllThereFalse.allThere();

        sWhosThere.whosThereRow(0, whosThereRow);
        boolean[] actualVals123 = new boolean[10];
        boolean whosRow123 = validateValuesInValArray(whosThereRow,  actualVals123, new int[]{1,2,3});
        sWhosThere.setXY(1, 0, 10);
        sWhosThere.setXY(1, 1, 5);
        sWhosThere.setXY(1, 2, 10);
        sWhosThere.whosThereRow(1, whosThereRow);
        boolean[] actualVals5 = new boolean[10];
        boolean whosRow5 = validateValuesInValArray(whosThereRow, actualVals5, new int[]{5});

        sWhosThere.setXY(0, 0, 4);
        sWhosThere.setXY(1,0,6);
        sWhosThere.setXY(2, 0, 7);
        sWhosThere.whosThereCol(0, whosThereCol);
        boolean[] actualVals467 = new boolean[10];
        boolean whosCol467 = validateValuesInValArray(whosThereCol,actualVals467, new int[]{4,6,7});

        sWhosThere.setXY(0, 2, 10);
        sWhosThere.setXY(1, 2, 9);
        sWhosThere.setXY(2, 2, 8);
        sWhosThere.whosThereCol(2, whosThereCol);
        boolean[] actualVals98 = new boolean[10];
        boolean whosCol98 = validateValuesInValArray(whosThereCol, actualVals98, new int[]{9,8});
        boolean[] vals = new boolean[10];
        try {
            sWhosThere.whosThereRow(4, vals);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(ANSI_RED + "ERROR: Before we begin check if your whosThereRow method validates row between 0 and 2");
            return;
        }

        try {
            sWhosThere.whosThereCol(6, vals);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(ANSI_RED + "ERROR: Before we begin check if your whosThereCol method validates col between 0 and 2");
            return;
        }

        SCAA[0][0] = 500;
        boolean SCAB = SCA.getCell(0, 0) != 500;

        TCAH.setXY(0,0, 800);
        boolean TCAB = TCA.getCell(0,0) != 800;

        // ACTIONS

        // ASSERTIONS

        print("Checking first constructor: ");
        if (allMinus1) pok();
        else error(firstC, new int[][]{{-1,-1,-1}, {-1,-1,-1}, {-1,-1,-1}});

        print("Checking second constructor (3x3): ");
        if (checkValidation(secondC1, secondCA1)) pok();
        else error(secondC1, secondCA1);

        print("Checking second constructor (3x2): ");
        if (checkValidation(secondC2, secondCA2)) pok();
        else error(secondC2, secondCA2);

        print("Checking second constructor (2x3): ");
        if (checkValidation(secondC3, secondCA3)) pok();
        else error(secondC3, secondCA3);

        print("Checking second constructor (1x1): ");
        if (checkValidation(secondC4, secondCA4)) pok();
        else error(secondC4, secondCA4);

        print("Checking second constructor (4x4): ");
        if (checkValidation(secondC5, secondCA5)) pok();
        else error(secondC5, secondCA5);

        print("Checking second constructor (5x6): ");
        if (checkValidation(secondC6, secondCA6)) pok();
        else error(secondC6, secondCA6);

        print("Checking second constructor (7x8): ");
        if (checkValidation(secondC7, secondCA7)) pok();
        else error(secondC7, secondCA7);

        print("Checking second constructor (11x20): ");
        if (checkValidation(secondC8, secondCA8)) pok();
        else error(secondC8, secondCA8);

        print("Checking second constructor (12x22): ");
        if (checkValidation(secondC9, secondCA9)) pok();
        else error(secondC9, secondCA9);

        print("Checking second constructor (2x2): ");
        if (checkValidation(secondC10, secondCA10)) pok();
        else error(secondC10, secondCA10);

        print("Checking second constructor (5x8): ");
        if (checkValidation(secondC11, secondCA11)) pok();
        else error(secondC11, secondCA11);

        print("Checking second constructor (12x12): ");
        if (checkValidation(secondC12, secondCA12)) pok();
        else error(secondC12, secondCA12);

        print("Checking third constructor: ");
        if (checkValidation(thirdC2C, thirdCA1C)) pok();
        else error(thirdC2C, thirdCA1C);

        System.out.println();

        print("Checking getCell method: ");
        if (r1c1g == 5 && r2c2g == 9) pok();
        else err("r1c1: 5, r2c2: 9", "r1c1: " + r1c1g + ", r2c2: " + r2c2g);

        print("Checking setXY method: ");
        if (squareSetXY.getCell(1, 1) == 500 && squareSetXY.getCell(2, 2) == 500) pok();
        else err("r1c1: 500, r2c2: 500", "r1c1: " + squareSetXY.getCell(1, 1) + ", r2c2: "
                + squareSetXY.getCell(2, 2));

        print("Checking toString method: ");
        if (toStringMethod) pok();
        else error(squareToString, squareCheckArr);

        print("Checking allThere method (true): ");
        if (allThereTrue) pok();
        else err(true, false);

        print("Checking allThere method (false): ");
        if (!allThereFalse) pok();
        else err(false, true);

        System.out.println();

        System.out.println(ANSI_YELLOW + "NOTE: these checks will validate that all other values in the array are false" +
                " except the ones that needs to be true" + ANSI_RESET);
        print("Checking whosThereRow (1,2,3): ");
        if (whosRow123) pok();
        else err("1: true, 2: true, 3: true", Arrays.toString(Arrays.copyOfRange(actualVals123, 1, 10)));

        print("Checking whosThereRow (5): ");
        if (whosRow5) pok();
        else err("5: true", Arrays.toString(Arrays.copyOfRange(actualVals5, 1, 10)));

        print("Checking whosThereCol (4,6,7): ");
        if (whosCol467) pok();
        else err("4: true, 6: true, 7: true", Arrays.toString(Arrays.copyOfRange(actualVals467, 1, 10)));

        print("Checking whosThereCol (9,8): ");
        if (whosCol98) pok();
        else err("9: true, 8: true", Arrays.toString(Arrays.copyOfRange(actualVals98, 1, 10)));

        System.out.println();

        print("Aliasing on second constructor: ");
        if (SCAB) pok();
        else error(SCA, SCAA);

        print("Aliasing on third constructor: ");
        if (TCAB) pok();
        else error(TCA, TCAA);
        // ASSERTIONS
    }

    private static Object[] square3x3Generator(int rows, int columns) {
        Object[] obj = new Object[2];
        int[][] arr = new int[rows][columns];
        int[][] expectedSquare = new int[3][3];
        Square3x3 s;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = ThreadLocalRandom.current().nextInt(1, 10);
            }
        }
        s = new Square3x3(arr);
        fillArrayValues(expectedSquare);
        for (int i = 0; i < Math.min(3, rows); i++) {
            System.arraycopy(arr[i], 0, expectedSquare[i], 0, Math.min(3, columns));
        }
        obj[0] = s;
        obj[1] = expectedSquare;
        return obj;
    }

    private static void fillArrayValues(int[][] array) {
        for (int[] ints : array) {
            Arrays.fill(ints, -1);
        }
    }

    private static void print(String s) {
        System.out.print(s);
    }

    private static void pok() {
        System.out.println(ANSI_GREEN + "Returned OK" + ANSI_RESET);
    }

    private static void err(Object expected, Object actual) {
        System.out.println(ANSI_RED + "Returned ERROR" + ANSI_RED + " - Expected: " + expected + " || Actual: " + actual + ANSI_RESET);
    }

    private static void error(Square3x3 s, int[][] expected) {
        StringBuilder expectedSen = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 2) expectedSen.append(expected[i][j]).append("\n");
                else expectedSen.append(expected[i][j]).append("\t");
            }
        }
        System.out.println(ANSI_RED + "Returned ERROR\n" + ANSI_RESET + "Expected Array\n" + expectedSen + "Actual Array\n" + s);
    }

    private static boolean checkValidation(Square3x3 s, int[][] expected) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (expected[i][j] != s.getCell(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean validateValuesInValArray(boolean[] vals, boolean[] printHelperArray, int[] expectedTrueVals) {
        for (int i = 1; i < 10; i++) {
            int finalI = i;
            printHelperArray[i] = vals[i];
            if (Arrays.stream(expectedTrueVals).anyMatch(j -> j == finalI)) {
                if (!vals[finalI]) {
                    Arrays.fill(vals, false);
                    return false;
                }
            } else if (vals[finalI]) {
                Arrays.fill(vals, false);
                return false;
            }
        }
        Arrays.fill(vals, false);
        return true;
    }
}
