package com.company.model;

import io.reactivex.Observable;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.core.buffer.Buffer;
import io.vertx.reactivex.ext.web.client.HttpRequest;
import io.vertx.reactivex.ext.web.client.WebClient;
import javafx.application.Platform;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public class OnlineBoard extends Board {
    private final static String HOST = "http://localhost:8080";
    private final static String URL_CREATE_GAME = HOST + "/createGame";
    private final static String URL_CREATE_CHESS_TURN = HOST + "/createChessTurn";
    private final static String URL_CREATE_PLAYER = HOST + "/createPlayer";
    private final static String URL_JOIN_GAME = HOST + "/getGameById/";
    private final static String URL_GET_TURNS = HOST + "/getTurns/";
    private final static String URL_GET_PLAYER = HOST + "/getPlayerById/";

    WebClient client;
    Vertx vertx = Vertx.vertx();


    JsonObject gameObject;
    JsonObject playerObject;
    JsonObject lastTurn;


    Runnable refresher;
    Consumer<ChessPiece> eater;

    public OnlineBoard(Runnable refresher, Consumer<ChessPiece> eater) {
        client = WebClient.create(vertx);
        this.refresher = refresher;
        this.eater = eater;
        gameObject = post(URL_CREATE_GAME);
        playerObject = joinGame(getGameId(), ChessPiece.Color.White);

        Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(e -> {
                    JsonObject lastTurn = getLastTurn();
                    if (this.lastTurn == null && lastTurn == null) {
                        //IDLE
                    } else if (this.lastTurn == null && lastTurn != null) {
                        moveOnline(lastTurn.getString("from_pos"), lastTurn.getString("to_pos"));
                    } else if (this.lastTurn.equals(lastTurn)) {
                        //SYNCED
                    } else {
                        System.out.println(this.lastTurn.encode());
                        System.out.println("vs");
                        System.out.println(lastTurn.encode());
                        moveOnline(lastTurn.getString("from_pos"), lastTurn.getString("to_pos"));
                    }
                });
    }

    public UUID getPass() {
        return UUID.fromString(playerObject.getString("pass"));
    }

    public UUID getGameId() {
        return UUID.fromString(gameObject.getString("id"));
    }

    public void joinGame(UUID gameId, UUID playerId) throws Exception {

        if(playerId == null) {
            playerObject = joinGame(gameId, ChessPiece.Color.Black);
        }
        else {
            playerObject = get(URL_GET_PLAYER + playerId.toString());
        }
        gameObject = get(URL_JOIN_GAME + gameId.toString());
        resumeOnline();
    }


    public JsonObject getLastTurn() {

        JsonArray lTurn = getArray(URL_GET_TURNS + getGameId() + "/" + 1);

        if (lTurn.size() < 1) {
            return null;
        } else return lTurn.getJsonObject(0);
    }

    private void resumeOnline() throws Exception {
        JsonArray allTurns = getArray(URL_GET_TURNS + getGameId() + "/" + -1);
        for ( int i = allTurns.size() - 1; i >= 0; -- i ) {
            JsonObject turn = allTurns.getJsonObject(i);
            lastTurn = turn;

            atPosition(turn.getString("from_pos")).move(turn.getString("to_pos"));
        }

        refresher.run();
    }

    public ChessPiece.Color getMyColor() {
        String color = playerObject.getString("color");

        return ChessPiece.Color.valueOf(color);
    }

    private JsonObject joinGame(UUID gameId, ChessPiece.Color color) {
        return post(
                URL_CREATE_PLAYER,
                new JsonObject().put("gameId", gameId.toString()).put("color", color.toString())
        );
    }

    private void moveOnline(String oldPosition, String newPosition) throws Exception {
        super.move(oldPosition, newPosition, eater);
        this.lastTurn = getLastTurn();

        Platform.runLater(refresher);
    }

    public void moveLocal(String oldPosition, String newPosition, Consumer<ChessPiece> onEat) throws Exception {

        String color = whoseTurn().toString();
        String oldPo = oldPosition;
        String newPos = newPosition;
        String gameId = getGameId().toString();
        String passId = getPass().toString();

        super.move(oldPosition, newPosition, onEat);

        post(URL_CREATE_CHESS_TURN, new JsonObject()
                .put("color", color)
                .put("fromPos", oldPo )
                .put("toPos", newPos)
                .put("gameId", gameId)
                .put("pass", passId)
        );

        this.lastTurn = getLastTurn();

    }

    @Override
    public void move(String oldPosition, String newPosition, Consumer<ChessPiece> onEat) throws Exception {
        if (!whoseTurn().equals(getMyColor())) {
            throw new Exception("Not my turn!");
        }

        this.moveLocal(oldPosition, newPosition, onEat);
    }


    private JsonObject post(String url) {
        return post(url, null);
    }

    private JsonObject post(String url, JsonObject body) {
        HttpRequest<Buffer> request = client.postAbs(url).putHeader("Content-Type", "application/json");

        if (body == null)
            return request.rxSend().blockingGet().bodyAsJsonObject();
        else {
            return request.rxSendJson(body).blockingGet().bodyAsJsonObject();
        }
    }

    private JsonObject get(String url) {
        return client.getAbs(url).rxSend().blockingGet().bodyAsJsonObject();
    }

    private JsonArray getArray(String url) {
        return client.getAbs(url).rxSend().blockingGet().bodyAsJsonArray();
    }
}
