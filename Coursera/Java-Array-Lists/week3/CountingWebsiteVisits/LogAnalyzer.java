package week3.CountingWebsiteVisits;

import edu.duke.FileResource;

import java.util.ArrayList;

public class LogAnalyzer {
    private ArrayList<LogEntry> records;

    public LogAnalyzer() {
        this.records = new ArrayList<>();
    }

    public int countUniqueIPs() {
        ArrayList<String> uniqueIPs = new ArrayList<>();

        for (LogEntry le : records) {
            String ipAddr = le.getIpAddress();

            if (!uniqueIPs.contains(ipAddr)) {
                uniqueIPs.add(ipAddr);
            }
        }
        return uniqueIPs.size();
    }

    public void printAllHigherThanNum(int num) {
        for (LogEntry le : records) {
            int statusCode = le.getStatusCode();

            if (le.getStatusCode() > num) {
                System.out.println(le);
            }
        }
    }

    public ArrayList uniqueIPVisitsOnDay(String someday) {
        ArrayList<String> uniqueIP = new ArrayList<>();
        for (LogEntry le : records) {
            String ipAddr = le.getIpAddress();
            String date = le.getAccessTime().toString().substring(4, 10);
            if (!uniqueIP.contains(ipAddr) && date.equals(someday)) {
                uniqueIP.add(ipAddr);
            }
        }
        return uniqueIP;
    }

    public int countUniqueIPsInRange(int low, int high) {
        ArrayList<String> uniqueIPsInRange = new ArrayList<>();
        int count = 0;
        for (LogEntry le : records) {
            String ipAddr = le.getIpAddress();
            int status = le.getStatusCode();

            if (!uniqueIPsInRange.contains(ipAddr) && (status >= low && status <= high)) {
                count++;
                uniqueIPsInRange.add(ipAddr);
            }
        }
        return count;
    }

    public void readFile(String filename) {
        FileResource resource = new FileResource(filename);
        for (String line : resource.lines()) {
            LogEntry l = WebLogParser.parseEntry(line);
            this.records.add(l);
        }
    }

    public void printAll() {
        for (LogEntry le : records) {
            System.out.println(le);
        }
    }


}