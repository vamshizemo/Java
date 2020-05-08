package week1;

import edu.duke.FileResource;

public class CaesarBreaker {
    public week1.WordLengths wordLengths;
    public week1.CaesarCipher caesarCipher;
    public CaesarBreaker(){
        wordLengths= new week1.WordLengths();
        caesarCipher=new week1.CaesarCipher();
    }

    public int maxIndex(int[] values){
        return wordLengths.indexOfMax(values);
    }
    public String decrypt(String message,int key){
        return caesarCipher.modifiedEncrypt(message,26-key);
    }
    public void testDecrypt(){
        FileResource fr = new FileResource("wordsLotsOfEs.txt");
        String message=fr.asString();
        message=caesarCipher.modifiedEncrypt(message,16);
        System.out.println((message));
//      System.out.println(getKey(message));
        String decrypted = decrypt(message,getKey(message));
        System.out.println(decrypted);

        // two key decryption
        fr = new FileResource("wordsLotsOfEsEncrypted.txt");
        message=fr.asString();
        System.out.println((message));
        System.out.println("two key decryption of above string");
        System.out.println(decryptTwoKeys(message));


    }
    public String halfOfString(String message,int start){
        String outputMessage="";
        if( start>=message.length()){ return "";}
        for(;start<message.length();start+=2){
            outputMessage+=String.valueOf(message.charAt(start));
        }
        return outputMessage;
    }
    public int getKey(String message){
        int[] values=countLetters(message);
        return (26+maxIndex(values)-4)%26;
    }
    public int[] countLetters(String message){
        int[] values=new int[26];
        String alphabet="abcdefghijklmnopqrstuvwxyz";
        int index;
        for(int i=0;i<message.length();i++){
            index=alphabet.indexOf(Character.toLowerCase(message.charAt(i)));
            if(index!=-1){
                if(values[index]==0){values[index]=1;}
                else{values[index]++;}
            }
        }
        return values;
    }
    public String decryptTwoKeys(String encrypted){
        int key1=getKey(halfOfString(encrypted,0));
        int key2=getKey(halfOfString(encrypted,1));
        return caesarCipher.encryptTwoKeys(encrypted,26-key1,26-key2);
    }
}
class testCaesarBreaker{
    public static void main(String[] args) {
        CaesarBreaker caesarBreaker=new CaesarBreaker();
        caesarBreaker.testDecrypt();
    }
}
