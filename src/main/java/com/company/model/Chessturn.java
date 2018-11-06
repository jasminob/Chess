package com.company.model;


import io.vertx.core.json.JsonObject;

public class Chessturn implements Saveable {
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

    public static Chessturn fromSaveData(JsonObject object) {

        Chessturn chessturn = new Chessturn(ChessPiece.Color.valueOf(object.getString("color")),
                object.getString("fromPos"), object.getString("toPos"));

        return chessturn;

    }

    @Override
    public JsonObject getSaveData() {
        return new JsonObject()
                .put("color", this.color)
                .put("fromPos", this.fromPos)
                .put("toPos", this.toPos);
    }
}
