package com.company.ui;

import com.company.model.*;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public abstract class UiChessPiece {
    private ChessPiece piece;
    private ImageView image;
    private BoardController boardController;

    public static UiChessPiece forChessPiece(ChessPiece piece, BoardController boardController) {

        if (piece.getClass().equals(Pawn.class)) {
            return new UiPawn(piece, boardController);
        } else if (piece.getClass().equals(Rook.class)) {
            return new UiRook(piece, boardController);
        } else if (piece.getClass().equals(Knight.class)) {
            return new UiKnight(piece, boardController);
        } else if (piece.getClass().equals(Bishop.class)) {
            return new UiBishop(piece, boardController);
        } else if (piece.getClass().equals(Queen.class)) {
            return new UiQueen(piece, boardController);
        } else return new UiKing(piece, boardController);
    }

    public static boolean isWhite(ChessPiece piece) {
        if (piece.getColor().equals(ChessPiece.Color.White)) {
            return true;
        }
        return false;
    }

    //Lacks sauce
    protected static String getPathForPiece(ChessPiece piece) {

        if (piece.getClass().equals(King.class)) {
            if (isWhite(piece)) {
                return "/w_king_png_256px.png";
            }
            return "/b_king_png_256px.png";
        } else if (piece.getClass().equals(Queen.class)) {
            if (isWhite(piece)) {
                return "/w_queen_png_256px.png";
            }
            return "/b_queen_png_256px.png";
        } else if (piece.getClass().equals(Rook.class)) {
            if (isWhite(piece)) {
                return "/w_rook_png_256px.png";
            }
            return "/b_rook_png_256px.png";
        } else if (piece.getClass().equals(Knight.class)) {
            if (isWhite(piece)) {
                return "/w_knight_png_256px.png";
            }
            return "/b_knight_png_256px.png";
        } else if (piece.getClass().equals(Pawn.class)) {
            if (isWhite(piece)) {
                return "/w_pawn_png_256px.png";
            }
            return "/b_pawn_png_256px.png";
        } else if (piece.getClass().equals(Bishop.class)) {
            if (isWhite(piece)) {
                return "/w_bishop_png_256px.png";
            }
            return "/b_bishop_png_256px.png";
        }

        return null;
    }


    public void refresh() {
        String pos = getPiece().getPosition();

        if ( image.getParent() != null ) {
            AnchorPane oldPane = (AnchorPane) image.getParent();
            oldPane.getChildren().remove(image);
        }

        ImageView cell = boardController.getCellByPosition(pos);

        AnchorPane pane = (AnchorPane) cell.getParent();

        pane.getChildren().add(image);
    }

    public UiChessPiece(ChessPiece piece, ImageView image, BoardController boardController) {
        this.piece = piece;
        this.image = image;
        this.boardController = boardController;
        image.setFitWidth(40);
        image.setFitHeight(40);
        image.setX(15);
        image.setY(15);

        image.setMouseTransparent(true);
    }

    public ChessPiece getPiece() {
        return piece;
    }

    public ImageView getImage() {
        return image;
    }

    protected ImageView getColorPic(ChessPiece piece, String white, String black) {

        if (piece.getColor().equals(ChessPiece.Color.White)) {
            return new ImageView(white);
        }
        return new ImageView(black);
    }

    public void mark(){
        image.setEffect(new ColorAdjust(1, 0.62, -0.55, 0.36));
    }

    public boolean isMarked(){
        return image.getEffect() != null;
    }

    public void unmark(){
        image.setEffect(null);
    }
}
