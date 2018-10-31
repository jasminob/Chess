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

newPosition.toLowerCase();
        int x = Math.abs(this.getPosition().charAt(0) - newPosition.charAt(0));
        int y = Math.abs(this.getPosition().charAt(1) - newPosition.charAt(1));

        if (!(x == 0 && y == 1) && !(x == 1 && y == 1)) {
            throw new IllegalChessMoveException();
        } else {
            super.move(newPosition);
        }
    }

    @Override
    public String toString() {
        if(this.getColor().equals(Color.White)) {
            return "WP";
        }
        return "BP";
    }


}

