package com.company.model;


public class Chessturn{
    private ChessPiece.Color color;
    private String fromPos;
    private String toPos;

    public Chessturn(ChessPiece.Color color, String fromPos, String toPos) {
        this.color = color;
        this.fromPos = fromPos;
        this.toPos = toPos;
    }

    public ChessPiece.Color getColor() {
        return color;
    }

    public String getFromPos() {
        return fromPos;
    }

    public String getToPos() {
        return toPos;
    }

}
