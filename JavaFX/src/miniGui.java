import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;



public class miniGui extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		HBox hbox = new HBox();
		
		Button btn = new Button("klick mich");
		hbox.getChildren().add(btn);
		
		Scene scene = new Scene(hbox, 100,100);
		primaryStage.setScene(scene);
		primaryStage.setTitle("mein erstes Fenster");
		primaryStage.show();
	}

}
