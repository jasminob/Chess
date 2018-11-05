package com.company.model;


public class Rook extends ChessPiece implements Saveable {


    public Rook(String position, Color color) {
        super(position, color);
    }

    public Rook(){

    }
    @Override
    public void move(String newPosition) throws Exception {

        int x1 = Character.toUpperCase(this.getPosition().charAt(0));
        int x2 = Character.toUpperCase(newPosition.charAt(0));

        int x = Math.abs(x1 - x2);
        int y = Math.abs(this.getPosition().charAt(1) - newPosition.charAt(1));

        if (!(x == 0 && y > 0) && !(x > 0 && y == 0)) {
            throw new IllegalChessMoveException("Illegal Rook movement");
        } else {
            super.move(newPosition);
        }
    }

    @Override
    public String toString() {
        return "R";
    }




}

