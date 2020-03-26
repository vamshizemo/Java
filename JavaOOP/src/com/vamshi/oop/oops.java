package com.vamshi.oop;

interface mobile{
    void call(String number);
    void sms(String sms);

}

class SamsungMob implements mobile {
    private int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public void call(String number) {
        System.out.println("calling number :"+number);

    }

    @Override
    public void sms(String sms) {
        System.out.println("sending sms :" +sms);

    }
}

class SamsungNote extends  SamsungMob{

    @Override
    public void sms(String sms){
        System.out.println("SamsungNote sending sms :" + sms);
    }

    public void call(String number1, String number2){
        System.out.println("Conference call on numbers :"+number1 +", "+number2);
    }

}

public class oops {
    public static void main(String[] args) {
        //Mobile mobile1 = new SamsungMob();
        SamsungMob mobile1 = new SamsungMob();
        SamsungNote mobile2 =  new SamsungNote();
        mobile1.call("999999999");
        mobile1.sms(" sms from mobile1");
        mobile2.call("888888888");
        mobile2.call("999999999","8888888888");
        mobile2.sms("hi how are you?");
    }
}
