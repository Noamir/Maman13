public class StudentEx13Tester
{
    public static void main(String[] args) {
        System.out.println("Using Square3x3 default constructor...");
        Square3x3 sq1 = new Square3x3();

        System.out.println("Using Square3x3 second constructor...");
        int[][] arrForSecondConstructor = {{1, 9, 8}, {7, 3, 2}, {5, 6, 4}};
        Square3x3 sq2 = new Square3x3(arrForSecondConstructor);

        System.out.println("Using Square3x3 copy constructor...");
        Square3x3 sq3 = new Square3x3(sq2);

        System.out.print("Checking getCell Method (should print true): ");
        System.out.println(sq2.getCell(1, 2) == 2);

        System.out.print("Checking setXY Method (should print true): ");
        sq2.setXY(1, 2, 3);
        System.out.println(sq2.getCell(1, 2) == 3);

        System.out.println("Checking Square3x3 toString method (make sure that the printed result is correct)");
        System.out.print(sq3);

        System.out.print("Checking method allThere with valid square (should print true): ");
        System.out.println(sq3.allThere());

        System.out.print("Checking method allThere with non valid square (should print false): ");
        System.out.println(sq2.allThere());

        System.out.print("Checking whosThereRow method: ");
        boolean[] whichNumbersAppear = new boolean[10];
        int tmpArr[][] = {{1, 6, 8}, {7, 3, 2}, {5, 6, 4}};
        Square3x3 sq4 = new Square3x3(tmpArr);
        sq4.whosThereRow(0, whichNumbersAppear);
        boolean[] arrayToCompare = {false, true, false, false, false, false, true, false, true, false};
        System.out.println("Make sure that both arrays are the same:");
        printArray(whichNumbersAppear);
        printArray(arrayToCompare);

        System.out.print("Checking whosThereCol method: ");
        whichNumbersAppear = new boolean[10];
        sq4.whosThereCol(0, whichNumbersAppear);
        boolean[] arrayToCompare2 = {false, true, false, false, false, true, false, true, false, false};
        System.out.println("Make sure that both arrays are the same:");
        printArray(whichNumbersAppear);
        printArray(arrayToCompare2);

        System.out.println("Creating a default sudoku board...");
        Sudoku sod1 = new Sudoku();

        int tmpArr00[][] = {{1, 9, 8}, {7, 3, 2}, {5, 6, 4}};
        int tmpArr01[][] = {{9, 2, 3}, {6, 5, 4}, {8, 1, 7}};
        int tmpArr02[][] = {{4, 5, 7}, {1, 8, 9}, {2, 3, 6}};
        int tmpArr10[][] = {{3, 1, 9}, {8, 4, 7}, {2, 5, 6}};
        int tmpArr11[][] = {{2, 8, 5}, {1, 3, 6}, {4, 7, 9}};
        int tmpArr12[][] = {{7, 6, 4}, {5, 9, 2}, {8, 1, 3}};
        int tmpArr20[][] = {{4, 8, 5}, {6, 2, 1}, {9, 7, 3}};
        int tmpArr21[][] = {{3, 6, 2}, {7, 9, 8}, {5, 4, 1}};
        int tmpArr22[][] = {{9, 7, 1}, {3, 4, 5}, {6, 2, 8}};

        Square3x3[][] square3x3Array = new Square3x3[3][3];
        square3x3Array[0][0] = new Square3x3(tmpArr00);
        square3x3Array[0][1] = new Square3x3(tmpArr01);
        square3x3Array[0][2] = new Square3x3(tmpArr02);
        square3x3Array[1][0] = new Square3x3(tmpArr10);
        square3x3Array[1][1] = new Square3x3(tmpArr11);
        square3x3Array[1][2] = new Square3x3(tmpArr12);
        square3x3Array[2][0] = new Square3x3(tmpArr20);
        square3x3Array[2][1] = new Square3x3(tmpArr21);
        square3x3Array[2][2] = new Square3x3(tmpArr22);

        System.out.println("Using Sudoku second constructor...");
        Sudoku sod2 = sod2 = new Sudoku(square3x3Array);

        System.out.print("Checking method isValid with invalid Sudoku (should print false): ");
        System.out.println(sod2.isValid());

        System.out.print("Checking method isValid with valid Sudoku (should print true): ");
        square3x3Array[0][0].setXY(0, 1, 6);
        square3x3Array[0][0].setXY(2, 1, 9);
        sod2 = new Sudoku(square3x3Array);
        System.out.println(sod2.isValid());
    }

    private static void printArray(boolean[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }
}
