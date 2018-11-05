package com.company;

import com.company.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
        // Is the board usable after isCheck
    void someLegalMoves() throws Exception {
        Board b = new Board();
        boolean no = b.isCheck(ChessPiece.Color.White);
        assertDoesNotThrow(
                () -> {

                    b.move("E2", "E3");
                    b.move("E3", "E4");
                    b.move("E4", "E5");
                    b.move("E5", "E6");
                }
        );
    }

    @Test
        // Pawn eats diagonally, check by queen
    void pawnDiagonal() {
        Board b = new Board();
        assertDoesNotThrow(
                () -> {
                    b.move("E2", "E3");
                    b.move("E3", "E4");
                    b.move("E4", "E5");
                    b.move("E5", "E6");
                    b.move("E6", "F7");
                    b.move("F7", "G8");
                }
        );
    }

    @Test
        // Check by queen
    void isCheck() throws Exception {
        Board b = new Board();
        try {

            b.move("E2", "E3");
            b.move("E3", "E4");
            b.move("E4", "E5");
            b.move("E5", "E6");
            b.move("E6", "F7");
            b.move("F7", "G8");
            b.move("D1", "E2");
            b.move("E2", "E7");


        } catch(Exception e) {
            // Do nothing
        }
        assertTrue(b.isCheck(ChessPiece.Color.Black));
    }


    @Test
        // Will queen be moved by isCheck
    void isCheckUsable() throws Exception {
        Board b = new Board();
        try {


            b.move("E2", "E3");
            b.move("E3", "E4");
            b.move("E4", "E5");
            b.move("E5", "E6");
            b.move("E6", "D7");
            b.move("D7", "C8");
            b.move("D1", "E2");

        } catch(Exception e) {
            // Do nothing
        }
        b.isCheck(ChessPiece.Color.Black);
        assertDoesNotThrow(
                () -> {
                    b.move(Queen.class, ChessPiece.Color.White, "D3");
                }
        );
    }

    @Test
        // Queen, bishop and rook can't jump pieces
    void jumpPiece() {
        Board b = new Board();
        assertAll(
                () -> assertThrows(
                        IllegalChessMoveException.class,
                        () -> b.move(Rook.class, ChessPiece.Color.Black, "H6")
                ),
                () -> assertThrows(
                        IllegalChessMoveException.class,
                        () -> b.move(Bishop.class, ChessPiece.Color.Black, "H6")
                ),
                () -> assertThrows(
                        IllegalChessMoveException.class,
                        () -> b.move(Queen.class, ChessPiece.Color.Black, "A5")
                )
        );
    }


    // Same test with other move method

    @Test
        // Is the board usable after isCheck
    void someLegalMoves1() throws Exception {
        Board b = new Board();
        boolean no = b.isCheck(ChessPiece.Color.White);
        assertDoesNotThrow(
                () -> {
                    b.move("E2", "E3");
                    b.move("E3", "E4");


                }
        );
    }

    @Test
        // Pawn eats diagonally, check by queen
    void pawnDiagonal1() {
        Board b = new Board();
        assertDoesNotThrow(
                () -> {
                    b.move("E2", "E3");
                    b.move("E3", "E4");
                    b.move("E4", "E5");
                    b.move("E5", "E6");
                    b.move("E6", "D7");
                    b.move("D7", "C8");
                }
        );
    }

    @Test
        // Check by queen
    void isCheck1() throws Exception {
        Board b = new Board();
        try {
            b.move("E2", "E3");
            b.move("E3", "E4");
            b.move("E4", "E5");
            b.move("E5", "E6");
            b.move("E6", "D7");
            b.move("D7", "C8");
            b.move("D1", "E2");
        } catch(Exception e) {
            // Do nothing
        }
        assertTrue(b.isCheck(ChessPiece.Color.Black));
    }

    @Test
        // Queen, bishop and rook can't jump pieces
    void jumpPiece1() {
        Board b = new Board();
        assertAll(
                () -> assertThrows(
                        IllegalChessMoveException.class,
                        () -> b.move("H8", "H6")
                ),
                () -> assertThrows(
                        IllegalChessMoveException.class,
                        () -> b.move("F8", "H6")
                ),
                () -> assertThrows(
                        IllegalChessMoveException.class,
                        () -> b.move("D8", "A5")
                )
        );
    }

    @Test
        // Check by queen
    void isCheckUsable1() throws Exception {
        Board b = new Board();
        try {
            b.move("E2", "E3");
            b.move("E3", "E4");
            b.move("E4", "E5");
            b.move("E5", "E6");
            b.move("E6", "D7");
            b.move("D7", "C8");
            b.move("D1", "E2");

        } catch(Exception e) {
            // Do nothing
        }
        b.isCheck(ChessPiece.Color.Black);
        assertDoesNotThrow(
                () -> {
                    b.move("E2", "D3");
                }
        );
    }

}