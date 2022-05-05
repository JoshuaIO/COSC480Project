package apex.example.demo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

    public class UsersParser {

        private String str;
        private Users users;
        private int error = 0;

        public UsersParser(String s){
            str = s;
            splitToWords();

        }

        private void splitToWords(){
            str = str.replaceAll("[=&]", " ");
            str = str.replaceAll("%40", "@");
        }

        public Users toList(){
            String[] p = str.split(" ");
            List<String> s = new ArrayList<String>(Arrays.asList(p));
            int i = 0;
            Users n = new Users(s.get(1),s.get(3), s.get(5), s.get(7));
            return n;
        }


       /* public static void main(String [] args){
            UsersParser str = new UsersParser("username=Chicken&password=1234&email=dds%40email.com&zipcode=23461");
            str.toList();

            System.out.println(str.toString());
        }*/

    }

