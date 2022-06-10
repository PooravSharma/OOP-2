package myloan;

/**
 * A public class that extends Loan. The BusinessLoan constructor sets the
 * interest rate to 1% over the current prime interest rate.
 *
 * @author Poorav Sharma
 */
public class BusinessLoan extends Loan {

    public BusinessLoan(int loanNumber, String LastName, double loanAmount, double interestRate, int loanTerm) {
        super(loanNumber, LastName, loanAmount, interestRate, loanTerm);
        interestRate += 1;
        setInterestRate(interestRate);
    }

}
