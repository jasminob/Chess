package com.company.ui;

import com.company.model.ChessPiece;
import javafx.scene.image.ImageView;

public class UiKing extends UiChessPiece{

    public UiKing(ChessPiece piece) {
        super(piece, new ImageView(UiChessPiece.getPathForPiece(piece)));
    }
}
