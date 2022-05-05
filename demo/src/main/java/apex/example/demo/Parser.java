package apex.example.demo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
public class Parser {
    private String str;
    private int error = 0;
    public Parser(String s){
        str = s.toLowerCase();
        splitToWords();
        checkError();
    }
    private void splitToWords(){
        str = str.replaceAll("[=&]", " ");
        str = str.replaceAll("%40", "@");
    }

    private void checkError(){
        String[] p = str.split(" ");
        List<String> s = new ArrayList<String>(Arrays.asList(p));
        int i = 0;
        for(int j = 0; j < s.size(); j++) {
            char[] c = s.get(j).toCharArray();
            for (i = 0; i < c.length; i++) {
                try {
                    if (c[i] == ':' && c[i + 1] == ' ') {
                        error++;
                        s.remove(j);
                    }
                }catch(ArrayIndexOutOfBoundsException e){
                    if(c[i] == ':'){
                        s.remove(j);
                        error++;
                    }
                }
            }
        }
        str = "";
        for(String w: s){
            str+=w+" ";
        }
    }

    public String getStr(){
        return str;
    }

    public String createMap(){
        TreeMap<String, Integer> map = new TreeMap<>();
        String [] s = str.split(" ");

        for(String w: s){
            if(map.containsKey(w)){
                map.put(w, map.get(w)+1);
            }else {
                map.put(w, 1);
            }
        }

        return getMap(map);
    }
    private String getMap(TreeMap<String, Integer> map){

        Object[] arr =  map.keySet().toArray();
        Arrays.sort(arr);
        String mapValues = "";
        for (int i = 0; i < arr.length-1; i++){
            mapValues+=arr[i] + " (Seen " + map.get(arr[i]) + ")\n";
        }
        mapValues += "Errors: " + error;
        return mapValues;
    }

    public static void main(String [] args){
        Parser str = new Parser("username=Chicken&password=1234&email=dds%40email.com&zipcode=23461");

        str.getStr();
        System.out.println(str.createMap());
    }


}
