//package com.zivlazarov.mamanim.maman13;

import java.io.*;

public class SudokuTests {

    //private final static String name = SudokuTests.class.getName().replace(".", File.separator);
    //private final static String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + name.substring(0, name.lastIndexOf(File.separator));

    // #################### if FileNotFoundException occurs, set FULL PATH to solved_board.txt file here ####################
    private final static String PATH_TO_SUDOKU_BOARDS_FILE = "C:\\Users\\Noa\\Downloads" + "\\solved_boards.txt";

    public static void main(String[] args) throws IOException {
        // declare relevant variables for reading files
        FileInputStream fileInputStream = null;
        BufferedReader br = null;
        try {
            // using FULL PATH to file as String parameter
            fileInputStream = new FileInputStream(PATH_TO_SUDOKU_BOARDS_FILE);
            // open the file
            br = new BufferedReader(new InputStreamReader(fileInputStream));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // if file doesn't exist, stop
        if (br == null) return;

        // String variable for each line
        String strLine;

        // 10,000 boards (number of lines in file). setting a flag for each one (false as default)
        boolean[] checks = new boolean[10_000];

        // counting board index
        int index = 0;

        // reading the file
        while ((strLine = br.readLine()) != null) {
            // converting every line in file (string) to a char array
            char[] chars = strLine.toCharArray();
            // 81 number of digits in sudoku board, which is the number of items in the char array
            int[] array = new int[chars.length];
            for (int i = 0; i < chars.length; i++) {
                // parsing the char to an integer
                array[i] = Integer.parseInt(String.valueOf(chars[i]));
            }

            // reshaping the 1x81 array to a 9x9 array
            int[][] reshapedArray = new int[9][9];
            for (int i = 0; i < 81; i++) {
                reshapedArray[i/9][i%9] = array[i];
            }

            // initializing every 3x3 square of board for passing to Square3x3 objects, total of 9
            int[][] s0 = new int[3][3];
            int[][] s1 = new int[3][3];
            int[][] s2 = new int[3][3];
            int[][] s3 = new int[3][3];
            int[][] s4 = new int[3][3];
            int[][] s5 = new int[3][3];
            int[][] s6 = new int[3][3];
            int[][] s7 = new int[3][3];
            int[][] s8 = new int[3][3];

            // setting each 3x3 square's values to its respective "spot" in the reshaped array
            // jumping each spot according to its row and column
            // first 3 are from the first 3 rows (indexes 0 to 2)
            for (int i = 0; i < 3; i++) {
                System.arraycopy(reshapedArray[i], 0, s0[i], 0, 3);
            }
            for (int i = 0; i < 3; i++) {
                System.arraycopy(reshapedArray[i], 3, s1[i], 0, 3);
            }
            for (int i = 0; i < 3; i++) {
                System.arraycopy(reshapedArray[i], 6, s2[i], 0, 3);
            }

            // second are from row number 3 to row number 6 (indexes 3 to 5)
            for (int i = 0; i < 3; i++) {
                System.arraycopy(reshapedArray[i + 3], 0, s3[i], 0, 3);
            }
            for (int i = 0; i < 3; i++) {
                System.arraycopy(reshapedArray[i + 3], 3, s4[i], 0, 3);
            }
            for (int i = 0; i < 3; i++) {
                System.arraycopy(reshapedArray[i + 3], 6, s5[i], 0, 3);
            }

            // third are from row number 6 to row number 9 (indexes 6 to 8)
            for (int i = 0; i < 3; i++) {
                System.arraycopy(reshapedArray[i + 6], 0, s6[i], 0, 3);
            }
            for (int i = 0; i < 3; i++) {
                System.arraycopy(reshapedArray[i + 6], 3, s7[i], 0, 3);
            }
            for (int i = 0; i < 3; i++) {
                System.arraycopy(reshapedArray[i + 6], 6, s8[i], 0, 3);
            }

            // initializing the 3x3 array of Square3x3 objects
            Square3x3[][] board = {
                    { new Square3x3(s0), new Square3x3(s1), new Square3x3(s2) },
                    { new Square3x3(s3), new Square3x3(s4), new Square3x3(s5) },
                    { new Square3x3(s6), new Square3x3(s7), new Square3x3(s8) }
            };

            // initializing the Sudoku board with the Square3x3 objects array
            Sudoku sudokuBoard = new Sudoku(board);
            // setting a flag for each one whether it's valid or not
            checks[index] = sudokuBoard.isValid();
            // incrementing index
            index++;
        }

        // looping through all flags
        for (int i = 0; i < checks.length; i++) {
            // if any of the flags is false, stop checking any further
            if (!checks[i]) {
                // show and print an error message with the index number of the board (row number in file)
                System.out.println("===================== ERROR ===================== AT ROW NUMBER " + (i+1));
                break;
                // show an OK message
            } else System.out.println("Board number " + (i+1) + ": OK");
        }

        // close the input stream
        fileInputStream.close();
    }
}
