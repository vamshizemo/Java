//Assingment 2
package week2;
import edu.duke.*;
import java.util.ArrayList;

public class CharactersInPlay {

    private ArrayList<String> characters;
    private ArrayList<Integer> parts;

    public CharactersInPlay() {
        this.characters = new ArrayList<String>();
        this.parts = new ArrayList<Integer>();
    }

    public void findAllCharacters() {
        this.characters.clear();
        this.parts.clear();
        FileResource resource = new FileResource();
        for (String line : resource.lines()) {
            line = line.toLowerCase();
            int indexOfPeriod = line.indexOf(".");
            String character = "";
            if (indexOfPeriod != -1) {
                character = line.substring(0, indexOfPeriod);
                int indexOfCharacter = characters.indexOf(character);
                if (indexOfCharacter == -1) {
                    characters.add(character);
                    parts.add(1);
                } else {
                    int freq = parts.get(indexOfCharacter);
                    parts.set(indexOfCharacter, freq + 1);
                }
            }
        }

    }

    public void tester() {
        findAllCharacters();
        int indexOfCharacter = 0;
        for (int i = 0; i < characters.size(); i++) {
            if (parts.get(i) > parts.get(indexOfCharacter)) {
                indexOfCharacter = i;
            }
        }
        System.out.println("Main character Name: "
                + characters.get(indexOfCharacter) + " " +
                parts.get(indexOfCharacter) );
        charactersWithNumParts(3, 5);
    }

    private void charactersWithNumParts(int numbera, int numberb) {
        for (int i = 0; i < parts.size(); i++) {
            if (parts.get(i) >= numbera && parts.get(i) <= numberb)
                System.out.println(parts.get(i) + " " + characters.get(i));
        }
    }

}
