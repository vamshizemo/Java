package com.vamshi.oop;

public class Fan {
    private boolean isOn;

    public void turnOn(){
        this.isOn = true;
        System.out.println("fan is spinning");
    }
    public void turnOff(){
        this.isOn = false;
        System.out.println("fan is stopped");
    }
}
