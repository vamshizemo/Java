package com.vamshi.solid;



interface Car {

    void turnOnEngine();
    void accelerate();
}

class Engine{
    void on(){
        System.out.println("engine is turned on");
    }

}

class MotorCar implements Car {

    private Engine engine= new Engine();

    public void turnOnEngine() {
        engine.on();
    }

    public void accelerate() {
        System.out.println("car is accelerated");
    }
}

class ElectricCar implements Car {

    public void turnOnEngine() {
        System.out.println("I don't have an engine!");
    }

    public void accelerate() {
        System.out.println("car is accelerated");
    }
}


public class LiskovSubstitution {
    public static void main(String[] args) {
        MotorCar Maruti= new MotorCar();
        ElectricCar Tesla=new ElectricCar();
        Maruti.turnOnEngine();
        Tesla.turnOnEngine();
    }

}
