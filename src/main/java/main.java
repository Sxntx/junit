import java.util.Arrays;
import java.util.HashMap;

public class main {

    public static void main(String[] args) {

        //ignore this file, it was other needed practice

        llamada("aaaabbbba");//2a2b
    }

    private  static String llamada(String
                                           aabb) {
String res="";
       String[] stringsplit=  aabb.split("");
        int connt=1;
        HashMap<String,Integer> map= new HashMap();
        for(int t=0; t<aabb.length();t++){
            if(t!=0){
            if(stringsplit[t].equals(stringsplit[t-1])) {
                connt++;
                map.put(stringsplit[t],connt);
                }else{
                connt=1;
                map.put( stringsplit[t],connt);

            }
            }
             res= map.toString();

            }


String restreeplace= res.replace("{","");
        restreeplace=restreeplace.replace("}","");
        restreeplace=restreeplace.replace("=","");

        System.out.println(restreeplace);
    return res; }
}
