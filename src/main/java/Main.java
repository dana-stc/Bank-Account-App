/**
 * Main class
 *
 * @author Stoica Ioana-Dana
 */

import repository.HibernateUtil;
import view.menus.MainMenu;

public class Main {

    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
        MainMenu menu = new MainMenu();
        menu.runMenu();
    }
}