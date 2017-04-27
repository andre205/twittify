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

		// DIVIDES SCREEN IN HALF; LEFT SIDE TWITTER (0,0); RIGHT SIDE SPOTIFY (1,0)
		welcomeLayout.add(twitterButton, 0, 0);
		welcomeLayout.add(spotifyButton, 1, 0);
		welcomeLayout.add(titleLabel, 1, 0);

		welcomeScene = new Scene(welcomeLayout);
		welcomeScene.getStylesheets().add("styleSheet.css");

		// // SPOTIFY SCENE
		// Button trackButton = new Button("Search Track");
		// Button artistButton = new Button("Search Artist");
		// Button albumButton = new Button("Search Album");
		// Button top20Button = new Button("Spotify Top 20");
		//
		// VBox choicesBox = new VBox();
		// choicesBox.getChildren().addAll(trackButton, artistButton, albumButton, top20Button);
		//
		// spotifyScene = new Scene(choicesBox);

		window.setScene(welcomeScene);
		window.show();
	}
}
