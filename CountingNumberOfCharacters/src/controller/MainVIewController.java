package controller;

//import counter.CharacterCounter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import outputformatter.WordLengthFormatter;
import validator.InputValidator;

/**
 *
 * @author animusanima
 */
public class MainVIewController implements Initializable 
{   
    @FXML
    Label wordLengthLabel;
    
    @FXML
    TextField wordField;    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        wordField.textProperty().addListener(
                (ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                    try {
                        if (InputValidator.validate(newValue))
                            wordLengthLabel.setText(WordLengthFormatter.format(newValue));
                    } catch (IllegalArgumentException argEx) {
                        wordLengthLabel.setText("The word is 0 character long.");
                    }
                        
                }
        );
    }    
    
}