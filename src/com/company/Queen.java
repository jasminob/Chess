package com.company;

import java.awt.*;


class Queen extends ChessPiece {

    public Queen(String position, Color color) {
        super(position, color);
    }

    @Override
    public void move(String newPosition) throws Exception {
        super.move(newPosition);

        int x = Math.abs(this.getPosition().charAt(0) - newPosition.charAt(0));
        int y = Math.abs(this.getPosition().charAt(1) - newPosition.charAt(1));

        if (!(x == y) && !(x == 0 && y > 0) && !(x > 0 && y == 0)) {
            throw new IllegalChessMoveException();
        } else{

        }

    }

    @Override
    public String toString() {
        return "Q";
    }
}
