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
	Scene welcomeScene, spotifyScene, twitterScene;
	ListView<String> listView1, listView2;
	ChoiceBox<String> choiceBox;

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

		// WELCOME SCREEN ELEMENTS
		Label titleLabel = new Label("TWITTIFY");
		titleLabel.setId("titleLabel");
		titleLabel.setMouseTransparent(true);
		Button twitterButton = new Button();
		twitterButton.setId("twitterButton");
		Button spotifyButton = new Button();
		spotifyButton.setId("spotifyButton");

		Image twitterLogoImage = new Image("twitterLogoGray.png");
		ImageView twitterLogo = new ImageView();
		twitterLogo.setMouseTransparent(true);
		twitterLogo.setFitWidth(200);
		twitterLogo.setPreserveRatio(true);

		Image spotifyLogoImage = new Image("spotifyLogoGray.png");
		ImageView spotifyLogo = new ImageView();
		spotifyLogo.setMouseTransparent(true);
		spotifyLogo.setFitWidth(175);
		spotifyLogo.setPreserveRatio(true);

		twitterButton.setGraphic(twitterLogo);
		spotifyButton.setGraphic(spotifyLogo);

		twitterLogo.setImage(twitterLogoImage);
		spotifyLogo.setImage(spotifyLogoImage);

		titleLabel.setTranslateY(-200);
		titleLabel.setTranslateX(-258);

		// IDVIDES SCREEN IN HALF; LEFT SIDE TWITTER (0,0); RIGHT SIDE SPOTIFY (1,0)
		welcomeLayout.add(twitterButton, 0, 0);
		welcomeLayout.add(spotifyButton, 1, 0);
		welcomeLayout.add(titleLabel, 1, 0);

		welcomeScene = new Scene(welcomeLayout);
		welcomeScene.getStylesheets().add("styleSheet.css");

		// SPOTIFY SCENE
		Button trackButton = new Button("Search Track");
		Button artistButton = new Button("Search Artist");
		Button albumButton = new Button("Search Album");
		Button top20Button = new Button("Spotify Top 20");

		

		window.setScene(welcomeScene);
		window.show();
	}
}
