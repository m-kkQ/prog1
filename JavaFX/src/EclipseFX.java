import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class EclipseFX extends Application {

	private TextArea editor;
	private TextArea console;
	private TextArea projectview;
	private TextArea outline;
	private Label lblStatus;
	private Stage mainStage;
	private File workingFile;

	@Override
	public void start(Stage primaryStage) throws Exception {
		mainStage = primaryStage;

		BorderPane mainPane = new BorderPane();

		mainPane.setTop(buildNavBar());
		mainPane.setLeft(buildProjectView());
		mainPane.setCenter(buildEditorPane());
		mainPane.setRight(buildOutlineView());
		mainPane.setBottom(BottomView());

		Scene scene = new Scene(mainPane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Eclipse");
		primaryStage.sizeToScene();
		primaryStage.show();

	}

	private Node BottomView() {

		BorderPane BottomView = new BorderPane();

		BottomView.setTop(buildConsole());
		BottomView.setBottom(buildStatusPane());

		return BottomView;
	}

	private Node buildConsole() {

		BorderPane ConsolePane = new BorderPane();

		ConsolePane.setTop(ConsoleTabs());
		ConsolePane.setBottom(ConsoleView());

		return ConsolePane;
	}

	private Node ConsoleView() {
		console = new TextArea();
		return console;
	}

	private Node ConsoleTabs() {

		HBox hbox = new HBox(2);

		Button btnConsole = new Button("Console");
		Button btnJavaDoc = new Button("JavaDoc");
		Button btnProblems = new Button("Problems");

		hbox.getChildren().addAll(btnConsole, btnJavaDoc, btnProblems);

		return hbox;

	}

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
		
		Button btnNew = new Button("New");
		btnNew.setOnAction(ev -> {
			lblStatus.setText("New file");
			editor.clear();
			workingFile = null;
			
		});

		Button btnOpen = new Button("Open");
		btnOpen.setOnAction(ev -> {
			lblStatus.setText("Open file...");
			chooseFileAndOpen();

		});

		Button btnSave = new Button("Save as..");
		btnSave.setOnAction(ev -> {
			lblStatus.setText("Saved as " + workingFile.getAbsolutePath());
			chooseFileAndSave();
		});

		Button btnSaveAs = new Button("Save");
		btnSaveAs.setOnAction(ev -> {
			saveAsToFile();
			lblStatus.setText("Saved");
		});

		hbox.getChildren().addAll(btnNew, btnOpen, btnSave, btnSaveAs);

		return hbox;

	}

	private void saveAsToFile() {
		if (workingFile == null) {
			chooseFileAndSave();			
		} else {
			saveFileFromEditor();
		}
		
	}

	private void chooseFileAndSave() {
		File selectedFile = chooseFileToSave();
		
		if(selectedFile != null) {
			workingFile = selectedFile;
			saveFileFromEditor();
		}
	}

	private void saveFileFromEditor() {
			try (BufferedWriter writer =
					new BufferedWriter(
							new FileWriter(
									workingFile))) {

				
			String text = editor.getText();
			writer.write(text);
			lblStatus.setText("File " + workingFile.getAbsolutePath() + " saved");
			
			
			} catch (IOException e) {
				lblStatus.setText("File not saved");
			}
		}
	

	private void chooseFileAndOpen() {
		File selectedFile = chooseFileToOpen();

		if(selectedFile != null) {
			workingFile = selectedFile;
			openFileAndShow();
		}
	}

	private void openFileAndShow() {
				try (BufferedReader reader =
						new BufferedReader(
								new FileReader(
										workingFile))) {

				editor.clear();
				String line = "";
				while ((line = reader.readLine()) != null) {
					editor.appendText(line);
					editor.appendText("\n");
				}
				lblStatus.setText("Opened file: " + workingFile.getAbsolutePath());

			} catch (FileNotFoundException e) {
				lblStatus.setText("File not found");
			} catch (IOException e) {
				lblStatus.setText("File not read");
			}

		}
	

	private File chooseFileToOpen() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open...");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt", "*.md", "*.rtf"),
				new ExtensionFilter("Java Files", "*.java"), new ExtensionFilter("Common Lisp File", "*.cl", "*.lisp"));

		File selectedFile = fileChooser.showOpenDialog(mainStage);
		return selectedFile;
	}

	private File chooseFileToSave() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save...");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt", "*.md", "*.rtf"),
				new ExtensionFilter("Java Files", "*.java"), new ExtensionFilter("Common Lisp File", "*.cl", "*.lisp"));

		File selectedFile = fileChooser.showSaveDialog(mainStage);
		return selectedFile;
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
		Button btn3 = new Button("Other");
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
		outline = new TextArea();

		return outline;
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

		projectview = new TextArea();

		return projectview;

	}

	private Node buildStatusPane() {
		HBox hbox = new HBox(10);

		lblStatus = new Label("ok");
		hbox.getChildren().add(lblStatus);
		return hbox;
	}

}
