public class Square3x3Tester {
    public static void main(String[] args) {

        // Test first constructor
        Square3x3 square0 = new Square3x3();
//        System.out.println(square0);

        // Test second constructor
        // Same size:
        int[][] array1 = {{1,2,3}, {4,5, 6}, {7,8,9}};
        Square3x3 square1 = new Square3x3(array1);
//        System.out.println(square1);
//
//        // array length is shorter than square:
//        int[][] array2 = {{1,2,3}, {4,5,6}};
//        Square3x3 square2 = new Square3x3(array2);
//        System.out.println(square2);
//
//        // array length is longer than square:
//        int[][] array3 = {{1,2,3}, {4,5,6}, {7,8,9}, {10,11,12}};
//        Square3x3 square3 = new Square3x3(array3);
//        System.out.println(square3);
//
//        // array col length is shorter than square col length:
//        int[][] array4 = {{1,2,3}, {4,5}, {7,8,9}};
//        Square3x3 square4 = new Square3x3(array4);
//        System.out.println(square4);
//
//        // array col length is longer than square col length:
//        int[][] array5 = {{1,2,3,4}, {4,5,6}, {7,8,9,10}};
//        Square3x3 square5 = new Square3x3(array5);
//        System.out.println(square5);
//
//        // Mix:
        int[][] array6 = {{1,2,3,4}, {4,5}, {7,8,9,10,11,0}, {10,11,12,13,14}};
        Square3x3 square6 = new Square3x3(array6);
//        System.out.println(square6);

        // Test copy constructor
//        Square3x3 square7 = new Square3x3(square0);
//        System.out.println(square7);
//        Square3x3 square8 = new Square3x3(square1);
//        System.out.println(square8);
//        Square3x3 square9 = new Square3x3(square6);
//        System.out.println(square9);

        // Test getCell
        int cell1 = square1.getCell(0,0);
        //System.out.println(cell1);
        int cell2 = square1.getCell(3,3);
        //System.out.println(cell2);
        int cell3 = square1.getCell(-9,-1);
        //System.out.println(cell3);
        int cell4 = square1.getCell(10, -2);
        //System.out.println(cell4);
        int cell5 = square1.getCell(2, 1);
        //System.out.println(cell5);

        // Test setXY

        // Test whosThereRow
//        int[][] array7 = {{1,2,3}, {4,4,4}, {7,8,9}};
//        Square3x3 square7 = new Square3x3(array7);
//        boolean[] bool = {false, false, false, false, false, false, false, false, false, false};
//        square7.whosThereRow(1, bool);
        //System.out.println();

        // Test whosThereCol
        int[][] array8 = {{1,2,3}, {4,5,6}, {7,8,9}};
        Square3x3 square8 = new Square3x3(array8);
        boolean[] bool1 = {false, false, false, false, false, false, false, false, false, false};
        square8.whosThereCol(1, bool1);
        //System.out.println();

        // Test allThere
        int[][] array9 = {{1,2,2,8}, {4,3,6,7}, {7,5,9}};
        Square3x3 square9 = new Square3x3(array9);
        System.out.println(square9.allThere());
        square9.printRow(0);


    }
}
