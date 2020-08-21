package Banking;

import Banking.Account;
import Banking.Bank;
import Banking.LoanAccount;
import Banking.CurrentAccount;

public class Bank_App {

    public static void main(String args[]) {


        Bank bank = new Bank();

        bank.addAccount(new CurrentAccount(1001, 300, 200));
        bank.addAccount(new LoanAccount(2001, 200000, 25 * 12));
        bank.addAccount(new LoanAccount(2002, 250000, 30 * 12));
        bank.addAccount(new LoanAccount(2003, 100000, 100 * 12));


        bank.displayAccount(1001);
        bank.displayAccount(2002);


        System.out.println("The total amount of outstanding loans is = " + bank.calculateTotalLoans() + " euros.");





    }
}