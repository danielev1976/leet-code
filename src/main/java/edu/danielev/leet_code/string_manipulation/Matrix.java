package edu.danielev.leet_code.string_manipulation;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class Matrix {

    public static boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) return false;
        // Validate rows of the board
        if (areDuplicatesInRows(board)) return false;
        // Transpose the boards "matrix"
        char[][] boardT = transposeBoard(board);
        List<char[][]> subMatrices = getSubMatrices(board);
        if(!areValidSubMatrices(subMatrices)) return false;
        return !areDuplicatesInRows(boardT);
    }

    static char[][] transposeBoard(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        char[][] boardT = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                boardT[j][i] = board[i][j];
            }
        }
        return boardT;
    }

    static boolean areDuplicatesInRows(char[][] board) {
        for (char[] row : board) {
            if (containsDuplicates(row)) {
                return true;
            }
        }
        return false;
    }

    static boolean containsDuplicates(char[] row) {
        Set<Character> set = new HashSet<>();
        for (char c : row) {
            if (c != '.') {
                if (set.contains(c)) {
                    return true;
                }
                set.add(c);
            }
        }
        return false;
    }

    public static List<char[][]> getSubMatrices(char[][] board) {
        List<char[][]> subMatrices = new ArrayList<>();
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                subMatrices.add(getSubMatrix(board, i, j));
            }
        }
        return subMatrices;
    }

    public static char[][] getSubMatrix(char[][] board, int n, int m) {
        char[][] subBoard = new char[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(board[n], m, subBoard[i], 0, 3);
            n++;
        }
        return subBoard;
    }

    public static boolean areValidSubMatrices(List<char[][]> boardMatrices) {
        for (char[][] matrix : boardMatrices) {
           if(matrixContainsDuplicates(matrix)) return false;
        }
        return true;
    }

    private static boolean matrixContainsDuplicates(char[][] board) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (set.contains(c)) {
                        return true;
                    }
                    set.add(c);
                }
            }
        }
        return false;
    }
}

