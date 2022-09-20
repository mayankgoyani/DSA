import java.nio.charset.StandardCharsets;
import java.util.*;
class Main {


    public static void main(String[] args) {
        
        for(byte[] p : packets){
            String s = new String(p, StandardCharsets.UTF_8);
            System.out.println(s);
        }
    }
}