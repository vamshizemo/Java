package StringsSecondAssignments;

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

    public static void main(String[] args) {
        Part1 part= new Part1();
        //part.testFindStopCodon();
        //part.testFindGene();
        part.printAllGenes("ATATGTAAATGTGAACGACGATGCGTCGCGCGTAGAATGTTTTAG");

    }
}
