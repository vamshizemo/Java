package StringsFirstAssignments;
import edu.duke.*;

public class Part4 {
    public void scrape(){
        String url = "http://www.dukelearntoprogram.com/course2/data/manylinks.html";
        URLResource dataFromUrl = new URLResource(url);
        String ytlink="";
        for(String line : dataFromUrl.lines()){
            ytlink=getBetween(line,"href=\"","\"");
            if(isYoutubeLink(ytlink)){
            System.out.println(getBetween(line,"href=\"","\""));
            }
            ytlink="";
        }
    }
    public String getBetween(String content,String from,String to){
        int start = content.indexOf(from);
        if(start==-1){return "";}
        int end = content.indexOf(to,start+from.length());
        if(end == -1){return "";}
        return content.substring(start+from.length(),end);

    }
    public boolean isYoutubeLink(String url){
        url=url.toLowerCase();
        int start = url.indexOf("youtube.com");
        if(start == -1){return false;}
        else{return true;}
    }

    public static void main(String[] args) {
        Part4 part = new Part4();
        part.scrape();
    }

}
