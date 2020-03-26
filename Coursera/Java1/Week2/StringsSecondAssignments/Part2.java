package StringsSecondAssignments;

public class Part2 {
    public int howMany(String stringa,String stringb){
        int count=0;
        int startIndex=stringb.indexOf(stringa);
        while(startIndex!=-1){
            count++;
            startIndex=stringb.indexOf(stringa,startIndex+stringa.length());
        }
        return count;
    }

    public static void main(String[] args) {
        String a="aa";
        String b="abaaaa";
        Part2 part = new Part2();
        System.out.println(part.howMany(a,b));

    }
}
