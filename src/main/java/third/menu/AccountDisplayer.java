package third.menu;

import constants.FileConstants;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountDisplayer {

    private final static Logger LOGGER = Logger.getLogger( AccountDisplayer.class.getName());

    public void printAccountFile() {
        String fileName = FileConstants.FILENAME + "accountFile.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

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