//Assignment 1

package week2;

import edu.duke.*;
import java.util.*;

public class CodonCounts {
    private HashMap<String, Integer> codonsMap=new HashMap<>();
    
    public void buildCodonMap(int start, String dna) {
        codonsMap.clear();
        for (int i = start; i < dna.length() - 3; i += 3) {
            String codon = dna.substring(i, i+3);
            if (!codonsMap.containsKey(codon)) {
                codonsMap.put(codon, 1);
            } else {
                codonsMap.put(codon, codonsMap.get(codon) + 1);
            }
        }
    }
    public String getMostCommonCodon() {
        int count = 0;
        String index = "";
        for (String i : codonsMap.keySet()) {
            int c = codonsMap.get(i);
            if (c > count) {
                count = c;
                index = i;
            }
        }
        return index;
    }
    public void printCodonCounts(int start, int end) {
        System.out.println("\n codon Counts between " + start + " and " + end + " inclusive are:");
        for (String key : codonsMap.keySet()) {
            int count = codonsMap.get(key);
            if (count >= start && count <= end) {
                System.out.println(key + " " + codonsMap.get(key));
            }
        }
    }
    public void test() {
        FileResource fileResource = new FileResource();
        String dna = fileResource.asString();
        for (int i = 0; i < 3; i++) {
            System.out.println("Reading frame starting with " + i + " results in 2 unique codons");
            buildCodonMap(i, dna);
            String mostCommonCodon = getMostCommonCodon();
            System.out.println("and most common codon is " + mostCommonCodon + " with count " + codonsMap.get(mostCommonCodon));
            printCodonCounts(1, 5);
        }
    }

}