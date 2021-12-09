public class SudokuTester {

    public static void main(String[] args){
        Sudoku s1 = new Sudoku();
        //s1.printGrid(); // expected all -1
        System.out.println(s1.isValid()); // expected false

        int[][] array1 = {{1,2,3}, {4,5,6}, {7,8,9}};
        Square3x3 square1 = new Square3x3(array1);

        int[][] array2 = {{4,5,6}, {7,8,9}, {1,2,3}};
        Square3x3 square2 = new Square3x3(array2);

        int[][] array3 = {{7,8,9}, {1,2,3}, {4,5,6}};
        Square3x3 square3 = new Square3x3(array3);

        int[][] array4 = {{2,3,4}, {5,6,7}, {8,9,1}};
        Square3x3 square4 = new Square3x3(array4);

        int[][] array5 = {{5,6,7}, {8,9,1}, {2,3,4}};
        Square3x3 square5 = new Square3x3(array5);

        int[][] array6 = {{8,9,1}, {2,3,4},{5,6,7}};
        Square3x3 square6 = new Square3x3(array6);

        int[][] array7 = {{3,4,5}, {6,7,8}, {9,1,2}};
        Square3x3 square7 = new Square3x3(array7);

        int[][] array8 = {{6,7,8}, {9,1,2}, {3,4,5}};
        Square3x3 square8 = new Square3x3(array8);

        int[][] array9 = {{9,1,2}, {3,4,5}, {6,7,8}};
        Square3x3 square9 = new Square3x3(array9);

        Square3x3[][] array = {{square1, square2, square3}, {square4, square5, square6}, {square7, square8, square9}};
        Sudoku s2 = new Sudoku(array);

        //s2.printGrid();
        System.out.println(s2.isValid());

    }
}
