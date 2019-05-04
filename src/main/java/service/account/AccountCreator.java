package service.account;

import cache.CacheUserData;
import repository.AccountRepository;
import service.exceptions.AmountCharacterIntroducingException;
import entity.Account;
import service.read.console.ConsoleReader;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author Stoica Ioana-Dana
 */
public class AccountCreator {

    public Boolean verifyInfo(Account account) {
        if (account.getAccountNumber().length() == 24 && account.getAccountNumber().startsWith("RO") && (account.getAccountType().equals("Euro") || account.getAccountType().equals("Ron")))
            return true;
        return false;
    }

    /**
     * a method for adding account information read from the keyboard into the database
     * @throws AmountCharacterIntroducingException - characters not allowed in amount
     */
    public void addAccountInformationsIntoFile() throws AmountCharacterIntroducingException {

        ConsoleReader reader = ConsoleReader.getInstance();
        Account account = new Account();
        CacheUserData cache = CacheUserData.getInstance();

        while (true) {
            System.out.println("Enter your account number");
            account.setAccountNumber(reader.readFromConsole());

            System.out.println("Enter the balance of your account");
            String balance = reader.readFromConsole();
            if(!balance.matches("[0-9]+"))
            {
                throw new AmountCharacterIntroducingException("Characters not allowed in amount");
            }
            account.setBalance(new BigDecimal(balance));

            System.out.println("Enter the account type - Euro or Ron - ");
            account.setAccountType(reader.readFromConsole());

            account.setCreatedTime(LocalDateTime.now());
            account.setUpdatedTime(LocalDateTime.now());
            account.setUser(cache.getUserInfo());

            AccountRepository accountRepository = new AccountRepository();

            if (verifyInfo(account)) {
                accountRepository.createAccount(account);
                break;
            } else
                System.out.println("Invalid data; please re-enter your information! ");
        }
    }
}
