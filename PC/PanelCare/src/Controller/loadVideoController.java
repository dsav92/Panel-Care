package Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Mosaic.VideoMosaic;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

public class loadVideoController {

	String absolutePath;
	VideoMosaic videoM;
	boolean control = false;	
	Task task_1 = task();
	

    @FXML
    private AnchorPane panel;
	
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ann;

    @FXML
    private Button elabora;

    @FXML
    private ProgressBar load;

    @FXML
    private TextField pathVideo;

    @FXML
    private Button browse;

    @FXML
    void cercaVideo(ActionEvent event) {
    	
    	FileChooser chooser = new FileChooser();
    	FileChooser.ExtensionFilter extensionMP4 =  new FileChooser.ExtensionFilter("Add Files(*.mp4)", "*.mp4");
    	chooser.getExtensionFilters().add(extensionMP4);
    	File file = chooser.showOpenDialog(browse.getContextMenu());
    	absolutePath = file.getAbsolutePath();
    	String sep = System.getProperty("file.separator");
    	char slash = sep.charAt(0);
    	absolutePath = absolutePath.replace(slash, '/');
    	pathVideo.setText(absolutePath);
    	control = true;

    }

    @FXML
    void elaboraVideo(ActionEvent event) throws IOException {

    	if(control == false) {
    		
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Impossibile proseguire");
    		alert.setHeaderText(null);
    		alert.setContentText("Nessun video selezionato!");
    		alert.show();
    		
    	} else {
    		
    		/*long inizio = System.currentTimeMillis();
        	videoM.workVideo(absolutePath);
        	long fine = System.currentTimeMillis();
        	long time=(inizio-fine)/1000;
        	load.setProgress(time); */
    		
    		elabora.setDisable(true);
    		load.setProgress(0);
    		load.progressProperty().unbind();
    		load.progressProperty().bind(task_1.progressProperty());
    		new Thread(task_1).start();
    	}
    	
    }

    @FXML
    void annulla(ActionEvent event) {

    	this.control = false;
    	pathVideo.setText("");
    	task_1.cancel(true);
    	load.progressProperty().unbind();
    	load.setProgress(0);
    	
    }

    public Task task() {
    	return new Task() {

			@Override
			protected Object call() throws Exception {
				return 	videoM.workVideo(absolutePath);
			}
    		
    	};
    }
    
    @FXML
    void initialize() {
        assert ann != null : "fx:id=\"ann\" was not injected: check your FXML file 'schermata2.fxml'.";
        assert elabora != null : "fx:id=\"elabora\" was not injected: check your FXML file 'schermata2.fxml'.";
        assert load != null : "fx:id=\"load\" was not injected: check your FXML file 'schermata2.fxml'.";
        assert pathVideo != null : "fx:id=\"pathVideo\" was not injected: check your FXML file 'schermata2.fxml'.";
        assert browse != null : "fx:id=\"browse\" was not injected: check your FXML file 'schermata2.fxml'.";

    }
	
}
