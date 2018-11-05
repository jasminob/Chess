package com.company.ui;

import com.company.model.ChessPiece;
import javafx.scene.image.ImageView;

public class UiPawn extends UiChessPiece{


    public UiPawn(ChessPiece piece) {
        super(piece, new ImageView(UiChessPiece.getPathForPiece(piece)));
    }




}
