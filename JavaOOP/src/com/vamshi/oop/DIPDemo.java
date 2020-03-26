package com.vamshi.oop;

interface ILogger{
    public void logInformation(String info);
}
class Logger implements ILogger{
    public void logInformation(String info){
        System.out.println(info);
    }
}
class LogginIntoFile{
    ILogger logger ;
    public LogginIntoFile(ILogger l){
        this.logger=l;
    }
    public void logging(){
        logger.logInformation("Printing logs into file...");
    }
}
class LogginIntoDB{
    ILogger logger ;
    public LogginIntoDB(ILogger l){
        this.logger=l;
    }
    public void logging(){
        logger.logInformation("saving logs into DB ...");
    }
}
public class DIPDemo {
    public static void main(String[] args) {
        LogginIntoFile filelogger= new LogginIntoFile(new Logger());
        filelogger.logging();
    }
}
