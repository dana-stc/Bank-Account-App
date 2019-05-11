package repository;

import entity.Person;
import entity.UserInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserRepository {

    private final static Logger LOGGER = Logger.getLogger( UserRepository.class.getName());

    public  List<UserInfo> getListOfUsersFromDb(){

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();
        List<UserInfo> listUsers = null;
            try {
            session.getTransaction().begin();

            // query user
            listUsers = session.createQuery("from UserInfo").getResultList();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        System.out.println("Done");

        return listUsers;
    }


    public static void createDummyUser(){

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();

            UserInfo user = new UserInfo("ioanad", "myPas", LocalDateTime.now(), LocalDateTime.now());
            Person person = new Person( "Tudor Vladimirescu", "Ioana", "Stoica", "ioanad@gmail.com" );

            session.persist(user);
            person.setUser(user);
            session.persist(person);

            UserInfo user1 = new UserInfo("gabist", "myPas2", LocalDateTime.now(), LocalDateTime.now());
            Person person1 = new Person( "str. Principala", "Gabi", "Stoica", "gabis@gmail.com" );

            session.persist(user1);
            person1.setUser(user1);
            session.persist(person1);

            UserInfo user2 = new UserInfo("cipr", "myPas3", LocalDateTime.now(), LocalDateTime.now());
            Person person2 = new Person( "Tudor Vladimirescu", "Ciprian", "Recianu", "cipr@gmail.com" );

            session.persist(user2);
            person2.setUser(user2);
            session.persist(person2);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }

        System.out.println("Done");

    }

    public UserInfo getCurrentUser(String username, String password){

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();
        UserInfo user  = null;
        try {
            session.getTransaction().begin();

            // query user
            Query query= session.createQuery("from UserInfo where username =: user and password =: pass");
            query.setParameter("user", username);
            query.setParameter("pass", password);

            user = (UserInfo) query.getSingleResult();

            session.getTransaction().commit();

        } catch (NoResultException e){
            LOGGER.log(Level.INFO, "No results found for user: " + username + " and password " + password);
        }

        catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }

        System.out.println("Done");

        return user;

    }


}
