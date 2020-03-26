package com.vamshi.solid2;

interface Computer{
    void input(String input,KeyBoardInterface keyBoard1);
    void output(MonitorInterface screen);

}
//interface segregation principle
interface FaxInterface{
    void sendFax(String message);
}
//dependency inversion principle
interface KeyBoardInterface {
    void takeInput(String input);
}

interface MonitorInterface{
    void showOutput(String output);
}

//single responsibility principle
class Fax implements FaxInterface{

    @Override
    public void sendFax(String message) {
        System.out.println("faxed message :"+message);
    }
}
class BaseComputer implements Computer {
    private String memory;
    @Override
    public void input(String input,KeyBoardInterface keyBoard1 ) {
        memory=input;
        keyBoard1.takeInput(input);
    }

    @Override
    public void output(MonitorInterface screen) {
        screen.showOutput(memory);
    }

}

//liskov substituion principle
class Desktop extends BaseComputer{
    public void readCdDrive(){
        cdDrive newDrive = new cdDrive();
        newDrive.read();
    }
}

class Laptop extends BaseComputer {


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
class KeyBoard implements KeyBoardInterface{
    @Override
    public void takeInput(String input){
        System.out.println("input submitted is:"+input);
    }
}

class Monitor implements MonitorInterface{
    @Override
    public void showOutput(String output){
        System.out.println("output on monitor:"+output);
    }
}

public class Demo {
    public static void main(String[] args) {
        Desktop desk1 = new Desktop();
        Laptop dellLaptop = new Laptop();
        desk1.input("some input to Desktop",new KeyBoard());
        dellLaptop.input("some input to Laptop",new KeyBoard());
        desk1.output(new Monitor());
        dellLaptop.output(new Monitor());
        Fax newFax = new Fax();
        newFax.sendFax("message in fax"); //single responsibilty principle
        desk1.readCdDrive();
        //dellLaptop.readCdDrive(); liskov substitution principle
    }

}

