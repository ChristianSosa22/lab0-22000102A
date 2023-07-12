import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
public class prueba{
    public static void main(String[] args){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean match = Pattern.matches("(0[1-9]|1[0-9]|2[0-9]|3[0-1])/(0[0-9]|1[0-2])/[0-9]{4}", "35/02/2025");
        
        System.out.println(match);
    }
}