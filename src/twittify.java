import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class twittify extends Application
{
	GridPane welcomeLayout, twitterLayout1, tweetLayout;
	HBox twitterTweetBox;
	ColumnConstraints column1, column2, column3;
	RowConstraints row1, row2, row3;
	Stage window;
	Scene welcomeScene, twitterScene, spotifyScene;

	Button twitterBackButton2;

	public static void main(String[] args)
	{
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception
	{
		// API OBJECTS
		spotify_groundwork sg = new spotify_groundwork();
		twitter_groundwork tg = new twitter_groundwork();
		spotify_chart_fetcher scf = new spotify_chart_fetcher();

		// DISABLES WINDOW RESIZING
		window = primaryStage;
		window.setMinWidth(1000);
		window.setMinHeight(597);
		window.setMaxWidth(1000);
		window.setMaxHeight(597);

		// ------------------------------------------------------------------ //

		// *** --- WELCOME SCENE --- *** //

		// WELCOME SCREEN LABEL
		Label titleLabel = new Label("TWITTIFY");
		titleLabel.setId("titleLabel");
		titleLabel.setMouseTransparent(true);

		// TWITTER BUTTON IMAGES
		Image twitterLogoGray = new Image("images/twitterLogoGray.png");
		Image twitterLogoWhite = new Image("images/twitterLogoWhite.png");
		ImageView twitterLogo = new ImageView();
		twitterLogo.setMouseTransparent(true);
		twitterLogo.setFitWidth(200);
		twitterLogo.setPreserveRatio(true);
		twitterLogo.setImage(twitterLogoGray);

		// SPOTIFY BUTTON IMAGES
		Image spotifyLogoGray = new Image("images/spotifyLogoGray.png");
		Image spotifyLogoColored = new Image("images/spotifyLogoColored.png");
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
		welcomeLayout = new GridPane();
		welcomeLayout.add(twitterButton, 0, 0);
		welcomeLayout.add(spotifyButton, 1, 0);
		welcomeLayout.add(titleLabel, 1, 0);

		// FILL SCENE AND APPLY STYLESHEET
		welcomeScene = new Scene(welcomeLayout);
		welcomeScene.getStylesheets().add("styleSheet.css");

		// ------------------------------------------------------------------ //


		// DEFINING TWEET LABELS, SEARCH BUTTON, AND SEARCH FIELD EARLY BECAUSE THEY ARE MODIFIED IN SPOTIFY TOP 20
		// TWEET LABELS
		Label tweetLabel1 = new Label("No results found"); 	tweetLabel1.setId("tweetLabel");
		Label tweetLabel2 = new Label("No results found"); 	tweetLabel2.setId("tweetLabel");
		Label tweetLabel3 = new Label("No results found"); 	tweetLabel3.setId("tweetLabel");
		Label tweetLabel4 = new Label("No results found"); 	tweetLabel4.setId("tweetLabel");
		Label tweetLabel5 = new Label("No results found"); 	tweetLabel5.setId("tweetLabel");
		Label tweetLabel6 = new Label("No results found"); 	tweetLabel6.setId("tweetLabel");
		Label tweetLabel7 = new Label("No results found"); 	tweetLabel7.setId("tweetLabel");
		Label tweetLabel8 = new Label("No results found"); 	tweetLabel8.setId("tweetLabel");
		Label tweetLabel9 = new Label("No results found"); 	tweetLabel9.setId("tweetLabel");

		//SEARCH BUTTON
		Button twitterSearchButton = new Button();

		// SEARCH FIELD
		TextField twitterSearchField = new TextField();
		twitterSearchField.setPromptText("Search");
		twitterSearchField.setId("twitterSearchField");

		// *** --- SPOTIFY SCENE --- *** //

		// LEFT BUTTONS
		Button spotifyTrackButton = new Button("Search Track");
		spotifyTrackButton.setId("spotifyTrackButton");
		Button spotifyArtistButton = new Button("Search Artist");
		spotifyArtistButton.setId("spotifyArtistButton");
		Button spotifyAlbumButton = new Button("Search Album");
		spotifyAlbumButton.setId("spotifyAlbumButton");
		Button spotifyTop20Button = new Button("Spotify Top 20");
		spotifyTop20Button.setId("spotifyTop20Button");
		Button spotifyHomeButton = new Button("Home");
		spotifyHomeButton.setId("spotifyHomeButton");

		// SEARCH BUTTON IMAGE
		Image searchIcon = new Image("images/searchIcon.png");
		ImageView spotifySearchIcon = new ImageView(searchIcon);
		spotifySearchIcon.setMouseTransparent(true);
		spotifySearchIcon.setFitHeight(20);
		spotifySearchIcon.setFitWidth(35);
		spotifySearchIcon.setPreserveRatio(true);
		spotifySearchIcon.setImage(searchIcon);

		// SEARCH BOX CONTAINTS INPUT FIELD AND SEARCH BUTTON
		Button spotifySearchButton = new Button();
		spotifySearchButton.setId("spotifySearchButton");
		spotifySearchButton.setGraphic(spotifySearchIcon);
		HBox spotifySearchBox = new HBox(10);

		// LAYOUT
		GridPane spotifyLayout = new GridPane();
		// LEFT MOST LIST OF CHOICES
		VBox choicesBox = new VBox();
		choicesBox.getChildren().addAll(spotifyTrackButton, spotifyArtistButton, spotifyAlbumButton, spotifyTop20Button, spotifyHomeButton);

		// ADD CHOICE BOX TO LAYOUT
		spotifyLayout.add(choicesBox, 0, 0);

		// CENTER DISPLAY BOX OF MAIN APPLICATION ELEMENTS (Divided in two)
		VBox mainDisplayBox = new VBox();
		mainDisplayBox.setId("mainDisplayBox");
		VBox mainDisplayBox2 = new VBox();
		mainDisplayBox2.setId("mainDisplayBox");

		Label spotifyInputFieldLabel = new Label();
		spotifyInputFieldLabel.setId("spotifyInputFieldLabel");
		Label spotifyTop20Label = new Label("    Spotify Top 20");
		spotifyTop20Label.setId("spotifyTop20Label");
		Label spotifyFillerLabel = new Label(" ");
		spotifyFillerLabel.setId("spotifyFillerLabel");

		// FOR BOX 1
		Label spotifyTrackResultLabel1 = new Label();
		spotifyTrackResultLabel1.setId("spotifyResultLabel");
		Label spotifyTrackResultLabel2 = new Label();
		spotifyTrackResultLabel2.setId("spotifyResultLabel");
		Label spotifyTrackResultLabel3 = new Label();
		spotifyTrackResultLabel3.setId("spotifyResultLabel");
		Label spotifyTrackResultLabel4 = new Label();
		spotifyTrackResultLabel4.setId("spotifyResultLabel");
		Label spotifyTrackResultLabel5 = new Label();
		spotifyTrackResultLabel5.setId("spotifyResultLabel");
		// FOR BOX 2
		Label spotifyTrackResultLabel6 = new Label();
		spotifyTrackResultLabel6.setId("spotifyResultLabel");
		Label spotifyTrackResultLabel7 = new Label();
		spotifyTrackResultLabel7.setId("spotifyResultLabel");
		Label spotifyTrackResultLabel8 = new Label();
		spotifyTrackResultLabel8.setId("spotifyResultLabel");
		Label spotifyTrackResultLabel9 = new Label();
		spotifyTrackResultLabel9.setId("spotifyResultLabel");
		Label spotifyTrackResultLabel10 = new Label();
		spotifyTrackResultLabel10.setId("spotifyResultLabel");

		// FOR BOX 1
		Label spotifyArtistResultLabel1 = new Label();
		spotifyArtistResultLabel1.setId("spotifyResultLabel");
		Label spotifyArtistResultLabel2 = new Label();
		spotifyArtistResultLabel2.setId("spotifyResultLabel");
		Label spotifyArtistResultLabel3 = new Label();
		spotifyArtistResultLabel3.setId("spotifyResultLabel");
		Label spotifyArtistResultLabel4 = new Label();
		spotifyArtistResultLabel4.setId("spotifyResultLabel");
		Label spotifyArtistResultLabel5 = new Label();
		spotifyArtistResultLabel5.setId("spotifyResultLabel");
		// FOR BOX 2
		Label spotifyArtistResultLabel6 = new Label();
		spotifyArtistResultLabel6.setId("spotifyResultLabel");
		Label spotifyArtistResultLabel7 = new Label();
		spotifyArtistResultLabel7.setId("spotifyResultLabel");
		Label spotifyArtistResultLabel8 = new Label();
		spotifyArtistResultLabel8.setId("spotifyResultLabel");
		Label spotifyArtistResultLabel9 = new Label();
		spotifyArtistResultLabel9.setId("spotifyResultLabel");
		Label spotifyArtistResultLabel10 = new Label();
		spotifyArtistResultLabel10.setId("spotifyResultLabel");

		// FOR BOX 1
		Label spotifyAlbumResultLabel1 = new Label();
		spotifyAlbumResultLabel1.setId("spotifyResultLabel");
		Label spotifyAlbumResultLabel2 = new Label();
		spotifyAlbumResultLabel2.setId("spotifyResultLabel");
		Label spotifyAlbumResultLabel3 = new Label();
		spotifyAlbumResultLabel3.setId("spotifyResultLabel");
		Label spotifyAlbumResultLabel4 = new Label();
		spotifyAlbumResultLabel4.setId("spotifyResultLabel");
		Label spotifyAlbumResultLabel5 = new Label();
		spotifyAlbumResultLabel5.setId("spotifyResultLabel");
		// FOR BOX 2
		Label spotifyAlbumResultLabel6 = new Label();
		spotifyAlbumResultLabel6.setId("spotifyResultLabel");
		Label spotifyAlbumResultLabel7 = new Label();
		spotifyAlbumResultLabel7.setId("spotifyResultLabel");
		Label spotifyAlbumResultLabel8 = new Label();
		spotifyAlbumResultLabel8.setId("spotifyResultLabel");
		Label spotifyAlbumResultLabel9 = new Label();
		spotifyAlbumResultLabel9.setId("spotifyResultLabel");
		Label spotifyAlbumResultLabel10 = new Label();
		spotifyAlbumResultLabel10.setId("spotifyResultLabel");

		// MULTIPLE INPUT FIELDS SO TEXT IS STORED FOR EACH SEARCH TYPE
		TextField spotifyTrackInputField = new TextField();
		spotifyTrackInputField.setId("spotifyInputField");
		TextField spotifyArtistInputField = new TextField();
		spotifyArtistInputField.setId("spotifyInputField");
		TextField spotifyAlbumInputField = new TextField();
		spotifyAlbumInputField.setId("spotifyInputField");

		// FETCH TOP 20, ADD NUMBERS FOR BUTTON CREATION
		String[] top20 = scf.getTop20();
		String[] top20string = scf.getTop20();
		String temp = "";
		for (int i = 0; i < 20; ++i)
		{
			temp = top20[i];
			top20[i] = (i+1) + ". " + temp;
		}

		// WHEN TOP 20 BUTTON IS CLICKED, SWITCH TO TWITTER SCENE, ENTER SONG NAME IN SEARCH FIELD, AND COMPLETE SEARCH
		Button top20_1 = new Button(top20[0]);
		top20_1.setOnMouseEntered( e -> top20_1.setText("View tweets!") );
		top20_1.setOnMouseExited( e -> top20_1.setText(top20[0]) );
		top20_1.setOnAction( e -> {
				twitterSearchField.setText(top20string[0]);
				window.setScene(twitterScene);
				twitterSearchButton.fire();
		} );

		Button top20_2 = new Button(top20[1]);
		top20_2.setOnMouseEntered( e -> top20_2.setText("View tweets!") );
		top20_2.setOnMouseExited( e -> top20_2.setText(top20[1]) );
		top20_2.setOnAction( e -> {
				twitterSearchField.setText(top20string[1]);
				window.setScene(twitterScene);
				twitterSearchButton.fire();
		} );

		Button top20_3 = new Button(top20[2]);
		top20_3.setOnMouseEntered( e -> top20_3.setText("View tweets!") );
		top20_3.setOnMouseExited( e -> top20_3.setText(top20[2]) );
		top20_3.setOnAction( e -> {
				twitterSearchField.setText(top20string[2]);
				window.setScene(twitterScene);
				twitterSearchButton.fire();
		} );

		Button top20_4 = new Button(top20[3]);
		top20_4.setOnMouseEntered( e -> top20_4.setText("View tweets!") );
		top20_4.setOnMouseExited( e -> top20_4.setText(top20[3]) );
		top20_4.setOnAction( e -> {
				twitterSearchField.setText(top20string[3]);
				window.setScene(twitterScene);
				twitterSearchButton.fire();
		} );

		Button top20_5 = new Button(top20[4]);
		top20_5.setOnMouseEntered( e -> top20_5.setText("View tweets!") );
		top20_5.setOnMouseExited( e -> top20_5.setText(top20[4]) );
		top20_5.setOnAction( e -> {
				twitterSearchField.setText(top20string[4]);
				window.setScene(twitterScene);
				twitterSearchButton.fire();
		} );

		Button top20_6 = new Button(top20[5]);
		top20_6.setOnMouseEntered( e -> top20_6.setText("View tweets!") );
		top20_6.setOnMouseExited( e -> top20_6.setText(top20[5]) );
		top20_6.setOnAction( e -> {
				twitterSearchField.setText(top20string[5]);
				window.setScene(twitterScene);
				twitterSearchButton.fire();
		} );

		Button top20_7 = new Button(top20[6]);
		top20_7.setOnMouseEntered( e -> top20_7.setText("View tweets!") );
		top20_7.setOnMouseExited( e -> top20_7.setText(top20[6]) );
		top20_7.setOnAction( e -> {
				twitterSearchField.setText(top20string[6]);
				window.setScene(twitterScene);
				twitterSearchButton.fire();
		} );

		Button top20_8 = new Button(top20[7]);
		top20_8.setOnMouseEntered( e -> top20_8.setText("View tweets!") );
		top20_8.setOnMouseExited( e -> top20_8.setText(top20[7]) );
		top20_8.setOnAction( e -> {
				twitterSearchField.setText(top20string[7]);
				window.setScene(twitterScene);
				twitterSearchButton.fire();
		} );

		Button top20_9 = new Button(top20[8]);
		top20_9.setOnMouseEntered( e -> top20_9.setText("View tweets!") );
		top20_9.setOnMouseExited( e -> top20_9.setText(top20[8]) );
		top20_9.setOnAction( e -> {
				twitterSearchField.setText(top20string[8]);
				window.setScene(twitterScene);
				twitterSearchButton.fire();
		} );

		Button top20_10 = new Button(top20[9]);
		top20_10.setOnMouseEntered( e -> top20_10.setText("View tweets!") );
		top20_10.setOnMouseExited( e -> top20_10.setText(top20[9]) );
		top20_10.setOnAction( e -> {
				twitterSearchField.setText(top20string[9]);
				window.setScene(twitterScene);
				twitterSearchButton.fire();
		} );

		Button top20_11 = new Button(top20[10]);
		top20_11.setOnMouseEntered( e -> top20_11.setText("View tweets!") );
		top20_11.setOnMouseExited( e -> top20_11.setText(top20[10]) );
		top20_11.setOnAction( e -> {
				twitterSearchField.setText(top20string[10]);
				window.setScene(twitterScene);
				twitterSearchButton.fire();
		} );

		Button top20_12 = new Button(top20[11]);
		top20_12.setOnMouseEntered( e -> top20_12.setText("View tweets!") );
		top20_12.setOnMouseExited( e -> top20_12.setText(top20[11]) );
		top20_12.setOnAction( e -> {
				twitterSearchField.setText(top20string[11]);
				window.setScene(twitterScene);
				twitterSearchButton.fire();
		} );

		Button top20_13 = new Button(top20[12]);
		top20_13.setOnMouseEntered( e -> top20_13.setText("View tweets!") );
		top20_13.setOnMouseExited( e -> top20_13.setText(top20[12]) );
		top20_13.setOnAction( e -> {
				twitterSearchField.setText(top20string[12]);
				window.setScene(twitterScene);
				twitterSearchButton.fire();
		} );

		Button top20_14 = new Button(top20[13]);
		top20_14.setOnMouseEntered( e -> top20_14.setText("View tweets!") );
		top20_14.setOnMouseExited( e -> top20_14.setText(top20[13]) );
		top20_14.setOnAction( e -> {
				twitterSearchField.setText(top20string[13]);
				window.setScene(twitterScene);
				twitterSearchButton.fire();
		} );

		Button top20_15 = new Button(top20[14]);
		top20_15.setOnMouseEntered( e -> top20_15.setText("View tweets!") );
		top20_15.setOnMouseExited( e -> top20_15.setText(top20[14]) );
		top20_15.setOnAction( e -> {
				twitterSearchField.setText(top20string[14]);
				window.setScene(twitterScene);
				twitterSearchButton.fire();
		} );

		Button top20_16 = new Button(top20[15]);
		top20_16.setOnMouseEntered( e -> top20_16.setText("View tweets!") );
		top20_16.setOnMouseExited( e -> top20_16.setText(top20[15]) );
		top20_16.setOnAction( e -> {
				twitterSearchField.setText(top20string[15]);
				window.setScene(twitterScene);
				twitterSearchButton.fire();
		} );

		Button top20_17 = new Button(top20[16]);
		top20_17.setOnMouseEntered( e -> top20_17.setText("View tweets!") );
		top20_17.setOnMouseExited( e -> top20_17.setText(top20[16]) );
		top20_17.setOnAction( e -> {
				twitterSearchField.setText(top20string[16]);
				window.setScene(twitterScene);
				twitterSearchButton.fire();
		} );

		Button top20_18 = new Button(top20[17]);
		top20_18.setOnMouseEntered( e -> top20_18.setText("View tweets!") );
		top20_18.setOnMouseExited( e -> top20_18.setText(top20[17]) );
		top20_18.setOnAction( e -> {
				twitterSearchField.setText(top20string[17]);
				window.setScene(twitterScene);
				twitterSearchButton.fire();
		} );

		Button top20_19 = new Button(top20[18]);
		top20_19.setOnMouseEntered( e -> top20_19.setText("View tweets!") );
		top20_19.setOnMouseExited( e -> top20_19.setText(top20[18]) );
		top20_19.setOnAction( e -> {
				twitterSearchField.setText(top20string[18]);
				window.setScene(twitterScene);
				twitterSearchButton.fire();
		} );

		Button top20_20 = new Button(top20[19]);
		top20_20.setOnMouseEntered( e -> top20_20.setText("View tweets!") );
		top20_20.setOnMouseExited( e -> top20_20.setText(top20[19]) );
		top20_20.setOnAction( e -> {
				twitterSearchField.setText(top20string[19]);
				window.setScene(twitterScene);
				twitterSearchButton.fire();
		} );

		top20_1.setId("top20TweetButton"); top20_2.setId("top20TweetButton"); top20_3.setId("top20TweetButton"); top20_4.setId("top20TweetButton"); top20_5.setId("top20TweetButton");
		top20_6.setId("top20TweetButton"); top20_7.setId("top20TweetButton"); top20_8.setId("top20TweetButton"); top20_9.setId("top20TweetButton"); top20_10.setId("top20TweetButton");
		top20_11.setId("top20TweetButton"); top20_12.setId("top20TweetButton"); top20_13.setId("top20TweetButton"); top20_14.setId("top20TweetButton"); top20_15.setId("top20TweetButton");
		top20_16.setId("top20TweetButton"); top20_17.setId("top20TweetButton"); top20_18.setId("top20TweetButton"); top20_19.setId("top20TweetButton"); top20_20.setId("top20TweetButton");

		// BUTTON ACTIONS (AFFECT MAIN DISPLAY BOX)
		// CLEAR CHILDREN, UPDATE LABEL, ADD RESPECTIVE LABELS AND INPUT BOX TO MAIN DISPLAY BOX

		spotifyTrackButton.setOnAction( e -> {
			mainDisplayBox.getChildren().clear();
			spotifyInputFieldLabel.setText("Enter a track name");
			spotifySearchBox.getChildren().clear();
			spotifySearchBox.getChildren().addAll(spotifyTrackInputField, spotifySearchButton);
			mainDisplayBox.getChildren().addAll(spotifyInputFieldLabel, spotifySearchBox, spotifyTrackResultLabel1, spotifyTrackResultLabel2, spotifyTrackResultLabel3, spotifyTrackResultLabel4, spotifyTrackResultLabel5);

			mainDisplayBox2.getChildren().clear();
			mainDisplayBox2.getChildren().addAll(spotifyFillerLabel, spotifyTrackResultLabel6, spotifyTrackResultLabel7, spotifyTrackResultLabel8, spotifyTrackResultLabel9, spotifyTrackResultLabel10);
		} );

		spotifyArtistButton.setOnAction( e -> {
			mainDisplayBox.getChildren().clear();
			spotifyInputFieldLabel.setText("Enter an artist name");
			spotifySearchBox.getChildren().clear();
			spotifySearchBox.getChildren().addAll(spotifyArtistInputField, spotifySearchButton);
			mainDisplayBox.getChildren().addAll(spotifyInputFieldLabel, spotifySearchBox, spotifyArtistResultLabel1, spotifyArtistResultLabel2, spotifyArtistResultLabel3, spotifyArtistResultLabel4, spotifyArtistResultLabel5);

			mainDisplayBox2.getChildren().clear();
			mainDisplayBox2.getChildren().addAll(spotifyFillerLabel, spotifyArtistResultLabel6, spotifyArtistResultLabel7, spotifyArtistResultLabel8, spotifyArtistResultLabel9, spotifyArtistResultLabel10);

		} );

		spotifyAlbumButton.setOnAction( e -> {
			mainDisplayBox.getChildren().clear();
			spotifyInputFieldLabel.setText("Enter an album name");
			spotifySearchBox.getChildren().clear();
			spotifySearchBox.getChildren().addAll(spotifyAlbumInputField, spotifySearchButton);
			mainDisplayBox.getChildren().addAll(spotifyInputFieldLabel, spotifySearchBox, spotifyAlbumResultLabel1, spotifyAlbumResultLabel2, spotifyAlbumResultLabel3, spotifyAlbumResultLabel4, spotifyAlbumResultLabel5);

			mainDisplayBox2.getChildren().clear();
			mainDisplayBox2.getChildren().addAll(spotifyFillerLabel, spotifyAlbumResultLabel6, spotifyAlbumResultLabel7, spotifyAlbumResultLabel8, spotifyAlbumResultLabel9, spotifyAlbumResultLabel10);

		} );

		spotifyTop20Button.setOnAction( e -> {
			mainDisplayBox.getChildren().clear();
			mainDisplayBox.getChildren().addAll(spotifyTop20Label, top20_1, top20_2, top20_3, top20_4, top20_5, top20_6, top20_7, top20_8, top20_9, top20_10);

			mainDisplayBox2.getChildren().clear();
			mainDisplayBox2.getChildren().addAll(spotifyFillerLabel, top20_11, top20_12, top20_13, top20_14, top20_15, top20_16, top20_17, top20_18, top20_19, top20_20);
		} );

		// HOME BUTTON
		spotifyHomeButton.setOnAction(e -> window.setScene(welcomeScene));

		// SEARCH BUTTON COMPLETES ALL SEARCHES (TRACK, ARTIST, ALBUM) IF POSSIBLE
		spotifySearchButton.setOnAction( e -> {

			if (spotifyTrackInputField.getText() != "")
			{
					try
					{
						JSONObject spotifyTrackJSON = sg.return_spotify_search(1, spotifyTrackInputField.getText());
						String[] JSON_track_strings = sg.return_spotify_track_string_array(spotifyTrackJSON);
						spotifyTrackResultLabel1.setText(JSON_track_strings[0]);
						spotifyTrackResultLabel2.setText(JSON_track_strings[1]);
						spotifyTrackResultLabel3.setText(JSON_track_strings[2]);
						spotifyTrackResultLabel4.setText(JSON_track_strings[3]);
						spotifyTrackResultLabel5.setText(JSON_track_strings[4]);

						spotifyTrackResultLabel6.setText(JSON_track_strings[5]);
						spotifyTrackResultLabel7.setText(JSON_track_strings[6]);
						spotifyTrackResultLabel8.setText(JSON_track_strings[7]);
						spotifyTrackResultLabel9.setText(JSON_track_strings[8]);
						spotifyTrackResultLabel10.setText(JSON_track_strings[9]);
					}

					catch(Exception ex)
					{
						spotifyTrackResultLabel1.setText("Error searching track");
					}
			}

			if (spotifyArtistInputField.getText() != "")
			{
					try
					{
						JSONObject spotifyArtistJSON = sg.return_spotify_search(2, spotifyArtistInputField.getText());
						String[] JSON_artist_strings = sg.return_spotify_artist_string_array(spotifyArtistJSON);
						spotifyArtistResultLabel1.setText(JSON_artist_strings[0]);
						spotifyArtistResultLabel2.setText(JSON_artist_strings[1]);
						spotifyArtistResultLabel3.setText(JSON_artist_strings[2]);
						spotifyArtistResultLabel4.setText(JSON_artist_strings[3]);
						spotifyArtistResultLabel5.setText(JSON_artist_strings[4]);

						spotifyArtistResultLabel6.setText(JSON_artist_strings[5]);
						spotifyArtistResultLabel7.setText(JSON_artist_strings[6]);
						spotifyArtistResultLabel8.setText(JSON_artist_strings[7]);
						spotifyArtistResultLabel9.setText(JSON_artist_strings[8]);
						spotifyArtistResultLabel10.setText(JSON_artist_strings[9]);
					}
					catch(Exception ex)
					{
						spotifyArtistResultLabel1.setText("Error searching artist");
					}
			}

			if (spotifyAlbumInputField.getText() != "")
			{
					try
					{
						JSONObject spotifyAlbumJSON = sg.return_spotify_search(3, spotifyAlbumInputField.getText());
						String[] JSON_album_strings = sg.return_spotify_album_string_array(spotifyAlbumJSON);
						spotifyAlbumResultLabel1.setText(JSON_album_strings[0]);
						spotifyAlbumResultLabel2.setText(JSON_album_strings[1]);
						spotifyAlbumResultLabel3.setText(JSON_album_strings[2]);
						spotifyAlbumResultLabel4.setText(JSON_album_strings[3]);
						spotifyAlbumResultLabel5.setText(JSON_album_strings[4]);

						spotifyAlbumResultLabel6.setText(JSON_album_strings[5]);
						spotifyAlbumResultLabel7.setText(JSON_album_strings[6]);
						spotifyAlbumResultLabel8.setText(JSON_album_strings[7]);
						spotifyAlbumResultLabel9.setText(JSON_album_strings[8]);
						spotifyAlbumResultLabel10.setText(JSON_album_strings[9]);
					}
					catch(Exception ex)
					{
						spotifyAlbumResultLabel1.setText("Error searching album");
					}
			}

		} );

		// ADD MAIN DISPLAY BOX TO LAYOUT
		spotifyLayout.add(mainDisplayBox, 1, 0);
		spotifyLayout.add(mainDisplayBox2, 2, 0);

		// CREATE SCENE FROM LAYOUT
		spotifyScene = new Scene(spotifyLayout);
		spotifyScene.getStylesheets().add("styleSheet.css");

		// ------------------------------------------------------------------ //

		// *** --- TWITTER SCENE --- *** //

		// ACTUALY LABELS DEFINED AT LINE 108
		// SEARCH TWITTER LABELS
		Label twitterSearchLabel = new Label("Find something on Twitter...");
		twitterSearchLabel.setId("twitterSearchLabel");
		Label twitterFillerLabel = new Label(" ");
		twitterFillerLabel.setId("twitterFillerLabel");

		// ACTUAL SEARCH BUTTON DEFINED AT LINE 119
		// SEARCH BUTTON IMAGE
		ImageView twitterSearchIcon = new ImageView(searchIcon);
		twitterSearchIcon.setMouseTransparent(true);
		twitterSearchIcon.setFitHeight(20);
		twitterSearchIcon.setFitWidth(35);
		twitterSearchIcon.setPreserveRatio(true);
		twitterSearchIcon.setImage(searchIcon);

		// SEARCH BUTTON
		twitterSearchButton.setId("twitterSearchButton");
		twitterSearchButton.setGraphic(twitterSearchIcon);
		HBox twitterSearchBox = new HBox(10);
		twitterSearchBox.getChildren().addAll(twitterSearchField, twitterSearchButton);
		twitterSearchBox.setId("twitterSearchBox");

		// ON CLICK, CLEAR SCENE, REPOPULATE WITH TWEET BOXES, AND REFRESH
		twitterSearchButton.setOnAction( e -> {

			twitterLayout1.getChildren().clear();
			twitterLayout1.getChildren().addAll(twitterSearchBox, twitterTweetBox);

			twitterSearchBox.setTranslateX(50);
			twitterSearchBox.setTranslateY(-250);
			// twitterTweetBox.setMouseTransparent(true);
			// twitterBackButton2.setMouseTransparent(false);

			if (twitterSearchField.getText() != "")
			{
				try
				{
					String[] tweet_strings = tg.search_return_string(twitterSearchField.getText());
					tweetLabel1.setText(tweet_strings[0]);
					tweetLabel2.setText(tweet_strings[1]);
					tweetLabel3.setText(tweet_strings[2]);
					tweetLabel4.setText(tweet_strings[3]);
					tweetLabel5.setText(tweet_strings[4]);
					tweetLabel6.setText(tweet_strings[5]);
					tweetLabel7.setText(tweet_strings[6]);
					tweetLabel8.setText(tweet_strings[7]);
					tweetLabel9.setText(tweet_strings[8]);
				}

				catch (Exception ex)
				{
					tweetLabel1.setText("Error fetching tweets");
				}

			}

			twitterScene.getStylesheets().clear();
			twitterScene.getStylesheets().add("styleSheet.css");

			window.setScene(twitterScene);
		} );

		// BACK BUTTON - PRE-SEARCH
		Button twitterBackButton = new Button("B\nA\nC\nK");
		twitterBackButton.setOnAction( e -> window.setScene(welcomeScene) );
		twitterBackButton.setId("twitterBackButton");
		twitterBackButton.setTranslateX(195);

		// BACK BUTTON - POST-SEARCH
		twitterBackButton2 = new Button("B\nA\nC\nK");
		twitterBackButton2.setOnAction( e -> window.setScene(welcomeScene) ); // NEED TO REBUILD SCENE WITH PREVIOUS LAYOUT
		twitterBackButton2.setId("twitterBackButton");

		// LAYOUT 2 - POST-SEARCH (VINCE I CHANGED THIS TO OVERWRITE THE INTIAL LAYOUT)
		tweetLayout = new GridPane();
		column1 = new ColumnConstraints(); column2 = new ColumnConstraints(); column3 = new ColumnConstraints();
		column1.setPercentWidth(100/3); column2.setPercentWidth(100/3); column3.setPercentWidth(100/3);
		row1 = new RowConstraints(); row2 = new RowConstraints(); row3 = new RowConstraints();
		row1.setMaxHeight(135); row2.setMaxHeight(135); row3.setMaxHeight(135);
		tweetLayout.getColumnConstraints().addAll(column1, column2, column3);
		tweetLayout.getRowConstraints().addAll(row1, row2, row3);

		// POPULATE LAYOUT WITH TWEET LABELS
		tweetLayout.add(tweetLabel1, 0, 0); tweetLayout.setHalignment(tweetLabel1, HPos.CENTER);
		tweetLayout.add(tweetLabel2, 1, 0); tweetLayout.setHalignment(tweetLabel2, HPos.CENTER);
		tweetLayout.add(tweetLabel3, 2, 0); tweetLayout.setHalignment(tweetLabel3, HPos.CENTER);
		tweetLayout.add(tweetLabel4, 0, 1); tweetLayout.setHalignment(tweetLabel4, HPos.CENTER);
		tweetLayout.add(tweetLabel5, 1, 1); tweetLayout.setHalignment(tweetLabel5, HPos.CENTER);
		tweetLayout.add(tweetLabel6, 2, 1); tweetLayout.setHalignment(tweetLabel6, HPos.CENTER);
		tweetLayout.add(tweetLabel7, 0, 2); tweetLayout.setHalignment(tweetLabel7, HPos.CENTER);
		tweetLayout.add(tweetLabel8, 1, 2); tweetLayout.setHalignment(tweetLabel8, HPos.CENTER);
		tweetLayout.add(tweetLabel9, 2, 2); tweetLayout.setHalignment(tweetLabel9, HPos.CENTER);
		tweetLayout.setHgap(35);
		tweetLayout.setVgap(25);
		tweetLayout.setAlignment(Pos.CENTER);
		tweetLayout.setMouseTransparent(true);
		tweetLayout.setId("tweetLayout");

		twitterTweetBox = new HBox();
		twitterTweetBox.getChildren().addAll(tweetLayout, twitterBackButton2);
		twitterTweetBox.setId("twitterTweetBox");

		// LAYOUT 1 - PRE-SEARCH
		twitterLayout1 = new GridPane();
		twitterLayout1.add(twitterSearchLabel, 0, 0);
		twitterLayout1.add(twitterFillerLabel, 1, 0);
		twitterLayout1.add(twitterSearchBox, 0, 0);
		twitterLayout1.add(twitterBackButton, 2, 0);
		twitterLayout1.setId("twitterLayout1");

		twitterLayout1.setAlignment(Pos.CENTER);

		twitterScene = new Scene(twitterLayout1);
		twitterScene.getStylesheets().add("styleSheet.css");

		// SHOW WELCOME SCENE ON START
		window.setScene(welcomeScene);
		window.show();
	}
}
