package com.company.model;


public class Bishop extends ChessPiece implements Saveable{

    public Bishop(String position, Color color) {
        super(position, color);
    }

    @Override
    public void move(String newPosition) throws Exception {



        int x1 = Character.toUpperCase(this.getPosition().charAt(0));
        int x2 = Character.toUpperCase(newPosition.charAt(0));;
        int x = Math.abs(x1 - x2);
        int y = Math.abs(this.getPosition().charAt(1) - newPosition.charAt(1));

        if (x != y) {
            throw new IllegalChessMoveException("Illegal Bishop movement");
        } else {
            super.move(newPosition);
        }
    }

    @Override
    public String toString() {
        return "B";
    }


}


