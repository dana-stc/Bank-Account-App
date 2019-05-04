package repository;

import entity.Account;
import entity.Person;
import entity.Transaction;
import entity.UserInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TransferRepository {

    private final static Logger LOGGER = Logger.getLogger( TransferRepository.class.getName());

    public void createTransfer(Account accountFrom, String toAccount, BigDecimal balance){

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();

            Transaction transaction = new Transaction( toAccount, balance, "", LocalDateTime.now());
            transaction.setAccount(accountFrom);

            session.persist(transaction);

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
