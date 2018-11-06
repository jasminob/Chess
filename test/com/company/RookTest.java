package com.company;

import com.company.model.ChessPiece;
import com.company.model.IllegalChessMoveException;
import com.company.model.Rook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RookTest {

    @Test
    public void testToString(){
        ChessPiece rook = new Rook("A1", ChessPiece.Color.White);
        assertEquals("R", rook.toString());
    }

    @Test
    public void testMoveException() throws Exception {
        ChessPiece rook = new Rook("A1", ChessPiece.Color.White);
        assertThrows(IllegalChessMoveException.class, () -> {
            rook.move("B5");

        });
    }

    @Test
    public void testMove() {
        ChessPiece rook = new Rook("A1", ChessPiece.Color.White);
        assertDoesNotThrow(() -> {
            rook.move("C1");

        });
    }


}
