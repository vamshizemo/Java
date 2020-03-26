package StringsSecondAssignments;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

import java.io.File;

public class Part3 {
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        int currentIndex;
        currentIndex=dna.indexOf(stopCodon,startIndex+3);
        while(true){

            if(currentIndex==-1){
                return dna.length();
            }
            if((currentIndex-startIndex)%3 == 0){
                return currentIndex;
            }else{
                currentIndex = dna.indexOf(stopCodon,currentIndex+3);
            }
        }
    }
    public int countGenes(String dna){
        int count=0;
        int startIndex=dna.indexOf("ATG");
        while (true) {
            if (startIndex == -1 || startIndex==dna.length()) {
                System.out.println("");
                break;
            }
            int taaIndex = findStopCodon(dna, startIndex, "TAA");
            int tagIndex = findStopCodon(dna, startIndex, "TAG");
            int tgaIndex = findStopCodon(dna, startIndex, "TGA");
            int minIndex = Integer.min(taaIndex, tagIndex);
            minIndex = Integer.min(minIndex, tgaIndex);
            if (minIndex == dna.length() ||minIndex==-1) {
                System.out.println("");
                break;
            }
            //System.out.println(dna.substring(startIndex, minIndex + 3));
            count++;
            if(minIndex+3==dna.length()){break;}
            startIndex = dna.indexOf("ATG",minIndex+3);
        }
      return count;
    }
    public void testCountGenes(){
        String[] dnas={"ATGTAATTATGTGAATGTAG","ATGTGA","ATGAAATGA","ATGTGAATGTAAATGTAG"};

        for(String dna : dnas){
            System.out.println(countGenes(dna));
        }

        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            String s = fr.asString();
            System.out.println("read " + s.length() + " characters");
            int result = countGenes(s.toUpperCase());
            System.out.println("found " + result+ " genes");
        }
    }

    public static void main(String[] args) {
        Part3 part = new Part3();
        part.testCountGenes();
    }
}
