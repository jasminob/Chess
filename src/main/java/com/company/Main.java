package com.company;


import com.company.model.Board;
import com.company.model.IllegalChessMoveException;
import io.vertx.core.json.JsonObject;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;


public class Main extends Application {

    public static int counter = 1;
    public static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Main.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("ui/board.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static Board loadBoard() {
        try {

            FileInputStream stream = new FileInputStream("BoardState.json");
            Scanner in = new Scanner(stream);
            JsonObject object = new JsonObject(in.nextLine());
            Board oldBoard = new Board(object);
            return oldBoard;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void saveBoard(Board board) throws IOException {
        FileWriter out = new FileWriter("BoardState.json");
        out.write(board.getSaveData().toString());
        out.flush();
    }



//Load Last State

    public static Board loadLastBoard() {
        try {
            FileInputStream stream = new FileInputStream("LastBoardState.json");
            Scanner in = new Scanner(stream);
            JsonObject object = new JsonObject(in.nextLine());
            Board oldBoard = new Board(object);
            counter--;
            return oldBoard;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static void saveLastBoardState(Board board) throws IOException {
        FileWriter out = new FileWriter("LastBoardState.json");
        out.write(board.getSaveData().toString());
        out.flush();
    }



    public static void move(Board board, PrintStream out, Scanner in) throws Exception {
        try {
            saveLastBoardState(board);
            if (isWhiteTurn()) {
                out.println("It's White's turn. Type in the location where you want to move the piece: ");
                 board.move(in.nextLine(), in.nextLine());
                counter++;
            } else {
                out.println("It's Black's turn. Type in the location where you want to move the piece: ");
                  board.move(in.nextLine(), in.nextLine());
                counter++;
            }
            board.check();
        }
        catch (IllegalChessMoveException x){
        }
    }


    public static boolean isWhiteTurn() {
        if (counter % 2 != 0) {
            return true;
        } else {
            return false;
        }
    }


    public static String whoseTurn(){

        if(isWhiteTurn()){
            return  "It's White's turn. What do you want to do? \n";
        }
        else{
           return  "It's Black's turn. What do you want to do? \n";
        }
    }

    public static void surrender(PrintStream out){

        if(isWhiteTurn()){
            out.println(String.format("White has decided to surrender on turn %d", counter));
        }
        else {
            out.println(String.format("Black has decided to surrender on turn %d", counter));
        }
        return;
    }


    public static void main(String[] args) throws Exception {

        Board board = new Board();
        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;
        Scanner q = new Scanner(System.in);

        while (true) {
            System.out.println(board.toString() + "\n" +
                    whoseTurn()  +
                    "1. Save current state of the board\n" +
                    "2. Load last saved board state\n" +
                    "3. Next move\n" +
                    "4. Undo Last Turn\n" +
                    "5. Surrender \n" +
                    "6. Undo \n" +
                    "7. Exit\n"
            );
            int choice = q.nextInt();
            q.nextLine();
            switch (choice) {
                case 1:
                    saveBoard(board);
                    break;
                case 2:
                    board = loadBoard();
                    break;
                case 3:
                    move(board, out, in);
                    break;
                case 4:
                    board = loadLastBoard();
                    break;
                case 5:
                    surrender(out);
                    break;
                case 6:
                    board.undoTurn();
                    counter--;
                    break;
                case 7:
                    return;
            }
        }

    }

}

