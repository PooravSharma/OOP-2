package myloan;

import java.io.Serializable;

/**
 * A public abstract class that implements the LoanConstants interface. A Loan
 * includes a loan number, customer last name, amount of loan, interest rate,
 * and term. The constructor requires data for each of the fields except
 * interest rate. Do not allow a loan amounts over the maximum specified in the
 * LoanConatants interface. Force any loan term that is not one of the three
 * defined in the LoanConstants class to a short-term, one-year loan. Override
 * the toString() method to display the loan data. *
 *
 *
 * @author Poorav Sharma
 */
public class Loan implements LoanConstants, Serializable {

    private int loanNumber;
    private String customerLastName;
    private double amountLoanWanted;
    private double interestRate;
    private int loanTerm;

    public Loan() {

    }

    public Loan(int loanNumber, String LastName, double loanAmount, double interestRate, int loanTerm) {
        setLoanNumber(loanNumber);
        setCustomerLastName(LastName);
        setAmountLoanWanted(loanAmount);
        setInterestRate(interestRate);
        setLoanTerm(loanTerm);

    }

    /**
     *
     * Over riding toString method
     */
    @Override
    public String toString() {
        return "\n Company : " + companyName + "\n Loan Number = "
                + getLoanNumber() + "\n Custersome LastName = "
                + getCustomerLastName() + "\n Amount Borrowed = $"
                + getAmountLoanWanted() + "\n Intrest Rate = "
                + getInterestRate() + "%\n Loan Term = "
                + getLoanTerm() + " years \n Loan Owed = $"
                + owedAmount() + " in " + getLoanTerm() + " years";
    }

    public double owedAmount() {
        double owed;
        owed = getAmountLoanWanted() + (getAmountLoanWanted() * (getLoanTerm() * (getInterestRate() / 100)));
        return owed;
    }

    /**
     * @return the loanNumber
     */
    public int getLoanNumber() {
        return loanNumber;
    }

    /**
     * @param loanNumber the loanNumber to set
     */
    private void setLoanNumber(int loanNumber) {
        this.loanNumber = loanNumber;
    }

    /**
     * @return the customerLastName
     */
    public String getCustomerLastName() {
        return customerLastName;
    }

    /**
     * @param customerLastName the customerLastName to set
     */
    private void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    /**
     * @return the amountLoanWanted
     */
    public double getAmountLoanWanted() {
        return amountLoanWanted;
    }

    /**
     * @param amountLoanWanted the amountLoanWanted to set
     */
    private void setAmountLoanWanted(double amountLoanWanted) {
        this.amountLoanWanted = amountLoanWanted;
    }

    /**
     * @return the intrestRate
     */
    public double getInterestRate() {
        return interestRate;
    }

    /**
     * @param intrestRate the intrestRate to set
     */
    public void setInterestRate(double intrestRate) {
        this.interestRate = intrestRate;
    }

    /**
     * @return the LoanTerm
     */
    public int getLoanTerm() {
        return loanTerm;
    }

    /**
     * @param LoanTerm the LoanTerm to set
     */
    private void setLoanTerm(int LoanTerm) {
        this.loanTerm = LoanTerm;
    }

    public int getMaxLoan() {
        return maximunLoan;
    }

    public int getShortTerm() {
        return shortTerm;
    }

    public int getMediumTerm() {
        return mediumTerm;
    }

    public int getLongTerm() {
        return longTerm;
    }
}
