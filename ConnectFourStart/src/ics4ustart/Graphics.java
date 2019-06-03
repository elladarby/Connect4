package ics4ustart;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

public class Graphics extends Application {
	// creates the board
	private static final int ROWS = 7;
	private static final int COLS = 7;
	private static Board board = new Board(ROWS, COLS);
	private static NewButton[][] slots = new NewButton[ROWS][COLS];

	private static CellState player = CellState.P1;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		final int BUTTON_WIDTH = 1000;
		final int BUTTON_HEIGHT = 1000;

		primaryStage.setWidth(400);
		primaryStage.setHeight(400);
		primaryStage.setTitle("Connect 4");
		GridPane gridPane = new GridPane();

		// setup slots
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getCols(); j++) {
				slots[i][j] = new NewButton(j);
				slots[i][j].setPrefSize(BUTTON_WIDTH, BUTTON_HEIGHT);
				slots[i][j].setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						System.out.println(((NewButton) event.getSource()).getCol());
						int column = ((NewButton) event.getSource()).getCol();
						int row = board.placeChip(player, column);

						boolean isWinner = false;
						boolean done = false;

						if (board.isVert(row, column)) {
							System.out.println("winner!");
							done = true;
							isWinner = true;
						}
						if (board.isHoriz(row, column)) {
							System.out.println("winner!");
							done = true;
							isWinner = true;
						}
						if (board.isDiagRight(row, column)) {
							System.out.println("winner!");
							done = true;
							isWinner = true;
						}
						if (board.isDiagLeft(row, column)) {
							System.out.println("winner!");
							done = true;
							isWinner = true;
						}

						if (isWinner) {
							StackPane sp = new StackPane();
							sp.setAlignment(Pos.CENTER);
							Font font = new Font("Tahoma", 30);

							if (player == CellState.P1) {
								Label msg2 = new Label("Player 1 is the big winner");
								msg2.setFont(font);
								sp.getChildren().add(msg2);
							} else {
								Label msg3 = new Label("Player 2 is the big winner");
								msg3.setFont(font);
								sp.getChildren().add(msg3);
							}

							Scene donedone = new Scene(sp);
							primaryStage.setScene(donedone);
						}

						board.display();
						updateBoard(board, slots);
						if (player == CellState.P1) {
							player = CellState.P2;
						} else {
							player = CellState.P1;
						}
					}
				});

				gridPane.add(slots[i][j], j, i);
			}
		}

		Scene myScene = new Scene(gridPane);
		primaryStage.setScene(myScene);
		primaryStage.show();

	}

	/**
	 * Updates colour of slots based on CellState player
	 * @param board : board object
	 * @param slots : 2D array of buttons
	 */
	public void updateBoard(Board board, Button[][] slots) {
		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getRows(); j++) {
				switch (board.getState(i, j)) {
				case P1:
					slots[i][j].setStyle(" -fx-base: #ff0000;");
					break;
				case P2:
					slots[i][j].setStyle(" -fx-base: #0000ff;");
					break;
				}
			}
		}
		return;
	}

}
