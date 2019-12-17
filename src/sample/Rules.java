package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.TreeMap;

public class Rules {

    // new treemap
    public  static TreeMap<Character, Integer> listOfLetters = new TreeMap<>();
    // new observable list
    public static ObservableList<String> previousWords = FXCollections.observableArrayList();

    //method which adds all letters to treemap array
    public static void loadLetters(){
        addLetters('A',9);
        addLetters('B',2);
        addLetters('C',2);
        addLetters('D',4);
        addLetters('E',12);
        addLetters('F',2);
        addLetters('G',3);
        addLetters('H',2);
        addLetters('I',8);
        addLetters('J',1);
        addLetters('K',1);
        addLetters('L',4);
        addLetters('M',2);
        addLetters('N',6);
        addLetters('O',8);
        addLetters('P',2);
        addLetters('Q',1);
        addLetters('R',6);
        addLetters('S',4);
        addLetters('T',6);
        addLetters('U',4);
        addLetters('V',2);
        addLetters('W',2);
        addLetters('X',1);
        addLetters('Y',2);
        addLetters('Z',1);




    }

    //adds word to previous words
    public static void addPreviousWords(String word){

        previousWords.add(word);

    }

    public static void addLetters(Character key, Integer value){
        listOfLetters.put(key,value);
    }

}
