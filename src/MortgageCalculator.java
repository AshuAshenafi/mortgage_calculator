import java.util.Scanner;

public class MortgageCalculator {

    public static void main(String[] args) {

        // Scanner helps to get console input from the user
        Scanner keyboard = new Scanner(System.in);

        double loanAmount = 0;
        double interestRate = 0;
        double monthlyPayment = 0;
        double balanceOwed = 0;
        int termInYears;

        // prompt user for details of loan
        System.out.printf("Enter the loan amount: ");
        loanAmount = keyboard.nextDouble();

        System.out.printf("Enter the interest rate on the loan: ");
        interestRate = keyboard.nextDouble();

        System.out.printf("Enter the term (years) for the loan payment: ");
        termInYears = keyboard.nextInt();

        System.out.printf("\n======================================\n");
        keyboard.close();

        // function call to get monthly payment
        monthlyPayment = monthlyPayment(loanAmount, interestRate, termInYears);
        // formula to get balance owed to the bank
        balanceOwed = -(monthlyPayment * (termInYears*12));

        // display details of loan
        // comma is very important for number formating
        System.out.format("%-30s$%-+,10.2f%n", "Balance owed to bank: ", balanceOwed);
        System.out.format("%-30s$%-+,10.2f%n", "Minimum monthly payment: ", monthlyPayment);
    }

    // static function out side of main() method
    public static double monthlyPayment(double loanAmt, double interestRt, int termInyrs) {
        // calculates the monthly payment
        //converting interest rate into decimal e.g. 4.5% = 0.045
        // monthly interest rate is yearly rate / 12
        double monthlyRate = (interestRt/ 100) / 12;
        double base = (1 + monthlyRate);
        double termInMonths = termInyrs * 12;
        double monthlyPymnt = 0.0;
        // the Math.pow() method is used to calculate values raised to a power
        // commonly know formula
        monthlyPymnt = ((monthlyRate * loanAmt) / (1 - Math.pow(base, -termInMonths)));

        return monthlyPymnt;
    }
}
