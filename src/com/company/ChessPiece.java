package com.company;


abstract class ChessPiece {

    public enum Color {
        Black,
        White
    }

    private String position;
    private Color color;
    public ChessPiece(String position, ChessPiece.Color color) {
        this.position = position;
        this.color = color;
    }

    public ChessPiece(){

    }

    public Color getColor() {
        return color;
    }

    public String getPosition() {
        return position.toLowerCase();
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
    public String toString() {
        return "ChessPiece{" +
                "position='" + position + '\'' +
                '}';
    }
}


