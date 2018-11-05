package com.company;

import com.company.model.Bishop;
import com.company.model.ChessPiece;
import com.company.model.IllegalChessMoveException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BishopTest {
    @Test
    public void testToString(){
        ChessPiece bishop = new Bishop("A1", ChessPiece.Color.White);
        assertEquals("B", bishop.toString());
    }

    @Test
    public void testMoveException() throws Exception {
        ChessPiece bishop = new Bishop("A1", ChessPiece.Color.White);
        assertThrows(IllegalChessMoveException.class, () -> {
            bishop.move("B5");

        });
    }

    @Test
    public void testMove() {
        ChessPiece bishop = new Bishop("A1", ChessPiece.Color.White);
        assertDoesNotThrow(() -> {
            bishop.move("B2");

        });
    }
}
