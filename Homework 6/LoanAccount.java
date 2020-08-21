package Banking;

public class LoanAccount extends Account {

    private int loanTerm;
    private float monthlyRepayment;

    public LoanAccount(int lacn, float lbal, int term)
    {
        super(lacn, lbal);
        loanTerm = term;

    }

    @Override
    public String accountType()
    {
        return "Loan Account";
    }

    @Override
    public void display()
    {
        super.display();
        System.out.println("   - Loan term: " + loanTerm + " months");
    }
}

