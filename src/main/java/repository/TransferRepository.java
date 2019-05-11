package repository;

import entity.Account;
import entity.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import service.constants.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.logging.Logger;

public class TransferRepository {

    private final static Logger LOGGER = Logger.getLogger( TransferRepository.class.getName());

    public void createTransfer(Account fromAccount, Account toAccount, String fromAccountNumber, String toAccountNumber,  BigDecimal amount){

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.getTransaction().begin();

            Transaction transactionFromAccount = new Transaction( fromAccountNumber, amount, "", LocalDateTime.now(), TransactionType.outgoing);
            Transaction transactionToAccount = new Transaction( toAccountNumber, amount, "", LocalDateTime.now(), TransactionType.incoming);

            // set the object that contains that primary key
            transactionFromAccount.setFromAccount(fromAccount);
            transactionToAccount.setFromAccount(toAccount);

            // save the transaction
            session.persist(transactionFromAccount);
            session.persist(transactionToAccount);

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
