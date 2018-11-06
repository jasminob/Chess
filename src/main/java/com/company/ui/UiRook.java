package com.company.ui;

import com.company.model.ChessPiece;
import javafx.scene.image.ImageView;

public class UiRook extends UiChessPiece{

    public UiRook(ChessPiece piece, BoardController boardController) {
        super(piece, new ImageView(UiChessPiece.getPathForPiece(piece)), boardController);
    }
}
