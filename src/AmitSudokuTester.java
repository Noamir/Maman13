import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Maman 13 Tester - Sudoku
 * Amit Yanay
 */
public class AmitSudokuTester {

    // Don't touch these, it's for colour purposes in Intellij
    public static final String ANSI_RESET = "";
    public static final String ANSI_RED = "";
    public static final String ANSI_GREEN = "";
    public static final String ANSI_YELLOW = "";
    // Don't touch these, it's for colour purposes in Intellij


    public static void main(String[] args) {

        // DECLARATIONS
        Square3x3[][] validSquare = new Square3x3[3][3];
        fillSudoku(validSquare);
        Sudoku validSudoku = new Sudoku(validSquare);

        // Start of checking on known sudoku
        Square3x3[][] sameInX = new Square3x3[3][3];
        generatedValid(sameInX);
        sameInX[0][0].setXY(1,1, 8);
        Sudoku sameInBox = new Sudoku(sameInX);

        generatedValid(sameInX);
        sameInX[0][0].setXY(0,1,8);
        sameInX[0][0].setXY(2,1,3);
        Sudoku sameInRow = new Sudoku(sameInX);

        generatedValid(sameInX);
        sameInX[1][0].setXY(0,0,3);
        sameInX[1][0].setXY(0,2,7);
        Sudoku sameInCol = new Sudoku(sameInX);
        // End of checking on known sudoku

        // Start of checking on unknown sudoku
        Object[] obj = generateSameIn(1);
        Sudoku box1 = (Sudoku) obj[0];
        String sbox1 = (String) obj[1];

        obj = generateSameIn(1);
        Sudoku box2 = (Sudoku) obj[0];
        String sbox2 = (String) obj[1];

        obj = generateSameIn(1);
        Sudoku box3 = (Sudoku) obj[0];
        String sbox3 = (String) obj[1];

        obj = generateSameIn(2);
        Sudoku row1 = (Sudoku) obj[0];
        String srow1 = (String) obj[1];

        obj = generateSameIn(2);
        Sudoku row2 = (Sudoku) obj[0];
        String srow2 = (String) obj[1];

        obj = generateSameIn(2);
        Sudoku row3 = (Sudoku) obj[0];
        String srow3 = (String) obj[1];

        obj = generateSameIn(3);
        Sudoku col1 = (Sudoku) obj[0];
        String scol1 = (String) obj[1];

        obj = generateSameIn(3);
        Sudoku col2 = (Sudoku) obj[0];
        String scol2 = (String) obj[1];

        obj = generateSameIn(3);
        Sudoku col3 = (Sudoku) obj[0];
        String scol3 = (String) obj[1];
        // End of checking on unknown sudoku

        Square3x3[][] aliasing = new Square3x3[3][3];
        fillSudoku(aliasing);
        Sudoku aliasingS = new Sudoku(aliasing);
        aliasing[0][0].setXY(0,0,50);

        // DECLARATIONS

        // ACTIONS

        boolean validSudoku1 = validSudoku.isValid();

        boolean sameInKnownBox = sameInBox.isValid();
        boolean sameInKnownRow = sameInRow.isValid();
        boolean sameInKnownCol = sameInCol.isValid();

        boolean bBox1 = box1.isValid();
        boolean bBox2 = box2.isValid();
        boolean bBox3 = box3.isValid();

        boolean bRow1 = row1.isValid();
        boolean bRow2 = row2.isValid();
        boolean bRow3 = row3.isValid();

        boolean bCol1 = col1.isValid();
        boolean bCol2 = col2.isValid();
        boolean bCol3 = col3.isValid();

        boolean aliasingValid = aliasingS.isValid();

        // ACTIONS

        // ASSERTIONS

        print("Checking on a normal valid sudoku: ");
        if (validSudoku1) pok();
        else perror(true, false);

        print("Checking conditions for same In box: ");
        if (!sameInKnownBox) pok();
        else perror(false, true);

        print("Checking condition for same In Row: ");
        if (!sameInKnownRow) pok();
        else perror(false, true);

        print("Checking condition for same In Col: ");
        if (!sameInKnownCol) pok();
        else perror(false, true);

        System.out.println(ANSI_YELLOW + "\nNOTE: These checks now receive complete random sudoku and set these conditions:\n" +
                " - Takes random square from the sudoku board\n" +
                " - For box: swaps between two random values in the same square\n" +
                " - For Row: Takes two random cells and swaps them so it'll activate sudoku with only disallowed rows\n" +
                " - For Col: Does same thing as the row\n");
        print("Randomized same In Box1 "+sbox1+": ");
        if (!bBox1) pok();
        else perror(false, true);

        print("Randomized same In Box2 "+sbox2+": ");
        if (!bBox2) pok();
        else perror(false, true);

        print("Randomized same In Box3 "+sbox3+": ");
        if (!bBox3) pok();
        else perror(false, true);

        print("Randomized same In Row1 "+srow1+": ");
        if (!bRow1) pok();
        else perror(false, true);

        print("Randomized same In Row2 "+srow2+": ");
        if (!bRow2) pok();
        else perror(false, true);

        print("Randomized same In Row3 "+srow3+": ");
        if (!bRow3) pok();
        else perror(false, true);

        print("Randomized same In Col1 "+scol1+": ");
        if (!bCol1) pok();
        else perror(false, true);

        print("Randomized same In Col2 "+scol2+": ");
        if (!bCol2) pok();
        else perror(false, true);

        print("Randomized same In Col3 "+scol3+": ");
        if (!bCol3) pok();
        else perror(false, true);

        System.out.println();
        print("Aliasing on second constructor: ");
        if (aliasingValid) pok();
        else perror(false, true + " (NOTE: Prevent aliasing by inserting every object as new Square3x3())");
        // ASSERTIONS
    }

