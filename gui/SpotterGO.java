import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SpotterGO extends Application
{
	Stage window;
	Scene scene1, scene2, scene3, scene4;
	ListView<String> listView1, listView2;
	ChoiceBox<String> choiceBox;

	public static void main(String[] args)
	{
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception
	{
		window = primaryStage;

		// SCENE 1 - WELCOME SCREEN
		GridPane layout1 = new GridPane();
		layout1.setPadding(new Insets(10, 10, 10, 10));	// GIVES 10-PIXEL PADDING AROUND ENTIRE GRIDPANE
		layout1.setVgap(8); 							// SETS VERTICAL GAP FOR EACH CELL
		layout1.setHgap(10); 							// SETS HORIZONTAL GAP FOR EACH CELL

		// SCENE 1 ITEMS
		Label welcomeLabel = new Label("Welcome to Twittify!");
		GridPane.setConstraints(welcomeLabel, 1, 0);

		choiceBox = new ChoiceBox<>();
		GridPane.setConstraints(choiceBox, 0, 1);
		choiceBox.getItems().addAll("Search by Song", "Search by Artist", "Search by Album", "View Top 200");
		choiceBox.setValue("Search by Song");

		Button goButton = new Button("SpotterGO!");
		goButton.setOnAction(e -> window.setScene(scene2));
		GridPane.setConstraints(goButton, 0, 2);

		layout1.getChildren().addAll(welcomeLabel, choiceBox, goButton);

		BorderPane border = new BorderPane();
		border.setCenter(layout1);

		Scene scene = new Scene(border, 800, 500);

		// SCENE 2 - SPOTIFY SEARCH
		GridPane layout2 = new GridPane();
		layout2.setPadding(new Insets(10, 10, 10, 10));
		layout2.setVgap(8);
		layout2.setHgap(10);

		// SCENE 2 ITEMS
		Label inputLabel = new Label("Please input name of [CHOICE]:");
		GridPane.setConstraints(inputLabel, 1, 0);

		TextField inputField = new TextField();
		inputField.setPromptText("Example text");
		GridPane.setConstraints(inputField, 1, 1);

		Button searchButton = new Button("SpotterGO!");
		searchButton.setOnAction(e -> window.setScene(scene3)); // TAKE TEXTFIELD DATA FROM HERE USING .getText()
		GridPane.setConstraints(searchButton, 2, 1);

		layout2.getChildren().addAll(inputLabel, inputField, searchButton);
		scene2 = new Scene(layout2, 800, 500);

		// SCENE 3 - SPOTIFY RESULTS
		GridPane layout3 = new GridPane();
		layout3.setPadding(new Insets(10, 10, 10, 10));
		layout3.setVgap(8);
		layout3.setHgap(10);

		// SCENE 3 ITEMS
		Label resultsLabel = new Label("Select [CHOICE] to view related tweets:");
		GridPane.setConstraints(resultsLabel, 1, 0);

		listView1 = new ListView<>();
		listView1.getItems().addAll("Result", "Result", "Result", "Result", "Result", "Result", "Result", "Result", "Result", "Result", "Result", "Result", "Result", "Result", "Result", "Result", "Result", "Result", "Result", "Result", "Result", "Result", "Result");
		GridPane.setConstraints(listView1, 1, 2);

		Button listButton = new Button ("Twittify!");
		listButton.setOnAction(e -> window.setScene(scene4)); // TAKE SELECTED ITEM FROM LISTVIEW FOR TWITTER SEARCH
		GridPane.setConstraints(listButton, 1, 3);

		layout3.getChildren().addAll(resultsLabel, listView1, listButton);
		scene3 = new Scene(layout3, 800, 500);

		// SCENE 4 - DISPLAYING TWEETS
		GridPane layout4 = new GridPane();
		layout4.setPadding(new Insets(10, 10, 10, 10));
		layout4.setVgap(8);
		layout4.setHgap(10);

		// SCENE 4 ITEMS
		Label tweetLabel = new Label("Tweets related to [CHOICE]:");
		GridPane.setConstraints(tweetLabel, 1, 0);

		listView2 = new ListView<>();
		// TWEETS GO HERE
		listView2.getItems().addAll("Result", "Result", "Result", "Result", "Result", "Result", "Result", "Result", "Result", "Result", "Result", "Result", "Result", "Result", "Result", "Result", "Result", "Result", "Result", "Result", "Result", "Result", "Result");
		GridPane.setConstraints(listView2, 1, 1);

		Button startOverButton = new Button("Start Over");
		startOverButton.setOnAction(e -> window.setScene(scene));
		GridPane.setConstraints(startOverButton, 1, 2);

		layout4.getChildren().addAll(tweetLabel, listView2, startOverButton);
		scene4 = new Scene(layout4, 800, 500);

		// START UP
		window.setScene(scene);
		window.setTitle("Twittify");
		window.show();
	}
}
