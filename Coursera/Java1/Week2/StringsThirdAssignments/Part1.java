package StringsThirdAssignments;

import edu.duke.FileResource;
import edu.duke.StorageResource;

public class Part1 {
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
    public String findGene(String dna){
        int startIndex=dna.indexOf("ATG");
        if (startIndex==-1){return "";}
        int taaIndex=findStopCodon(dna,startIndex,"TAA");
        int tagIndex=findStopCodon(dna,startIndex,"TAG");
        int tgaIndex=findStopCodon(dna,startIndex,"TGA");
        int minIndex=Integer.min(taaIndex,tagIndex);
        minIndex=Integer.min(minIndex,tgaIndex);
        if (minIndex==dna.length()){return "";}
        return dna.substring(startIndex,minIndex+3);

    }
    public void printAllGenes(String dna){

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
            System.out.println(dna.substring(startIndex, minIndex + 3));
            if(minIndex+3==dna.length()){break;}
            startIndex = dna.indexOf("ATG",minIndex+3);
        }
    }
    public StorageResource getAllGenes(String dna){
        dna=dna.toUpperCase();
        String temp;
        StorageResource sr=new StorageResource();
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
            temp=dna.substring(startIndex, minIndex + 3);
            //System.out.println(cgRatio(temp));
            sr.add(temp);
            //System.out.println(temp);
            if(minIndex+3==dna.length()){break;}
            startIndex = dna.indexOf("ATG",minIndex+3);
        }
        return sr;

    }
    public float cgRatio(String dna){
        dna=dna.toUpperCase();
        int ccount=0;
        int gcount=0;
        char c='C';
        char g='G';
        for(int i=0;i<dna.length();i++){
            if(dna.charAt(i)==c){ccount++;}
            if(dna.charAt(i)==g){gcount++;}
        }
        return (float)ccount/gcount;
    }
    public int countCTG(String dna){
        int count=0;
        int startIndex=dna.indexOf("CTG");
        while((startIndex+3)<=dna.length()){
            if(startIndex==-1){return count;}
            count++;
            startIndex = dna.indexOf("CTG",startIndex+3);
        }
        return count;
    }
    public void processGenes(StorageResource sr){
        int dna9count=0;
        int cgGreatcount=0;
        int longGeneLen=0;
        for(String dna:sr.data()){
            if(dna.length()>60){
                System.out.println(dna);
                dna9count++;
                longGeneLen=Math.max(longGeneLen,dna.length());
            }
        }
        System.out.println("number of dnas whose length greate than 60 :"+dna9count);
        for(String dna:sr.data()){
            if(cgRatio(dna)>0.35){
                System.out.println(dna);
                cgGreatcount++;
            }
        }
        System.out.println("number of dnas whose cg ratio >0.35 are :"+cgGreatcount);
        System.out.println("lenght of longest gene :"+longGeneLen);
    }
    public void testProcessGenes(){
        FileResource fr=new FileResource();
        String dna=fr.asString();
        StorageResource sr = getAllGenes(dna);
        processGenes(sr);
    }
    public void testFindStopCodon(){
        String[] dnas={"ATGATAATACTATAATA",
                "AAATTTATGGGGGGGGGGGGTAAGTAA","ATGTAA","GTGATGATAAAAA"
        };
        for(String dna : dnas){
            int startIndex;
            startIndex = dna.indexOf("ATG");
            if(startIndex!=-1){
                System.out.println(findStopCodon(dna, startIndex,"TAA"));
                //System.out.println(dna.substring(startIndex,findStopCodon( dna, startIndex,"TAA")+3));
            }else{
                System.out.println("no match");
            }
        }
    }
    public void testFindGene(){
        String[] dnas={"ATAATACTATAATA",
                "AAATTTATGGGGGGGGGGGGTAAGTAA","ATGGTGTGATAATAG","ATGATAA","GTGATGATAAAAA"
        };

        for(String dna : dnas){
            System.out.println(findGene(dna));
        }

    }

    public static void main(String[] args) {
        Part1 part= new Part1();
        //part.testFindStopCodon();
        //part.testFindGene();
        //part.printAllGenes("ATATGTAAATGTGAACGACGATGCGTCGCGCGTAGAATGTTTTAG");
        part.testProcessGenes();
        FileResource fr=new FileResource("./dna/GRch38dnapart.fa");
        String dna=fr.asString();
        System.out.println("all genes count "+part.getAllGenes(dna).size());
        System.out.println("ctg count is :"+part.countCTG(dna));
        /*
        StorageResource sr;
        sr=part.getAllGenes("ATATGTAAATGTGAACGACGATGCGTCGCGCGTAGAATGTTTTAG");
        System.out.println("CTG count:"+part.countCTG("ATATGTAACTGATGTGAACGACGCTGATGCGTCGCGCGTAGAATGTTTTAGCTGCTG"));
        for(String dna:sr.data()){
            System.out.println(dna);
        }*/

    }
}
