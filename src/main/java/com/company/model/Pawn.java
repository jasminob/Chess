package com.company.model;


public class Pawn extends ChessPiece implements Saveable {

    public Pawn(String position, Color color) {
        super(position, color);
    }

    public Pawn(){

    }
    @Override
    public void move(String newPosition) throws Exception {
        int x1 = Character.toUpperCase(this.getPosition().charAt(0));
        int x2 = Character.toUpperCase(newPosition.charAt(0));

        int y1 = this.getPosition().charAt(1);

        int x = Math.abs(x1 - x2);
        int y = y1 - newPosition.charAt(1);

        boolean shouldGoUp = getColor() == Color.Black;
        boolean goesDown = y > 0;

        y = Math.abs(y);

        if((shouldGoUp && goesDown) || (!shouldGoUp && !goesDown)) {

            if (!(x == 0 && y == 1) && !(this.getColor()==Color.White && y1 == 50 && y == 2 && x == 0)
                    && !(this.getColor()==Color.Black && y1 == 55 && y == 2 && x == 0)) {
                throw new IllegalChessMoveException("Illegal Pawn movement");
            } else {
                super.move(newPosition);
            }
        } else{
            throw new IllegalChessMoveException("Illegal Pawn movement");
        }
    }



    public void moveIt(String newPosition) throws Exception {
        int x1 = Character.toUpperCase(this.getPosition().charAt(0));
        int x2 = Character.toUpperCase(newPosition.charAt(0));

        int x = Math.abs(x1 - x2);
        int y = this.getPosition().charAt(1) - newPosition.charAt(1);

        boolean shouldGoUp = getColor() == Color.Black;
        boolean goesDown = y > 0;

        y = Math.abs(y);

        if(shouldGoUp != goesDown) {
            throw new IllegalChessMoveException("Illegal Pawn movement");
        }


            if (!(x == 1 && y == 1) ) {
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

