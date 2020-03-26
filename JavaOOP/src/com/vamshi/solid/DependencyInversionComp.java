package com.vamshi.solid;

interface  MonitorInt{

}
interface KeyBoardInt{

}
class Desktopnew{
    MonitorInt monitor ;
    KeyBoardInt keyBoard ;

    void setMonitor(MonitorInt monitor){
        this.monitor = monitor;
    }
    void setKeyBoard(KeyBoardInt keyBoard){
        this.keyBoard = keyBoard;

    }
}

class NewMonitor implements MonitorInt {

}

class NewKeyBoard implements KeyBoardInt{

}


public class DependencyInversionComp {
    public static void main(String[] args) {
        Desktopnew myDesktop= new Desktopnew();
        myDesktop.setKeyBoard(new NewKeyBoard());
        myDesktop.setMonitor(new NewMonitor());
    }
}
