package sample;

import javafx.scene.control.Alert;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WordModel {

    String words;
    //constructor
    public WordModel(String words) {
        setWords(words);
    }

    public String getWords() {
        return words;
    }
    //checks entered words for vowels
    public static boolean vowels(String s){
        String word = s.toUpperCase();
        char[] words = word.toCharArray();
        for(int i = 0; i<words.length; i++){
            char z = words[i];
            if (z=='A'||z=='E'||z=='I'||z=='O'||z=='U'||z=='Y') return true;
        }
        return false;
    }
    public void setWords(String words) {
        //created new alert for future error usage
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Error message");
        //checks if the text field is empty
        if(words.isEmpty()){
            //sets and shows error message
            alert.setContentText("Word is empty");
            alert.showAndWait();
            throw new IllegalArgumentException("Word is empty");
        }
        //checks if the word not less than 2 letters and not more than 8
        else if(words.length() < 2 || words.length() > 8){
            //sets and shows error message
            alert.setContentText("Unaccepted length! Must be more than or equals 2 less then 9");
            alert.showAndWait();
            throw new IllegalArgumentException("Unaccepted length! Must be more than or equals 2 less then 9");
        }
        //checks entered words for vowels
         else if (!vowels(words)){
            //sets and shows error message
            alert.setContentText("Must be at least one vowel");
            alert.showAndWait();
            throw new IllegalArgumentException("Must contain a vowel");
        }
        this.words = words;
    }
}
