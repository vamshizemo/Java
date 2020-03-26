package com.vamshi.oop;

public class Fan {
    private boolean isOn;
    public static int num=5;
    Fan(boolean a){
        this.isOn = true;
    }
    public void turnOn(){
        isOn = true;
        System.out.println("fan is spinning");
    }
    public void turnOff(){
        isOn = false;
        System.out.println("fan is stopped");
    }
}
