import java.util.*;
import java.util.regex.Pattern;
import java.io.*;
public class Categories{
    static int counter;
    private Hashtable<String, LinkedList<String>> three;

    public Categories(){
        this.counter = 0;
        this.three = new Hashtable<String, LinkedList<String>>();
    }

    public void classify(String input){
        /*se crean variables booleanas las cuales validaran si el input
         cumple con los requisitos de alguna de las 3 opciones */
        boolean correo = Pattern.matches("[a-z]+[0-9]*@[a-z]+[\\.[a-z]+]+", input);
        boolean telef = Pattern.matches("\\+502 \\d{4} \\d{4}|\\d{4}-\\d{4}",input);
        boolean fecha = Pattern.matches("(0[1-9]|1[0-9]|2[0-9]|3[0-1])/(0[0-9]|1[0-2])/[0-9]{4}|(0[1-9]|1[0-9]|2[0-9]|3[0-1])-(0[0-9]|1[0-2])-[0-9]{4}",input);
        //se valida cual de las 3 booleanas es verdadera 
        if (correo){
            //si el mapa contiene la clave, significa que ya se ha ingresado mas de un valor 
            if (three.containsKey("mail")){
                LinkedList<String> lista = three.get("mail");
                lista.add(input);
                three.replace("mail",lista);
                counter+=1;

            }else{
                //si la key no ha sido encontrada, se crea y se guarda el input en la linkedList
                three.put("mail", new LinkedList<>());
                LinkedList<String> lista = three.get("mail");
                lista.add(input);
                three.replace("mail",lista);
                counter+=1;
            }
        }else if(telef){
            if(three.containsKey("phone")){
                LinkedList<String> lista = three.get("phone");
                lista.add(input);
                three.replace("phone",lista);
                counter+=1;

            }else{
                three.put("phone", new LinkedList<>());
                LinkedList<String> lista = three.get("phone");
                lista.add(input);
                three.replace("phone",lista);
                counter+=1;

            }
        }else if(fecha){

            if(three.containsKey("date")){
                LinkedList<String> lista = three.get("date");
                lista.add(input);
                three.replace("date",lista);
                counter+=1;

            }else{
                three.put("date", new LinkedList<>());
                LinkedList<String> lista = three.get("date");
                lista.add(input);
                three.replace("date",lista);
                counter+=1;
            }
        }
    }
    //metodo que imprime todos los mails que esten en la lista 
    public void printMails(){
        System.out.println("*****CORREOS*****");
        if (three.containsKey("mail")){
            LinkedList<String> listaMails = three.get("mail");
            for (String elem : listaMails){
                System.out.println(elem);
            }
        }else{
            System.out.println("NO EMAILS /n");
        }
        System.out.println("************* \n");
    }
    //metodo que imprime todos los telefonos de la lista
    public void printPhones(){
        System.out.println("*****TELEFONOS*****");
        if (three.containsKey("phone")){
             LinkedList<String> listaPhone = three.get("phone");
             
            for(String e : listaPhone){
                System.out.println(e);
            }
           
        }else{
            System.out.println("NO PHONES \n");
        }
         System.out.println("************* \n");
    }
    public void printDates(){
         System.out.println("*****FECHAS*****");
        if (three.containsKey("date")){
            LinkedList<String> listaDate = three.get("date");
           
            for (String e : listaDate){
                System.out.println(e);
            }
            
        }else{
            System.out.println("NO DATES \n");
        }
        System.out.println("************* \n");
    }

    public void countByCategory(){
        for (String key : three.keySet()){
            LinkedList<String> llaves = three.get(key);
            int cantidad = llaves.size();
            System.out.println("cantidad de elementos de "+ key + ": "+ cantidad + "\n");
        }
    }

}