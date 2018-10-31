package com.company;


import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {
        Board board = new Board();
        System.out.println(board.toString());


        board.move(Knight.class, ChessPiece.Color.White, "h3");
        System.out.println(board.toString());

        board.move(Knight.class, ChessPiece.Color.White, "g5");
        System.out.println(board.toString());


    }
}

