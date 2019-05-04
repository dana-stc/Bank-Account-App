package repository;

import entity.Account;
import entity.Person;
import entity.UserInfo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountRepository {

    private final static Logger LOGGER = Logger.getLogger(AccountRepository.class.getName());

    /**
     * @return list of accounts
     */
    public List<Account> getListOfAccountsFromDb(BigInteger user_id) {

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();
        List<Account> listAccounts = null;
        try {
            session.getTransaction().begin();
            // query user
            Query query = session.createQuery("from Account where user.id =:id ");
            query.setParameter("id", user_id);
            listAccounts = query.getResultList();
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return listAccounts;
    }

    /**
     * create a new account into the database
     */
    public void createAccount(Account account) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();
            session.persist(account);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
    }

}
