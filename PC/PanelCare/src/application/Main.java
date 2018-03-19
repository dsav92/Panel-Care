package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private static final int MIN_HEIGHT = 100;
    private static final int MIN_WIDTH = 640;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			FXMLLoader loader = new FXMLLoader();
			Class<?> classe = getClass();
			Parent root = loader.load(classe.getResource("schermata1.fxml"));
			primaryStage.setTitle("PanelCare");
			primaryStage.initStyle(StageStyle.DECORATED);
			primaryStage.setMaxHeight(MIN_HEIGHT);
			primaryStage.setMaxWidth(MIN_WIDTH);
			double width = Screen.getPrimary().getBounds().getWidth();
	        double height = Screen.getPrimary().getBounds().getHeight();
	        
	        Scene scene = new Scene(root);
	        primaryStage.setScene(scene);
	        primaryStage.centerOnScreen();
	        primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
