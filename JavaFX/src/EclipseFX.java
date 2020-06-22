import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class EclipseFX extends Application {

	private TextArea editor;
	private Label lblStatus;

	@Override
	public void start(Stage primaryStage) throws Exception {

		BorderPane mainPane = new BorderPane();

		mainPane.setTop(buildNavBar());
		mainPane.setLeft(buildProjectView());
		mainPane.setCenter(MainView());
		mainPane.setBottom(buildStatusPane());

		Scene scene = new Scene(mainPane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Eclipse");
		primaryStage.sizeToScene();
		primaryStage.show();

	}

	private Node MainView() {

		BorderPane MainView = new BorderPane();

		MainView.setLeft(TopMain());
		MainView.setBottom(buildConsole());

		return MainView;
	}

	private Node TopMain() {

		BorderPane TopMain = new BorderPane();

		TopMain.setLeft(buildEditorPane());
		TopMain.setRight(buildOutlineView());

		return TopMain;

	}

	// Console Panels
	private Node buildConsole() {

		BorderPane ConsolePane = new BorderPane();

		ConsolePane.setTop(ConsoleTabs());
		ConsolePane.setBottom(ConsoleView());

		return ConsolePane;
	}

	private Node ConsoleView() {
		editor = new TextArea();
		return editor;
	}

	private Node ConsoleTabs() {

		HBox hbox = new HBox(2);

		Button btnConsole = new Button("Console");
		Button btnJavaDoc = new Button("JavaDoc");
		Button btnProblems = new Button("Problems");

		hbox.getChildren().addAll(btnConsole, btnJavaDoc, btnProblems);

		return hbox;

	}

	// Editor Pane

	private Node buildEditorPane() {

		BorderPane EditorPane = new BorderPane();

		EditorPane.setTop(EditorLabel());
		EditorPane.setLeft(EditorText());

		return EditorPane;
	}

	private Node EditorText() {
		editor = new TextArea();

		return editor;
	}

	private Node EditorLabel() {
		HBox hbox = new HBox();

		Button btn1 = new Button("Editor");

		hbox.getChildren().add(btn1);

		return hbox;
	}

	// Top Bars
	private Node buildNavBar() {

		BorderPane navPane = new BorderPane();

		navPane.setTop(NavBar());
		navPane.setBottom(ButtonBar());

		return navPane;
	}

	private Node ButtonBar() {
		HBox hbox = new HBox(2);

		Button btnCompile = new Button("Compile");
		Button btnDebug = new Button("Debug");
		Button btnDelete = new Button("Delete");

		hbox.getChildren().addAll(btnCompile, btnDebug, btnDelete);

		return hbox;
	}

	private Node NavBar() {
		HBox hbox = new HBox(2);

		Button btnOpen = new Button("Öffnen");

		btnOpen.setOnAction(ev -> {
			lblStatus.setText("Datei öffnen");
		});


		Button btnSave = new Button("Speichern");
		btnSave.setOnAction(ev -> {
			lblStatus.setText("Datei gespeichert");
		});

	
		Button btnSaveAs = new Button("Speichern als...");
		btnSaveAs.setOnAction(ev -> {
			lblStatus.setText("Datei speichern als...");
		});


		hbox.getChildren().addAll(btnOpen, btnSave, btnSaveAs);

		return hbox;

	}

	private Node buildOutlineView() {

		BorderPane OutlineView = new BorderPane();

		OutlineView.setTop(OutLineView());
		OutlineView.setLeft(OutlineText());

		return OutlineView;
	}

	private Node OutLineView() {
		BorderPane OutlineView = new BorderPane();

		OutlineView.setTop(OutlineLabel());
		OutlineView.setCenter(OutlineTabs());

		return OutlineView;

	}

	private Node OutlineTabs() {

		HBox hbox = new HBox();
		Button btn1 = new Button("Variables");
		Button btn2 = new Button("Functions");
		Button btn3 = new Button("Anderer Scheiß");
		hbox.getChildren().addAll(btn1, btn2, btn3);
		return hbox;
	}

	private Node OutlineLabel() {
		HBox hbox = new HBox();

		Button btn1 = new Button("Outline");

		hbox.getChildren().add(btn1);

		return hbox;
	}

	private Node OutlineText() {
		editor = new TextArea();

		return editor;
	}

	private Node buildProjectView() {

		BorderPane ProjectView = new BorderPane();

		ProjectView.setTop(ProjectLabel());
		ProjectView.setRight(ProjectText());

		return ProjectView;
	}

	private Node ProjectLabel() {
		HBox hbox = new HBox();

		Button btn1 = new Button("Project View");

		hbox.getChildren().add(btn1);
		return hbox;
	}

	private Node ProjectText() {

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
