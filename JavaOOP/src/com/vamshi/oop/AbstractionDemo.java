package com.vamshi.oop;

import java.util.ArrayList;

interface Mobile{
    public void call(String number);

    public void sendMessage(String message);
}

class Apple implements Mobile{
    public ArrayList<String> contacts =new ArrayList<String>();

    public void addContacts(String number){
        contacts.add(number);
    }

    @Override
    public void call(String number) {
        System.out.println("calling....."+number);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("Sending message....."+message);

    }
}

abstract class Mobile1{
    ArrayList<String> contacts = new ArrayList<String>();
    void addContacts(String number){
        contacts.add(number);
    }
    abstract void calling(String number);
    abstract void sendMessage(String message);
}

class Samsung extends Mobile1 {


    @Override
    void calling(String number) {
        System.out.println("calling...."+number);
    }

    @Override
    void sendMessage(String message) {
        System.out.println("sending message...."+message);

    }

}
public class AbstractionDemo {
    public static void main(String[] args) {
        Apple myPhone =new Apple();
        myPhone.call("984375934979");
        myPhone.sendMessage("hi how are you?");
        myPhone.addContacts("9843u43484893");
        Samsung Sphone=new Samsung();
        Sphone.addContacts("9843534543");
        Sphone.calling(Sphone.contacts.get(0));

    }
}
