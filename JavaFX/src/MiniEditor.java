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
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class MiniEditor extends Application {
	
	private Label lblStatus;
	private TextArea editor;
	private File workingFile;
	private Stage mainStage;
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		mainStage = primaryStage;
		
		BorderPane mainPane = new BorderPane();
		
		mainPane.setTop(NavBar());
		mainPane.setCenter(buildEditorPane());
		mainPane.setBottom(buildStatusPane());
		
		Scene scene = new Scene(mainPane, 600, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("MiniEditor");
		primaryStage.show();
		

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
			chooseFileAndSave();
			lblStatus.setText("Saved as " + workingFile.getAbsolutePath());
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
