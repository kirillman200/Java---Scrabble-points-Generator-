package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class previousWordsController {


    @FXML
    private ListView<String> previousWordsListView;

    // sets the list of previous words
    @FXML
    public void initialize() {

      previousWordsListView.setItems( Rules.previousWords);

    }


}
