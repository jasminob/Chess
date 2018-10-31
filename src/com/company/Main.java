package com.company;


import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {
        Board board = new Board();
        System.out.println(board.toString());




        board.move("b8", "a6");
        board.move("a2", "a3");

        board.move(Pawn.class, ChessPiece.Color.White, "A3");
        System.out.println(board.toString());
    }
}

