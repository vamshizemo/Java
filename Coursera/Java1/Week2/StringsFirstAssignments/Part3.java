package StringsFirstAssignments;

public class Part3 {
    public String findSimpleGene(String dna,String startCodon, String endCodon){
        //String startCodon = startCodon;
        //String endCodon = endCodon;
        boolean isCapital;
        if(dna.toUpperCase()==dna){
            isCapital = true;
        }else{
            isCapital = false;
        }
        dna = dna.toUpperCase();
        startCodon = startCodon.toUpperCase();
        endCodon = endCodon.toUpperCase();
        int startIndex = dna.indexOf(startCodon);
        if (startIndex == -1){
            return "";
        }
        int endIndex = dna.indexOf(endCodon,startIndex+3);
        if(endIndex == -1){
            return "";
        }
        if((endIndex-startIndex)%3 != 0){
            return "";
        }
        else{
            if(isCapital){
                return dna.substring(startIndex, endIndex + 3);
            }else{
                return dna.substring(startIndex, endIndex + 3).toLowerCase();
            }
        }
    }
    public void testSimpleGene() {
        String case1 ="ATCCTACTATGGTAA"; //no ATG
        String case2 ="ATGCTACTATGGTAC"; //no TAA
        String case3 ="ATCCTACTATGGTAC"; // no ATG , TAA
        String case4 ="ATGCTACTATGGTAA"; // ATG , TAA, with difference is multiple of 3
        String case5 ="ATGAACTACTATGGTAA"; // ATG , TAA with difference is not multiple of 3
        String case6 = "atggttatccgtcgttgctaa";

        System.out.println(findSimpleGene(case1,"ATG","TAA"));
        System.out.println(findSimpleGene(case2,"ATG","TAA"));
        System.out.println(findSimpleGene(case3,"ATG","TAA"));
        System.out.println(findSimpleGene(case4,"ATG","TAA"));
        System.out.println(findSimpleGene(case5,"ATG","TAA"));
        System.out.println(findSimpleGene(case6,"atg","taa"));
    }
    public boolean twoOccurrences(String stringa,String stringb){
        int startIndex = stringb.indexOf(stringa);
        if(startIndex == -1){
            return false;
        }
        int nextStartIndex = stringb.indexOf(stringa,startIndex+stringa.length());
        if(nextStartIndex == -1){
            return false;
        }else{
            return true;
        }

    }
    public  void testing(){
        String[][] pairs ={{"an","banana"},{"atg","atgtgaactatg"},{"ata","atatactg"},{"b","abcdef"},{"fun","funfreefunny"},{"zoo","forest"}};
        for(String[] pair: pairs){
            System.out.println(twoOccurrences(pair[0],pair[1]));
        }
        for(String[] pair: pairs){
            System.out.println(lastPart(pair[0],pair[1]));
        }

    }
    public String lastPart(String stringa,String stringb){
        int startIndex = stringb.indexOf(stringa);
        if(startIndex == -1){
            return stringb;
        }else{
            return stringb.substring(startIndex+stringa.length());
        }

    }

    public static void main(String[] args) {
        Part3 part = new Part3();
        part.testing();
    }


}
