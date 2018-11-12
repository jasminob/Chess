package com.company.model;

import io.reactivex.Observable;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.core.buffer.Buffer;
import io.vertx.reactivex.ext.web.client.HttpRequest;
import io.vertx.reactivex.ext.web.client.WebClient;

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

    WebClient client;
    Vertx vertx = Vertx.vertx();



    JsonObject gameObject;
    JsonObject playerObject;
    JsonObject lastTurn;

    public OnlineBoard() {
        client = WebClient.create(vertx);

        gameObject = post(URL_CREATE_GAME);
        playerObject = joinGame(getGameId(), ChessPiece.Color.White);

        Observable.interval(5, TimeUnit.SECONDS)
                .subscribe( e-> {
                   JsonObject lastTurn = getLastTurn();
                    if(this.lastTurn == null && lastTurn == null){
                        //IDLE
                    }
                    else if(this.lastTurn == null && lastTurn != null){
                        move(lastTurn.getString("fromPos"), lastTurn.getString("toPos"));
                        this.lastTurn = lastTurn;
                    }
                    else if(this.lastTurn.equals(lastTurn)){
                        //SYNCED
                    }
                    else {
                        move(lastTurn.getString("fromPos"), lastTurn.getString("toPos"));
                        this.lastTurn = lastTurn;
                    }
                });
    }

    public UUID getPass(){
        return UUID.fromString(playerObject.getString("pass"));
    }

    public UUID getGameId() {
        return UUID.fromString(gameObject.getString("id"));
    }

    public void joinGame(UUID gameId){
        playerObject = joinGame(gameId, ChessPiece.Color.Black);
        gameObject = get(URL_JOIN_GAME + gameId.toString());
    }


    public JsonObject getLastTurn(){

        JsonArray lTurn = getArray(URL_GET_TURNS + getGameId() + "/" + 1);

        if(lTurn.size() < 1)
        {
            return null;
        }
        else return lTurn.getJsonObject(0);
    }


    private JsonObject joinGame(UUID gameId, ChessPiece.Color color){
       return post(
                URL_CREATE_PLAYER,
                new JsonObject().put("gameId", gameId.toString()).put("color", color.toString())
        );
    }

    @Override
    public void move(String oldPosition, String newPosition, Consumer<ChessPiece> onEat) throws Exception {
        post(URL_CREATE_CHESS_TURN, new JsonObject()
                .put("color", whoseTurn().toString())
                .put("fromPos", oldPosition)
                .put("toPos", newPosition)
                .put("gameId", getGameId().toString())
                .put("pass", getPass().toString())
        );

        super.move(oldPosition, newPosition, onEat);
    }



    private JsonObject post(String url) {
        return post(url, null);
    }

    private JsonObject post(String url, JsonObject body) {
        HttpRequest<Buffer> request = client.postAbs(url).putHeader("Content-Type", "application/json");

        if ( body == null )
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