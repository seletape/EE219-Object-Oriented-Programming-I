package Banking;

public class CurrentAccount extends Account{

    private float overdraftLimit;

    public CurrentAccount(int cacn, float cbal, float limit)
    {
        super(cacn,cbal);
        overdraftLimit = limit;
    }


    @Override
    public void makeWithdrawal(float amount)
    {
        if(amount <= (balance + overdraftLimit))
        {
            makeWithdrawal(amount);
        }
    }

    public void setOverdraftLimit(float limit)
    {
        overdraftLimit = limit;
    }

    @Override
    public String accountType()
    {
        return "Current Account";
    }

    @Override
    public void display()
    {
        super.display();
        System.out.println("   - Overdraft limit: " + overdraftLimit);
    }


}
