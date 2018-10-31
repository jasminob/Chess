package com.company;


import java.util.ArrayList;
import java.util.List;

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

        pieces.add(new Knight("B8", ChessPiece.Color.Black));
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

    public void move(Class type, ChessPiece.Color color, String position) throws Exception {

        boolean check = false;

        for (ChessPiece piece : pieces) {
            if (type.isInstance(piece) && piece.getColor().equals(color)) {

                if (isPieceAtPosition(position)) {
                    for (ChessPiece piece1 : pieces) {
                        if (piece1.getColor().equals(color)) {
                            throw new IllegalChessMoveException();
                        } else {
                            piece1 = null;
                        }
                    }
                }

                piece.move(position);
                check = true;
                break;
            }
        }

        if (!check) {
            throw new IllegalChessMoveException();
        }




   /*    if (type.isInstance(Rook.class) || type.isInstance(Queen.class) || type.isInstance(Bishop.class)
                || type.isInstance(Pawn.class)) {
            //Dunno for loop?
            String startPosition = piece.getPosition();
            char x = startPosition.charAt(0);
            char y = startPosition.charAt(1);

            while (!startPosition.equals(position)) {
                if (x < position.charAt(0) - 1) {
                    x++;
                }
                if (y < position.charAt(1) - 1) {
                    y++;
                }
                startPosition = x + y + "";
                if (isPieceAtPosition(startPosition)) {
                    throw new IllegalChessMoveException();
                }
            }
        }
        */
    }

    public void move(String oldPosition, String newPosition) throws Exception {

        ChessPiece piece = atPosition(oldPosition);

        if (!isPieceAtPosition(oldPosition)) {
            throw new IllegalArgumentException("oldPosition");
        } else {
            piece.move(newPosition);
        }


        if (isPieceAtPosition(newPosition)) {
            if (atPosition(newPosition).getColor().equals(piece)) {
                throw new IllegalChessMoveException();
            } else {
                //Dunno for loop?
                piece = null;
            }
        }
    }

    //boolean isCheck(ChessPiece.Color color) { }

    public boolean isPieceAtPosition(String position) {
        position.toLowerCase();
        for (ChessPiece piece : pieces) {
            if (piece.getPosition().equals(position)) {
                return true;
            }
        }
        return false;

    }

    public ChessPiece atPosition(String position) {
        position.toLowerCase();
        for (ChessPiece piece : pieces) {
            if (piece.getPosition().equals(position)) {
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
                position = "" + c + i;

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



