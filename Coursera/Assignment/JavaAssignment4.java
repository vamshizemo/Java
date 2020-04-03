/*
Gruber Healthcare has different types of forms for their customer, one of which
 is a know your customer form ( KYC ) which has to be filled annually. Each form
 has a date which signifies the date the form was filled called the form date.

Due to government regulations the KYC form can only be filled within + or - 30 days
of the signup anniversary of a customer. When filling it up, you have to provide
the form date. If you are past the +-30 day anniversary then you can back-date
 it so that it falls in the +-30-day window. When filling it up you cannot use a
 future date for the form date.

For Example, assuming today is 4 Apr 2017 and I had signed up on 1st Mar 2014,
my window for KYC submission this year would be 30 Jan 2017 to 31 Mar 2017. Since
it is already 4th Apr - I would have to back-date the KYC to a date in this range.

Note: The KYC form can be filled only for the closest anniversary in the past or
 within 30 days range in future.Anniversary refers to same day and month every year.
  If your birthday is 01-02-1992 -then your first anniversary will be 01-02-1993,
  the 2nd will be 01-02-1994 and so on. 01-02-1992 is not an anniversary.

Given the signup date and the current date, provide the allowable date range for the form date.

Input - First line is an integer n as the number of inputs to be passed. Next,
n lines are n input for the program in the format dd-mm-yyyy dd-mm-yyyy Each line
has two dates separated by space where the first date in signup date and the second
date is the current date.

Output - Range of dates for KYC form in format dd-mm-yyyy dd-mm-yyyy

Test Input:
5
16-07-1998 27-06-2017
04-02-2016 04-04-2017
04-05-2017 04-04-2017
04-04-2015 04-04-2016
04-04-2015 15-03-2016

Test output:
16-06-2017 27-06-2017
05-01-2017 06-03-2017
No range
05-03-2016 04-04-2016
05-03-2016 15-03-2016

Add your code to your GitHub and provide the link.

 */
package Assignment;

import java.util.Scanner;

public class JavaAssignment4 {

    public String getRangeKYC(String signupDate,String currDate){
        myDate sdate= new myDate(signupDate);
        myDate cdate=new myDate(currDate);
        if(cdate.daysBeforeMe(sdate)<0){return "No range";}
        myDate anniDate=new myDate(sdate.toString());
        anniDate.setYear(cdate.getYear());
        if(cdate.daysBeforeMe(anniDate.addDays(-30))<0){
            anniDate.setYear(anniDate.getYear()-1);
        }
        myDate minDate = anniDate.addDays(-30);
        myDate pluDate = anniDate.addDays(30);
        //System.out.println(cdate.daysBeforeMe(pluDate));
        if(cdate.daysBeforeMe(pluDate)>0){
            return minDate+" "+pluDate;
        }else {
            return minDate+" "+cdate;
        }
    }
    public static void main(String[] args){
        JavaAssignment4 object = new JavaAssignment4();
        String input="6\n" +
                "16-07-1998 27-06-2017\n" +
                "04-02-2016 04-04-2017\n" +
                "04-05-2017 04-04-2017\n" +
                "04-04-2015 04-04-2016\n" +
                "04-08-2015 04-04-2016\n" +
                "04-04-2015 15-03-2016";
        Scanner scan = new Scanner(input);
        //System.out.println(scan.nextLine());
        //System.out.println(scan.nextLine());
        int tests=Integer.parseInt(scan.nextLine());
        for(int i=0;i<tests;i++){
            String[] a=scan.nextLine().split(" ");
            System.out.println(object.getRangeKYC(a[0],a[1]));
        }

    }
}
class myDate{
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    private int year,month,day;
    public myDate(String date){
        String[] dateSplit=date.split("-");
        this.day = Integer.parseInt(dateSplit[0]);
        this.month = Integer.parseInt(dateSplit[1]);
        this.year = Integer.parseInt(dateSplit[2]);
    }
    public myDate(int days){
        int[] daysc= new int[]{0,31,59,90,120,151,181,212,243,273,304,334,365};
        int[] dayscleap=new int[]{0,31,60,91,121,152,182,213,244,275,306,335,366};
        boolean isleapyear=false;
        year= ((int)(days/(365*400+24*4+1)))*400;
        days=days%(365*400+24*4+1);
        year+=((int)(days/(365*100+24)))*100;
        days=days%(365*100+24);
        year+=((int)(days/(365*4+1)))*4;
        days=days%(365*4+1);
        year+=(int)(days/(365));
        year++;
        if((year%400==0)||((year%4==0)&&(!(year%100==0 && year%400!=0)))){daysc=dayscleap;}
        days=days%(365);
        if(days==0){
            year--;
            month=12;
            day = 31;
        }else{
            for(int i=1;i<13;i++){
                if(days==daysc[i]){
                    month=i;
                    day=daysc[i]-daysc[i-1];
                }else if(days>daysc[i-1] && days<daysc[i]){
                    month=i;
                    day=days-daysc[i-1];
                }
            }
        }

      }
    int getTotalDays(){
        int[] daysc= new int[]{0,31,59,90,120,151,181,212,243,273,304,334,365};
        int total=0;
        int leapDay=0;
        if(month>2 && ((year%400==0)||((year%4==0)&&(!(year%100==0 && year%400!=0))))){leapDay=1;}
        //if(month>2 &&(year%4==0 && year%400){leapDay=1;}
        total = (year-1)*365+((int)((year-1)/100))*24+((int)((year-1)%100)/4)+daysc[month-1]+day+leapDay+(int)((year-1)/400);
        return total;
    }
    public myDate addDays(int days){
        myDate x =new myDate(getTotalDays()+days);
        return x;
    }
    public int daysBetween(myDate fromDate,myDate toDate){
        return toDate.getTotalDays()-fromDate.getTotalDays();
    }
    public int daysBeforeMe(myDate toDate){
        return -toDate.getTotalDays()+getTotalDays();
    }

    public
    @Override
    String toString() {
        String sday=Integer.toString(100+day).substring(1);
        String smonth=Integer.toString(100+month).substring(1);
        return sday+"-"+smonth+"-"+year;
    }
}