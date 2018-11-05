package com.company.model;


import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.util.*;

public class Board implements Saveable{

    List<ChessPiece> pieces = new ArrayList<ChessPiece>();


    Stack<Chessturn> stackTurns = new Stack<>();



    public Board(JsonObject saveData){
            JsonArray activePieces = saveData.getJsonArray("activePieces");
            for(int i = 0; i < activePieces.size(); i++){
                JsonObject piece = activePieces.getJsonObject(i);
                ChessPiece e = ChessPiece.fromSaveData(piece);
                pieces.add(e);
            }
    }


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

    public void move(Class type, ChessPiece.Color color, String targetPosition) throws Exception {

        for (ChessPiece piece : pieces) {
            if (type.isInstance(piece) && piece.getColor().equals(color)) {
                String oldPosition = piece.getPosition();
                move(oldPosition, targetPosition);
                break;
            }
        }


    }

    public void move(String oldPosition, String newPosition) throws Exception {

        //Check if there is a piece at the old position
        if (!isPieceAtPosition(oldPosition)) {
            throw new IllegalArgumentException("oldPosition");
        }

        ChessPiece piece = atPosition(oldPosition);


        //Check for obstacle for Rook, Bishop, Queen
        if (piece.getClass() == Rook.class
                || piece.getClass() == Bishop.class || piece.getClass() == Queen.class) {

            String startPosition = piece.getPosition();
            char x = Character.toUpperCase(startPosition.charAt(0));
            char y = startPosition.charAt(1);

            char sX  = x;
            char sY = y;

            char newPosX = newPosition.charAt(0);
            char newPosY = newPosition.charAt(1);

            boolean directionX = true;
            boolean directionY = true;

            if(x > newPosX){
                directionX = false;
            }

            if(y > newPosY){
                directionY = false;
            }


            while (!(startPosition.charAt(0) == newPosX) && !(startPosition.charAt(1) == newPosY)) {
                if (directionX && (x < newPosX - 1 || (sX == x && sX != newPosX))) {
                    x++;
                }
                else if(!directionX && x > newPosX - 1 ||   ((sX == x && sX != newPosX))){
                    x--;
                }

                if (directionY && (y < newPosY - 1 || (sY == y && sY != newPosY))) {
                    y++;
                }
                else if( !directionY && y > newPosY - 1 || (sY == y && sY != newPosY))
                {
                    y--;
                }
                startPosition = x + "" + y;
                if (isPieceAtPosition(startPosition)) {
                    throw new IllegalChessMoveException("Another piece is in the way");
                }

            }
        }

        //Check color / Remove piece
        if (isPieceAtPosition(newPosition)) {
            ChessPiece other = atPosition(newPosition);

            if (other.getColor().equals(piece.getColor())) {
                throw new IllegalChessMoveException("Same color");
            } else {
                pieces.remove(other);
                if(piece.getClass() == Pawn.class){
                    ((Pawn) piece).moveIt(newPosition);
                } else piece.move(newPosition);
            }
        } else piece.move(newPosition);

        stackTurns.push(new Chessturn(piece.getColor(), oldPosition, newPosition));

    }


    public void undoTurn() throws Exception {

        if(stackTurns.empty()){
            throw new Exception("Stack is empty");
        }

        String old = stackTurns.peek().getToPos();
        for(ChessPiece piece : pieces){
            if(piece.isAtPosition(old)){
                piece.move(stackTurns.peek().getFromPos());
                stackTurns.pop();
            }
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


    @Override
    public JsonObject getSaveData() {
        JsonObject result = new JsonObject();
        JsonArray pieces = new JsonArray();
        for(ChessPiece piece : this.pieces){
            pieces.add(piece.getSaveData());
        }
        result.put("activePieces", pieces);
        return result;
    }
}



