package com.company.model;


import io.vertx.core.json.JsonObject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public abstract class ChessPiece implements Saveable {

    public enum Color {
        Black,
        White
    }

    private String position;
    private Color color;

    public static ChessPiece fromSaveData(JsonObject saveData) {

        try {
            Class<? extends ChessPiece> pieceClass = (Class<? extends ChessPiece>) Class.forName(saveData.getString("piece"));

            String position = saveData.getString("position");
            Color color = Color.valueOf(saveData.getString("color"));

            Constructor<? extends ChessPiece> constructor = pieceClass.getConstructor(String.class, Color.class);
            ChessPiece currentChessPiece = constructor.newInstance(position, color);

            return currentChessPiece;

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            return null;
        }


    }




    public ChessPiece(String position, ChessPiece.Color color) {
        this.position = position;
        this.color = color;
    }

    private ChessPiece(JsonObject saveData){
    }

    public ChessPiece(){

    }


    public Color getColor() {
        return color;
    }

    public String getPosition() {
        return position;
    }


    public boolean isAtPosition(String pos){
        if(this.position.equalsIgnoreCase(pos)){
            return true;
        }
        return false;
    }

    public void move(String position) throws Exception {
        if (!validNewPosition(position)) {
            throw new Exception("Pozicija nije ok");
        } else {
            this.position = position;
        }
    }

   public boolean validNewPosition(String position) throws Exception {

        if (position.length() < 2) {
            throw new Exception("Format nije dure");
        }

       position = position.toLowerCase();
        char x = position.charAt(0);
        char y = position.charAt(1);
        if ((x >= 97 && x <= 122)
                && (y >= 49 && y <= 56)) {
            return true;
        } else return false;

    }

    @Override
    public  JsonObject getSaveData(){
        return new JsonObject()
                .put("piece", this.getClass().getCanonicalName())
                .put("position", this.getPosition())
                .put("color", this.getColor());
    }

    @Override
    public String toString() {
        return "ChessPiece{" +
                "position='" + position + '\'' +
                '}';
    }
}


