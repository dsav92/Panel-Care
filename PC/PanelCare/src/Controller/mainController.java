package Controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class mainController extends Stage {

	public Region root;
	public Scene scene;
	private static final int MIN_HEIGHT = 296;
    private static final int MIN_WIDTH = 458;
	
	@FXML
    private ResourceBundle resources;

    @FXML
    private VBox vBox;
	
    @FXML
    private URL location;

    @FXML
    private MenuItem mNew;

    @FXML
    private MenuItem mCopy;

    @FXML
    private MenuItem mSelect;

    @FXML
    private MenuItem mHelpp;

    @FXML
    private Menu menuH;

    @FXML
    private MenuItem mCut;

    @FXML
    private Menu menuF;

    @FXML
    private MenuItem mClose;

    @FXML
    private Menu menuE;

    @FXML
    private MenuItem mDelete;

    @FXML
    private MenuItem mSaveAs;

    @FXML
    private MenuItem mSave;

    @FXML
    private MenuItem mPr;

    @FXML
    private MenuBar menuBar;

    @FXML
    private MenuItem mUnselect;

    @FXML
    private MenuItem mOpen;

    @FXML
    private MenuItem mPaste;

    @FXML
    private MenuItem mUndo;

    @FXML
    private MenuItem mQuit;

    @FXML
    private Menu mOpenRecent;

    @FXML
    void openVideo(ActionEvent event) throws IOException {

    	FXMLLoader loader = new FXMLLoader();
		Class<?> classe = getClass();
		Parent root = loader.load(classe.getResource("schermata2.fxml"));
		Stage stage = new Stage();
		stage.setTitle("PanelCare");
		stage.initStyle(StageStyle.DECORATED);
		stage.setMaxHeight(MIN_HEIGHT);
		stage.setMaxWidth(MIN_WIDTH);
		
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
        
		
    }
    
    @FXML
    void initialize() {
        assert mNew != null : "fx:id=\"mNew\" was not injected: check your FXML file 'schermata1.fxml'.";
        assert mCopy != null : "fx:id=\"mCopy\" was not injected: check your FXML file 'schermata1.fxml'.";
        assert mSelect != null : "fx:id=\"mSelect\" was not injected: check your FXML file 'schermata1.fxml'.";
        assert vBox != null : "fx:id=\"vBox\" was not injected: check your FXML file 'schermata1.fxml'.";
        assert mHelpp != null : "fx:id=\"mHelpp\" was not injected: check your FXML file 'schermata1.fxml'.";
        assert menuH != null : "fx:id=\"menuH\" was not injected: check your FXML file 'schermata1.fxml'.";
        assert mCut != null : "fx:id=\"mCut\" was not injected: check your FXML file 'schermata1.fxml'.";
        assert menuF != null : "fx:id=\"menuF\" was not injected: check your FXML file 'schermata1.fxml'.";
        assert mClose != null : "fx:id=\"mClose\" was not injected: check your FXML file 'schermata1.fxml'.";
        assert menuE != null : "fx:id=\"menuE\" was not injected: check your FXML file 'schermata1.fxml'.";
        assert mDelete != null : "fx:id=\"mDelete\" was not injected: check your FXML file 'schermata1.fxml'.";
        assert mSaveAs != null : "fx:id=\"mSaveAs\" was not injected: check your FXML file 'schermata1.fxml'.";
        assert mSave != null : "fx:id=\"mSave\" was not injected: check your FXML file 'schermata1.fxml'.";
        assert mPr != null : "fx:id=\"mPr\" was not injected: check your FXML file 'schermata1.fxml'.";
        assert menuBar != null : "fx:id=\"menuBar\" was not injected: check your FXML file 'schermata1.fxml'.";
        assert mUnselect != null : "fx:id=\"mUnselect\" was not injected: check your FXML file 'schermata1.fxml'.";
        assert mOpen != null : "fx:id=\"mOpen\" was not injected: check your FXML file 'schermata1.fxml'.";
        assert mPaste != null : "fx:id=\"mPaste\" was not injected: check your FXML file 'schermata1.fxml'.";
        assert mUndo != null : "fx:id=\"mUndo\" was not injected: check your FXML file 'schermata1.fxml'.";
        assert mQuit != null : "fx:id=\"mQuit\" was not injected: check your FXML file 'schermata1.fxml'.";
        assert mOpenRecent != null : "fx:id=\"mOpenRecent\" was not injected: check your FXML file 'schermata1.fxml'.";

    }	
	
}
