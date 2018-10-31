package com.company;


import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {
        Board board = new Board();
        System.out.println(board.toString());




        board.move("b8", "a6");
        System.out.println(board.toString());

        board.move("a6", "c5");
        System.out.println(board.toString());

        board.move("c5", "d3");
        System.out.println(board.toString());


    }
}

