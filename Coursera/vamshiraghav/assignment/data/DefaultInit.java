package vamshiraghav.assignment.data;

public class DefaultInit {
    int num;
    char letter;
    public void printVariables(){
        System.out.println("uninitialized number is :"+num);
        System.out.println("uninitialized character is :"+letter);
    }
    public void printLocalVariables(){
        int localNum;
        char localLetter;
        System.out.println("Uninitialized local number is :"+localNum);
        System.out.println("Uninitialized local character is :"+localLetter);
    }

}
