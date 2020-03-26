package com.vamshi.solid;
interface  MobilePhone{
    void call();
    void message();
    void dialhardkeypad();
}


class OldNokia implements MobilePhone{

    @Override
    public void call() {

    }

    @Override
    public void message() {

    }

    @Override
    public void dialhardkeypad() {

    }
}

class Samsung implements MobilePhone{

    @Override
    public void call() {

    }

    @Override
    public void message() {

    }

    @Override
    public void dialhardkeypad() {

    }
}
public class InterfaceSegregation {
    public static void main(String[] args) {
        OldNokia nokia = new OldNokia();
        Samsung samsung = new Samsung();

    }
}
