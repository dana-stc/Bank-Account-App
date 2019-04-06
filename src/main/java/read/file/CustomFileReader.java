package read.file;

import first.menu.Login;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomFileReader {

    private final static Logger LOGGER = Logger.getLogger( CustomFileReader.class.getName());
    // write
    public <T> boolean writeFromFileAny(String filename, List<T> listUsers) {
        // save the object to file
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            for(int i = 0; i < listUsers.size(); i++) {
                out.writeObject(listUsers.get(i));
            }
            return true;

        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "An error has occured while processing the file" );
            ex.printStackTrace();
        }
        finally {
            try {
                out.close();
            } catch (IOException e) {
                LOGGER.log(Level.SEVERE, "An error has occured while closing the file" );
            }
        }

        return false;

    }

    public <T> List<T> readFromFileAny(String filename){
        FileInputStream fis;
        ObjectInputStream in = null;
        List<T> arr = new ArrayList<>();
        try {
            fis = new FileInputStream(filename);
            in = new ObjectInputStream(fis); // clasa asta citeste din fisier
            while(true){
                Object obj = in.readObject();
                if(obj != null)
                    arr.add((T)obj); //cast la obiectul respecti
            }
        }catch (EOFException e) {
            //System.out.println("end of file");
            //return times;
        }
        catch(FileNotFoundException ex){
            LOGGER.log(Level.SEVERE, "The file " + filename + " was not found. Please create it");
        }
        catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "An error has occured while processing the file" );
        }
        finally {
            try {
                if(in!=null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return arr;
    }

}
