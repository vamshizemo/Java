package StringsFirstAssignments;

public class Part1 {
    public String findSimpleGene(String dna){
        String startCodon = "ATG";
        String endCodon = "TAA";
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
            return dna.substring(startIndex,endIndex+3);
        }
    }
    public void testSimpleGene() {
        String case1 ="ATCCTACTATGGTAA"; //no ATG
        String case2 ="ATGCTACTATGGTAC"; //no TAA
        String case3 ="ATCCTACTATGGTAC"; // no ATG , TAA
        String case4 ="ATGCTACTATGGTAA"; // ATG , TAA, with difference is multiple of 3
        String case5 ="ATGAACTACTATGGTAA"; // ATG , TAA with difference is not multiple of 3

        System.out.println(findSimpleGene(case1));
        System.out.println(findSimpleGene(case2));
        System.out.println(findSimpleGene(case3));
        System.out.println(findSimpleGene(case4));
        System.out.println(findSimpleGene(case5));
    }

    public static void main(String[] args) {
        Part1 part = new Part1();
        part.testSimpleGene();
    }
}
