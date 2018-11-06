package com.company.ui;

import com.company.Main;
import com.company.model.Board;
import com.company.model.ChessPiece;
import com.company.model.Chessturn;
import com.sun.org.apache.regexp.internal.RE;
import io.vertx.core.json.JsonObject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import java.io.*;
import java.net.URL;
import java.util.*;

public class BoardController implements Initializable {
    Board board = new Board();
    List<UiChessPiece> pieces = new ArrayList<>();

    List<ImageView> cells = new ArrayList<>();

    @FXML
    private ImageView cell1x1;
    @FXML
    private ImageView cell1x2;
    @FXML
    private ImageView cell1x3;
    @FXML
    private ImageView cell1x4;
    @FXML
    private ImageView cell1x5;
    @FXML
    private ImageView cell1x6;
    @FXML
    private ImageView cell1x7;
    @FXML
    private ImageView cell1x8;
    @FXML
    private ImageView cell1x9;
    @FXML
    private ImageView cell1x10;


    @FXML
    private ImageView cell2x1;
    @FXML
    private ImageView cell2x2;
    @FXML
    private ImageView cell2x3;
    @FXML
    private ImageView cell2x4;
    @FXML
    private ImageView cell2x5;
    @FXML
    private ImageView cell2x6;
    @FXML
    private ImageView cell2x7;
    @FXML
    private ImageView cell2x8;
    @FXML
    private ImageView cell2x9;
    @FXML
    private ImageView cell2x10;

    @FXML
    private ImageView cell3x1;
    @FXML
    private ImageView cell3x2;
    @FXML
    private ImageView cell3x3;
    @FXML
    private ImageView cell3x4;
    @FXML
    private ImageView cell3x5;
    @FXML
    private ImageView cell3x6;
    @FXML
    private ImageView cell3x7;
    @FXML
    private ImageView cell3x8;
    @FXML
    private ImageView cell3x9;
    @FXML
    private ImageView cell3x10;

    @FXML
    private ImageView cell4x1;
    @FXML
    private ImageView cell4x2;
    @FXML
    private ImageView cell4x3;
    @FXML
    private ImageView cell4x4;
    @FXML
    private ImageView cell4x5;
    @FXML
    private ImageView cell4x6;
    @FXML
    private ImageView cell4x7;
    @FXML
    private ImageView cell4x8;
    @FXML
    private ImageView cell4x9;
    @FXML
    private ImageView cell4x10;

    @FXML
    private ImageView cell5x1;
    @FXML
    private ImageView cell5x2;
    @FXML
    private ImageView cell5x3;
    @FXML
    private ImageView cell5x4;
    @FXML
    private ImageView cell5x5;
    @FXML
    private ImageView cell5x6;
    @FXML
    private ImageView cell5x7;
    @FXML
    private ImageView cell5x8;
    @FXML
    private ImageView cell5x9;
    @FXML
    private ImageView cell5x10;

    @FXML
    private ImageView cell6x1;
    @FXML
    private ImageView cell6x2;
    @FXML
    private ImageView cell6x3;
    @FXML
    private ImageView cell6x4;
    @FXML
    private ImageView cell6x5;
    @FXML
    private ImageView cell6x6;
    @FXML
    private ImageView cell6x7;
    @FXML
    private ImageView cell6x8;
    @FXML
    private ImageView cell6x9;
    @FXML
    private ImageView cell6x10;

    @FXML
    private ImageView cell7x1;
    @FXML
    private ImageView cell7x2;
    @FXML
    private ImageView cell7x3;
    @FXML
    private ImageView cell7x4;
    @FXML
    private ImageView cell7x5;
    @FXML
    private ImageView cell7x6;
    @FXML
    private ImageView cell7x7;
    @FXML
    private ImageView cell7x8;
    @FXML
    private ImageView cell7x9;
    @FXML
    private ImageView cell7x10;

    @FXML
    private ImageView cell8x1;
    @FXML
    private ImageView cell8x2;
    @FXML
    private ImageView cell8x3;
    @FXML
    private ImageView cell8x4;
    @FXML
    private ImageView cell8x5;
    @FXML
    private ImageView cell8x6;
    @FXML
    private ImageView cell8x7;
    @FXML
    private ImageView cell8x8;
    @FXML
    private ImageView cell8x9;
    @FXML
    private ImageView cell8x10;

