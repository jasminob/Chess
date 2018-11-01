package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class KnightTest {

    @Test
    public void testToString(){
        ChessPiece knight = new Knight("A1", ChessPiece.Color.White);
        assertEquals("N", knight.toString());
    }

    @Test
    public void testMoveException() throws Exception {
        ChessPiece knight = new Knight("A1", ChessPiece.Color.White);
        assertThrows(IllegalChessMoveException.class, () -> {
            knight.move("B1");

        });
    }

    @Test
    public void testMove() {
        ChessPiece knight = new Knight("A1", ChessPiece.Color.White);
        assertDoesNotThrow(() -> {
            knight.move("B3");

        });
    }
}
