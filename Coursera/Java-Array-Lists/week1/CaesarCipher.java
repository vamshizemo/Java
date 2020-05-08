package week1;

import edu.duke.FileResource;

public class CaesarCipher {
    public String encrypt(String input,int key){
        char[] inputArray=input.toCharArray();
        String alphabet ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key)+alphabet.substring(0,key);
        for(int i=0;i<inputArray.length;i++){
            int index=alphabet.indexOf(inputArray[i]);
            if(index!=-1){
                inputArray[i]=shiftedAlphabet.charAt(index);
            }
        }
        return String.valueOf(inputArray);
    }
    public String modifiedEncrypt(String input,int key){
        char[] inputArray=input.toCharArray();
        String alphabetLower ="abcdefghijklmnopqrstuvwxyz";
        String alphabetUpper ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabetLower = alphabetLower.substring(key)+alphabetLower.substring(0,key);
        String shiftedAlphabetUpper = alphabetUpper.substring(key)+alphabetUpper.substring(0,key);
        for(int i=0;i<inputArray.length;i++){
            if(Character.isLowerCase(inputArray[i])) {
                int index = alphabetLower.indexOf(inputArray[i]);
                if (index != -1) {
                    inputArray[i] = shiftedAlphabetLower.charAt(index);
                }
            }else {
                int index = alphabetUpper.indexOf(inputArray[i]);
                if (index != -1) {
                    inputArray[i] = shiftedAlphabetUpper.charAt(index);
                }
            }
        }
        return String.valueOf(inputArray);
    }
    public String encryptTwoKeys(String input, int key1,int key2){
        char[] inputArray=input.toCharArray();
        String alphabetLower ="abcdefghijklmnopqrstuvwxyz";
        String alphabetUpper ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabetLower ;
        String shiftedAlphabetUpper ;
        int key;
        for(int i=0;i<inputArray.length;i++){
            key= i%2==0 ? key1 :key2;
            if(Character.isLowerCase(inputArray[i])) {
                shiftedAlphabetLower = alphabetLower.substring(key)+alphabetLower.substring(0,key);
                int index = alphabetLower.indexOf(inputArray[i]);
                if (index != -1) {
                    inputArray[i] = shiftedAlphabetLower.charAt(index);
                }
            }else {
                shiftedAlphabetUpper = alphabetUpper.substring(key)+alphabetUpper.substring(0,key);
                int index = alphabetUpper.indexOf(inputArray[i]);
                if (index != -1) {
                    inputArray[i] = shiftedAlphabetUpper.charAt(index);
                }
            }
        }
        return String.valueOf(inputArray);
    }
    public void testCaesar(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        int key=23;
        String encrypted = encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);
        encrypted = modifiedEncrypt(message, key);
        System.out.println("Modifiedencrypt message for key is " + key + "\n" + encrypted);
        encrypted = encryptTwoKeys("First Legion", 23, 17);
        System.out.println("Two keys are 23,17 \n" + encrypted);
    }

    public static void main(String[] args) {
        CaesarCipher caesarCipher=new CaesarCipher();
        caesarCipher.testCaesar();
    }
}
