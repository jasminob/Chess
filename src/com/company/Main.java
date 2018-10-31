package com.company;


import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {
        Board board = new Board();
        System.out.println(board.toString());


        board.move(Pawn.class, ChessPiece.Color.White, "g3");
        System.out.println(board.toString());

        board.move(Bishop.class, ChessPiece.Color.White, "g4");
        System.out.println(board.toString());


    }
}

