package com.company;


import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {
        Board board = new Board();
        System.out.println(board.toString());



    board.move("H8", "H6");

        board.check();

        System.out.println(board.toString());

    }
}

