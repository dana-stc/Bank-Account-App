package accountMenu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountDisplaying {

    private final static Logger LOGGER = Logger.getLogger( AccountDisplaying.class.getName());

    public void printAccountFile() {
        final String FILENAME = System.getProperty("user.dir") + "\\src\\main\\resources\\accountFile.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

            String st;
            while ((st = br.readLine()) != null)
                System.out.println(st);

        } catch (FileNotFoundException e) {
            LOGGER.log(Level.SEVERE, "An error has occured because the file doesn't exist" );
            LOGGER.log(Level.SEVERE, e.getMessage() );
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "An error has occured while processing the file" );
            LOGGER.log(Level.SEVERE, e.getMessage() );
        }
    }
}