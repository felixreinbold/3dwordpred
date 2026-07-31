import model.Room;
import model.WordInitializer;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Room room = new Room(50, 50, 50);

        WordInitializer initializer = new WordInitializer(room);
        initializer.initializeWords();

        boolean condition = true;

        Scanner scanner = new Scanner(System.in);

        while(condition){
            System.out.println("Bitte tragen Sie ein fehlerhaftes Wort ein");
            String word = scanner.nextLine();

            String result = room.search(word);
            System.out.println(result);
        }




    }



}