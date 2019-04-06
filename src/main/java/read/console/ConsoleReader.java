package read.console;

import java.util.Scanner;

public class ConsoleReader {

    private static ConsoleReader single_instance = null;
    private  Scanner option;

    private ConsoleReader(){
        option=new Scanner(System.in);
    }

    // singleton
    public static ConsoleReader getInstance()
    {
        if (single_instance == null)
            single_instance = new ConsoleReader();

        return single_instance;
    }

    public String readFromConsole(){
        return option.next();
    }

    public void closeScaner(){
        option.close();
    }

}
