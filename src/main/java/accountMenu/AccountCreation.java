package accountMenu;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AccountCreation {


    public void addAccountInformationsIntoFile(){

        Scanner option = new Scanner(System.in);
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter("accountFile.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {

            AccountInfo account = new AccountInfo();

            while(true) {
                System.out.println("Enter your account number");
                account.setAccountNumber(option.next());
                System.out.println("Enter your user number");
                account.setUserNumber(option.next());
                System.out.println("Enter the amount of your account");
                account.setAmount(option.next());
                System.out.println("Enter the balance of your account");
                account.setBalance(option.next());
                System.out.println("Enter the account type - Euro or Ron - ");
                account.setAccountType(option.next());

                if(account.verifyInfo())
                {
                    out.write( account.getAccountNumber() + " " + account.getUserNumber() + " " +
                            account.getAmount() + " " + account.getBalance() + " " +  account.getAccountType());
                    break;
                }
                else
                    System.out.println("Invalid data; please re-enter your informations! ");
            }
        }

        catch (IOException e)
        {
            System.out.println("Exception ");
        }
        finally
        {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