    @FXML
    private ImageView cell9x1;
    @FXML
    private ImageView cell9x2;
    @FXML
    private ImageView cell9x3;
    @FXML
    private ImageView cell9x4;
    @FXML
    private ImageView cell9x5;
    @FXML
    private ImageView cell9x6;
    @FXML
    private ImageView cell9x7;
    @FXML
    private ImageView cell9x8;
    @FXML
    private ImageView cell9x9;
    @FXML
    private ImageView cell9x10;

    @FXML
    private ImageView cell10x1;
    @FXML
    private ImageView cell10x2;
    @FXML
    private ImageView cell10x3;
    @FXML
    private ImageView cell10x4;
    @FXML
    private ImageView cell10x5;
    @FXML
    private ImageView cell10x6;
    @FXML
    private ImageView cell10x7;
    @FXML
    private ImageView cell10x8;
    @FXML
    private ImageView cell10x9;
    @FXML
    private ImageView cell10x10;
    @FXML
    private TextArea turnLog;


    public ImageView getCellByPosition(String position) {

        position = position.toUpperCase();
        char x = position.charAt(0);
        char y = position.charAt(1);

        int cellX = x - 64;
        int cellY = y - 48;

        if (cellX == 1 && cellY == 1) {
            return cell2x2;
        } else if (cellX == 1 && cellY == 2) {
            return cell2x3;
        } else if (cellX == 1 && cellY == 3) {
            return cell2x4;
        } else if (cellX == 1 && cellY == 4) {
            return cell2x5;
        } else if (cellX == 1 && cellY == 5) {
            return cell2x6;
        } else if (cellX == 1 && cellY == 6) {
            return cell2x7;
        } else if (cellX == 1 && cellY == 7) {
            return cell2x8;
        } else if (cellX == 1 && cellY == 8) {
            return cell2x9;
        }

        if (cellX == 2 && cellY == 1) {
            return cell3x2;
        } else if (cellX == 2 && cellY == 2) {
            return cell3x3;
        } else if (cellX == 2 && cellY == 3) {
            return cell3x4;
        } else if (cellX == 2 && cellY == 4) {
            return cell3x5;
        } else if (cellX == 2 && cellY == 5) {
            return cell3x6;
        } else if (cellX == 2 && cellY == 6) {
            return cell3x7;
        } else if (cellX == 2 && cellY == 7) {
            return cell3x8;
        } else if (cellX == 2 && cellY == 8) {
            return cell3x9;
        }

        if (cellX == 3 && cellY == 1) {
            return cell4x2;
        } else if (cellX == 3 && cellY == 2) {
            return cell4x3;
        } else if (cellX == 3 && cellY == 3) {
            return cell4x4;
        } else if (cellX == 3 && cellY == 4) {
            return cell4x5;
        } else if (cellX == 3 && cellY == 5) {
            return cell4x6;
        } else if (cellX == 3 && cellY == 6) {
            return cell4x7;
        } else if (cellX == 3 && cellY == 7) {
            return cell4x8;
        } else if (cellX == 3 && cellY == 8) {
            return cell4x9;
        }

        if (cellX == 4 && cellY == 1) {
            return cell5x2;
        } else if (cellX == 4 && cellY == 2) {
            return cell5x3;
        } else if (cellX == 4 && cellY == 3) {
            return cell5x4;
        } else if (cellX == 4 && cellY == 4) {
            return cell5x5;
        } else if (cellX == 4 && cellY == 5) {
            return cell5x6;
        } else if (cellX == 4 && cellY == 6) {
            return cell5x7;
        } else if (cellX == 4 && cellY == 7) {
            return cell5x8;
        } else if (cellX == 4 && cellY == 8) {
            return cell5x9;
        }


        if (cellX == 5 && cellY == 1) {
            return cell6x2;
        } else if (cellX == 5 && cellY == 2) {
            return cell6x3;
        } else if (cellX == 5 && cellY == 3) {
            return cell6x4;
        } else if (cellX == 5 && cellY == 4) {
            return cell6x5;
        } else if (cellX == 5 && cellY == 5) {
            return cell6x6;
        } else if (cellX == 5 && cellY == 6) {
            return cell6x7;
        } else if (cellX == 5 && cellY == 7) {
            return cell6x8;
        } else if (cellX == 5 && cellY == 8) {
            return cell6x9;
        }

        if (cellX == 6 && cellY == 1) {
            return cell7x2;
        } else if (cellX == 6 && cellY == 2) {
            return cell7x3;
        } else if (cellX == 6 && cellY == 3) {
            return cell7x4;
        } else if (cellX == 6 && cellY == 4) {
            return cell7x5;
        } else if (cellX == 6 && cellY == 5) {
            return cell7x6;
        } else if (cellX == 6 && cellY == 6) {
            return cell7x7;
        } else if (cellX == 6 && cellY == 7) {
            return cell7x8;
        } else if (cellX == 6 && cellY == 8) {
            return cell7x9;
        }

        if (cellX == 7 && cellY == 1) {
            return cell8x2;
        } else if (cellX == 7 && cellY == 2) {
            return cell8x3;
        } else if (cellX == 7 && cellY == 3) {
            return cell8x4;
        } else if (cellX == 7 && cellY == 4) {
            return cell8x5;
        } else if (cellX == 7 && cellY == 5) {
            return cell8x6;
        } else if (cellX == 7 && cellY == 6) {
            return cell8x7;
        } else if (cellX == 7 && cellY == 7) {
            return cell8x8;
        } else if (cellX == 7 && cellY == 8) {
            return cell8x9;
        }


        if (cellX == 8 && cellY == 1) {
            return cell9x2;
        } else if (cellX == 8 && cellY == 2) {
            return cell9x3;
        } else if (cellX == 8 && cellY == 3) {
            return cell9x4;
        } else if (cellX == 8 && cellY == 4) {
            return cell9x5;
        } else if (cellX == 8 && cellY == 5) {
            return cell9x6;
        } else if (cellX == 8 && cellY == 6) {
            return cell9x7;
        } else if (cellX == 8 && cellY == 7) {
            return cell9x8;
        } else
            return cell9x9;
        //   if (cellX == 8 && cellY == 8) {        }


    }

