package week1;

import edu.duke.FileResource;

public class CaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int theKey;

    public CaesarCipher(int key) {
        theKey = key;
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) +
                alphabet.substring(0,key);
        alphabet = alphabet + alphabet.toLowerCase();
        shiftedAlphabet = shiftedAlphabet + shiftedAlphabet.toLowerCase();
    }
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
    public String decrypt(String message,int key){
        return modifiedEncrypt(message,26-key);
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

    private char transformLetter(char c, String from, String to) {
        int idx = from.indexOf(c);
        if (idx != -1) {
            return to.charAt(idx);
        }
        return c;
    }

    public char encryptLetter(char c) {
        return transformLetter(c, alphabet, shiftedAlphabet);
    }

    public char decryptLetter(char c) {
        return transformLetter(c, shiftedAlphabet, alphabet);
    }

    public static void main(String[] args) {
        CaesarCipher caesarCipher=new CaesarCipher();
        caesarCipher.testCaesar();
    }
}
