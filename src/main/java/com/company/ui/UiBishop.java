package com.company.ui;

import com.company.model.ChessPiece;
import javafx.scene.image.ImageView;

public class UiBishop extends UiChessPiece{

    public UiBishop(ChessPiece piece, BoardController boardController) {
        super(piece, new ImageView(UiChessPiece.getPathForPiece(piece)), boardController);
    }
}
