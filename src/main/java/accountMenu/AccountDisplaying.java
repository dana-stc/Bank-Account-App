package accountMenu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AccountDisplaying {

    public void printAccountFile() {
        final String FILENAME = System.getProperty("user.dir") + "\\src\\main\\resources\\accountFile.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

            String st;
            while ((st = br.readLine()) != null)
                System.out.println(st);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}