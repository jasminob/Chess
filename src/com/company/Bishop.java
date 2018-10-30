package com.company;

import java.awt.*;


class Bishop extends ChessPiece {

    public Bishop(String position, Color color) {
        super(position, color);
    }

    @Override
    public void move(String newPosition) throws Exception {
        int x = Math.abs(this.getPosition().charAt(0) - newPosition.charAt(0));
        int y = Math.abs(this.getPosition().charAt(1) - newPosition.charAt(1));

        if (x != y) {
            throw new IllegalChessMoveException();
        } else {

        }
    }

    @Override
    public String toString() {
        return "B";
    }
}


