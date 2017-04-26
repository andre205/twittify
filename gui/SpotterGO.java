import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Tooltip;
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

//scene1 ******************************************************************************************
		// SCENE 1 - WELCOME SCREEN
		//creating welcome label
		Label welcome = new Label("WELCOME TO TWITTIFY!!");

		//creating drop down menu
		choiceBox = new ChoiceBox<>();
		choiceBox.getItems().addAll("Search by Song", "Search by Artist", "Search by Album", "View Top 200");
		choiceBox.setValue("Search by Song");


		//creating floating tip on choiceBox
		choiceBox.setTooltip(new Tooltip("Select search catagory"));

		//creating button
		Button goButton = new Button("SpotterGO!");
		goButton.setOnAction(e -> window.setScene(scene2));

		//creating grid pane
		GridPane layout1 = new GridPane();

		//setting a size for the pane
		layout1.setMinSize(800,500);

		//setting the padding
		layout1.setPadding(new Insets(10,10,10,10));

		//setting the vertical and horizontal gaps between the columns
		layout1.setVgap(5);
		layout1.setHgap(5);

		//setting the grid alignment
		layout1.setAlignment(Pos.CENTER);

		//setting the welcome label
		welcome.setLayoutX(300);
		welcome.setLayoutY(100);
		welcome.setAlignment(Pos.CENTER);


		//arranging all the nodes in teh grid
		layout1.add(welcome, 0,0);
		layout1.add(choiceBox, 0,2);
		layout1.add(goButton, 0,4);

		//styling nodes
		goButton.setStyle("-fx-background-color: blue; -fx-text-fill: white;");
		welcome.setStyle("-fx-font: normal bold 20px 'serif' ");
		layout1.setStyle("-fx-background-color: lightblue;");

		//creating scene object
		Scene scene = new Scene(layout1);
//scene1 end ***********************************************************************************

//scene2 start****************************************************************************
// SCENE 2 - input search text

		//getting selected choice from choice box
		String choice1 = choiceBox.getSelectionModel().getSelectedItem().toString();
		String choiceInput;

		//this part doesnt work because i dont think the choiceBox is retaining the item?????
		if (choice1 == "Search by Song")
			choiceInput = "song";

		else if (choice1 == "Search by Artist")
			choiceInput = "artist";

		else if (choice1 == "Search by Album")
			choiceInput = "album";
		else
			choiceInput = "N/A";



		//creating input label
		Label inputText = new Label("Please input name of the " + choiceInput + ":");

		//creating text field
		TextField inputField = new TextField();

		inputField.setPromptText("Beyonce");
		inputField.setTooltip(new Tooltip("Search by item name"));


		//creating button
		Button spotterGo = new Button("SpotterGO!");
		spotterGo.setOnAction(e -> window.setScene(scene3));

		//creating grid pane
		GridPane layout2 = new GridPane();

		//setting a size for the pane
		layout2.setMinSize(800,500);

		//setting the padding
		layout2.setPadding(new Insets(10,10,10,10));

		//setting the vertical and horizontal gaps between the columns
		layout2.setVgap(5);
		layout2.setHgap(5);

		//setting the grid alignment
		layout2.setAlignment(Pos.CENTER);


		//arranging all the nodes in the grid
		layout2.add(inputText, 0,0);
		layout2.add(inputField, 0,1);
		layout2.add(spotterGo, 1,1);

		//styling nodes
		inputText.setStyle("-fx-font: normal bold 20px 'serif' ");
		layout2.setStyle("-fx-background-color: lightblue;");

		//creating scene object
		scene2 = new Scene(layout2);

//scene2 end ***********************************************************************************************************

//scene3 start**************************************************************************************

// SCENE 3 - spotify output
		//creating spotify label
		Label spotifyOutputLabel = new Label("Select [CHOICE] to view related tweets:");

		//creating list view to see resutls
		listView1 = new ListView<>();
		listView1.getItems().addAll("Result", "Result", "Result", "Result", "Result", "Result");
		listView1.setTooltip(new Tooltip("Spotify results"));


		//creating button
		Button twittifyButton = new Button("Twittify!");
		twittifyButton.setOnAction(e -> window.setScene(scene4));

		//creating grid pane
		GridPane layout3 = new GridPane();

		//setting a size for the pane
		layout3.setMinSize(800,500);

		//setting the padding
		layout3.setPadding(new Insets(10,10,10,10));

		//setting the vertical and horizontal gaps between the columns
		layout3.setVgap(5);
		layout3.setHgap(5);

		//setting the grid alignment
		layout3.setAlignment(Pos.CENTER);


		//arranging all the nodes in the grid
		layout3.add(spotifyOutputLabel, 0,0);
		layout3.add(listView1, 0,1);
		layout3.add(twittifyButton, 0,2);

		//styling nodes
		spotifyOutputLabel.setStyle("-fx-font: normal bold 20px 'serif' ");
		layout3.setStyle("-fx-background-color: lightblue;");

		//creating scene object
		scene3 = new Scene(layout3);

//scene3 end ************************************************************************************************

//scene4 start ***********************************************************************************************

	//creating spotify label
		Label twitterOutputLabel = new Label("Tweets related to [CHOICE]:");

		//creating list view to see results
		listView2 = new ListView<>();
		listView2.getItems().addAll("Result", "Result", "Result", "Result", "Result", "Result");
		listView2.setTooltip(new Tooltip("Twitter results"));


		//creating button
		Button startOverbutton = new Button("Start Over :)");
		startOverbutton.setOnAction(e -> window.setScene(scene));

		//creating grid pane
		GridPane layout4 = new GridPane();

		//setting a size for the pane
		layout4.setMinSize(800,500);

		//setting the padding
		layout4.setPadding(new Insets(10,10,10,10));

		//setting the vertical and horizontal gaps between the columns
		layout4.setVgap(5);
		layout4.setHgap(5);

		//setting the grid alignment
		layout4.setAlignment(Pos.CENTER);


		//arranging all the nodes in the grid
		layout4.add(twitterOutputLabel, 0,0);
		layout4.add(listView2, 0,1);
		layout4.add(startOverbutton, 0,2);

		//styling nodes
		twitterOutputLabel.setStyle("-fx-font: normal bold 20px 'serif' ");
		layout4.setStyle("-fx-background-color: lightblue;");

		//creating scene object
		scene4 = new Scene(layout4);

//scene4 end********************************************************************************************************

//start up

		window.setScene(scene);
		window.setTitle("Twittify");
		window.show();

		//STARTS HERE ***************************************
		/*GridPane layout1 = new GridPane();
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

		Scene scene = new Scene(border, 800, 500); */


//ends here ********************************************************

		// SCENE 2 - SPOTIFY SEARCH
		/*GridPane layout2 = new GridPane();
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
		scene2 = new Scene(layout2, 800, 500);*/
//*********************************************************************************************************
		// SCENE 3 - SPOTIFY RESULTS
		/*GridPane layout3 = new GridPane();
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
		scene3 = new Scene(layout3, 800, 500);*/

		// SCENE 4 - DISPLAYING TWEETS
		/*GridPane layout4 = new GridPane();
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
		scene4 = new Scene(layout4, 800, 500);*/


	}
}
