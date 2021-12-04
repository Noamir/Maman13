import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;


public class AmitSquare3x3Tester {

    // Don't touch these, it's for colour purposes in Intellij
    public static final String ANSI_RESET = "";
    public static final String ANSI_RED = "";
    public static final String ANSI_GREEN = "";
    public static final String ANSI_YELLOW = "";
    // Don't touch these, it's for colour purposes in Intellij

    public static void main(String[] args) {

        // DECLARATIONS
        Square3x3 s1 = new Square3x3(); // Square3x3 of -1s
        int[][] s1arr = new int[3][3];
        fillArrayValues(s1arr);

        Object[] obj = square3x3Generator(3, 3); // 3x3 square
        Square3x3 s2 = (Square3x3) obj[0]; // 3x3 Square
        int[][] s2arr = (int[][]) obj[1]; // Expected arr

        obj = square3x3Generator(1, 3); // 1x3 square
        Square3x3 s3 = (Square3x3) obj[0];
        int[][] s3arr = (int[][]) obj[1];

        obj = square3x3Generator(3, 2); // 3x2 square
        Square3x3 s4 = (Square3x3) obj[0];
        int[][] s4arr = (int[][]) obj[1];

        obj = square3x3Generator(5, 5); // 5x5 square
        Square3x3 s5 = (Square3x3) obj[0];
        int[][] s5arr = (int[][]) obj[1];

        obj = square3x3Generator(1, 2); // 1x2 square
        Square3x3 s6 = (Square3x3) obj[0];
        int[][] s6arr = (int[][]) obj[1];

        obj = square3x3Generator(6, 6); // 6x6 square
        Square3x3 s7 = (Square3x3) obj[0];
        int[][] s7arr = (int[][]) obj[1];

        obj = square3x3Generator(10, 10);
        Square3x3 s8 = (Square3x3) obj[0];
        int[][] s8arr = (int[][]) obj[1];

        Square3x3 s9 = new Square3x3(new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        });
        Square3x3 s10 = new Square3x3(s9);

        boolean[] r0values = new boolean[10];
        boolean[] r1values = new boolean[10];
        boolean[] c0values = new boolean[10];
        boolean[] c2values = new boolean[10];
        // DECLARATIONS

        // ACTIONS

        boolean thirdC = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (s10.getCell(i,j) != s9.getCell(i,j)) {
                    thirdC = false;
                    break;
                }
            }
            if (!thirdC) break;
        }

        int r1c2S9, r4c1S9, r1c5S9, r5c7S9;
        r1c2S9 = s9.getCell(1,2); // 6
        try {
            r4c1S9 = s9.getCell(4,1); // -1
            r1c5S9 = s9.getCell(1,5); // -1
            r5c7S9 = s9.getCell(5,7); // -1
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(ANSI_RED + "ERROR: Before we begin check if your getCell method validates row and col between 0 and 2");
            return;
        }

        s9.setXY(1, 2, -3);
        try {
            s9.setXY(5, 2, -4);
            s9.setXY(1, 6, -5);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(ANSI_RED + "ERROR: Before we begin, check if you validate in setXY method if row and col are between 0 and 2");
            return;
        }

        String s9Sen = "1\t2\t3\n4\t5\t-3\n7\t8\t9\n"; // Expected: 1,2,3,4,5,-3,7,8,9
        s9.setXY(1,2,6);
        boolean allThereTrue = s9.allThere(); // Expected True;
        s9.setXY(1,0, 40);
        boolean allThereFalse = s9.allThere(); // Expected False
        s9.setXY(1,2,-3);
        s9.setXY(1,0,4);

        s10.whosThereRow(0, r0values); // values: 1,2,3
        s10.whosThereRow(1, r1values); // values: 5,6
        s10.whosThereCol(0, c0values); // values: 1,7
        s10.whosThereCol(2, c2values); // values: 3,6,9
        // ACTIONS

        // ASSERTIONS
        print("First Constructor Tester: ");
        if (checkValidation(s1, s1arr)) pok();
        else error(s1, s1arr);

        print("Second Constructor Tester (3x3): ");
        if (checkValidation(s2, s2arr)) pok();
        else error(s2, s2arr);

        print("Second Constructor Tester (1x3): ");
        if (checkValidation(s3, s3arr)) pok();
        else error(s3, s3arr);

        print("Second Constructor Tester (3x2): ");
        if (checkValidation(s4, s4arr)) pok();
        else error(s4, s4arr);

        print("Second Constructor Tester (5x5): ");
        if (checkValidation(s5, s5arr)) pok();
        else error(s5, s5arr);

        print("Second Constructor Tester (1x2): ");
        if (checkValidation(s6, s6arr)) pok();
        else error(s6, s6arr);

        print("Second Constructor Tester (6x6): ");
        if (checkValidation(s7, s7arr)) pok();
        else error(s7, s7arr);

        print("Second Constructor Tester (10x10): ");
        if (checkValidation(s8,s8arr)) pok();
        else error(s8, s8arr);

        print("Third Constructor Tester: ");
        if (thirdC) pok();
        else error(s10, new int[][]{{1,2,3},{4,5,6},{7,8,9}});

        System.out.println();

        print("getCell method (value: 6): ");
        if (r1c2S9 == 6) pok();
        else err(6, s9.getCell(1,2));

        print("getCell method (value: -1): ");
        if (r4c1S9 == -1) pok();
        else err(-1, s9.getCell(4, 1));

        print("getCell method (value: -1): ");
        if (r1c5S9 == -1) pok();
        else err(-1, s9.getCell(1,5));

        print("getCell method (value: -1): ");
        if (r5c7S9 == -1) pok();
        else err(-1, s9.getCell(5,7));

        print("setXY method (value: -3): ");
        if (s9.getCell(1,2) == -3) pok();
        else err(-3, s9.getCell(1,2));

        System.out.println(ANSI_YELLOW + "NOTE: Tester already checked for rows and cols greater than 2 for getCell and setXY" + ANSI_RESET + "\n");

        print("toString method: ");
        if (s9.toString().equals(s9Sen)) pok();
        else {
            System.out.println(ANSI_RED + "Returned ERROR\n" + ANSI_RESET + "Expected Array\n" + s9Sen + "Actual Array\n" + s9 + ANSI_RESET);
        }

        print("allThere method (true): ");
        if (allThereTrue) pok();
        else err(true, false);

        print("allThere method (false [row: 1, col: 0, value: 40]): ");
        if (!allThereFalse) pok();
        else err(false, true);

        print("whosThereRow method (values 1,2,3): ");
        if (r0values[1] && r0values[2] && r0values[3]) pok();
        else err(true, "1: " + r0values[1] + ", 2: " + r0values[2] + ", 3: " + r0values[3]);

        print("whosThereRow method (values 5,6): ");
        if (r1values[5] && r1values[6]) pok();
        else err(true, "5: " + r1values[5] + ", 6: " + r1values[6]);

        print("whosThereCol method (values 1,7): ");
        if (c0values[1] && c0values[7]) pok();
        else err(true, "1: " + c0values[1] + ", 6: " + c0values[7]);

        print("whosThereCol method (values 3,6,9): ");
        if (c2values[3] && c2values[6] && c2values[9]) pok();
        else err(true, "3: " + c2values[3] + ", 6: " + c2values[6] + ", 9: " + c2values[9]);
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

    private static Object[] square3x3Generator(int rows, int columns) {
        Object[] obj = new Object[2];
        int[][] arr = new int[rows][columns];
        int[][] expectedSquare = new int[3][3];
        Square3x3 s;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = ThreadLocalRandom.current().nextInt(1, 11);
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
}
