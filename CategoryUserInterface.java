import java.io.*;
public class CategoryUserInterface{
    public static void main(String[] args)throws Exception{
        Categories test = new Categories();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int i = 0; i < 5; i++){
            System.out.print("Ingrese correo, telefono o fecha: ");
            test.classify(br.readLine());
        }
        System.out.println();
        test.countByCategory();
        test.printDates();
    }
}