package week1;


public class WordPlay {
    public boolean isVowel(char ch){
        char[] vowels={'a','e','i','o','u'};
        ch = Character.toLowerCase(ch);
        for(char vowel:vowels){
            if(ch==vowel){
                return true;
            }
        }
        return false;
    }

    public String replaceVowels(String phrase,char ch){
        char[] phraseArray=phrase.toCharArray();
        for(int i=0;i<phraseArray.length;i++){
            if(isVowel(phraseArray[i])){
                phraseArray[i]=ch;
            }
        }
        return String.valueOf(phraseArray);
    }
    public String emphasize(String phrase,char ch){
        char[] phraseArray=phrase.toCharArray();
        ch=Character.toLowerCase(ch);
        for(int i=0;i<phraseArray.length;i++){
            if(Character.toLowerCase(phraseArray[i])==ch){
                if(i%2==0){
                    phraseArray[i] = '*';
                }else {
                    phraseArray[i] = '+';
                }
            }
        }
        return String.valueOf(phraseArray);
    }

    public static void main(String[] args) {
        //test for vowels
        WordPlay wordPlay=new WordPlay();
        System.out.println(wordPlay.isVowel('a'));
        System.out.println(wordPlay.isVowel('u'));
        System.out.println(wordPlay.isVowel('b'));
        System.out.println(wordPlay.isVowel('z'));
        //test for replace vowels function
        System.out.println(wordPlay.replaceVowels("Hello World", '*'));
        System.out.println(wordPlay.replaceVowels("Hello World", '+'));
        System.out.println(wordPlay.replaceVowels("Welcome to Java", '*'));
        System.out.println(wordPlay.replaceVowels("Zemosolabs ", '+'));
        // test for emphasize method
        System.out.println(wordPlay.emphasize("Aeroplane", 'a'));
        System.out.println(wordPlay.emphasize("Java Spring BOOT", 'o'));
        System.out.println(wordPlay.emphasize("!Hello World!", 'o'));
        System.out.println(wordPlay.emphasize("Hello World", 'o'));


    }

}
