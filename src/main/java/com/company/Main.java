    package com.company;


    import com.company.model.Board;
    import com.company.model.IllegalChessMoveException;
    import io.vertx.core.json.JsonObject;
    import javafx.application.Application;
    import javafx.fxml.FXMLLoader;
    import javafx.scene.Parent;
    import javafx.scene.Scene;
    import javafx.scene.media.Media;
    import javafx.scene.media.MediaPlayer;
    import javafx.stage.FileChooser;
    import javafx.stage.Stage;

    import java.awt.*;
    import java.io.*;
    import java.util.Scanner;


    public class Main extends Application {

        public static Stage primaryStage;

        @Override
        public void start(Stage primaryStage) throws Exception {
            Main.primaryStage = primaryStage;
            Parent root = FXMLLoader.load(getClass().getResource("/ui/board.fxml"));
            primaryStage.setScene(new Scene(root));
            primaryStage.show();

        }



        public static void main(String[] args) throws Exception {


            launch(args);
        }

    }

