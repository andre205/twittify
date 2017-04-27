import javafx.application.Application;
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
		twitterButton.setOnAction( e -> window.setScene(twitterScene) );

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

		// SPOTIFY SCENE
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

		// CENTER DISPLAY BOX OF MAIN APPLICATION ELEMENTS (Divided in two)
		VBox mainDisplayBox = new VBox();
		mainDisplayBox.setId("mainDisplayBox");
		VBox mainDisplayBox2 = new VBox();
		mainDisplayBox2.setId("mainDisplayBox");

		Label spotifyInputFieldLabel = new Label();
		Label spotifyTop20Label = new Label("    Spotify Top 20");
		spotifyTop20Label.setId("spotifyTop20Label");
		//spotifyTop20Label.setStyle("-fx-text-fill: white");
		Label spotifyFillerLabel = new Label(" ");
		spotifyFillerLabel.setId("spotifyFillerLabel");


		// MULTIPLE INPUT FIELDS SO TEXT IS STORED FOR EACH SEARCH TYPE
		TextField trackInputField = new TextField();
		TextField artistInputField = new TextField();
		TextField albumInputField = new TextField();

		// FETCH TOP 20 HERE WITH SPOTIFY CHART FETCHER
		//ListView top20List = new ListView<>();
		String[] top20 = new String[20];
		for (int i = 0; i < 20; ++i)
		{
			top20[i] = (i+1) + ". Probably a Kendrick Lamar Song";
		}

		Button top20_1 = new Button(top20[0]);
		top20_1.setOnMouseEntered( e -> top20_1.setText("View tweets!") );
		top20_1.setOnMouseExited( e -> top20_1.setText(top20[0]) );
		Button top20_2 = new Button(top20[1]);
		top20_2.setOnMouseEntered( e -> top20_2.setText("View tweets!") );
		top20_2.setOnMouseExited( e -> top20_2.setText(top20[1]) );
		Button top20_3 = new Button(top20[2]);
		top20_3.setOnMouseEntered( e -> top20_3.setText("View tweets!") );
		top20_3.setOnMouseExited( e -> top20_3.setText(top20[2]) );
		Button top20_4 = new Button(top20[3]);
		top20_4.setOnMouseEntered( e -> top20_4.setText("View tweets!") );
		top20_4.setOnMouseExited( e -> top20_4.setText(top20[3]) );
		Button top20_5 = new Button(top20[4]);
		top20_5.setOnMouseEntered( e -> top20_5.setText("View tweets!") );
		top20_5.setOnMouseExited( e -> top20_5.setText(top20[4]) );
		Button top20_6 = new Button(top20[5]);
		top20_6.setOnMouseEntered( e -> top20_6.setText("View tweets!") );
		top20_6.setOnMouseExited( e -> top20_6.setText(top20[5]) );
		Button top20_7 = new Button(top20[6]);
		top20_7.setOnMouseEntered( e -> top20_7.setText("View tweets!") );
		top20_7.setOnMouseExited( e -> top20_7.setText(top20[6]) );
		Button top20_8 = new Button(top20[7]);
		top20_8.setOnMouseEntered( e -> top20_8.setText("View tweets!") );
		top20_8.setOnMouseExited( e -> top20_8.setText(top20[7]) );
		Button top20_9 = new Button(top20[8]);
		top20_9.setOnMouseEntered( e -> top20_9.setText("View tweets!") );
		top20_9.setOnMouseExited( e -> top20_9.setText(top20[8]) );
		Button top20_10 = new Button(top20[9]);
		top20_10.setOnMouseEntered( e -> top20_10.setText("View tweets!") );
		top20_10.setOnMouseExited( e -> top20_10.setText(top20[9]) );
		Button top20_11 = new Button(top20[10]);
		top20_11.setOnMouseEntered( e -> top20_11.setText("View tweets!") );
		top20_11.setOnMouseExited( e -> top20_11.setText(top20[10]) );
		Button top20_12 = new Button(top20[11]);
		top20_12.setOnMouseEntered( e -> top20_12.setText("View tweets!") );
		top20_12.setOnMouseExited( e -> top20_12.setText(top20[11]) );
		Button top20_13 = new Button(top20[12]);
		top20_13.setOnMouseEntered( e -> top20_13.setText("View tweets!") );
		top20_13.setOnMouseExited( e -> top20_13.setText(top20[12]) );
		Button top20_14 = new Button(top20[13]);
		top20_14.setOnMouseEntered( e -> top20_14.setText("View tweets!") );
		top20_14.setOnMouseExited( e -> top20_14.setText(top20[13]) );
		Button top20_15 = new Button(top20[14]);
		top20_15.setOnMouseEntered( e -> top20_15.setText("View tweets!") );
		top20_15.setOnMouseExited( e -> top20_15.setText(top20[14]) );
		Button top20_16 = new Button(top20[15]);
		top20_16.setOnMouseEntered( e -> top20_16.setText("View tweets!") );
		top20_16.setOnMouseExited( e -> top20_16.setText(top20[15]) );
		Button top20_17 = new Button(top20[16]);
		top20_17.setOnMouseEntered( e -> top20_17.setText("View tweets!") );
		top20_17.setOnMouseExited( e -> top20_17.setText(top20[16]) );
		Button top20_18 = new Button(top20[17]);
		top20_18.setOnMouseEntered( e -> top20_18.setText("View tweets!") );
		top20_18.setOnMouseExited( e -> top20_18.setText(top20[17]) );
		Button top20_19 = new Button(top20[18]);
		top20_19.setOnMouseEntered( e -> top20_19.setText("View tweets!") );
		top20_19.setOnMouseExited( e -> top20_19.setText(top20[18]) );
		Button top20_20 = new Button(top20[19]);
		top20_20.setOnMouseEntered( e -> top20_20.setText("View tweets!") );
		top20_20.setOnMouseExited( e -> top20_20.setText(top20[19]) );
		top20_1.setId("top20TweetButton");
		top20_2.setId("top20TweetButton");
		top20_3.setId("top20TweetButton");
		top20_4.setId("top20TweetButton");
		top20_5.setId("top20TweetButton");
		top20_6.setId("top20TweetButton");
		top20_7.setId("top20TweetButton");
		top20_8.setId("top20TweetButton");
		top20_9.setId("top20TweetButton");
		top20_10.setId("top20TweetButton");
		top20_11.setId("top20TweetButton");
		top20_12.setId("top20TweetButton");
		top20_13.setId("top20TweetButton");
		top20_14.setId("top20TweetButton");
		top20_15.setId("top20TweetButton");
		top20_16.setId("top20TweetButton");
		top20_17.setId("top20TweetButton");
		top20_18.setId("top20TweetButton");
		top20_19.setId("top20TweetButton");
		top20_20.setId("top20TweetButton");

		// BUTTON ACTIONS (AFFECT MAIN DISPLAY BOX)
		// CLEAR CHILDREN, UPDATE LABEL, ADD LABEL AND INPUT BOX TO MAIN DISPLAY BOX
		trackButton.setOnAction( e -> {
			mainDisplayBox.getChildren().clear();
			spotifyInputFieldLabel.setText("Enter a track name");
			mainDisplayBox.getChildren().addAll(spotifyInputFieldLabel, trackInputField);

			mainDisplayBox2.getChildren().clear();
		} );

		artistButton.setOnAction( e -> {
			mainDisplayBox.getChildren().clear();
			spotifyInputFieldLabel.setText("Enter an artist name");
			mainDisplayBox.getChildren().addAll(spotifyInputFieldLabel, artistInputField);

			mainDisplayBox2.getChildren().clear();
		} );

		albumButton.setOnAction( e -> {
			mainDisplayBox.getChildren().clear();
			spotifyInputFieldLabel.setText("Enter an album name");
			mainDisplayBox.getChildren().addAll(spotifyInputFieldLabel, albumInputField);

			mainDisplayBox2.getChildren().clear();
		} );

		top20Button.setOnAction( e -> {
			mainDisplayBox.getChildren().clear();
			mainDisplayBox.getChildren().addAll(spotifyTop20Label, top20_1, top20_2, top20_3, top20_4, top20_5, top20_6, top20_7, top20_8, top20_9, top20_10);

			mainDisplayBox2.getChildren().clear();
			mainDisplayBox2.getChildren().addAll(spotifyFillerLabel, top20_11, top20_12, top20_13, top20_14, top20_15, top20_16, top20_17, top20_18, top20_19, top20_20);
		} );

		// ADD MAIN DISPLAY BOX TO LAYOUT
		spotifyLayout.add(mainDisplayBox, 1, 0);
		spotifyLayout.add(mainDisplayBox2, 2, 0);

		Button spotifyBackButton = new Button("B\nA\nC\nK");
		spotifyBackButton.setId("spotifyBackButton");
		spotifyBackButton.setOnAction(e -> window.setScene(welcomeScene));

		// ADD BACK BUTTON TO LAYOUT
		spotifyLayout.add(spotifyBackButton, 3, 0);

		// CREATE SCENE FROM LAYOUT
		spotifyScene = new Scene(spotifyLayout);
		spotifyScene.getStylesheets().add("styleSheet.css");

		// TWITTAH SCENE
		Label twitterSearchLabel = new Label("Find something on Twitter...");
		twitterSearchLabel.setId("twitterSearchLabel");
		TextField twitterSearchField = new TextField();
		twitterSearchField.setPromptText("Search Twitter");
		twitterSearchField.setId("twitterSearchField");
		Button twitterSearchButton = new Button("ICON"); // ADD MAGNIFYING GLASS ICON
		Button twitterBackButton = new Button("B\nA\nC\nK");
		twitterBackButton.setOnAction( e -> window.setScene(welcomeScene) );
		twitterBackButton.setId("twitterBackButton");

		GridPane twitterLayout = new GridPane();
		twitterLayout.add(twitterSearchLabel, 0, 0); // MOVE EVERYTHING TO CENTER
		twitterLayout.add(twitterSearchField, 0, 1);
		twitterLayout.add(twitterSearchButton, 1, 1);
		twitterLayout.add(twitterBackButton, 2, 0);
		twitterLayout.setId("twitterLayout");

		twitterScene = new Scene(twitterLayout);
		twitterScene.getStylesheets().add("styleSheet.css");








		window.setScene(welcomeScene);
		window.show();
	}
}
