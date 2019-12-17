package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;



public class Controller   {
    //array to check point values
  private   int [] pointsArray = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
    int points = 0;
    int temp = 0 ;

    //define all fxml
    @FXML
    TextField enterWords;
    @FXML
    Label pointsTotal;

    @FXML
    private Button submitButton;


    @FXML
    private Label letterA,letterB,letterC,letterD,letterE,letterF,letterG,letterH,letterI,letterJ,letterK,letterL,letterM,letterN,letterO,letterP,letterQ,letterR,letterS,letterT,letterU,letterV,letterW,letterX,letterY,letterZ;
    //submit button on click
    @FXML
    private void submitButtonClicked(ActionEvent event) {
        String text;
        text = enterWords.getText();
        WordModel submittedWord = new WordModel(text);
        String wordText = submittedWord.getWords().toUpperCase();
        //created new alert for future error usage
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        boolean isValidWord=true;
        //for loop to check the previous words and if new word contains one of the previous word
        for(int i=0;i<Rules.previousWords.size();i++){
             isValidWord=true;
             //if statement to check new word with old words
            if(wordText.equals(Rules.previousWords.get(i))){
                //sets and shows error message
                alert.setHeaderText("Error message");
                alert.setContentText("Word was already entered");
                alert.showAndWait();
                isValidWord=false;
                break;
            }
        }
        //checks if the word still valid
        if(isValidWord) {
            //loop where i check remaining letters in the bag
            for (int i = 0; i < wordText.length(); i++) {

                temp = Rules.listOfLetters.get(wordText.charAt(i));
                temp--;
                if (temp < 0) {
                    //sets and shows error message
                    isValidWord = false;
                    alert.setHeaderText("Error message");
                    alert.setContentText("You have no more letters left");
                    alert.showAndWait();

                }

            }
        }
            if(isValidWord) {

                for (int i = 0; i < wordText.length(); i++) {
                    //runs if the word you enter contains letters from game
                    if (Rules.listOfLetters.containsKey(wordText.charAt(i))) {
                        //counts points
                        points  +=  pointsArray[wordText.charAt(i) - 65];

                        int value = Rules.listOfLetters.get(wordText.charAt(i));
                        if (value >= 0) {
                            //decrement from the amount of letters in array
                            Rules.listOfLetters.put(wordText.charAt(i), value - 1);
                        }
                        //ends game
                        if(value <= 0){
                            System.out.println("Game over");
                        }

                    }
                    //sets a number of letters in a bag
                    setGUILetters();
                }
                //sets points to label
                pointsTotal.setText(" " + points);
                //adds new word to previous words
                Rules.addPreviousWords(wordText);
            }
            else{
                //clear and reset
                enterWords.setText(" ");
            }

    }



    public  void setGUILetters(){
        //sets labels to number of remaining letters in a bag
        letterA.setText(Rules.listOfLetters.values().toArray()[0].toString());
        letterB.setText(Rules.listOfLetters.values().toArray()[1].toString());
        letterC.setText(Rules.listOfLetters.values().toArray()[2].toString());
        letterD.setText(Rules.listOfLetters.values().toArray()[3].toString());
        letterE.setText(Rules.listOfLetters.values().toArray()[4].toString());
        letterF.setText(Rules.listOfLetters.values().toArray()[5].toString());
        letterG.setText(Rules.listOfLetters.values().toArray()[6].toString());
        letterH.setText(Rules.listOfLetters.values().toArray()[7].toString());
        letterI.setText(Rules.listOfLetters.values().toArray()[8].toString());
        letterJ.setText(Rules.listOfLetters.values().toArray()[9].toString());
        letterK.setText(Rules.listOfLetters.values().toArray()[10].toString());
        letterL.setText(Rules.listOfLetters.values().toArray()[11].toString());
        letterM.setText(Rules.listOfLetters.values().toArray()[12].toString());
        letterN.setText(Rules.listOfLetters.values().toArray()[13].toString());
        letterO.setText(Rules.listOfLetters.values().toArray()[14].toString());
        letterP.setText(Rules.listOfLetters.values().toArray()[15].toString());
        letterQ.setText(Rules.listOfLetters.values().toArray()[16].toString());
        letterR.setText(Rules.listOfLetters.values().toArray()[17].toString());
        letterS.setText(Rules.listOfLetters.values().toArray()[18].toString());
        letterT.setText(Rules.listOfLetters.values().toArray()[19].toString());
        letterU.setText(Rules.listOfLetters.values().toArray()[20].toString());
        letterV.setText(Rules.listOfLetters.values().toArray()[21].toString());
        letterW.setText(Rules.listOfLetters.values().toArray()[22].toString());
        letterX.setText(Rules.listOfLetters.values().toArray()[23].toString());
        letterY.setText(Rules.listOfLetters.values().toArray()[24].toString());
        letterZ.setText(Rules.listOfLetters.values().toArray()[25].toString());




    }
   // calls new fxml window made for previous words
    @FXML private void previousWordsButton(ActionEvent event) throws Exception{
        Rules.loadLetters() ;
        Stage secondStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("previousWordsWindow.fxml"));
        secondStage.setTitle("Assignment 2");
        secondStage.setScene(new Scene(root));
        secondStage.show();
    }

    @FXML
    public void initialize() {
                setGUILetters();
    }

}
