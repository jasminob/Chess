package com.company;

import com.company.model.ChessPiece;
import com.company.model.IllegalChessMoveException;
import com.company.model.Queen;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QueenTest {

    @Test
    public void testToString() {
        ChessPiece queen = new Queen("A1", ChessPiece.Color.White);
        assertEquals("Q", queen.toString());
    }

    @Test
    public void testMoveException() throws Exception {
        ChessPiece queen = new Queen("A1", ChessPiece.Color.White);
        assertThrows(IllegalChessMoveException.class, () -> {
            queen.move("C8");

        });
    }

    @Test
    public void testMove() {
        ChessPiece queen = new Queen("A1", ChessPiece.Color.White);
        assertDoesNotThrow(() -> {
            queen.move("B2");

        });
    }

}
