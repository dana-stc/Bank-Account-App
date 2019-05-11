import repository.HibernateUtil;
import view.menus.MainMenu;

/**
 * Main class
 *
 * @author Stoica Ioana-Dana
 */

public class Main {

    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
        MainMenu menu = new MainMenu();
        menu.runMenu();
        //UserRepository.createDummyUser(); // for static methods !

    }
}