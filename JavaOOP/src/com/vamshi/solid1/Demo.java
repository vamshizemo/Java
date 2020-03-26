package com.vamshi.solid1;

interface Computer{
    void input(String input);
    void output();
    void sendFax(String message);
}

class Desktop implements Computer{
     private String memory;
    @Override
    public void input(String input) {
        memory=input;
        KeyBoard keyBoard1 =  new KeyBoard();
        keyBoard1.takeInput(input);
    }

    @Override
    public void output() {
        Monitor screen1 = new Monitor();
        screen1.showOutput(memory);
    }

    @Override
    public void sendFax(String message) {
        System.out.println("faxed message :"+message);
    }

    public void readCdDrive(){
        cdDrive newDrive = new cdDrive();
        newDrive.read();
    }

}

class Laptop extends Desktop{

    @Override
    public void readCdDrive() {
        System.out.println("no cd drive is present");
    }
}

class cdDrive{
    void close(){
        System.out.println("cd drive is closed");
    }
    void eject(){
        System.out.println("CD drive is ejected");
    }
    void read(){
        System.out.println("cd is reading ..");
    }

}
class KeyBoard{
    void takeInput(String input){
        System.out.println("input submitted is:"+input);
    }
}

class Monitor{
    void showOutput(String output){
        System.out.println("output on monitor:"+output);
    }

}
public class Demo {
    public static void main(String[] args) {
        Desktop desk1 = new Desktop();
        Laptop dellLaptop = new Laptop();
        desk1.input("some input to Desktop");
        dellLaptop.input("some input to Laptop");
        desk1.output();
        dellLaptop.output();
        desk1.sendFax("message in fax");
        desk1.readCdDrive();
        dellLaptop.readCdDrive();
    }

}