    private static void print(String s) {
        System.out.print(ANSI_RESET + s);
    }

    private static void pok() {
        System.out.println(ANSI_GREEN + "Returned OK" + ANSI_RESET);
    }

    private static void perror(Object expected, Object actual) {
        System.out.println(ANSI_RED + "Returned ERROR - Expected: " + expected + " | actual: " + actual);
    }

    private static Object[] generateSameIn(int type) {
        // type - 1: sameInBox
        // type - 2: sameInRow
        // type - 3: sameInCol
        int genRow = ThreadLocalRandom.current().nextInt(0, 3);
        int genCol = ThreadLocalRandom.current().nextInt(0, 3);
        String sen = String.format("(box: %s,%s ", genRow, genCol);
        Square3x3[][] sameInX = new Square3x3[3][3];
        fillSudoku(sameInX);
        if (type == 1) { // same In Box
            int rndSwapR = ThreadLocalRandom.current().nextInt(1, 9);
            int rndSwapC = rndSwapR;
            while (rndSwapC == rndSwapR) {
                rndSwapC = ThreadLocalRandom.current().nextInt(2, 9);
            }
            int sameNum = sameInX[genRow][genCol].getCell(rndSwapR,rndSwapC);
            sameInX[genRow][genCol].setXY(0,1,sameNum);
            sen += String.format("| cell: %s,%s)", rndSwapR, rndSwapC);
        } else if (type == 2) { // same In Row
            int genColCell = ThreadLocalRandom.current().nextInt(0, 3);
            int cell01 = sameInX[genRow][genCol].getCell(0,genColCell);
            int cell21 = sameInX[genRow][genCol].getCell(2,genColCell);
            sameInX[genRow][genCol].setXY(0,genColCell,cell21);
            sameInX[genRow][genCol].setXY(2,genColCell,cell01);
            sen += String.format("| between cell0%s and cell2%s)", cell01, cell21);
        } else if (type == 3) { // same In Column
            int genRowCell = ThreadLocalRandom.current().nextInt(0, 3);
            int cell00 = sameInX[genRow][genCol].getCell(genRowCell,0);
            int cell02 = sameInX[genRow][genCol].getCell(genRowCell,2);
            sameInX[genRow][genCol].setXY(genRowCell,0,cell02);
            sameInX[genRow][genCol].setXY(genRowCell,2,cell00);
            sen += String.format("| between cell%s0 and cell%s2)", cell00, cell02);
        }
        // Otherwise, it'll return valid state of a sudoku ( valid complete Sudoku )
        return new Object[]{new Sudoku(sameInX), sen};
    }

    private static void generatedValid(Square3x3[][] s) {
        s[0][0] = eVals(new int[]{6,3,4,1,7,5,2,8,9});
        s[0][1] = eVals(new int[]{7,5,9,8,3,2,6,1,4});
        s[0][2] = eVals(new int[]{2,1,8,6,4,9,5,7,3});
        s[1][0] = eVals(new int[]{7,5,3,9,6,1,8,4,2});
        s[1][1] = eVals(new int[]{9,4,8,5,2,7,3,6,1});
        s[1][2] = eVals(new int[]{1,2,6,3,8,4,7,9,5});
        s[2][0] = eVals(new int[]{5,1,8,4,9,6,3,2,7});
        s[2][1] = eVals(new int[]{2,9,6,1,7,3,4,8,5});
        s[2][2] = eVals(new int[]{4,3,7,8,5,2,9,6,1});
    }

