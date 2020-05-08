package week1;

import edu.duke.FileResource;

public class WordLengths {

    public void countWordLengths(FileResource resource, int[] counts){
        int sum;
        for(String s : resource.words()) {
            sum=0;
            for (int i = 0; i < s.length(); i++) {
                if (Character.isLetter(s.charAt(i)))
                    sum++;
            }
            if(sum>=30){
                counts[30]++;
            }else{
                counts[sum]++;
            }

        }
    }

    public int indexOfMax(int[] values) {
        int max = values[0], index = 0;
        for (int i = 1; i < values.length; i++){
//            System.out.println(i+","+values[i]);
            if (values[i] > max) {
                max = values[i];
                index = i;
            }}
        return index;
    }
    public void testcountWordLengths()
    {
        FileResource resource = new FileResource();
        int[] counts = new int[31];
        countWordLengths(resource,counts);
        System.out.println(indexOfMax(counts));
    }


}
class test{
    public static void main(String[] args) {
        WordLengths wordLengths = new WordLengths();
        wordLengths.testcountWordLengths();
    }
}
