package week3.CountingWebVisits;

import week3.ReadingLogFIles.LogEntry;

import java.text.*;
import java.util.*;

public class WebLogParser {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy:kk:mm:ss Z", Locale.US);
    private static String getFirstStr(StringBuilder sb, String delim) {
        int x = sb.indexOf(delim);
        if (x == -1) {
            x = sb.length();
        }
        String ans = sb.substring(0,x);
        sb.delete(0, x + delim.length());
        return ans;
    }
    public static week3.ReadingLogFIles.LogEntry parseEntry(String line) {
        //Assumes line is valid and in this format:
        //130.56.124.123 - - [30/Apr/2020:07:47:11 -0400] "GET //favicon.ico HTTP/1.1" 200 3433
        StringBuilder sb = new StringBuilder(line);
        String ip = getFirstStr(sb, " ");
        getFirstStr(sb, " ");
        getFirstStr(sb, " [");
        String dateStr = getFirstStr(sb, "] \"");
        Date date = parseDate(dateStr);
        String request = getFirstStr(sb, "\" ");
        String statusStr = getFirstStr(sb, " ");
        int status = Integer.parseInt(statusStr);
        String byteStr = getFirstStr(sb, " ");
        int bytes = Integer.parseInt(byteStr);
        return new LogEntry(ip, date, request, status, bytes);
    }
    public static Date parseDate(String dateStr) {
        ParsePosition pp = new ParsePosition(0);
        return  dateFormat.parse(dateStr, pp);
    }

}