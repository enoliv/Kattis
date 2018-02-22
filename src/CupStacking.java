import java.io.*;
import java.util.Scanner;
import java.util.*;

public class CupStacking {

    public boolean isNumber(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch(NumberFormatException n){
            return false;
        }
    }

    public static void main(String[] args){
        CupStacking program = new CupStacking();
        try{
            FileReader fileReader = new FileReader("cups-01.in");
            BufferedReader in = new BufferedReader(fileReader);

            TreeMap <Integer,String> radCol = new TreeMap<Integer,String>();

            int n;
            String line;
            String[] arr;
            n = Integer.parseInt(in.readLine());
            int radius;
            String col;

            for(int i = 0; i < n; i++){
                line = in.readLine();
                arr = line.split(" ");
                if(program.isNumber(arr[0])){
                    radius = Integer.parseInt(arr[0]);
                    col = arr[1];
                }else{
                    radius = Integer.parseInt(arr[1])*2;
                    col = arr[0];
                }
                radCol.put(radius, col);
            }
            for(Map.Entry<Integer,String> entry : radCol.entrySet()){
                System.out.println(entry.getValue());
            }

            in.close();
            fileReader.close();

        }catch(FileNotFoundException f){
            System.out.println("No such file");

        }catch(IOException e){
            System.out.println("Could not read from file");
        }

    }

}
