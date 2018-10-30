package com.company;

import java.awt.*;


class Pawn extends ChessPiece {

    public Pawn(String position, Color color) {
        super(position, color);
    }

    @Override
    public void move(String newPosition) throws Exception {
        int x = Math.abs(this.getPosition().charAt(0) - newPosition.charAt(0));
        int y = Math.abs(this.getPosition().charAt(1) - newPosition.charAt(1));

        if ((x == 0 && y == 1) || (x == 1 && y == 1)) {

        } else throw new IllegalChessMoveException();
    }

    @Override
    public String toString() {
        return "P";
    }


}

