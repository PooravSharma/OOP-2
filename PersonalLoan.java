package myloan;

/**
 * A public class that extends Loan. The PersonalLoan constructor sets the
 * interest rate to 2% over the current prime interest rate.
 *
 * @author Poorav Sharma
 */
public class PersonalLoan extends Loan {

    public PersonalLoan(int loanNumber, String LastName, double loanAmount, double interestRate, int loanTerm) {
        super(loanNumber, LastName, loanAmount, interestRate, loanTerm);
        interestRate += 2;
        setInterestRate(interestRate);

    }
}
