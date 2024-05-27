package edu.danielev.leet_code.string_manipulation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    char[][] emptyBoard = {
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
    };


    char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '2', '7', '9'}
    };

    char[][] expectedSubMatrix2 = {
            {'2', '8', '.'},
            {'.', '.', '5'},
            {'2', '7', '9'}
    };

    char[][] expectedSubMatrix = {
            {'5', '3', '.'},
            {'6', '.', '.'},
            {'.', '9', '8'}
    };

    char[][] expectedTransposedBoard = {
            {'5', '6', '.', '8', '4', '7', '.', '.', '.'},
            {'3', '.', '9', '.', '.', '.', '6', '.', '.'},
            {'.', '.', '8', '.', '.', '.', '.', '.', '.'},
            {'.', '1', '.', '.', '8', '.', '.', '4', '.'},
            {'7', '9', '.', '6', '.', '2', '.', '1', '8'},
            {'.', '5', '.', '.', '3', '.', '.', '9', '.'},
            {'.', '.', '.', '.', '.', '.', '2', '.', '2'},
            {'.', '.', '6', '.', '.', '.', '8', '.', '7'},
            {'.', '.', '.', '3', '1', '6', '.', '5', '9'}
    };

    char[][] invalidBoard1 = {
            {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
            {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
            {'8', '.', '.', '.', '.', '.', '5', '2', '.'},
            {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
            {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
            {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
            {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
    };

    char[][] invalidBoard = {
            {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
            {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
            {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
            {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
            {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
            {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
            {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
    };

    @BeforeEach
    void setUp() {
    }

    @Test
    void isValidSudoku_shouldReturn_False() {
        assertFalse(Matrix.isValidSudoku(invalidBoard));
        assertFalse(Matrix.isValidSudoku(board));
    }

    @Test
    void when_emptyBoard_isValidSudoku_shouldReturn_True() {
        assertTrue(Matrix.isValidSudoku(emptyBoard));
    }

    @Test
    void isInValidSudoku_shouldReturn_False() {
        assertFalse(Matrix.isValidSudoku(invalidBoard1));
    }

    @Test
    void transposeBoard() {

        char[][] transposedBoard = Matrix.transposeBoard(board);

        assertArrayEquals(expectedTransposedBoard, transposedBoard);
    }

    @Test
    void areDuplicatesInRows_shouldReturn_False() {
        assertFalse(Matrix.areDuplicatesInRows(board));
    }

    @Test
    void areDuplicatesInRows_shouldReturn_True() {
        char[][] transposedBoard = Matrix.transposeBoard(board);
        assertTrue(Matrix.areDuplicatesInRows(transposedBoard));
    }

    @Test
    void containsDuplicates_shouldReturn_false() {
        char[] row = {'5', '3', '.', '.', '7', '.', '.', '.', '.'};
        char[] row2 = {'.', '.', '.', '.', '.', '.', '.', '.', '.'};
        assertFalse(Matrix.containsDuplicates(row));
        assertFalse(Matrix.containsDuplicates(row2));
    }

    @Test
    void containsDuplicate_shouldReturn_false() {
        char[] row = {'5', '3', '.', '7', '.',};
        assertFalse(Matrix.containsDuplicates(row));
    }

    @Test
    void containsDuplicates_shouldReturn_True() {
        char[] row = {'5', '3', '.', '.', '7', '.', '.', '7', '.'};
        assertTrue(Matrix.containsDuplicates(row));
    }

    @Test
    void testEmptySetReturns_true() {
        Set<Character> emptySet = new HashSet<>();
        assertTrue(true);
    }

    @Test
    void getSubMatrices() {

    }

    @Test
    void getSubMatrix() {
        char[][] subMatrix = Matrix.getSubMatrix(board, 0, 0);
        char[][] subMatrix2 = Matrix.getSubMatrix(board, 6, 6);
        assertArrayEquals(expectedSubMatrix, subMatrix);
        assertArrayEquals(expectedSubMatrix2, subMatrix2);
    }
}