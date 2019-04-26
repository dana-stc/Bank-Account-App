/**
 * @Author Stoica Ioana-Dana
 */

package account;

import cache.CacheUserData;
import custom.exceptions.UnacceptableTransferException;
import entity.AccountInfo;
import read.console.ConsoleReader;

import java.math.BigDecimal;


public class PaymentFunctionality {

    private String chosenOption;
    private ConsoleReader reader = ConsoleReader.getInstance();
    private CacheUserData cache = CacheUserData.getInstance();
    private AccountDisplayer accountDisplaying = new AccountDisplayer();
    /**
     * transfer money between two accounts of the same type (Ron/ Euro) implementation
     *
     * @throws UnacceptableTransferException - you cannot make transfers if you don't have any accounts or you have only one
     */
    public void transferMoney() throws UnacceptableTransferException {

        System.out.println("-------------------------------------------");
        accountDisplaying.printAccountForPayment();
        System.out.println("-------------------------------------------");

        if (cache.getListAccounts().size() == 1 || cache.getListAccounts().size() == 0) {
            throw new UnacceptableTransferException("Error, you cannot make transfers");
        }

        System.out.println("Please enter a choice for the account from which you want to make the transfer");
        chosenOption = reader.readFromConsole();

        if (chosenOption.matches("[0-9]+") && Integer.parseInt(chosenOption) < cache.getListAccounts().size() + 1) {
            this.startTransfer();
        } else {
            System.out.println("Please enter a valid option! ");
        }


    }

    private void startTransfer(){
        AccountInfo currentAccount = cache.getListAccounts().get(Integer.parseInt(chosenOption) - 1);

        System.out.println("Please enter the amount that you want to transfer");
        chosenOption = reader.readFromConsole();
        if (chosenOption.matches("[0-9]+") && new BigDecimal(chosenOption).compareTo(currentAccount.getAmount()) <= 0) {
            this.enterAmount(currentAccount);
        } else {
            System.out.println("Please enter an amount <= than the current amount! ");
        }
    }


    private void enterAmount( AccountInfo currentAccount){
        // the chosen amount
        BigDecimal chosenAmount = new BigDecimal(chosenOption);

        System.out.println("-------------------------------------------");
        accountDisplaying.printAccountByType(currentAccount.getAccountType(), currentAccount.getAccountNumber());
        System.out.println("-------------------------------------------");

        System.out.println("Please enter the account where you want to make the transfer");
        chosenOption = reader.readFromConsole();
        if (chosenOption.matches("[0-9]+") && Integer.parseInt(chosenOption) < cache.getListAccounts().size() + 1) {
            AccountInfo secondAccount = cache.getListAccounts().get(Integer.parseInt(chosenOption) - 1);

            BigDecimal currentAcountAmount = currentAccount.getAmount();
            BigDecimal secondAccountAmount = secondAccount.getAmount();
            currentAcountAmount = currentAcountAmount.subtract(chosenAmount); // '-' operation in BigDecimal
            secondAccountAmount = secondAccountAmount.add(chosenAmount); // '+' operation in BigDecimal
            currentAccount.setAmount(currentAcountAmount);
            secondAccount.setAmount(secondAccountAmount);

            System.out.println(chosenAmount + " " + currentAccount.getAccountType() + " had been transfered into your " + secondAccount.getAccountNumber() + " account.");

            System.out.println("-------------------------------------------");
            accountDisplaying.printAccountForPayment();
            System.out.println("-------------------------------------------");

            cache.saveCacheData();
        } else {
            System.out.println("Please enter a valid option! ");
        }

    }


}
