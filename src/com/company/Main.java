package com.company;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        // Board board = new Board();

        String x = "H1";
        System.out.println(x.charAt(0));
    }
}


abstract class ChessPiece {


    private String position;
    private Color color;

    public ChessPiece(String position, Color color) {
        this.position = position;
        this.color = color;
    }

    public String getPosition() {
        return position;
    }

    public Color getColor() {
        return color;
    }

    public void move(String position) {

    }

    public boolean blackPawn() {
        if (this.getColor().equals(Color.BLACK)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean offside() {

        if ((int) this.getPosition().charAt(0) < 97 || (int) this.getPosition().charAt(0) > 122
                && this.getPosition().charAt(1) < 1 || this.getPosition().charAt(1) > 8) {
            return true;
        } else return false;
    }

}


class Board {

    ChessPiece piece;

    public void move(Class type, Color color, String position) {

        switch (type.get) {
            case 'K':
                type.
        }
    }

    public void move(String oldPosition, String newPosition) {

    }

    boolean isCheck(Color color) {
    }


}

class King extends ChessPiece {

    public King(String position, Color color) {
        super(position, color);
    }

    public void move(String newPosition) {
        int x = Math.abs(this.getPosition().charAt(0) - newPosition.charAt(0));
        int y = Math.abs(this.getPosition().charAt(1) - newPosition.charAt(1));

        if ((x == 1 && y == 1) || (x == 0 && y == 1) || (x == 1 && y == 0)) {

        } else //exception
    }


}

class Queen extends ChessPiece {

    public Queen(String position, Color color) {
        super(position, color);
    }

    public void move(String newPosition) {
        int x = Math.abs(this.getPosition().charAt(0) - newPosition.charAt(0));
        int y = Math.abs(this.getPosition().charAt(1) - newPosition.charAt(1));

        if ((x > 0 && y > 0) || (x == 0 && y > 0) || (x > 0 && y == 0)) {

        } else //exception
    }
}

class Rook extends ChessPiece {


    public Rook(String position, Color color) {
        super(position, color);
    }

    public void move(String newPosition) {
        int x = Math.abs(this.getPosition().charAt(0) - newPosition.charAt(0));
        int y = Math.abs(this.getPosition().charAt(1) - newPosition.charAt(1));

        if ((x == 0 && y > 0) || (x > 0 && y == 0)) {

        } else //exception
    }
}

class Pawn extends ChessPiece {

    public Pawn(String position, Color color) {
        super(position, color);
    }


    public void move(String newPosition) {
        int x = Math.abs(this.getPosition().charAt(0) - newPosition.charAt(0));
        int y = Math.abs(this.getPosition().charAt(1) - newPosition.charAt(1));

        if ((x == 0 && y == 1) || (x == 1 && y == 1)) {

        } else //exception
    }

  /*
    public void move(String newPosition) {
        String[] tempString = this.getPosition().split("");
        String[] tempNewString = newPosition.split("");
        int y = Integer.parseInt(tempString[1]);

        if (blackPawn()) {
            y--;
            tempString[1] = y + "";
        } else {
            y++;
            tempString[1] = y + "";
        }

        if (tempString[1] != tempNewString[1]) {
            //IllegalChessMoveException
        }

    }
*/

}

class Knight extends ChessPiece {

    public Knight(String position, Color color) {
        super(position, color);
    }

    public void move(String newPosition) {
        int x = Math.abs(this.getPosition().charAt(0) - newPosition.charAt(0));
        int y = Math.abs(this.getPosition().charAt(1) - newPosition.charAt(1));

        if ((x == 2 && y == 1) || (x == 1 && y == 2)) {

        } else //exception
    }
}

class Bishop extends ChessPiece {

    public Bishop(String position, Color color) {
        super(position, color);
    }

    public void move(String newPosition) {
        int x = Math.abs(this.getPosition().charAt(0) - newPosition.charAt(0));
        int y = Math.abs(this.getPosition().charAt(1) - newPosition.charAt(1));

        if (x > 0 && y > 0) {

        } else //exception
    }



  /*  public void move(String newPosition) {
        String[] tempString = this.getPosition().split("");
        String[] tempNewString = newPosition.split("");

        int x = this.getPosition().charAt(0);
        int y = Integer.parseInt(tempString[1]);

        while (!this.getPosition().equals(newPosition)) {

            if (newPosition.charAt(0) < this.getPosition().charAt(0)) {
                x++;
                tempString[0] = String.valueOf(x);
                tempString[1] = yCoordinate(newPosition.charAt(1), y) +"";
                if (offside()) {
                    //EXCEPTION
                }
            } else if (newPosition.charAt(0) > this.getPosition().charAt(0)) {
                x--;
                tempString[0] = String.valueOf(x);
                tempString[1] = yCoordinate(newPosition.charAt(1), y) +"";

                if (offside()) {
                    //EXCEPTION
                }
            }
        }

    }

    public int yCoordinate(char newPos, int y){
        if (newPos < this.getPosition().charAt(1)) {
            return y++;
        } else  return y--;
    }
    */
}


