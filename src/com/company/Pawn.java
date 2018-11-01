package com.company;

import java.awt.*;


class Pawn extends ChessPiece {

    public Pawn(String position, Color color) {
        super(position, color);
    }

    public Pawn(){

    }
    @Override
    public void move(String newPosition) throws Exception {

        int x = this.getPosition().charAt(0) - newPosition.charAt(0);
        int y = this.getPosition().charAt(1) - newPosition.charAt(1);

        if (!(x == 0 && y == 1) && !(y == 1)) {
            throw new IllegalChessMoveException("Illegal Pawn movement");
        } else {
            super.move(newPosition);
        }


    }

    @Override
    public String toString() {
            return "P";
    }


}

