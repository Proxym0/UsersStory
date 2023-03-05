package console;

import java.util.Scanner;

public class ConsoleReader {
    private static final Scanner SCANNER=new Scanner(System.in);
    public static String readString(){
        return SCANNER.next();
    }
    public static String readLine(){
        return SCANNER.nextLine();
    }

    public static  int readInt(){
        return SCANNER.nextInt();
    }
}
