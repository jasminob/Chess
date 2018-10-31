package com.company;


import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {
        Board board = new Board();
        System.out.println(board.toString());


        board.move(Pawn.class, ChessPiece.Color.White, "a3");
        board.move(Pawn.class, ChessPiece.Color.White, "a4");
        board.move(Pawn.class, ChessPiece.Color.White, "a5");
        board.move(Pawn.class, ChessPiece.Color.White, "a6");
        board.move(Pawn.class, ChessPiece.Color.White, "a7");
        System.out.println(board.toString());





    }
}

