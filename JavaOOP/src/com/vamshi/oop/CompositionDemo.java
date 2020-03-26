package com.vamshi.oop;


class House{
    private Kitchen kitchen;

    public House(){

        kitchen = new Kitchen();
        kitchen.setFood("pizza");

    }
    public String getFood(){
        return this.kitchen.getFood();
    }
}
class Kitchen{
    private String food;
    public void setFood(String food) {
        this.food = food;

    }
    public String getFood() {

        return food;
    }


}
public class CompositionDemo {
    public static void main(String[] args) {
        House myHouse = new House();
        System.out.println(myHouse.getFood());
    }
}
