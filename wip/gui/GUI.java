import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;

public class GUI extends Application
{
	Stage window;
	Scene welcomeScene, twitterScene, spotifyScene;
	ListView<String> listView1, listView2;

	public static void main(String[] args)
	{
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception
	{
		// DISABLES WINDOW RESIZING
		window = primaryStage;
		window.setMinWidth(1000);
		window.setMinHeight(600);
		window.setMaxWidth(1000);
		window.setMaxHeight(600);

		// WELCOME SCREEN
		GridPane welcomeLayout = new GridPane();

		// WELCOME SCREEN LABEL
		Label titleLabel = new Label("TWITTIFY");
		titleLabel.setId("titleLabel");
		titleLabel.setMouseTransparent(true);
		//titleLabel.setStyle("-fx-font-family: Nunito; -fx-font-size: 100;");

		// TWITTER BUTTON IMAGES
		Image twitterLogoGray = new Image("twitterLogoGray.png");
		Image twitterLogoWhite = new Image("twitterLogoWhite.png");
		ImageView twitterLogo = new ImageView();
		twitterLogo.setMouseTransparent(true);
		twitterLogo.setFitWidth(200);
		twitterLogo.setPreserveRatio(true);
		twitterLogo.setImage(twitterLogoGray);

		// SPOTIFY BUTTON IMAGES
		Image spotifyLogoGray = new Image("spotifyLogoGray.png");
		Image spotifyLogoColored = new Image("spotifyLogoColored.png");
		ImageView spotifyLogo = new ImageView();
		spotifyLogo.setMouseTransparent(true);
		spotifyLogo.setFitWidth(175);
		spotifyLogo.setPreserveRatio(true);
		spotifyLogo.setImage(spotifyLogoGray);

		// TWITTER BUTTON
		Button twitterButton = new Button();
		twitterButton.setId("twitterButton");
		twitterButton.setGraphic(twitterLogo);
		twitterButton.setOnMouseEntered( e -> twitterLogo.setImage(twitterLogoWhite) );
		twitterButton.setOnMouseExited( e -> twitterLogo.setImage(twitterLogoGray) );

		// SPOTIFY BUTTON
		Button spotifyButton = new Button();
		spotifyButton.setId("spotifyButton");
		spotifyButton.setGraphic(spotifyLogo);
		spotifyButton.setOnMouseEntered( e -> spotifyLogo.setImage(spotifyLogoColored) );
		spotifyButton.setOnMouseExited( e -> spotifyLogo.setImage(spotifyLogoGray) );
		spotifyButton.setOnAction(e -> window.setScene(spotifyScene));

		// DIVIDES SCREEN IN HALF; LEFT SIDE TWITTER (0,0); RIGHT SIDE SPOTIFY (1,0)
		welcomeLayout.add(twitterButton, 0, 0);
		welcomeLayout.add(spotifyButton, 1, 0);
		welcomeLayout.add(titleLabel, 1, 0);

		welcomeScene = new Scene(welcomeLayout);
		welcomeScene.getStylesheets().add("styleSheet.css");

		// // SPOTIFY SCENE
		// LEFT BUTTONS
		Button trackButton = new Button("Search Track");
		trackButton.setId("trackButton");
		Button artistButton = new Button("Search Artist");
		artistButton.setId("artistButton");
		Button albumButton = new Button("Search Album");
		albumButton.setId("albumButton");
		Button top20Button = new Button("Spotify Top 20");
		top20Button.setId("top20Button");

		// LAYOUT
		GridPane spotifyLayout = new GridPane();
		// LEFT MOST LIST OF CHOICES
		VBox choicesBox = new VBox();
		choicesBox.getChildren().addAll(trackButton, artistButton, albumButton, top20Button);

		// ADD CHOICE BOX TO LAYOUT
		spotifyLayout.add(choicesBox, 0, 0);

		// CENTER DISPLAY BOX OF MAIN APPLICATION ELEMENTS
		VBox mainDisplayBox = new VBox();
		mainDisplayBox.setId("mainDisplayBox");

		Label spotifyInputFieldLabel = new Label();
		Label spotifyTop20Label = new Label("Here's the top twenty, buckaroo");

		// MULTIPLE INPUT FIELDS SO TEXT IS STORED FOR EACH SEARCH TYPE
		TextField trackInputField = new TextField();
		TextField artistInputField = new TextField();
		TextField albumInputField = new TextField();

		ListView top20List = new ListView<>();

		// BUTTON ACTIONS (AFFECT MAIN DISPLAY BOX)
		// CLEAR CHILDREN, UPDATE LABEL, ADD LABEL AND INPUT BOX TO MAIN DISPLAY BOX
		trackButton.addEventHandler(ActionEvent.ACTION, (e)-> {
				mainDisplayBox.getChildren().clear();
				spotifyInputFieldLabel.setText("Enter a track name");
				mainDisplayBox.getChildren().addAll(spotifyInputFieldLabel, trackInputField);
		});

		artistButton.addEventHandler(ActionEvent.ACTION, (e)-> {
				mainDisplayBox.getChildren().clear();
				spotifyInputFieldLabel.setText("Enter an artist name");
				mainDisplayBox.getChildren().addAll(spotifyInputFieldLabel, artistInputField);
		});

		albumButton.addEventHandler(ActionEvent.ACTION, (e)-> {
				mainDisplayBox.getChildren().clear();
				spotifyInputFieldLabel.setText("Enter an album name");
				mainDisplayBox.getChildren().addAll(spotifyInputFieldLabel, albumInputField);
		});

		top20Button.addEventHandler(ActionEvent.ACTION, (e)-> {
				mainDisplayBox.getChildren().clear();
				// fetch top 20 here
				String[] top20 = {"1","2","skip a few","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","20"};
				top20List.getItems().addAll((Object[])top20);
				mainDisplayBox.getChildren().addAll(spotifyTop20Label, top20List);
		});

		// ADD MAIN DISPLAY BOX TO LAYOUT
		spotifyLayout.add(mainDisplayBox, 1, 0);

		Button backButton = new Button("B");
		backButton.setId("backButton");
		backButton.setOnAction(e -> window.setScene(welcomeScene));

		// ADD BACK BUTTON TO LAYOUT
		spotifyLayout.add(backButton, 2, 0);

		// CREATE SCENE FROM LAYOUT
		spotifyScene = new Scene(spotifyLayout);
		spotifyScene.getStylesheets().add("styleSheet.css");

		window.setScene(welcomeScene);
		window.show();
	}
}
