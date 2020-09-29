import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class StageTitle extends Application {
	public void start(Stage stage) {
		Label label = new Label("Hello World!");
		label.setFont(new Font(20));
		
		Scene scene = new Scene(label);
		stage.setTitle("Hello!");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch();
	}
}
