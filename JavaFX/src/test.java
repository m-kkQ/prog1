import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class test extends Application {

	private static void setBackground(Region region, Color color) {
	    region.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

	    BorderPane outer = new BorderPane();
	    BorderPane inner = new BorderPane();

	    Region top = new Region();
	    top.setPrefSize(300, 300);
	    setBackground(top, Color.RED);

	    Region bottom = new Region();
	    bottom.setPrefSize(400, 200);
	    setBackground(bottom, Color.YELLOW);

	    Region right = new Region();
	    setBackground(right, Color.BLUE);
	    right.setPrefSize(200, 500);

	    inner.setCenter(top);
	    inner.setBottom(bottom);

	    outer.setCenter(inner);
	    outer.setRight(right);

	    Scene s = new Scene(outer);
	    primaryStage.setScene(s);
	    primaryStage.show();

	}
	
	
	
}
