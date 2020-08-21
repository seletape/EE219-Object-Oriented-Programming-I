package Banking;

public abstract class Account {

    protected int accountNumber;
    protected float balance;

    public Account(int acn, float bal)
    {
        accountNumber = acn;
        balance = bal;
    }

    public int getAccountNumber()
    {
        return accountNumber;
    }

    public float getAccountBalance()
    {
        return balance;
    }
    public void makeLodgement(float amount)
    {
        balance += amount;
    }

    public void makeWithdrawal(float amount)
    {
        balance -= amount;
    }

    public abstract String accountType();

    public void display()
    {

        System.out.println("Account Type: " + this.accountType());
        System.out.println("==============================");
        System.out.println("Account Number: " + accountNumber + " has balance: " + balance + " Euro");

    }

}
