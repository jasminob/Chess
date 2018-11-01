package com.company;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Board {

    List<ChessPiece> pieces = new ArrayList<>();


    public Board() {

        //Rooks
        pieces.add(new Rook("A1", ChessPiece.Color.White));
        pieces.add(new Rook("H1", ChessPiece.Color.White));

        pieces.add(new Rook("A8", ChessPiece.Color.Black));
        pieces.add(new Rook("H8", ChessPiece.Color.Black));

        //Knights
        pieces.add(new Knight("B1", ChessPiece.Color.White));
        pieces.add(new Knight("G1", ChessPiece.Color.White));

        pieces.add(new Knight("D3", ChessPiece.Color.Black));
        pieces.add(new Knight("G8", ChessPiece.Color.Black));

        //Bishop
        pieces.add(new Bishop("C1", ChessPiece.Color.White));
        pieces.add(new Bishop("F1", ChessPiece.Color.White));

        pieces.add(new Bishop("C8", ChessPiece.Color.Black));
        pieces.add(new Bishop("F8", ChessPiece.Color.Black));


        //Queen
        pieces.add(new Queen("D1", ChessPiece.Color.White));
        pieces.add(new Queen("D8", ChessPiece.Color.Black));


        //King
        pieces.add(new King("E1", ChessPiece.Color.White));
        pieces.add(new King("E8", ChessPiece.Color.Black));

        //Pawns
        pieces.add(new Pawn("A2", ChessPiece.Color.White));
        pieces.add(new Pawn("B2", ChessPiece.Color.White));
        pieces.add(new Pawn("C2", ChessPiece.Color.White));
        pieces.add(new Pawn("D2", ChessPiece.Color.White));
        pieces.add(new Pawn("E2", ChessPiece.Color.White));
        pieces.add(new Pawn("F2", ChessPiece.Color.White));
        pieces.add(new Pawn("G2", ChessPiece.Color.White));
        pieces.add(new Pawn("H2", ChessPiece.Color.White));

        pieces.add(new Pawn("A7", ChessPiece.Color.Black));
        pieces.add(new Pawn("B7", ChessPiece.Color.Black));
        pieces.add(new Pawn("C7", ChessPiece.Color.Black));
        pieces.add(new Pawn("D7", ChessPiece.Color.Black));
        pieces.add(new Pawn("E7", ChessPiece.Color.Black));
        pieces.add(new Pawn("F7", ChessPiece.Color.Black));
        pieces.add(new Pawn("G7", ChessPiece.Color.Black));
        pieces.add(new Pawn("H7", ChessPiece.Color.Black));

    }

    public void move(Class type, ChessPiece.Color color, String targetPosition) throws Exception {


        boolean check = false;
        for (ChessPiece piece : pieces) {
            if (type.isInstance(piece) && piece.getColor().equals(color)) {
                move(piece.getPosition(), targetPosition);
            }
        }


    }

    public void move(String oldPosition, String newPosition) throws Exception {

        //Check if there is a piece at the old position
        if (!isPieceAtPosition(oldPosition)) {
            throw new IllegalArgumentException("oldPosition");
        }

        ChessPiece piece = atPosition(oldPosition);
        boolean check = false;

        //Check color / Remove piece
        if (isPieceAtPosition(newPosition)) {
            ChessPiece other = atPosition(newPosition);

            if (other.getColor().equals(piece.getColor())) {
                throw new IllegalChessMoveException("Same color");
            } else {
                pieces.remove(other);
            }
        }

        // Obstacle
        if (piece.getClass() == Rook.class || piece.getClass() == Pawn.class
                || piece.getClass() == Bishop.class || piece.getClass() == Queen.class) {

            String startPosition = piece.getPosition();
            char x = startPosition.charAt(0);
            char y = startPosition.charAt(1);

            while (!startPosition.equals(newPosition)) {
                if (x < newPosition.charAt(0) - 1) {
                    x++;
                }
                if (y < newPosition.charAt(1) - 1) {
                    y++;
                }
                startPosition = x + "" + y;
                if (isPieceAtPosition(oldPosition)) {
                    throw new IllegalChessMoveException("Another piece is in the way");
                }
            }
        }
        piece.move(newPosition);
        check = true;


        if (!check) {
            throw new IllegalChessMoveException("No piece found");
        }
    }

    public boolean isCheck(ChessPiece.Color color) throws Exception {

        String kingPosition = "";
        for (ChessPiece piece : pieces) {

            //  if(piece.equals(King.Color.valueOf(color+""))){
            if (King.class.isInstance(piece) && piece.getColor().equals(color)) {
                kingPosition = piece.getPosition();
            }
        }

        for (ChessPiece piece : pieces) {
            if (!piece.getColor().equals(color)) {
                String currentPiecePosition = piece.getPosition();
                try {
                    piece.move(kingPosition);
                    if (currentPiecePosition != piece.getPosition()) {
                        piece.move(currentPiecePosition);
                        return true;
                    }
                } catch (IllegalChessMoveException e) {
                    System.out.println("Could not move " + piece.toString());
                }
            }
        }

        return false;
    }

    public void check() throws Exception {

        if (isCheck(ChessPiece.Color.White)) {
            System.out.println("Check, White");
        } else if (isCheck(ChessPiece.Color.Black)) {
                System.out.println("Check, Black");
        }

    }

    public boolean isPieceAtPosition(String position) {
        for (ChessPiece piece : pieces) {
            if (piece.getPosition().equalsIgnoreCase(position)) {
                return true;
            }
        }
        return false;

    }

    public ChessPiece atPosition(String position) {
        for (ChessPiece piece : pieces) {
            if (piece.getPosition().equalsIgnoreCase(position)) {
                return piece;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        String result = "";
        char c;
        String position;

        for (int i = 1; i <= 8; i++) {
            for (int j = 0; j < 8; j++) {
                c = (char) ('a' + j);
                position = c + "" + i;

                ChessPiece atPosition = atPosition(position);
                if (atPosition != null) {
                    result += atPosition.toString() + " ";
                } else {
                    result += "- ";
                }
            }
            result += "\n";
        }
        return result;
    }
}



