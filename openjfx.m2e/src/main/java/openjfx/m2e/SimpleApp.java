package openjfx.m2e;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SimpleApp extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane p = new BorderPane(new Button("Hello World!"));
		Scene s = new Scene(p, 800, 600);
		stage.setScene(s);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}
