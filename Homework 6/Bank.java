package Banking;

import Banking.Account;

public class Bank {

    private static final int MAX_NUM_ACCOUNTS = 1000;
    private Account[] accounts = new Account[MAX_NUM_ACCOUNTS];
    private int numAccounts;




    public Bank()
    {
        numAccounts = 0;
    }

    public void addAccount(Account ac)
    {
        if(numAccounts < MAX_NUM_ACCOUNTS)
        {
            accounts[numAccounts++] = ac;
        }

        else
        {
            System.out.println("Bank is full!");
        }
    }

    public void displayAccount(int acn)
    {
        for(int i=0; i<numAccounts; i++)
        {
            if(accounts[i].getAccountNumber()==acn)
            {
                accounts[i].display();
            }
        }
    }

    public float calculateTotalLoans()
    {
        float totalLoansAmount = 0;
        for(int i=0; i<numAccounts; i++)
        {
            if(accounts[i].accountType()== "Loan Account")
            {
                totalLoansAmount += accounts[i].getAccountBalance();
            }
        }
        return totalLoansAmount;
    }
}