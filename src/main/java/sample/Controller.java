package sample;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;
    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;
    @FXML // fx:id="nameTextField"
    private TextField nameTextField; // Value injected by FXMLLoader
    @FXML // fx:id="commentTextArea"
    private TextArea commentTextArea; // Value injected by FXMLLoader
    @FXML // fx:id="levelChoiceBox"
    private ChoiceBox<String> levelChoiceBox; // Value injected by FXMLLoader
    @FXML // fx:id="btnGenerate"
    private Button btnGenerate; // Value injected by FXMLLoader
    @FXML
    private Button btnCleanField;

    Dictionaries dictionaries = new Dictionaries();
    ObservableList<String> marks = FXCollections.observableArrayList("Excellent", "Good", "Bad");
    private boolean isInitialize = false;
    private String comment = null;

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        //Кнопка генерации
        btnGenerate.setOnAction(event -> {
            if (!isInitialize) {
                dictionaries.initializeLists();
                isInitialize = true;
            }



            if (Objects.equals(levelChoiceBox.getValue(), "Excellent"))
            {
                comment = nameTextField.getText() + " "
                        + dictionaries.getMaterial() + " "
                        + dictionaries.getHomework() + " "
                        + dictionaries.getGeneralCharacter() + " "
                        + dictionaries.getSelfEducation();
            }

            if (Objects.equals(levelChoiceBox.getValue(),"Good"))
            {
                comment = nameTextField.getText() + " "
                        + dictionaries.getMaterial() + " "
                        + dictionaries.getBadWork() + " "
                        + dictionaries.getGeneralCharacter() + " "
                        + dictionaries.getGoodWork();
            }

            if (Objects.equals(levelChoiceBox.getValue(),"Bad"))
            {
                comment = nameTextField.getText() + " "
                        + dictionaries.getMaterial() + " "
                        + dictionaries.getGeneralCharacter() + " "
                        + dictionaries.getBadWork();
            }

            if (Objects.equals(levelChoiceBox.getValue(),null))
            {
                comment = "Select student level!";
            }

            commentTextArea.setText(comment);
        });
        // Очистка полей
        btnCleanField.setOnAction(event -> {
            nameTextField.clear();
            commentTextArea.clear();
        });

        levelChoiceBox.setItems(marks);
    }


}
