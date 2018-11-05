package com.company.ui;

import com.company.model.Board;
import com.company.model.ChessPiece;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BoardController implements Initializable {
    Board board = new Board();
    List<UiChessPiece> pieces = new ArrayList<>();

    List<ImageView> cells = new ArrayList<>();
    
    public BoardController() {
        for(ChessPiece piece : board.getPieces()){
            pieces.add(UiChessPiece.forChessPiece(piece));
        }

        refresh();
    }

    public void refresh(){
        for (UiChessPiece piece : pieces) {
            piece.refresh();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
