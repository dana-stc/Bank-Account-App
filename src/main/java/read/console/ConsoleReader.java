/**
 * ConsoleReader class
 * reading from the keyboard an option
 */

package read.console;

import java.util.Scanner;

public class ConsoleReader {

    private Scanner option;
    private static ConsoleReader single_instance = null; // Singleton

    private ConsoleReader(){
        option = new Scanner(System.in);
    }

    /**
     * Singleton Design Pattern
     *
     * @return a single instance of the class
     */
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
