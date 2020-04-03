package Assignment.JavaAssignment6;

import java.util.Arrays;

public class Vampire{
    final static long START = 10, END = 10000;
    public static void printNumbers(int num){
        int count=0;
        long vstart = 10,vend=10000000;
        for (long fangA = START; fangA < END; fangA++) {

            String sFangA = String.valueOf(fangA);
            boolean trailingZeros = sFangA.endsWith("0");
            int max = (int) Math.min(END, Math.pow(10, sFangA.length()));

            for (long fangB = fangA; fangB < max; fangB++) {

                if(((numDigits(vstart)%2)!=0) || ((numDigits(vend)%2)!=0))
                    break;
                long candidate = fangA * fangB;
                if (candidate % 9 == (fangA + fangB) % 9) {

                    String sCandidate = String.valueOf(candidate);
                    String sFangB = String.valueOf(fangB);

                    if ((trailingZeros && sFangB.endsWith("0")) == false) {

                        char[] cVampire = sCandidate.toCharArray();
                        Arrays.sort(cVampire);

                        char[] cFangs = (sFangA + sFangB).toCharArray();
                        Arrays.sort(cFangs);

                        //  System.out.println(cVampire);

                        if (Arrays.equals(cVampire, cFangs)) {
                            if((candidate > vstart) && (candidate < vend)){
                                count++;
                                System.out.println(sFangA + " * " + sFangB + " = " + sCandidate);

                            }
                        }
                    }
                }
            }
            if (count==num){
                break;
            }
        }
        System.out.println("Total vampire numbers count is :"+count);
    }

    private static int numDigits(long num){
        return Long.toString(Math.abs(num)).length();
    }
    public static void main(String[] args) {
        Vampire.printNumbers(100);

    }
}
