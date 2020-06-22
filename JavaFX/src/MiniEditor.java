import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MiniEditor extends Application {
	
	private Label lblStatus;
	private TextArea editor;
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		BorderPane mainPane = new BorderPane();
		
		mainPane.setTop(buildButtonPane());
		mainPane.setCenter(buildEditorPane());
		mainPane.setBottom(buildStatusPane());
		
		Scene scene = new Scene(mainPane, 600, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("MiniEditor");
		primaryStage.show();
		

	}

	private Node buildButtonPane() {
		HBox hbox = new HBox(1);
		
		Button btnOpen = new Button("Öffnen");
		Button btnSave = new Button("Speichern");
		Button btnSaveAs = new Button("Speichern unter");
		
		hbox.getChildren().addAll(btnOpen,btnSave,btnSaveAs);
		
	
		return hbox;
	}

	private Node buildEditorPane() {
		editor = new TextArea();
		
		return editor;
	}

	private Node buildStatusPane() {
		HBox hbox = new HBox(10);
		
		lblStatus = new Label("ok");
		hbox.getChildren().add(lblStatus);
		return hbox;
	}

}
