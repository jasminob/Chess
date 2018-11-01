package com.company;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class KingTest {

    @Test
    public void testToString(){
        ChessPiece king = new King("A1", ChessPiece.Color.White);
        assertEquals("K", king.toString());
    }

    @Test
    public void testMoveException() throws Exception {
        ChessPiece king = new King("A1", ChessPiece.Color.White);
        assertThrows(IllegalChessMoveException.class, () -> {
            king.move("B5");

        });
    }

    @Test
    public void testMove() {
        ChessPiece king = new King("A1", ChessPiece.Color.White);
        assertDoesNotThrow(() -> {
            king.move("B2");

        });
    }


}
