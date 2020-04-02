/*
Write a java function that will ping any host ( given as input ) and
computes the median of the time taken to ping.

Use the system ping utility, do not use any deprecated methods.

 */

package Assignment;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class JavaAssignment3 {

    public float getPingMedian(String host){
        ArrayList<Float> times= new ArrayList<>();
        for(int i=1;i<16;i++){
            times.add(pingTime(host));
        }
        Collections.sort(times);
        return times.get(7);

    }

    public float pingTime(String ip){
        try
        {   ip="ping " +ip;
            float time;
            Process p = Runtime.getRuntime().exec(ip);
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String s;
            int count=0;
            while ((s = inputStream.readLine()) != null)
            {   int start = s.indexOf("time=");
                int end = s.indexOf("ms");
                count++;
                if(start!=-1 && end!=-1) {
                    p.destroy();
                    time = Float.parseFloat(s.substring(start + 5, end));
                    return time;
                }
                if(count==2){
                    System.out.println(s);
                    return -1.0f;
                }
            }

           return -1.0f;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return -1.0f;
        }
    }

    public static void main(String[] args) {
        JavaAssignment3 object = new JavaAssignment3();
        //System.out.println(object.pingTime("google.com"));
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Host Address for getting Median Ping time ..");
        String host = scan.nextLine();
        scan.close();
        float medTime = object.getPingMedian(host);
        if (medTime<0){
            System.out.println("No connection to ip address");
        }else {
            System.out.println("Median ping time to Host :"+host+" is :"+medTime+" ms");
        }
    }

}