    public void initializeUIPieces() {

        pieces.clear();

        for (ChessPiece piece : board.getPieces()) {
            pieces.add(UiChessPiece.forChessPiece(piece, this));
        }
    }

    public BoardController() {
        initializeUIPieces();
    }

    public void refresh() {
        for (UiChessPiece piece : pieces) {
            piece.refresh();
        }

        turnLog.setText("");
        Iterator<Chessturn> it = board.getStackTurns().iterator();
        while(it.hasNext()){
            Chessturn current = it.next();
            turnLog.setText(turnLog.getText() + String.format("%s -> %s \n", current.getFromPos(), current.getToPos() ));
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        turnLog.clear();

        refresh();
    }

    public UiChessPiece pieceByImage(ImageView imageView) {

        for (UiChessPiece piece : pieces) {
            if (piece.getImage() == imageView) {
                return piece;
            }
        }
        return null;
    }


    public UiChessPiece getMarkedPiece() {
        for (UiChessPiece piece : pieces) {
            if (piece.isMarked()) {
                return piece;
            }
        }
        return null;
    }

    public String getPositionByCell(ImageView imageView) {

        /*
       char x = (char) ( imageView.getX() + 15);
        char y = (char) (imageView.getY()-1);

        return x + "" + y;

*/
        if (imageView == cell2x2) {
            return "A1";
        } else if (imageView == cell2x3) {
            return "A2";
        } else if (imageView == cell2x4) {
            return "A3";
        } else if (imageView == cell2x5) {
            return "A4";
        } else if (imageView == cell2x6) {
            return "A5";
        } else if (imageView == cell2x7) {
            return "A6";
        } else if (imageView == cell2x8) {
            return "A7";
        } else if (imageView == cell2x9) {
            return "A8";
        } else if (imageView == cell3x2) {
            return "B1";
        } else if (imageView == cell3x3) {
            return "B2";
        } else if (imageView == cell3x4) {
            return "B3";
        } else if (imageView == cell3x5) {
            return "B4";
        } else if (imageView == cell3x6) {
            return "B5";
        } else if (imageView == cell3x7) {
            return "B6";
        } else if (imageView == cell3x8) {
            return "B7";
        } else if (imageView == cell3x9) {
            return "B8";
        } else if (imageView == cell4x2) {
            return "C1";
        } else if (imageView == cell4x3) {
            return "C2";
        } else if (imageView == cell4x4) {
            return "C3";
        } else if (imageView == cell4x5) {
            return "C4";
        } else if (imageView == cell4x6) {
            return "C5";
        } else if (imageView == cell4x7) {
            return "C6";
        } else if (imageView == cell4x8) {
            return "C7";
        } else if (imageView == cell4x9) {
            return "C8";
        } else if (imageView == cell5x2) {
            return "D1";
        } else if (imageView == cell5x3) {
            return "D2";
        } else if (imageView == cell5x4) {
            return "D3";
        } else if (imageView == cell5x5) {
            return "D4";
        } else if (imageView == cell5x6) {
            return "D5";
        } else if (imageView == cell5x7) {
            return "D6";
        } else if (imageView == cell5x8) {
            return "D7";
        } else if (imageView == cell5x9) {
            return "D8";
        } else if (imageView == cell6x2) {
            return "E1";
        } else if (imageView == cell6x3) {
            return "E2";
        } else if (imageView == cell6x4) {
            return "E3";
        } else if (imageView == cell6x5) {
            return "E4";
        } else if (imageView == cell6x6) {
            return "E5";
        } else if (imageView == cell6x7) {
            return "E6";
        } else if (imageView == cell6x8) {
            return "E7";
        } else if (imageView == cell6x9) {
            return "E8";
        } else if (imageView == cell7x2) {
            return "F1";
        } else if (imageView == cell7x3) {
            return "F2";
        } else if (imageView == cell7x4) {
            return "F3";
        } else if (imageView == cell7x5) {
            return "F4";
        } else if (imageView == cell7x6) {
            return "F5";
        } else if (imageView == cell7x7) {
            return "F6";
        } else if (imageView == cell7x8) {
            return "F7";
        } else if (imageView == cell7x9) {
            return "F8";
        } else if (imageView == cell8x2) {
            return "G1";
        } else if (imageView == cell8x3) {
            return "G2";
        } else if (imageView == cell8x4) {
            return "G3";
        } else if (imageView == cell8x5) {
            return "G4";
        } else if (imageView == cell8x6) {
            return "G5";
        } else if (imageView == cell8x7) {
            return "G6";
        } else if (imageView == cell8x8) {
            return "G7";
        } else if (imageView == cell8x9) {
            return "G8";
        } else if (imageView == cell9x2) {
            return "H1";
        } else if (imageView == cell9x3) {
            return "H2";
        } else if (imageView == cell9x4) {
            return "H3";
        } else if (imageView == cell9x5) {
            return "H4";
        } else if (imageView == cell9x6) {
            return "H5";
        } else if (imageView == cell9x7) {
            return "H6";
        } else if (imageView == cell9x8) {
            return "H7";
        } else if (imageView == cell9x9) {
            return "H8";
        }
        return null;

    }


    public void onCellClick(MouseEvent event) throws Exception {

        ImageView imageView = (ImageView) event.getPickResult().getIntersectedNode();
        AnchorPane anchor = (AnchorPane) imageView.getParent();

        UiChessPiece markedPiece = getMarkedPiece();

        for (UiChessPiece piece : pieces) {
            piece.unmark();
        }

        if (markedPiece != null) {
            String from = markedPiece.getPiece().getPosition();
            String to = getPositionByCell(imageView);

            board.move(from, to, (eaten) -> {
                for (UiChessPiece piece : pieces) {
                    if (piece.getPiece().equals(eaten)) {
                        removePieceFromUI(piece);
                        break;
                    }
                }
            });

            refresh();

            return;
        }

        if (anchor.getChildren().size() == 2) {
            for (Node n : anchor.getChildren()) {
                if (n != imageView && n instanceof ImageView) {
                    ImageView pieceImage = (ImageView) n;
                    UiChessPiece currentPiece = pieceByImage(pieceImage);

                    if (currentPiece.getPiece().getColor().equals(board.whoseTurn())) {
                        currentPiece.mark();
                    }


                }
            }
        }


    }

    public void removePieceFromUI(UiChessPiece piece){

            AnchorPane anchorPane = (AnchorPane) piece.getImage().getParent();
            anchorPane.getChildren().remove(piece.getImage());
            pieces.remove(piece);

    }

    public void loadGame(ActionEvent actionEvent) {
        try {
            while (pieces.size()>0){
                removePieceFromUI(pieces.get(0));

            }

            FileChooser f = new FileChooser();
            f.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("Bilo sta", ".json"));
            File file = f.showOpenDialog(Main.primaryStage);

            FileInputStream stream = new FileInputStream(file);
            Scanner in = new Scanner(stream);
            JsonObject object = new JsonObject(in.nextLine());
            Board oldBoard = new Board(object);
            board = oldBoard;

            initializeUIPieces();

            refresh();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void saveGame(ActionEvent actionEvent) throws IOException {
        FileChooser f = new FileChooser();
        f.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("Bilo sta", ".json"));
        File file = f.showSaveDialog(Main.primaryStage);

        FileWriter out = new FileWriter(file);
        out.write(board.getSaveData().toString());
        out.flush();

    }
}
