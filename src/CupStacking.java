import java.io.*;
import java.util.Scanner;
import java.util.*;

public class CupStacking {

    public boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException n) {
            return false;
        }
    }

    public static void main(String[] args) {
        TreeMap<Integer, String> radCol = new TreeMap<Integer, String>();

        CupStacking program = new CupStacking();
        Scanner keyboard = new Scanner(System.in);
        int count = 0;

        int n = keyboard.nextInt();
        keyboard.nextLine();

        String line;
        int radius;
        String col;

        do {
            String[] arr;
            line = keyboard.nextLine();
            arr = line.split(" ");
            if (program.isNumber(arr[0])) {
                radius = Integer.parseInt(arr[0]);
                col = arr[1];
            } else {
                radius = Integer.parseInt(arr[1]) * 2;
                col = arr[0];
            }
            radCol.put(radius, col);
            count ++;
        } while (count < n);

        for (Map.Entry<Integer, String> entry : radCol.entrySet()) {
            System.out.println(entry.getValue());
        }

    }
}
