package repository;

import entity.Notification;
import entity.UserInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.time.LocalDateTime;

public class NotificationRepository {

    public void createNotification(UserInfo currentUser){
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();
            Notification notification = new Notification(" ", LocalDateTime.now(), LocalDateTime.now());

            // set the object that contains that primary key
            notification.setUserInfo(currentUser);

            session.persist(notification);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }
    }

}
