/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doc;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author youse
 */
public class GUIController implements Initializable {

    @FXML
    private TextArea text;
    
    @FXML
    private Button scanner;
    @FXML
    private Button clearer;
    @FXML
    private TextArea out;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
        
    


    @FXML
    private void scan(ActionEvent event) {
        if (text.getText().isEmpty())
            {   
                text.setText("The field cannot be left blank.");
            }
        else{
            String s = text.getText(); 
            TinyScanner ts = new TinyScanner(s);
            ts.analyze();
            String ss = ts.toString();
            if(ss.contains("ERROR")){
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("An error has occurred");
                alert.setContentText("You entered an unrecognized character");
                alert.showAndWait();
                }
            else
                {
                   out.setText(ss);
                }
            }
}
    
    @FXML
    private void clear(ActionEvent event) {
        text.clear();
        out.clear();
        text.requestFocus();
    }

    @FXML
    private void initialize(MouseEvent event) {
    }
    
}
