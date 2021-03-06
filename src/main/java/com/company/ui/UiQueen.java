package com.company.ui;

import com.company.model.Board;
import com.company.model.ChessPiece;
import javafx.scene.image.ImageView;

public class UiQueen extends UiChessPiece{

    public UiQueen(ChessPiece piece, BoardController boardController) {
        super(piece, new ImageView(UiChessPiece.getPathForPiece(piece)), boardController);
    }
}
