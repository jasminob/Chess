package com.company.ui;

import com.company.model.*;
import javafx.scene.image.ImageView;

public abstract class UiChessPiece  {
    private ChessPiece piece;
    private ImageView image;

    public static UiChessPiece forChessPiece(ChessPiece piece){

        if (piece.getClass().equals(Pawn.class)){
           return new UiPawn(piece);
        }
        else if(piece.getClass().equals(Rook.class)){
            return new UiRook(piece);
        }
        else if (piece.getClass().equals(Knight.class)){
            return new UiKnight(piece);
        }
        else if(piece.getClass().equals(Bishop.class)){
            return new UiBishop(piece);
        }
        else if(piece.getClass().equals(Queen.class)){
            return new UiQueen(piece);
        }
        else return new UiKing(piece);
    }

    public static boolean isWhite(ChessPiece piece){
        if(piece.getColor().equals(ChessPiece.Color.White)){
            return true;
        }
        return false;
    }

    //Lacks sauce
    protected static String getPathForPiece(ChessPiece piece){

        if(piece.getClass().equals(King.class)){
            if(isWhite(piece)){
                return "/w_king_png_256px.png";
            }
            return "/b_king_png_256px.png";
        }
        else if(piece.getClass().equals(Queen.class)){
            if(isWhite(piece)){
                return "/w_queen_png_256px.png";
            }
            return "/b_queen_png_256px.png";
        }

        else if(piece.getClass().equals(Rook.class)){
            if(isWhite(piece)){
                return "/w_rook_png_256px.png";
            }
            return "/b_rook_png_256px.png";
        }

        else if(piece.getClass().equals(Knight.class)){
            if(isWhite(piece)){
                return "/w_knight_png_256px.png";
            }
            return "/b_knight_png_256px.png";
        }

        else if(piece.getClass().equals(Pawn.class)){
            if(isWhite(piece)){
                return "/w_pawn_png_256px.png";
            }
            return "/b_pawn_png_256px.png";
        }

        else if(piece.getClass().equals(Bishop.class)){
            if(isWhite(piece)){
                return "/w_bishop_png_256px.png";
            }
            return "/b_bishop_png_256px.png";
        }

        return null;
    }


    public void refresh(){
        String pos = getPiece().getPosition();

        char x = pos.charAt(0);
        char y = pos.charAt(1);

        getImage().setX(x);
        getImage().setY(y);
    }

    public UiChessPiece(ChessPiece piece, ImageView image) {
        this.piece = piece;
        this.image = image;
    }

    public ChessPiece getPiece() {
        return piece;
    }

    public ImageView getImage() {
        return image;
    }

    protected ImageView getColorPic(ChessPiece piece, String white, String black){

        if(piece.getColor().equals(ChessPiece.Color.White)){
            return new ImageView(white);
        }
        return new ImageView(black);
    }



}