    private static Square3x3 eVals(int[] enter) {
        int[][] arr = new int[3][3];
        int c = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = enter[c];
                c++;
            }
        }
        return new Square3x3(arr);
    }

    private static void fillSudoku(Square3x3[][] s) {
        int[] generatedSudoku = generateGrid();
        int counter = 0;
        int cadder = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                s[i][j] = new Square3x3();
                Square3x3 square3x3 = s[i][j];
                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        square3x3.setXY(r, c, generatedSudoku[counter + cadder]);
                        cadder+= 1;
                    }
                    cadder += 6;
                }
                counter += 3;
                cadder = 0;
            }
            counter += 18;
        }
    }

    private static void printGrid(int[] grid)
    {
        if(grid.length != 81) throw new IllegalArgumentException("The grid must be a single-dimension grid of length 81");
        for(int i = 0; i < 81; i++)
        {
            System.out.print("["+grid[i]+"] "+(i%9 == 8?"\n":""));
        }
    }

    private static int[] generateGrid()
    {
        ArrayList<Integer> arr = new ArrayList<Integer>(9);
        int[] grid = new int[81];
        for(int i = 1; i <= 9; i++) arr.add(i);

        //loads all boxes with numbers 1 through 9
        for(int i = 0; i < 81; i++)
        {
            if(i%9 == 0) Collections.shuffle(arr);
            int perBox = ((i / 3) % 3) * 9 + ((i % 27) / 9) * 3 + (i / 27) * 27 + (i %3);
            grid[perBox] = arr.get(i%9);
        }

        //tracks rows and columns that have been sorted
        boolean[] sorted = new boolean[81];

        for(int i = 0; i < 9; i++)
        {
            boolean backtrack = false;
            //0 is row, 1 is column
            for(int a = 0; a<2; a++)
            {
                //every number 1-9 that is encountered is registered
                boolean[] registered = new boolean[10]; //index 0 will intentionally be left empty since there are only number 1-9.
                int rowOrigin = i * 9;
                int colOrigin = i;

                ROW_COL: for(int j = 0; j < 9; j++)
                {
                    //row/column stepping - making sure numbers are only registered once and marking which cells have been sorted
                    int step = (a%2==0? rowOrigin + j: colOrigin + j*9);
                    int num = grid[step];

                    if(!registered[num]) registered[num] = true;
                    else //if duplicate in row/column
                    {
                        //box and adjacent-cell swap (BAS method)
                        //checks for either unregistered and unsorted candidates in same box,
                        //or unregistered and sorted candidates in the adjacent cells
                        for(int y = j; y >= 0; y--)
                        {
                            int scan = (a%2==0? i * 9 + y: i + 9 * y);
                            if(grid[scan] == num)
                            {
                                //box stepping
                                for(int z = (a%2==0? (i%3 + 1) * 3: 0); z < 9; z++)
                                {
                                    if(a%2 == 1 && z%3 <= i%3)
                                        continue;
                                    int boxOrigin = ((scan % 9) / 3) * 3 + (scan / 27) * 27;
                                    int boxStep = boxOrigin + (z / 3) * 9 + (z % 3);
                                    int boxNum = grid[boxStep];
                                    if((!sorted[scan] && !sorted[boxStep] && !registered[boxNum])
                                            || (sorted[scan] && !registered[boxNum] && (a%2==0? boxStep%9==scan%9: boxStep/9==scan/9)))
                                    {
                                        grid[scan] = boxNum;
                                        grid[boxStep] = num;
                                        registered[boxNum] = true;
                                        continue ROW_COL;
                                    }
                                    else if(z == 8) //if z == 8, then break statement not reached: no candidates available
                                    {
                                        //Preferred adjacent swap (PAS)
                                        //Swaps x for y (preference on unregistered numbers), finds occurence of y
                                        //and swaps with z, etc. until an unregistered number has been found
                                        int searchingNo = num;

                                        //noting the location for the blindSwaps to prevent infinite loops.
                                        boolean[] blindSwapIndex = new boolean[81];

                                        //loop of size 18 to prevent infinite loops as well. Max of 18 swaps are possible.
                                        //at the end of this loop, if continue or break statements are not reached, then
                                        //fail-safe is executed called Advance and Backtrack Sort (ABS) which allows the
                                        //algorithm to continue sorting the next row and column before coming back.
                                        //Somehow, this fail-safe ensures success.
                                        for(int q = 0; q < 18; q++)
                                        {
                                            SWAP: for(int b = 0; b <= j; b++)
                                            {
                                                int pacing = (a%2==0? rowOrigin+b: colOrigin+b*9);
                                                if(grid[pacing] == searchingNo)
                                                {
                                                    int adjacentCell = -1;
                                                    int adjacentNo = -1;
                                                    int decrement = (a%2==0? 9: 1);

                                                    for(int c = 1; c < 3 - (i % 3); c++)
                                                    {
                                                        adjacentCell = pacing + (a%2==0? (c + 1)*9: c + 1);

                                                        //this creates the preference for swapping with unregistered numbers
                                                        if(   (a%2==0 && adjacentCell >= 81)
                                                                || (a%2==1 && adjacentCell % 9 == 0)) adjacentCell -= decrement;
                                                        else
                                                        {
                                                            adjacentNo = grid[adjacentCell];
                                                            if(i%3!=0
                                                                    || c!=1
                                                                    || blindSwapIndex[adjacentCell]
                                                                    || registered[adjacentNo])
                                                                adjacentCell -= decrement;
                                                        }
                                                        adjacentNo = grid[adjacentCell];

                                                        //as long as it hasn't been swapped before, swap it
                                                        if(!blindSwapIndex[adjacentCell])
                                                        {
                                                            blindSwapIndex[adjacentCell] = true;
                                                            grid[pacing] = adjacentNo;
                                                            grid[adjacentCell] = searchingNo;
                                                            searchingNo = adjacentNo;

                                                            if(!registered[adjacentNo])
                                                            {
                                                                registered[adjacentNo] = true;
                                                                continue ROW_COL;
                                                            }
                                                            break SWAP;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        //begin Advance and Backtrack Sort (ABS)
                                        backtrack = true;
                                        break ROW_COL;
                                    }
                                }
                            }
                        }
                    }
                }

                if(a%2==0)
                    for(int j = 0; j < 9; j++) sorted[i*9+j] = true; //setting row as sorted
                else if(!backtrack)
                    for(int j = 0; j < 9; j++) sorted[i+j*9] = true; //setting column as sorted
                else //reseting sorted cells through to the last iteration
                {
                    backtrack = false;
                    for(int j = 0; j < 9; j++) sorted[i*9+j] = false;
                    for(int j = 0; j < 9; j++) sorted[(i-1)*9+j] = false;
                    for(int j = 0; j < 9; j++) sorted[i-1+j*9] = false;
                    i-=2;
                }
            }
        }

        if(!isPerfect(grid)) throw new RuntimeException("ERROR: Imperfect grid generated.");

        return grid;
    }

    /**
     *Tests an int array of length 81 to see if it is a valid Sudoku grid. i.e. 1 through 9 appearing once each in every row, column, and box
     *@param grid an array with length 81 to be tested
     *@return a boolean representing if the grid is valid
     */
    public static boolean isPerfect(int[] grid)
    {
        if(grid.length != 81) throw new IllegalArgumentException("The grid must be a single-dimension grid of length 81");

        //tests to see if the grid is perfect

        //for every box
        for(int i = 0; i < 9; i++)
        {
            boolean[] registered = new boolean[10];
            registered[0] = true;
            int boxOrigin = (i * 3) % 9 + ((i * 3) / 9) * 27;
            for(int j = 0; j < 9; j++)
            {
                int boxStep = boxOrigin + (j / 3) * 9 + (j % 3);
                int boxNum = grid[boxStep];
                registered[boxNum] = true;
            }
            for(boolean b: registered)
                if(!b) return false;
        }

        //for every row
        for(int i = 0; i < 9; i++)
        {
            boolean[] registered = new boolean[10];
            registered[0] = true;
            int rowOrigin = i * 9;
            for(int j = 0; j < 9; j++)
            {
                int rowStep = rowOrigin + j;
                int rowNum = grid[rowStep];
                registered[rowNum] = true;
            }
            for(boolean b: registered)
                if(!b) return false;
        }

        //for every column
        for(int i = 0; i < 9; i++)
        {
            boolean[] registered = new boolean[10];
            registered[0] = true;
            int colOrigin = i;
            for(int j = 0; j < 9; j++)
            {
                int colStep = colOrigin + j*9;
                int colNum = grid[colStep];
                registered[colNum] = true;
            }
            for(boolean b: registered)
                if(!b) return false;
        }

        return true;
    }
}
