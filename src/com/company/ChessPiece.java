package com.company;


abstract class ChessPiece {

    public enum Color {
        Black,
        White
    }

    private String position;

    public ChessPiece(String position, ChessPiece.Color color) {
        this.position = position;

    }

    public String getPosition() {
        return position.toLowerCase();
    }


    public void move(String position) throws Exception {

        if (validNewPosition(position)) {
            
        } else throw new Exception("Pozicija nije ok");
    }

    public boolean validNewPosition(String position) throws Exception {

        if (position.length() < 2) {
            throw new Exception("Format nije dure");
        }

        position.toLowerCase();
        if ((position.charAt(0) >= 'a' && position.charAt(0) <= 'z')
                && (position.charAt(1) >= 1 && position.charAt(1) <= 8)) {
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


