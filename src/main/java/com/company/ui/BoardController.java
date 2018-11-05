package com.company.ui;

import com.company.model.Board;
import com.company.model.ChessPiece;
import javafx.fxml.FXML;
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

    @FXML private ImageView cell1x1;
    @FXML private ImageView cell1x2;
    @FXML private ImageView cell1x3;
    @FXML private ImageView cell1x4;
    @FXML private ImageView cell1x5;
    @FXML private ImageView cell1x6;
    @FXML private ImageView cell1x7;
    @FXML private ImageView cell1x8;
    @FXML private ImageView cell1x9;
    @FXML private ImageView cell1x10;


    @FXML private ImageView cell2x1;
    @FXML private ImageView cell2x2;
    @FXML private ImageView cell2x3;
    @FXML private ImageView cell2x4;
    @FXML private ImageView cell2x5;
    @FXML private ImageView cell2x6;
    @FXML private ImageView cell2x7;
    @FXML private ImageView cell2x8;
    @FXML private ImageView cell2x9;
    @FXML private ImageView cell2x10;

    @FXML private ImageView cell3x1;
    @FXML private ImageView cell3x2;
    @FXML private ImageView cell3x3;
    @FXML private ImageView cell3x4;
    @FXML private ImageView cell3x5;
    @FXML private ImageView cell3x6;
    @FXML private ImageView cell3x7;
    @FXML private ImageView cell3x8;
    @FXML private ImageView cell3x9;
    @FXML private ImageView cell3x10;

    @FXML private ImageView cell4x1;
    @FXML private ImageView cell4x2;
    @FXML private ImageView cell4x3;
    @FXML private ImageView cell4x4;
    @FXML private ImageView cell4x5;
    @FXML private ImageView cell4x6;
    @FXML private ImageView cell4x7;
    @FXML private ImageView cell4x8;
    @FXML private ImageView cell4x9;
    @FXML private ImageView cell4x10;

    @FXML private ImageView cell5x1;
    @FXML private ImageView cell5x2;
    @FXML private ImageView cell5x3;
    @FXML private ImageView cell5x4;
    @FXML private ImageView cell5x5;
    @FXML private ImageView cell5x6;
    @FXML private ImageView cell5x7;
    @FXML private ImageView cell5x8;
    @FXML private ImageView cell5x9;
    @FXML private ImageView cell5x10;

    @FXML private ImageView cell6x1;
    @FXML private ImageView cell6x2;
    @FXML private ImageView cell6x3;
    @FXML private ImageView cell6x4;
    @FXML private ImageView cell6x5;
    @FXML private ImageView cell6x6;
    @FXML private ImageView cell6x7;
    @FXML private ImageView cell6x8;
    @FXML private ImageView cell6x9;
    @FXML private ImageView cell6x10;

    @FXML private ImageView cell7x1;
    @FXML private ImageView cell7x2;
    @FXML private ImageView cell7x3;
    @FXML private ImageView cell7x4;
    @FXML private ImageView cell7x5;
    @FXML private ImageView cell7x6;
    @FXML private ImageView cell7x7;
    @FXML private ImageView cell7x8;
    @FXML private ImageView cell7x9;
    @FXML private ImageView cell7x10;

    @FXML private ImageView cell8x1;
    @FXML private ImageView cell8x2;
    @FXML private ImageView cell8x3;
    @FXML private ImageView cell8x4;
    @FXML private ImageView cell8x5;
    @FXML private ImageView cell8x6;
    @FXML private ImageView cell8x7;
    @FXML private ImageView cell8x8;
    @FXML private ImageView cell8x9;
    @FXML private ImageView cell8x10;

    @FXML private ImageView cell9x1;
    @FXML private ImageView cell9x2;
    @FXML private ImageView cell9x3;
    @FXML private ImageView cell9x4;
    @FXML private ImageView cell9x5;
    @FXML private ImageView cell9x6;
    @FXML private ImageView cell9x7;
    @FXML private ImageView cell9x8;
    @FXML private ImageView cell9x9;
    @FXML private ImageView cell9x10;

    @FXML private ImageView cell10x1;
    @FXML private ImageView cell10x2;
    @FXML private ImageView cell10x3;
    @FXML private ImageView cell10x4;
    @FXML private ImageView cell10x5;
    @FXML private ImageView cell10x6;
    @FXML private ImageView cell10x7;
    @FXML private ImageView cell10x8;
    @FXML private ImageView cell10x9;
    @FXML private ImageView cell10x10;

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
