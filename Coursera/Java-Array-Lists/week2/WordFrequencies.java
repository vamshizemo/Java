//Assignment 1

package week2;

import edu.duke.FileResource;

import java.util.ArrayList;

public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;

    // constructor
    public WordFrequencies() {
        this.myWords = new ArrayList<String>();
        this.myFreqs = new ArrayList<Integer>();
    }
    //finding the unique words and their frequencies
    public void findUnique() {
        myWords.clear();
        myFreqs.clear();
        FileResource resource = new FileResource();
        for (String word : resource.words()) {
            word = word.toLowerCase();
            int wordIndex = myWords.indexOf(word);
            if (wordIndex == -1) {
                myWords.add(word);
                myFreqs.add(1);
            } else {
                int repeats = myFreqs.get(wordIndex);
                repeats++;
                myFreqs.set(wordIndex, repeats);
            }
        }
    }

    
    public int findIndexOfMax() {
        int max = myFreqs.get(0);
        int index = 0;
        for (int i = 0; i < myFreqs.size(); i++) {
            if (myFreqs.get(i) > max) {
                max = myFreqs.get(i);
                index = i;
            }
        }
        return index;
    }

    public void tester() {
        findUnique();
        System.out.println("unique words count: " + myWords.size());
        int maxIndex = findIndexOfMax();
        for (int i = 0; i < myFreqs.size(); i++) {
            System.out.println(myFreqs.get(i) + " " + myWords.get(i));
        }
        System.out.println("The word that occurs most " +
                "often and its count are: " + myWords.get(maxIndex) + " " + myFreqs.get(maxIndex));
        System.out.println("The unique word :" + myWords.size());
    }

}
class TestWordFreq{
    public static void main(String[] args) {
        WordFrequencies wordFrequencies=new WordFrequencies();
        wordFrequencies.tester();
    }
}
